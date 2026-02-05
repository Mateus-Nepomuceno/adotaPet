package br.com.adotapet.pets;

import br.com.adotapet.endereco.Endereco;

public class Pet {
    private String nomeSobrenome;
    private TipoPet tipoPet;
    private TipoSexo tipoSexo;
    private Endereco endereco;
    private Double idade;
    private Double peso;
    private String raca;

    public Pet(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, Endereco endereco, Double idade, Double peso, String raca) {
        this.nomeSobrenome = nomeSobrenome;
        this.tipoPet = tipoPet;
        this.tipoSexo = tipoSexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public TipoSexo getTipoSexo() {
        return tipoSexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Double getIdade() {
        return idade;
    }

    public Double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeSobrenome +
                ", Tipo: " + tipoPet.NOME_RELATORIO +
                ", Sexo: " + tipoSexo.SEXO_RELATORIO +
                ", Endereço: " + endereco +
                ", Idade: " + idade +
                ", Peso: " + peso +
                ", Raça: " + raca;
    }
}