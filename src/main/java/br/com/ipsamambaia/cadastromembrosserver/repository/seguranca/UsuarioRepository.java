package br.com.ipsamambaia.cadastromembrosserver.repository.seguranca;

import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Papel;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    default Usuario findByEmail(String email) {
        Usuario usuario =
                new Usuario(1L, "usuario@email.com", "$2a$10$5HvNfuQSpvHuGNgdf7O01u4ZQp208wLrRaFRUw0/TScPKQqk.3dbe"); // senha: 123456
        usuario.addPapel(Papel.NOME_PAPEL);

        return usuario;
    }

    Long countByEmail(String email);
}
