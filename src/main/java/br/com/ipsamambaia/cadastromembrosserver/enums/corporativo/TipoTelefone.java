package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de telefone")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoTelefone implements EnumJsonCreator {

    FIXO(0, "Fixo"),
    CELULAR(1, "Celular");
    
    private Integer id;
    private String descricao;

    private TipoTelefone(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
