package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.SituacaoCadastro;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "cadastro_membro", schema = "corporativo")

public class CadastroMembro extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do cadastro do membro")
    @Id
    @SequenceGenerator(name = "corporativo.sq_cadastro_membro", sequenceName = "corporativo.sq_cadastro_membro", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_cadastro_membro", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(notes = "Situação do cadastro")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "st_cadastro")
    private SituacaoCadastro situacao;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ultima_alteracao")
    private LocalDate dataAlteracao;

    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;

    @ManyToOne
    @JoinColumn(name = "id_cadastrador", referencedColumnName = "id")
    private Membro cadastrador;

    @ManyToOne
    @JoinColumn(name = "id_validador", referencedColumnName = "id")
    private Membro validador;

    public CadastroMembro() {
        this.dataCriacao = LocalDateTime.now();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SituacaoCadastro getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCadastro situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public Membro getCadastrador() {
        return cadastrador;
    }

    public void setCadastrador(Membro cadastrador) {
        this.cadastrador = cadastrador;
    }

    public Membro getValidador() {
        return validador;
    }

    public void setValidador(Membro validador) {
        this.validador = validador;
    }
    
}
