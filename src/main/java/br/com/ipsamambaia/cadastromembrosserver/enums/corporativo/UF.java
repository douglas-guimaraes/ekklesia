package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Unidades federativas do Brasil")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UF implements EnumJsonCreator {
    
    AC(0, "Acre"),
    AL(1, "Alagoas"),
    AP(2, "Amapá"),
    AM(3, "Amazonas"),
    BA(4, "Bahia"),
    CE(5, "Ceará"),
    DF(6, "Distrito Federal"),
    ES(7, "Espírito Santo"),
    GO(8, "Goiás"),
    MA(9, "Maranhão"),
    MT(10, "Mato Grosso"),
    MS(11, "Mato Grosso do Sul"),
    MG(12, "Minas Gerais"),
    PA(13, "Pará"),
    PB(14, "Paraíba"),
    PR(15, "Paraná"),
    PE(16, "Pernambuco"),
    PI(17, "Piauí"),
    RJ(18, "Rio de Janeiro"),
    RN(19, "Rio Grande do Norte"),
    RS(20, "Rio Grande do Sul"),
    RO(21, "Rondônia"),
    RR(22, "Roraima"),
    SC(23, "Santa Catarina"),
    SP(24, "São Paulo"),
    SE(25, "Sergipe"),
    TO(26, "Tocantins");

    private Integer id;
    private String descricao;

    private UF(Integer id, String descricao) {
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
    public static UF fromObject(final Map<String, Object> obj) {
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

    public static UF fromId(final Integer id) {
        for (UF e : UF.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
    
}
