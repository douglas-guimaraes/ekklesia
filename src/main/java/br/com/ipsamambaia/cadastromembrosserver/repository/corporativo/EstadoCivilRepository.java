package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, Long> {

    EstadoCivil findByMembro(Membro membro);
}
