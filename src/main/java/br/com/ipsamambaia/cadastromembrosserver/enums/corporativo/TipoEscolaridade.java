package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoEscolaridade {

    NAO_INFORMACA("Não informada"),
    NAO_ALFABETIZADO("Não alfabetizado(a)"),
    ALFABETIZADO("Alfabetizado(a)"),
    ENSINO_MEDIO_INCOMPLETO("Ensino médio incompleto"),
    ENSINO_MEDIO_COMPLETO("Ensino médio completo"),
    ENSINO_PROFISSIONALIZANTE("Ensino profissionalizante"),
    GRADUADO("Graduado"),
    POS_GRADUADO("Pós-graduação Lato Sensu"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado"),
    POS_DOUTORADO("Pós-doutorado");
    
    private String descricao;

    private TipoEscolaridade(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
