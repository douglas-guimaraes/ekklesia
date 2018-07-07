package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoTelefone;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "telefone", schema = "corporativo")
@ApiModel(description = "Repesenta o telefone de um membro")
public class Telefone extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do telefone")
    @Id
    @SequenceGenerator(name = "corporativo.sq_telefone", sequenceName = "corporativo.sq_telefone", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_telefone", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "DDD")
    @NotBlank
    @Size(min = 2, max = 2)
    @Column(name = "ddd")
    private String ddd;
    
    @ApiModelProperty(notes = "Número")
    @NotBlank
    @Size(min = 1, max = 12)
    @Column(name = "numero")
    private String numero;
    
    @ApiModelProperty(notes = "Tipo do telefone")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_telefone")
    private TipoTelefone tipoTelefone;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;

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

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

}
