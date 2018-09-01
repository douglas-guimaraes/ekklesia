package br.com.ipsamambaia.cadastromembrosserver.repository.seguranca;

import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    Long countByEmail(String email);
}
