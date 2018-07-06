package br.com.ipsamambaia.cadastromembrosserver.enums.corporativo;

public enum TipoParentesco {

    PAI("Pai"),
    MAE("Mãe"),
    IRMAO("Irmão(ã)"),
    ESPOSO("Esposo(a)"),
    FILHO("Filho(a)");
    
    private String descricao;

    private TipoParentesco(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
