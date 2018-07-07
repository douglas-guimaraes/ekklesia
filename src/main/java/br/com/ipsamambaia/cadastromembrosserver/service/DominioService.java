package br.com.ipsamambaia.cadastromembrosserver.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Cargo;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Procedencia;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import br.com.ipsamambaia.cadastromembrosserver.repository.CargoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.EstadoCivilRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.ProcedenciaRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.ProfissaoRepository;

@Service
public class DominioService {

    @Autowired
    private ProfissaoRepository profissaoRepository;
    
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;
    
    @Autowired
    private ProcedenciaRepository procedenciaRepository;
    
    @Autowired
    private CargoRepository cargoRepository;
    
    public List<Profissao> obterProfissoes() {
        return profissaoRepository.findAll();
    }
    
    public List<EstadoCivil> obterEstadosCivis() {
        return estadoCivilRepository.findAll();
    }
    
    public List<Procedencia> obterProcedencias() {
        return procedenciaRepository.findAll();
    }
    
    public List<Cargo> obterCargos() {
        return cargoRepository.findAll();
    }
    
    public List<UF> obterUFs() {
        return Arrays.asList(UF.values());
    }
    
    public List<TipoEscolaridade> obterTiposEscolaridade() {
        return Arrays.asList(TipoEscolaridade.values());
    }
    
    public List<Sexo> obterSexos() {
        return Arrays.asList(Sexo.values());
    }
    
    public List<TipoAlocacao> obterTiposAlocacao() {
        return Arrays.asList(TipoAlocacao.values());
    }
}
