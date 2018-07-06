package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ipsamambaia.cadastromembrosserver.enums.EnumJsonCreator;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Situação do cadastro do membro")
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SituacaoCadastro implements EnumJsonCreator {

    CADASTRADO(0, "Cadastrado"),
    APROVADO(1, "Aprovado"),
    REPROVADO(2, "Reprovado");
    
    private Integer id;
    private String descricao;

    private SituacaoCadastro(Integer id, String descricao) {
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
    public static SituacaoCadastro fromObject(final Map<String, Object> obj) {
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

    public static SituacaoCadastro fromId(final Integer id) {
        for (SituacaoCadastro e : SituacaoCadastro.values()) {
            if (id.equals(e.getId())) {
                return e;
            }
        }

        return null;
    }
}
