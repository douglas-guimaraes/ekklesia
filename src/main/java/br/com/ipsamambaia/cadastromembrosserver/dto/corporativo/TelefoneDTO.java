package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Telefone;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoTelefone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = "Telefone")
public class TelefoneDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do telefone")
    private Long id;

    @ApiModelProperty(notes = "DDD")
    @NotBlank
    @Size(min = 2, max = 2)
    private String ddd;

    @ApiModelProperty(notes = "Número")
    @NotBlank
    @Size(min = 1, max = 12)
    private String numero;

    @ApiModelProperty(notes = "Tipo do telefone")
    @Enumerated(EnumType.ORDINAL)
    private TipoTelefone tipoTelefone;

    public TelefoneDTO() {
        // default constructor
    }

    public TelefoneDTO(Telefone telefone) {
        this.id = telefone.getId();
        this.ddd = telefone.getDdd();
        this.numero = telefone.getNumero();
        this.tipoTelefone = telefone.getTipoTelefone();
    }

    public Telefone toEntity(Membro membro) {
        Telefone telefone = new Telefone();
        telefone.setDdd(this.ddd);
        telefone.setNumero(this.numero);
        telefone.setTipoTelefone(this.tipoTelefone);
        telefone.setMembro(membro);
        return telefone;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }
}
