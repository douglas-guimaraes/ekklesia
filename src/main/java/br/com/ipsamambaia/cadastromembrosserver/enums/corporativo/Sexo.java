package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Sexo")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sexo implements EnumJsonCreator {

    MASCULINO(0, "Masculino"),
    FEMININO(1, "Feminino");
    
    private Integer id;
    private String descricao;

    private Sexo(Integer id, String descricao) {
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
    
    @JsonCreator
    public static Sexo fromObject(final Map<String, Object> obj) {
        if (obj != null && obj.containsKey(ID_MEMBER)) {
            Integer id = null;
            if (obj.get(ID_MEMBER) instanceof Integer) {
                id = (Integer) obj.get(ID_MEMBER);
            } else {
                id = Integer.parseInt((String) obj.get(ID_MEMBER));
            }

            return fromId(id);
        }

        return null;
    }

    public static Sexo fromId(final Integer id) {
        for (Sexo e : Sexo.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
