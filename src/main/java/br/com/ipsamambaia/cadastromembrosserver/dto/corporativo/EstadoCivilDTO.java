package br.com.ipsamambaia.cadastromembrosserver.dto.corporativo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.dto.BaseDTO;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.EstadoCivil;
import br.com.ipsamambaia.cadastromembrosserver.entity.corporativo.Membro;
import br.com.ipsamambaia.cadastromembrosserver.enums.corporativo.TipoEstadoCivil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Estado civil")
public class EstadoCivilDTO extends BaseDTO<Long> {

    @ApiModelProperty(notes = "Identificador único do estado civil")
    private Long id;

    @ApiModelProperty(notes = "Tipo do estado civil")
    private TipoEstadoCivil estadoCivil;

    @ApiModelProperty(notes = "Data do casamento se o estado for casado(a)")
    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDate dataCasamento;

    public EstadoCivilDTO() {
        // default constructor
    }

    public EstadoCivilDTO(EstadoCivil estadoCivil) {
        this.id = estadoCivil.getId();
        this.estadoCivil = estadoCivil.getEstadoCivil();
        this.dataCasamento = estadoCivil.getDataCasamento();
    }

    public EstadoCivil toEntity(Membro membro) {
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setEstadoCivil(this.estadoCivil);
        estadoCivil.setDataCasamento(this.dataCasamento);
        estadoCivil.setMembro(membro);
        return estadoCivil;
    }
    
    public EstadoCivil toEntity(Membro membro, Integer idEstadoCivil) {
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setEstadoCivil(TipoEstadoCivil.fromId(idEstadoCivil));
        estadoCivil.setDataCasamento(this.dataCasamento);
        estadoCivil.setMembro(membro);
        return estadoCivil;
    }

    @Override
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
