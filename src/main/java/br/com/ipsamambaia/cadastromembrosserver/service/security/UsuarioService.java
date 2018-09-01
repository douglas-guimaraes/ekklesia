package br.com.ipsamambaia.cadastromembrosserver.service.security;

import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Papel;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.RegistroFeedback;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import br.com.ipsamambaia.cadastromembrosserver.repository.seguranca.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@Service(value = "userService")
@Transactional
public class UsuarioService implements UserDetailsService, AuthenticationManager {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	/**
	 * Carrega o usuário pelo e-mail.
	 *
	 * @param email e-mail do usuário.
	 * @return uma instância de {@link UserDetails}.
	 * @throws UsernameNotFoundException caso o usuário não seja encontrado.
	 */
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);

		 if (usuario == null) {
		 	throw new UsernameNotFoundException("Invalid email or password.");
		 }
		
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), "", getAuthority(usuario));
	}

	/**
	 * Autentica o usuário.
	 *
	 * @param authentication credenciais do usuário.
	 * @return uma instância de {@link Authentication}.
	 * @throws AuthenticationException caso o usuário não seja autenticado.
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Usuario usuario = usuarioRepository.findByEmail(authentication.getName());
		String senha = (String) authentication.getCredentials();

		if (usuario != null
				&& senha != null
				&& bcryptEncoder.matches(senha, usuario.getSenha())) {
			return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
					authentication.getCredentials(), getAuthority(usuario));
		}

		return null;
	}

	/**
	 * Registra um novo usuário na base de dados.
	 *
	 * @param usuario usuário a ser registrado.
     * @return o feedback do registro.
	 */
	public RegistroFeedback registrarNovoUsuario(Usuario usuario) {
	    RegistroFeedback registroFeedback = new RegistroFeedback();

		if (isUsuarioExistente(usuario.getEmail())) {
		    registroFeedback.setUsuarioJaExistente(true);
        }

        if (!isEmailValido(usuario.getEmail())) {
            registroFeedback.setEmailInvalido(true);
        }

        if (isSenhaInvalida(usuario.getSenha())) {
            registroFeedback.setSenhaIncorreta(true);
        }

        if (!usuario.isSenhasIguais()) {
            registroFeedback.setSenhasDiferentes(true);
        }

        if (registroFeedback.isRegistroInvalido()) {
            return registroFeedback;
        }

		usuario.setId(null);
		usuario.setSenha(bcryptEncoder.encode(usuario.getSenha()));
		usuario.addPapel(Papel.NOME_PAPEL);
		this.usuarioRepository.save(usuario);
		return registroFeedback;
	}

	/**
	 * Verifica se o usuário já existe.
	 *
	 * @param email e-mail de usuário.
	 * @return <code>true</code> caso exista.
	 */
	public boolean isUsuarioExistente(String email) {
		return this.usuarioRepository.countByEmail(email) > 0;
	}

	/**
	 * Verifica se o e-mail é válido.
	 *
	 * @param email email do usuário.
	 * @return <code>true</code> caso seja válido.
	 */
	public boolean isEmailValido(String email) {
		final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		return Pattern.compile(emailPattern).matcher(email).matches();
	}

	/**
	 * Verifica a senha de acordo com a política estabelecida.
	 * <ul>
	 *     <li>Deve ter, no mínimo, 6 dígitos.</li>
	 *     <li>Deve ter, no mínimo, um número</li>
	 *     <li>Deve ter, no mínimo, uma letra maiúscula.</li>
	 * </ul>
	 * @param senha senha.
	 * @return <code>true</code> caso a senha seja inválida.
	 */
	public boolean isSenhaInvalida(@NotNull String senha) {
		return senha.length() < 6
                || senha.replaceAll("\\D", "").isEmpty()
				|| senha.replaceAll("\\p{Lu}", "").isEmpty();
	}

	/**
	 * Atribui os papeis ao usuário.
	 *
	 * @param usuario usuário autenticado.
	 * @return um set de {@link GrantedAuthority}.
	 */
	private Set<GrantedAuthority> getAuthority(Usuario usuario) {
        Set<GrantedAuthority> authorities = new HashSet<>();
		usuario.getPapeis().forEach(papel -> authorities.add(new SimpleGrantedAuthority("ROLE_" + papel.getNome())));
		return authorities;
	}
	
}