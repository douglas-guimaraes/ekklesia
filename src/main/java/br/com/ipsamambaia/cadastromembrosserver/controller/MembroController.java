package br.com.ipsamambaia.cadastromembrosserver.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.service.MembroService;
import br.com.ipsamambaia.cadastromembrosserver.util.Loggable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/v1/membro/")
@Api(description = "Conjunto de endpoints para criar, recuperar, atualizar e excluir membros.")
public class MembroController implements Loggable {

    @Autowired
    private MembroService service;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os membros.")
    public List<Membro> obterTodosMembros() {
        return service.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("Retorna um membro específico pelo seu identificador. 404 se não for encontrado.")
    public ResponseEntity<Membro> obterMembroPorId(@ApiParam("Identificador do membro. Não pode ser vazio.") @PathVariable long id) {
        Optional<Membro> membro = service.findById(id);
        
        if (membro.isPresent()) {
            return ResponseEntity.ok(membro.get());
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("Exclui o membro do sistema. 404 se o identificador informado for inválido.")
    public ResponseEntity<Membro> excluirMembro(@ApiParam("Identificador do membro a ser deletado. Não pode ser vazio.") @PathVariable long id) {
        ResponseEntity<Membro> resp = obterMembroPorId(id);
        
        if (HttpStatus.NOT_FOUND.equals(resp.getStatusCode())) {
            return resp;
        }
        
        service.delete(resp.getBody());
        return new ResponseEntity<Membro>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Cria um novo membro.")
    public ResponseEntity<Membro> criarMembro(@ApiParam("Dados do membro a ser criado.")
                                   @RequestBody Membro membro) {
        try {
            membro.setId(null);
            Membro membroSalvo = service.save(membro);
            return new ResponseEntity<Membro>(membroSalvo, HttpStatus.OK);
        } catch (Exception e) {
            getLogger().error("Falha ao salvar membro", e);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", path = "/{id}")
    @ApiOperation("Atualiza um membro existente.")
    public Membro atualizarMembro(@ApiParam("Identificador do membro a ser atualizado.") @PathVariable long id,
        @ApiParam("Dados do membro a ser atualizado.") @RequestBody Membro membro) {
        
        membro.setId(id);
        return service.save(membro);
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/quantidade")
    @ApiOperation("Retorna a quantidade de membros cadastrados.")
    public Long contarMembros() {
        return service.count();
    }
}
