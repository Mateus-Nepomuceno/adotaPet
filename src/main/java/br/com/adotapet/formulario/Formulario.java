package br.com.adotapet.formulario;

import java.util.List;

public class Formulario {
    private List<String> perguntas;

    public Formulario(List<String> perguntas) {
        this.perguntas = perguntas;
    }

    public List<String> getPerguntas() {
        return perguntas;
    }
}