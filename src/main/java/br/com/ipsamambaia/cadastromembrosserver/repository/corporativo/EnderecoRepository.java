package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Endereco;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findEnderecoByMembro(Membro membro);
}
