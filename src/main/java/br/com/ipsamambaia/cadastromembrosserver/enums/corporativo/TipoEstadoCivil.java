package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    
    @JsonCreator
    public static TipoEstadoCivil fromObject(final Map<String, Object> obj) {
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

    public static TipoEstadoCivil fromId(final Integer id) {
        for (TipoEstadoCivil e : TipoEstadoCivil.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
