package br.com.ipsamambaia.cadastromembrosserver.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Cargo;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.MeioAdmissao;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Procedencia;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.SituacaoCadastro;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.SituacaoOficialato;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoCadastroRol;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoMembro;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoParentesco;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoTelefone;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import br.com.ipsamambaia.cadastromembrosserver.repository.CargoRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.EstadoCivilRepository;
import br.com.ipsamambaia.cadastromembrosserver.repository.MeioAdmissaoRepository;
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
    private MeioAdmissaoRepository meioAdmissaoRepository;
    
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
    
    public List<MeioAdmissao> obterMeiosAdmissao() {
        return meioAdmissaoRepository.findAll();
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
    
    public List<TipoParentesco> obterTiposParentesco() {
        return Arrays.asList(TipoParentesco.values());
    }
    
    public List<SituacaoCadastro> obterSituacoesCadastroMembro() {
        return Arrays.asList(SituacaoCadastro.values());
    }
    
    public List<SituacaoOficialato> obterSituacoesOficialato() {
        return Arrays.asList(SituacaoOficialato.values());
    }
    
    public List<TipoCadastroRol> obterTiposCadastrosRol() {
        return Arrays.asList(TipoCadastroRol.values());
    }
    
    public List<TipoEstadoCivil> obterTiposEstadosCivil() {
        return Arrays.asList(TipoEstadoCivil.values());
    }
    
    public List<TipoMembro> obterTiposMembro() {
        return Arrays.asList(TipoMembro.values());
    }
    
    public List<TipoTelefone> obterTiposTelefone() {
        return Arrays.asList(TipoTelefone.values());
    }
}
