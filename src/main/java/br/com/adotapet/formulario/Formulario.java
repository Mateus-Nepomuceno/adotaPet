package br.com.adotapet.formulario;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.pet.controle.GeraPet;
import br.com.adotapet.pet.Pet;
import br.com.adotapet.pet.TipoPet;
import br.com.adotapet.pet.TipoSexo;

import java.util.List;

public class Formulario {
    private List<String> perguntas;
    private Pet pet;

    public Formulario(List<String> perguntas) {
        this.perguntas = perguntas;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public Pet getPet() {
        return pet;
    }

    public void salvaPet(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, Endereco endereco, String idade, String peso, String raca){
        this.pet = new GeraPet().gera(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }
}