package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoTelefone {

    FIXO("Fixo"),
    CELULAR("Celular");
    
    private String descricao;

    private TipoTelefone(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
