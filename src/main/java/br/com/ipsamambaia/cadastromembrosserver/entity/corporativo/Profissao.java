package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "profissao", schema = "corporativo")
@ApiModel(description = "Repesenta uma profissão.")
public class Profissao extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único da profissão.", position = 0)
    @Id
    @SequenceGenerator(name = "corporativo.sq_profissao", sequenceName = "corporativo.sq_profissao", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_profissao", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Nome da profissão.", required = true, position = 1)
    @NotBlank
    @Column(name = "nome")
    private String nome;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
