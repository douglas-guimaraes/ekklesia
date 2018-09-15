package br.com.ipsamambaia.cadastromembrosserver.service;

import br.com.ipsamambaia.cadastromembrosserver.dto.corporativo.CadastroBasicoDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EnderecoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EstadoCivilRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.MembroRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MembroService {

    @Autowired
    private MembroRepository membroRepository;

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public Long count() {
        return membroRepository.count();
    }
    
    public List<Membro> findAll(Pageable pageable) {
        return membroRepository.findAll(pageable).getContent();
    }
    
    public Optional<Membro> findById(Long id) {
        return membroRepository.findById(id);
    }
    
    public CadastroBasicoDTO save(CadastroBasicoDTO cadastroBasico) {
        Membro membro = membroRepository.save(cadastroBasico.toEntity(null));
        saveDependents(cadastroBasico, membro);
        cadastroBasico.setId(membro.getId());
        return cadastroBasico;
    }

    public CadastroBasicoDTO update(Membro membroTemp, CadastroBasicoDTO cadastroBasico) {
        estadoCivilRepository.delete(estadoCivilRepository.findByMembro(membroTemp));
        telefoneRepository.deleteAll(telefoneRepository.findByMembro(membroTemp));
        enderecoRepository.deleteAll(enderecoRepository.findEnderecoByMembro(membroTemp));

        Membro membro = membroRepository.save(cadastroBasico.toEntity(membroTemp.getId()));
        saveDependents(cadastroBasico, membro);

        return cadastroBasico;
    }

    public void delete(Membro membro) {
        membroRepository.delete(membro);
    }

    private void saveDependents(CadastroBasicoDTO cadastroBasico, Membro membro) {
        cadastroBasico.toEstadoCivilEntity(membro).ifPresent(estadoCivilRepository::save);
        cadastroBasico.toTelefonesEntities(membro).ifPresent(telefoneRepository::saveAll);
        cadastroBasico.toEnderecosEntities(membro).ifPresent(enderecoRepository::saveAll);
    }
}
