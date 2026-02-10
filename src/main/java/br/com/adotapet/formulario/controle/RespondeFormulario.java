package br.com.adotapet.formulario.controle;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.resposta.RetornaRespostas;
import br.com.adotapet.pet.TipoPet;
import br.com.adotapet.pet.TipoSexo;
import java.util.Scanner;

public class RespondeFormulario {
    private Scanner sc;
    private Formulario formulario;

    public RespondeFormulario(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void responde() {
        RetornaRespostas respostas = new RetornaRespostas(this.sc, this.formulario);

        String nomeSobrenome = respostas.retornaNomeSobrenome();
        TipoPet tipoPet = respostas.retornaTipoPet();
        TipoSexo tipoSexo = respostas.retornaTipoSexo();
        Endereco endereco = respostas.retornaEndereco();
        String idade = respostas.retornaIdade();
        String peso = respostas.retornaPeso();
        String raca = respostas.retornaRaca();

        this.formulario.salvaPet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }
}
