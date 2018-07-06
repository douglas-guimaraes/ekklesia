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

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoParentesco;

@Entity
@Table(name = "parentesco", schema = "corporativo")
public class Parentesco extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_parentesco", sequenceName = "corporativo.sq_parentesco", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_parentesco", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_parentesco")
    private TipoParentesco tipoParentesco;
    
    @Column(name = "nome_parentesco_nao_afiliado")
    private String nomeParentescoNaoAfiliado;
    
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
