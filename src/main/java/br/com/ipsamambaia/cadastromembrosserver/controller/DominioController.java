package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Cargo;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Procedencia;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.Sexo;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoAlocacao;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEscolaridade;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.UF;
import br.com.ipsamambaia.cadastromembrosserver.service.DominioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
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
    
    @RequestMapping(method = RequestMethod.GET, path = "/estadocivil", produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os estados civis.")
    public List<EstadoCivil> obterEstadosCivis() {
        return service.obterEstadosCivis();
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
}
