package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Unidades federativas do Brasil")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UF implements EnumJsonCreator {
    
    AC(0, "AC", "Acre"),
    AL(1, "AL", "Alagoas"),
    AP(2, "AP", "Amapá"),
    AM(3, "AM", "Amazonas"),
    BA(4, "BA", "Bahia"),
    CE(5, "CE", "Ceará"),
    DF(6, "DF", "Distrito Federal"),
    ES(7, "ES", "Espírito Santo"),
    GO(8, "GO", "Goiás"),
    MA(9, "MA", "Maranhão"),
    MT(10, "MT", "Mato Grosso"),
    MS(11, "MS", "Mato Grosso do Sul"),
    MG(12, "MG", "Minas Gerais"),
    PA(13, "PA", "Pará"),
    PB(14, "PB", "Paraíba"),
    PR(15, "PR", "Paraná"),
    PE(16, "PE", "Pernambuco"),
    PI(17, "PI", "Piauí"),
    RJ(18, "RJ", "Rio de Janeiro"),
    RN(19, "RN", "Rio Grande do Norte"),
    RS(20, "RS", "Rio Grande do Sul"),
    RO(21, "RO", "Rondônia"),
    RR(22, "RR", "Roraima"),
    SC(23, "SC", "Santa Catarina"),
    SP(24, "SP", "São Paulo"),
    SE(25, "SE", "Sergipe"),
    TO(26, "TO", "Tocantins");

    private Integer id;
    private String sigla;
    private String descricao;

    private UF(Integer id, String sigla, String descricao) {
        this.id = id;
        this.sigla = sigla;
        this.descricao = descricao;
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getSigla() {
        return sigla;
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
    
    public static UF fromSigla(String sigla) {
    	for (UF e : UF.values()) {
            if (e.getSigla().equals(sigla)) {
                return e;
            }
        }
    	return null;
    }
    
}
