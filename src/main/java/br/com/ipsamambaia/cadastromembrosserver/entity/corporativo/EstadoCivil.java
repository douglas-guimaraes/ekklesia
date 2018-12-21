package br.com.ipsamambaia.cadastromembrosserver.entity.corporativo;

import java.time.LocalDate;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEstadoCivil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "estado_civil", schema = "corporativo")
public class EstadoCivil extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_estado_civil", sequenceName = "corporativo.sq_estado_civil", allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_estado_civil", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_estado_civil")
    private TipoEstadoCivil estadoCivil;

    @Column(name = "data_casamento")
    private LocalDate dataCasamento;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    @JsonIgnore
    private Membro membro;

    public EstadoCivil() {
        // empty constructor
    }
    
    public EstadoCivil(Long id) {
    	this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(TipoEstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public LocalDate getDataCasamento() {
        return dataCasamento;
    }

    public void setDataCasamento(LocalDate dataCasamento) {
        this.dataCasamento = dataCasamento;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

}
