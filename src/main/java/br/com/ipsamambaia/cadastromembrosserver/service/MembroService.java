package br.com.ipsamambaia.cadastromembrosserver.service;

import br.com.ipsamambaia.cadastromembrosserver.dto.corporativo.CadastroBasicoDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Endereco;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Telefone;
import br.com.ipsamambaia.cadastromembrosserver.entity.seguranca.Usuario;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EnderecoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.EstadoCivilRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.MembroRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.corporativo.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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
    
    public Page<Membro> findAll(Pageable pageable) {
        return membroRepository.findAll(pageable);
    }

    public List<Membro> findByFilter(String filter, Pageable pageable) {
//        return membroRepository.findByFilter(filter, pageable).getContent();
    	return Collections.emptyList();
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
        deleteDependents(membroTemp);
        Membro membro = membroRepository.save(cadastroBasico.toEntity(membroTemp.getId()));
        saveDependents(cadastroBasico, membro);

        return cadastroBasico;
    }

    public void delete(Membro membro) {
        deleteDependents(membro);
        membroRepository.delete(membro);
    }

    private void saveDependents(CadastroBasicoDTO cadastroBasico, Membro membro) {
        cadastroBasico.toEstadoCivilEntity(membro).ifPresent(estadoCivilRepository::save);
        cadastroBasico.toTelefonesEntities(membro).ifPresent(telefoneRepository::saveAll);
        cadastroBasico.toEnderecosEntities(membro).ifPresent(enderecoRepository::saveAll);
    }

    private void deleteDependents(Membro membroTemp) {
    	EstadoCivil estadoCivil = estadoCivilRepository.findByMembro(membroTemp);
    	List<Telefone> telefones = telefoneRepository.findByMembro(membroTemp);
    	List<Endereco> enderecos = enderecoRepository.findEnderecoByMembro(membroTemp);
    	if(estadoCivil != null) estadoCivilRepository.delete(estadoCivil);
    	if(telefones != null) telefoneRepository.deleteAll(telefones);
    	if(enderecos != null) enderecoRepository.deleteAll(enderecos);
    }

	public Optional<CadastroBasicoDTO> findBy(long id) {
		Optional<Membro> membro = findById(id);
		if(membro.isPresent()) {
			EstadoCivil estadoCivil = estadoCivilRepository.findByMembro(membro.get());
			List<Telefone> telefones = telefoneRepository.findByMembro(membro.get());
			List<Endereco> enderecos = enderecoRepository.findEnderecoByMembro(membro.get());
			return Optional.of(new CadastroBasicoDTO(
					membro.get(), 
					Optional.ofNullable(membro.get().getProfissao()), 
					Optional.ofNullable(membro.get().getUsuario()),
					Optional.ofNullable(estadoCivil), 
					Optional.ofNullable(telefones), 
					Optional.ofNullable(enderecos)));
		}
		return Optional.empty();
	}
}
