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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEstadoCivil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "estado_civil", schema = "corporativo")
@ApiModel(description = "Repesenta um estado civil")
public class EstadoCivil extends BaseEntity<Long> {

    @ApiModelProperty(notes = "Identificador único do estado civil")
    @Id
    @SequenceGenerator(name = "corporativo.sq_estado_civil", sequenceName = "corporativo.sq_estado_civil", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_estado_civil", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Tipo do estado civil")
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tp_estado_civil")
    private TipoEstadoCivil estadoCivil;
    
    @ApiModelProperty(notes = "Data do casamento se o estado for casado(a)")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data_casamento")
    private LocalDate dataCasamento;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;

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
    
}
