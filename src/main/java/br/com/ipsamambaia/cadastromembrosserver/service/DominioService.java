package br.com.ipsamambaia.cadastromembrosserver.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import br.com.ipsamambaia.cadastromembrosserver.repository.ProfissaoRepository;

@Service
public class DominioService {

    @Autowired
    private ProfissaoRepository profissaoRepository;
    
    public List<Profissao> obterProfissoes() {
        return profissaoRepository.findAll();
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
