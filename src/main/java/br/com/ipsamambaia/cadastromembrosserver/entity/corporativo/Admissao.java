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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "admissao", schema = "corporativo")
@ApiModel(description = "Repesenta a admissão de um membro na igreja local")
public class Admissao extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único da admissão")
    @Id
    @SequenceGenerator(name = "corporativo.sq_membro", sequenceName = "corporativo.sq_membro", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Data da admissão")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data")
    private LocalDate data;
    
    @ApiModelProperty(notes = "Número da ata")
    @Size(max = 45)
    @Column(name = "numero_ata")
    private String numeroAta;
    
    @ApiModelProperty(notes = "Igreja de origem")
    @Size(max = 150)
    @Column(name = "igreja_origem")
    private String igrejaOrigem;
    
    @ApiModelProperty(notes = "Nome do pastor da igreja de origem")
    @Size(max = 150)
    @Column(name = "pastor_origem")
    private String pastorOrigem;
    
    @ApiModelProperty(notes = "Data do batismo")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data_batismo")
    private LocalDate dataBatismo;
    
    @ApiModelProperty(notes = "Data da profissão de fé")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data_profissao_fe")
    private LocalDate dataProfissaoFe;
    
    @ApiModelProperty(notes = "Meio de admissão")
    @ManyToOne
    @JoinColumn(name = "id_meio_admissao", referencedColumnName = "id")
    private MeioAdmissao meioAdmissao;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;
    
    @ApiModelProperty(notes = "Pastor da igreja local que fez o batismo")
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
