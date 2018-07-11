package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "meio_admissao", schema = "corporativo")
@ApiModel(description = "Repesenta o meio de admissão de um membro")
public class MeioAdmissao extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do meio de admissão")
    @Id
    @SequenceGenerator(name = "corporativo.sq_meio_admissao", sequenceName = "corporativo.sq_meio_admissao", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_meio_admissao", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Descrição", required = true)
    @NotBlank
    @Size(min = 1, max = 45)
    @Column(name = "descricao")
    private String descricao;

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
