package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/v1/membro/")
@Api(description = "Conjunto de endpoints para criar, recuperar, atualizar e excluir membros.")
public class MembroController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os membros.")
    public List<Membro> obterTodosMembros() {
        return Collections.emptyList();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("Retorna um membro específico pelo seu identificador. 404 se não for encontrado.")
    public Membro obterMembroPorId(@ApiParam("Identificador do membro. Não pode ser vazio.") @PathVariable int id) {
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("Exclui o membro do sistema. 404 se o identificador informado for inválido.")
    public void excluirMembro(@ApiParam("Identificador do membro a ser deletado. Não pode ser vazio.") @PathVariable int id) {
        
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Cria um novo membro.")
    public Membro criarMembro(@ApiParam("Dados do membro a ser criado.")
                                   @RequestBody Membro membro) {
        return null;
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ApiOperation("Atualiza um membro existente.")
    public Membro atualizarMembro(@ApiParam("Dados do membro a ser atualizado.") @RequestBody Membro membro) {
        return null;
    }
}
