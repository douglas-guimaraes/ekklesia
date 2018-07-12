package br.com.ipsamambaia.cadastromembrosserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.repository.MembroRepository;

@Service
public class MembroService {

    @Autowired
    private MembroRepository repository;
    
    public Long count() {
        return repository.count();
    }
    
    public List<Membro> findAll() {
        return repository.findAll();
    }
    
    public Optional<Membro> findById(Long id) {
        return repository.findById(id);
    }
    
    public Membro save(Membro membro) {
        return repository.save(membro);
    }
    
    public void delete(Membro membro) {
        repository.delete(membro);
    }
}
