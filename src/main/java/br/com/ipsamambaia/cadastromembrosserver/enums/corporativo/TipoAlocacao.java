package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de alocação")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoAlocacao implements EnumJsonCreator {

    SEDE(0, "Sede"), NOVA_CONGREGACAO(1, "Nova congregação");

    private Integer id;
    private String descricao;

    private TipoAlocacao(Integer id, String descricao) {
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
    public static TipoAlocacao fromObject(final Map<String, Object> obj) {
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

    public static TipoAlocacao fromId(final Integer id) {
        for (TipoAlocacao e : TipoAlocacao.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
