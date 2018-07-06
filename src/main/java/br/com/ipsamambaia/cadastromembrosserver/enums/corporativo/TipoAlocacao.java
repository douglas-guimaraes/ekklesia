package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoAlocacao {

    SEDE("Sede"),
    NOVA_CONGREGACAO("Nova congregação");
    
    private String descricao;

    private TipoAlocacao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
