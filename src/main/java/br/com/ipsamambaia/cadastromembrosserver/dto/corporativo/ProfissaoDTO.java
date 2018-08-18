package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Profissao;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "Profissão")
public class ProfissaoDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único da profissão", position = 0)
    private Long id;

    @ApiModelProperty(notes = "Nome da profissão", required = true, position = 1)
    @NotBlank
    private String descricao;

    public ProfissaoDTO() {
        // default constructor
    }

    public ProfissaoDTO(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ProfissaoDTO(Profissao profissao) {
        this.id = profissao.getId();
        this.descricao = profissao.getNome();
    }

    public Profissao toEntity() {
        return new Profissao(getId());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
