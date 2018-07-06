package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Tipos de escolaridade")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoEscolaridade implements EnumJsonCreator {

    NAO_INFORMADA(0, "Não informada"),
    NAO_ALFABETIZADO(1, "Não alfabetizado(a)"),
    ALFABETIZADO(2, "Alfabetizado(a)"),
    ENSINO_MEDIO_INCOMPLETO(3, "Ensino médio incompleto"),
    ENSINO_MEDIO_COMPLETO(4, "Ensino médio completo"),
    ENSINO_PROFISSIONALIZANTE(5, "Ensino profissionalizante"),
    GRADUADO(6, "Graduado"),
    POS_GRADUADO(7, "Pós-graduação Lato Sensu"),
    MESTRADO(8, "Mestrado"),
    DOUTORADO(9, "Doutorado"),
    POS_DOUTORADO(10, "Pós-doutorado");
    
    private Integer id;
    private String descricao;

    private TipoEscolaridade(Integer id, String descricao) {
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
    public static TipoEscolaridade fromObject(final Map<String, Object> obj) {
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

    public static TipoEscolaridade fromId(final Integer id) {
        for (TipoEscolaridade e : TipoEscolaridade.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
