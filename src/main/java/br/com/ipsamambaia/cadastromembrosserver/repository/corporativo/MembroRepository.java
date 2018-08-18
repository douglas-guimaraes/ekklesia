package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

    List<Membro> findAll();
    
    Optional<Membro> findById(Long id);
    
    Membro save(Membro membro);
    
}
