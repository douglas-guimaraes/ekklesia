package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoCadastroRol {

    PRINCIPAL("Principal"),
    SEPARADO("Separado"),
    DISCIPLINADO("Disciplinado");
    
    private String descricao;

    private TipoCadastroRol(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
}
