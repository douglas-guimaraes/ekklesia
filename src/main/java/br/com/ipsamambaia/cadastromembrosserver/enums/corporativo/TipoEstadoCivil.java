package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoEstadoCivil {

    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    SEPARADO("Separado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)"),
    EM_UNIAO_ESTAVEL("Em união estável");
    
    private String descricao;

    private TipoEstadoCivil(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
