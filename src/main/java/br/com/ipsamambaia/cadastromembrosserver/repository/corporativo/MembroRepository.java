package br.com.ipsamambaia.cadastromembrosserver.repository.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MembroRepository extends PagingAndSortingRepository<Membro, Long> {

    Page<Membro> findAll(Pageable pageable);
    
    Optional<Membro> findById(Long id);
    
    Membro save(Membro membro);
    
}
