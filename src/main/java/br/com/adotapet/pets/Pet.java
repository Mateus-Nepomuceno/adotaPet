package br.com.adotapet.pets;

import br.com.adotapet.endereco.Endereco;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nomeSobrenome;
    private TipoPet tipoPet;
    private TipoSexo tipoSexo;
    private Endereco endereco;
    private String idade;
    private String peso;
    private String raca;

    public Pet(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, Endereco endereco, String idade, String peso, String raca) {
        this.nomeSobrenome = nomeSobrenome;
        this.tipoPet = tipoPet;
        this.tipoSexo = tipoSexo;
        this.endereco = endereco;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public List<String> atributosPet(){
        List<String> atributos = new ArrayList<>();
        atributos.add(this.nomeSobrenome);
        atributos.add(this.tipoPet.NOME_RELATORIO);
        atributos.add(this.tipoSexo.SEXO_RELATORIO);
        atributos.add(this.endereco.toString());
        atributos.add(this.idade);
        atributos.add(this.peso);
        atributos.add(this.raca);
        return atributos;
    }

    public String getNomeSobrenome() {
        return this.nomeSobrenome;
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

    public String getIdade() {
        return idade;
    }

    public String getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    @Override
    public String toString() {
        return this.nomeSobrenome + " - " + this.tipoPet.NOME_RELATORIO +
                " - " + this.tipoSexo.SEXO_RELATORIO + " - " + this.endereco + " - " +
                this.idade + " - " + this.peso + " - " + this.raca;
    }
}