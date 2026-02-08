package br.com.adotapet.endereco;

public class Endereco {
    private String numeroCasa;
    private String cidade;
    private String rua;

    public Endereco(String numeroCasa, String cidade, String rua) {
        this.numeroCasa = numeroCasa;
        this.cidade = cidade;
        this.rua = rua;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    @Override
    public String toString() {
        return this.rua + ", " + this.numeroCasa +
                ", " + this.cidade;
    }
}
