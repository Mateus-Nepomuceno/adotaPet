package br.com.adotapet.formulario;

import br.com.adotapet.pets.TipoPet;
import br.com.adotapet.pets.TipoSexo;

public class Respostas {
    private String nomeSobrenome;
    private TipoPet tipoPet;
    private TipoSexo tipoSexo;
    private String endereco;
    private double idade;
    private double peso;
    private String raca;

    public Respostas(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, String endereco, double idade, double peso, String raca) {
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

    public String getEndereco() {
        return endereco;
    }

    public double getIdade() {
        return idade;
    }

    public double getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }
}
