package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum SituacaoOficialato {

    ATIVO("Ativo"),
    DISPONIBILIDADE("Em disponibilidade");
    
    private String descricao;

    private SituacaoOficialato(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
