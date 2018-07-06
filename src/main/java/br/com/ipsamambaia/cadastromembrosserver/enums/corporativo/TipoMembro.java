package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoMembro {

    COMUNGANTE("Comungante"),
    NAO_COMUNGANTE("Não comungante"),
    MINISTRO_EVANGELHO("Ministro do evangelho");
    
    private String descricao;

    private TipoMembro(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
