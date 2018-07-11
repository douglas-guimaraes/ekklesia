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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "batismo", schema = "corporativo")
@ApiModel(description = "Repesenta o batismo de um membro")
public class Batismo extends BaseEntity<Long> {

    @Id
    @SequenceGenerator(name = "corporativo.sq_batismo", sequenceName = "corporativo.sq_batismo", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "corporativo.sq_batismo", strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    
    @ApiModelProperty(notes = "Data do batismo")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @Column(name = "data")
    private LocalDate data;
    
    @ApiModelProperty(notes = "Membro dono do relacionamento")
    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private Membro membro;
    
    @ApiModelProperty(notes = "Pastor que fez o batismo")
    @ManyToOne
    @JoinColumn(name = "id_pastor_batismo", referencedColumnName = "id")
    private Membro pastorBatismo;

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

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }
    
}
