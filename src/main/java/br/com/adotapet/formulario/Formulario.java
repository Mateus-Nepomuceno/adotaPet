package br.com.adotapet.formulario;

import br.com.adotapet.pets.TipoPet;
import br.com.adotapet.pets.TipoSexo;

import java.util.List;

public class Formulario {
    private List<String> perguntas;
    private Respostas respostas;

    public Formulario(List<String> perguntas) {
        this.perguntas = perguntas;
    }

    public void salvaRespostas(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, String endereco, double idade, double peso, String raca){
        Respostas respostas = new Respostas(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
        this.respostas = respostas;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }

    public Respostas getRespostas() {
        return respostas;
    }
}