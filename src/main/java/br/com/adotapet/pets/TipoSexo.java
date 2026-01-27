package br.com.adotapet.pets;

public enum TipoSexo {
    MACHO("Macho"),
    FEMEA("Fêmea");

    public final String SEXO_RELATORIO;

    TipoSexo(String SEXO_RELATORIO) {
        this.SEXO_RELATORIO = SEXO_RELATORIO;
    }

    public String getSEXO_RELATORIO() {
        return SEXO_RELATORIO;
    }
}
