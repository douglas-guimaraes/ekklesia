package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de estado civil")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoEstadoCivil implements EnumJsonCreator {


    SOLTEIRO(0, "Solteiro(a)"),
    CASADO(1, "Casado(a)"),
    SEPARADO(2, "Separado(a)"),
    DIVORCIADO(3, "Divorciado(a)"),
    VIUVO(4, "Viúvo(a)"),
    EM_UNIAO_ESTAVEL(5, "Em união estável");
    
    private Integer id;
    private String descricao;

    private TipoEstadoCivil(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
