package br.com.ipsamambaia.cadastromembrosserver.controller;

import br.com.ipsamambaia.cadastromembrosserver.dto.corporativo.CadastroBasicoDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.service.MembroService;
import br.com.ipsamambaia.cadastromembrosserver.util.Loggable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "${origin.host}", maxAge = 3600)
@RestController
@RequestMapping(path = "/v1/membro/", consumes = MediaType.APPLICATION_JSON_VALUE, produces =  MediaType.APPLICATION_JSON_VALUE)
@Api(description = "Conjunto de endpoints para criar, recuperar, atualizar e excluir membros.")
public class MembroController implements Loggable {

    @Autowired
    private MembroService service;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Retorna uma lista de todos os membros.")
    public List<Membro> obterTodosMembros(Pageable pageable) {
        return service.findAll(pageable);
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "cadastrobasico")
    @ApiOperation("Cria um novo cadastro básico.")
    public ResponseEntity<CadastroBasicoDTO> criarCadastroBasico(@ApiParam("Novos dados básicos de um membro.")
                                   @RequestBody CadastroBasicoDTO cadastroBasico) {
        try {
            service.save(cadastroBasico);
            return new ResponseEntity<>(cadastroBasico, HttpStatus.OK);
        } catch (Exception e) {
            getLogger().error("Falha ao salvar membro", e);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", path = "/cadastrobasico/{id}")
    @ApiOperation("Atualiza um cadastro básico existente. 404 se o identificador informado for inválido.")
    public ResponseEntity<CadastroBasicoDTO> atualizarCadastroBasico(
            @ApiParam("Identificador do cadastro básico a ser atualizado.") @PathVariable long id,
            @ApiParam("Dados do cadastro básico a ser atualizado.") @RequestBody CadastroBasicoDTO cadastroBasicoDTO) {

        Optional<Membro> membroTemp = service.findById(id);

        if (!membroTemp.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(service.update(membroTemp.get(), cadastroBasicoDTO));
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/quantidade")
    @ApiOperation("Retorna a quantidade de membros cadastrados.")
    public Long contarMembros() {
        return service.count();
    }

}
