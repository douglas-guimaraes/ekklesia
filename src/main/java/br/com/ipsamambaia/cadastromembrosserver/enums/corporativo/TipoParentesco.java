package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de parentesco")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoParentesco implements EnumJsonCreator {

    PAI(0, "Pai"),
    MAE(1, "Mãe"),
    IRMAO(2, "Irmão(ã)"),
    ESPOSO(3, "Esposo(a)"),
    FILHO(4, "Filho(a)");
    
    private Integer id;
    private String descricao;

    private TipoParentesco(Integer id, String descricao) {
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
    public static TipoParentesco fromObject(final Map<String, Object> obj) {
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

    public static TipoParentesco fromId(final Integer id) {
        for (TipoParentesco e : TipoParentesco.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
