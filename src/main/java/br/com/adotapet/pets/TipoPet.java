package br.com.adotapet.pets;

public enum TipoPet {
    CACHORRO("Cachorro"),
    GATO("Gato");

    public final String NOME_RELATORIO;

    TipoPet(String NOME_RELATORIO) {
        this.NOME_RELATORIO = NOME_RELATORIO;
    }

    public static TipoPet retornaPetRelatorio(String nome){
        for (TipoPet tipoPet : values()) {
            if(tipoPet.NOME_RELATORIO.equalsIgnoreCase(nome)){
                return tipoPet;
            }
        }
        throw new IllegalArgumentException("Tipo de pet inválido");
    }
}
