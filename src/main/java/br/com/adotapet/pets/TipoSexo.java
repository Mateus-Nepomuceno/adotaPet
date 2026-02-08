package br.com.adotapet.pets;

public enum TipoSexo {
    MACHO("Macho"),
    FEMEA("Femea");

    public final String SEXO_RELATORIO;

    TipoSexo(String SEXO_RELATORIO) {
        this.SEXO_RELATORIO = SEXO_RELATORIO;
    }

    public static TipoSexo retornaPetRelatorio(String sexo){
        for (TipoSexo tipoPet : values()) {
            if(tipoPet.SEXO_RELATORIO.equalsIgnoreCase(sexo)){
                return tipoPet;
            }
        }
        throw new IllegalArgumentException("Sexo de pet inválido");
    }
}
