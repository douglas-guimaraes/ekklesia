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
@Table(name = "procedencia", schema = "corporativo")
@ApiModel(description = "Repesenta a procedência de um membro")
public class Procedencia extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único da procedência")
    @Id
    @SequenceGenerator(name = "corporativo.sq_procedencia", sequenceName = "corporativo.sq_procedencia", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_procedencia", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Descrição")
    @NotBlank
    @Size(min = 1, max = 150)
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
