package br.com.adotapet.pets;

public enum TipoPet {
    CACHORRO("Cachorro"),
    GATO("Gato");

    public final String NOME_RELATORIO;

    TipoPet(String NOME_RELATORIO) {
        this.NOME_RELATORIO = NOME_RELATORIO;
    }

    public String getNOME_RELATORIO() {
        return NOME_RELATORIO;
    }
}
