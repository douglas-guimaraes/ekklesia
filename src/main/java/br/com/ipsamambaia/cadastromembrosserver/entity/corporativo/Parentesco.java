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
import javax.validation.constraints.Size;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoParentesco;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "parentesco", schema = "corporativo")
@ApiModel(description = "Repesenta o parentesco do membro")
public class Parentesco extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do parentesco")
    @Id
    @SequenceGenerator(name = "corporativo.sq_parentesco", sequenceName = "corporativo.sq_parentesco", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_parentesco", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Tipo de parentesco")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_parentesco")
    private TipoParentesco tipoParentesco;
    
    @ApiModelProperty(notes = "Nome do parente não afiliado à igreja")
    @Size(max = 150)
    @Column(name = "nome_parentesco_nao_afiliado")
    private String nomeParentescoNaoAfiliado;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;
    
    @ManyToOne
    @JoinColumn(name = "id_parente", referencedColumnName = "id")
    private Membro parente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeParentescoNaoAfiliado() {
        return nomeParentescoNaoAfiliado;
    }

    public void setNomeParentescoNaoAfiliado(String nomeParentescoNaoAfiliado) {
        this.nomeParentescoNaoAfiliado = nomeParentescoNaoAfiliado;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Membro getParente() {
        return parente;
    }

    public void setParente(Membro parente) {
        this.parente = parente;
    }
    
}
