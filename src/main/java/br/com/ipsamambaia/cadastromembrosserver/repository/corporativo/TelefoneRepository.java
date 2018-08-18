package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    List<Telefone> findByMembro(Membro membro);
}
