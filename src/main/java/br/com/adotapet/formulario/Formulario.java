package br.com.adotapet.formulario;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.pets.Pet;
import br.com.adotapet.pets.TipoPet;
import br.com.adotapet.pets.TipoSexo;

import java.util.List;

public class Formulario {
    private List<String> perguntas;
    private Pet pet;

    public Formulario(List<String> perguntas) {
        this.perguntas = perguntas;
    }

    protected void criaPet(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, Endereco endereco, String idade, String peso, String raca){
        this.pet = new Pet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public Pet getPet() {
        return pet;
    }
}