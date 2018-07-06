package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipo de cadastro no rol de membros")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoCadastroRol implements EnumJsonCreator {

    PRINCIPAL(0, "Principal"),
    SEPARADO(1, "Separado"),
    DISCIPLINADO(2, "Disciplinado");
    
    private Integer id;
    private String descricao;

    private TipoCadastroRol(Integer id, String descricao) {
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
    public static TipoCadastroRol fromObject(final Map<String, Object> obj) {
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

    public static TipoCadastroRol fromId(final Integer id) {
        for (TipoCadastroRol e : TipoCadastroRol.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
    
}
