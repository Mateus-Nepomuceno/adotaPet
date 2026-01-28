package br.com.adotapet.formulario;

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

    public void criaPet(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, String endereco, double idade, double peso, String raca){
        this.pet = new Pet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public Pet getPet() {
        return pet;
    }
}