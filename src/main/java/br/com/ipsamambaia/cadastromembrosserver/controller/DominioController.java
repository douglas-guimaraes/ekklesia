package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Cargo;
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
import br.com.ipsamambaia.cadastromembrosserver.service.DominioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/dominio/")
@Api(description = "Conjunto de endpoints com os domínios da aplicação.")
public class DominioController {
    
    @Autowired
    private DominioService service;
    
    @RequestMapping(method = RequestMethod.GET, path = "/profissao", produces = "application/json")
    @ApiOperation("Retorna uma lista de todas as profissões.")
    public List<Profissao> obterProfissoes() {
        return service.obterProfissoes();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/uf", produces = "application/json")
    @ApiOperation("Retorna todas Unidades Federativas do Brasil.")
    public List<UF> obterUFs() {
        return service.obterUFs();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/escolaridade", produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os tipos de escolaridade.")
    public List<TipoEscolaridade> obterTiposEscolaridade() {
        return service.obterTiposEscolaridade();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/sexo", produces = "application/json")
    @ApiOperation("Retorna uma lista com os domínios de sexo.")
    public List<Sexo> obterSexos() {
        return service.obterSexos();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/alocacao", produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os tipos de alocação.")
    public List<TipoAlocacao> obterTiposAlocacao() {
        return service.obterTiposAlocacao();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/procedencia", produces = "application/json")
    @ApiOperation("Retorna uma lista de todas as procedências.")
    public List<Procedencia> obterProcedencias() {
        return service.obterProcedencias();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/cargo", produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os cargos.")
    public List<Cargo> obterCargos() {
        return service.obterCargos();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/meioadmissao", produces = "application/json")
    @ApiOperation("Retorna uma lista de meios de admissão.")
    public List<MeioAdmissao> obterMeiosAdmissao() {
        return service.obterMeiosAdmissao();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/parentesco", produces = "application/json")
    @ApiOperation("Retorna uma lista de tipo de parentesco.")
    public List<TipoParentesco> obterTiposParentesco() {
        return service.obterTiposParentesco();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/situacaocadastromembro", produces = "application/json")
    @ApiOperation("Retorna uma lista das situações do cadastro de um membro.")
    public List<SituacaoCadastro> obterSituacoesCadastroMembro() {
        return service.obterSituacoesCadastroMembro();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/situacaooficialato", produces = "application/json")
    @ApiOperation("Retorna uma lista de situações do oficialato.")
    public List<SituacaoOficialato> obterSituacoesOficialato() {
        return service.obterSituacoesOficialato();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/cadastrorol", produces = "application/json")
    @ApiOperation("Retorna uma lista dos tipos de cadastro do rol de membros.")
    public List<TipoCadastroRol> obterTiposCadastrosRol() {
        return service.obterTiposCadastrosRol();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/estadocivil", produces = "application/json")
    @ApiOperation("Retorna uma lista dos tipos de estado civil.")
    public List<TipoEstadoCivil> obterTiposEstadosCivil() {
        return service.obterTiposEstadosCivil();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tipomembro", produces = "application/json")
    @ApiOperation("Retorna uma lista dos tipos de membro.")
    public List<TipoMembro> obterTiposMembro() {
        return service.obterTiposMembro();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/tipotelefone", produces = "application/json")
    @ApiOperation("Retorna uma lista dos tipos de telefone.")
    public List<TipoTelefone> obterTiposTelefone() {
        return service.obterTiposTelefone();
    }
}
