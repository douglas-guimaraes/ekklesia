package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;

@Entity
@Table(name = "admissao", schema = "corporativo")
public class Admissao extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_membro", sequenceName = "corporativo.sq_membro", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "data")
    private LocalDate data;
    
    @Column(name = "numero_ata")
    private String numeroAta;
    
    @Column(name = "igreja_origem")
    private String igrejaOrigem;
    
    @Column(name = "pastor_origem")
    private String pastorOrigem;
    
    @Column(name = "data_batismo")
    private LocalDate dataBatismo;
    
    @Column(name = "data_profissao_fe")
    private LocalDate dataProfissaoFe;
    
    @ManyToOne
    @JoinColumn(name = "id_meio_admissao", referencedColumnName = "id")
    private MeioAdmissao meioAdmissao;
    
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;
    
    @ManyToOne
    @JoinColumn(name = "id_pastor_admissao", referencedColumnName = "id")
    private Membro pastorAdmissao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getIgrejaOrigem() {
        return igrejaOrigem;
    }

    public void setIgrejaOrigem(String igrejaOrigem) {
        this.igrejaOrigem = igrejaOrigem;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public LocalDate getDataProfissaoFe() {
        return dataProfissaoFe;
    }

    public void setDataProfissaoFe(LocalDate dataProfissaoFe) {
        this.dataProfissaoFe = dataProfissaoFe;
    }

    public MeioAdmissao getMeioAdmissao() {
        return meioAdmissao;
    }

    public void setMeioAdmissao(MeioAdmissao meioAdmissao) {
        this.meioAdmissao = meioAdmissao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Membro getPastorAdmissao() {
        return pastorAdmissao;
    }

    public void setPastorAdmissao(Membro pastorAdmissao) {
        this.pastorAdmissao = pastorAdmissao;
    }
    
}
