package br.com.adotapet.formulario;

import java.util.Scanner;

public class RespondeFormulario {
    private Scanner sc;
    private Formulario formulario;

    public RespondeFormulario(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void responde(){
        this.sc.nextLine();
        for (int i = 0; i < this.formulario.getPerguntas().size() ; i++) {
            String pergunta = this.formulario.getPerguntas().get(i);
            System.out.println(pergunta);

            var resposta = this.sc.nextLine();
        }
    }

    public Formulario getFormulario() {
        return formulario;
    }
}
