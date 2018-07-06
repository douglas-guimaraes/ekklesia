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
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.SituacaoOficialato;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoCadastroRol;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoMembro;

@Entity
@Table(name = "info_eclesiastica", schema = "corporativo")
public class InformacaoEclesiastica extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_info_eclesiastica", sequenceName = "corporativo.sq_info_eclesiastica", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_info_eclesiastica", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_membro")
    private TipoMembro tipoMembro;
    
    @ManyToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id")
    private Cargo cargo;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "st_oficialato")
    private SituacaoOficialato situacaoOficialato;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_cadastro_rol")
    private TipoCadastroRol tipoCadastroRol;
    
    @Column(name = "numero_ordem")
    private String numeroOrdem;
    
    @ManyToOne
    @JoinColumn(name = "id_procedencia", referencedColumnName = "id")
    private Procedencia procedencia;
    
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMembro getTipoMembro() {
        return tipoMembro;
    }

    public void setTipoMembro(TipoMembro tipoMembro) {
        this.tipoMembro = tipoMembro;
    }

    public SituacaoOficialato getSituacaoOficialato() {
        return situacaoOficialato;
    }

    public void setSituacaoOficialato(SituacaoOficialato situacaoOficialato) {
        this.situacaoOficialato = situacaoOficialato;
    }

    public TipoCadastroRol getTipoCadastroRol() {
        return tipoCadastroRol;
    }

    public void setTipoCadastroRol(TipoCadastroRol tipoCadastroRol) {
        this.tipoCadastroRol = tipoCadastroRol;
    }

    public String getNumeroOrdem() {
        return numeroOrdem;
    }

    public void setNumeroOrdem(String numeroOrdem) {
        this.numeroOrdem = numeroOrdem;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
}
