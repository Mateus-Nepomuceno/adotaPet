package br.com.adotapet.pets;

public enum TipoSexo {
    MACHO("Macho"),
    FEMEA("Fêmea");

    public final String SEXO_RELATORIO;

    TipoSexo(String SEXO_RELATORIO) {
        this.SEXO_RELATORIO = SEXO_RELATORIO;
    }

    public static TipoSexo sexoPetRelatorio(String sexoRelatorio){
        for (TipoSexo tipoPet : values()) {
            if(tipoPet.SEXO_RELATORIO.equalsIgnoreCase(sexoRelatorio)){
                return tipoPet;
            }
        }
        throw new IllegalArgumentException("Sexo de pet inválido");
    }
}
