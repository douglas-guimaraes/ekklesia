package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de membro")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoMembro implements EnumJsonCreator {

    COMUNGANTE(0, "Comungante"),
    NAO_COMUNGANTE(1, "Não comungante"),
    MINISTRO_EVANGELHO(2, "Ministro do evangelho");
    
    private Integer id;
    private String descricao;

    private TipoMembro(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    @JsonCreator
    public static TipoMembro fromObject(final Map<String, Object> obj) {
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

    public static TipoMembro fromId(final Integer id) {
        for (TipoMembro e : TipoMembro.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
