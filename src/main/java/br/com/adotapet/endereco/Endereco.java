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

    @Override
    public String toString() {
        return "(Número: " + numeroCasa +
                ", Cidade: " + cidade +
                ", Rua: " + rua + ")";
    }
}
