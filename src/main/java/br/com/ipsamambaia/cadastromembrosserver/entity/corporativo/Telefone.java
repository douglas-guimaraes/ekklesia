package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoTelefone;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "telefone", schema = "corporativo")
public class Telefone extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_telefone", sequenceName = "corporativo.sq_telefone", allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_telefone", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "ddd")
    private String ddd;
    
    @Column(name = "numero")
    private String numero;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_telefone")
    private TipoTelefone tipoTelefone;
    
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    @JsonIgnore
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
