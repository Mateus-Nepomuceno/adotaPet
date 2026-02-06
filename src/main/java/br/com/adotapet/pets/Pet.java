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
        atributos.add(this.endereco.enderecoCompleto());
        atributos.add(this.idade);
        atributos.add(this.peso);
        atributos.add(this.raca);
        return atributos;
    }

    public String getNomeSobrenome() {
        return nomeSobrenome;
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