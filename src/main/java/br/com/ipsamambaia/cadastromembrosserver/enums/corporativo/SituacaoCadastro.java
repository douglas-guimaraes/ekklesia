package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum SituacaoCadastro {

    CADASTRADO("Cadastrado"),
    APROVADO("Aprovado"),
    REPROVADO("Reprovado");
    
    private String descricao;

    private SituacaoCadastro(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
