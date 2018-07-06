package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
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
}
