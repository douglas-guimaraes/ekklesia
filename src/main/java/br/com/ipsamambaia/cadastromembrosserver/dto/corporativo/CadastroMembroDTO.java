package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.SituacaoCadastro;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(value = "Cadastro do membro", description = "Propriedades do cadastro do membro")
public class CadastroMembroDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do cadastro do membro")
    private Long id;

    @ApiModelProperty(notes = "Situação do cadastro")
    private SituacaoCadastro situacao;

    private LocalDateTime dataCriacao;

    private LocalDate dataAlteracao;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
