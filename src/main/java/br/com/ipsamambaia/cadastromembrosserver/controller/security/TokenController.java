package br.com.ipsamambaia.cadastromembrosserver.controller.security;

import br.com.ipsamambaia.cadastromembrosserver.dto.seguranca.Token;
import br.com.ipsamambaia.cadastromembrosserver.security.AccountCredentials;
import br.com.ipsamambaia.cadastromembrosserver.security.TokenProvider;
import br.com.ipsamambaia.cadastromembrosserver.service.security.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "${origin.host}", maxAge = 3600)
@RestController
@RequestMapping("/v1/token")
@Api(description = "API para autenticação por meio de token.")
public class TokenController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenProvider tokenProvider;

    @ApiOperation("Gera o token para as credenciais informadas. " +
            "O token gerado deve ser utilizado para todas as operações que requerem autenticação.")
    @RequestMapping(path = "/generate", method = RequestMethod.POST)
    public ResponseEntity<Token> authenticate(@RequestBody AccountCredentials account) throws AuthenticationException {
        final Authentication authentication = usuarioService.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
        );

        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return ResponseEntity.ok(tokenProvider.generateToken(authentication));
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}