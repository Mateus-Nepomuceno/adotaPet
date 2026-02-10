package br.com.adotapet.resposta;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.endereco.controle.GeraEndereco;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.pet.TipoPet;
import br.com.adotapet.pet.TipoSexo;
import br.com.adotapet.resposta.controle.ProcessaRespostas;
import br.com.adotapet.resposta.controle.ValidaRespostas;

import java.util.List;
import java.util.Scanner;

public class RetornaRespostas {
    private Scanner sc;
    private List<String> perguntas;
    private static final String NAO_INFORMADO = "NÃO INFORMADO";
    private static final String ERRO_CAMPO_VAZIO = "Erro: Este campo não pode ficar vazio.";

    public RetornaRespostas(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.perguntas = formulario.getPerguntas();
    }

    public String retornaNomeSobrenome(){
        String resposta, nomeSobrenome = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(0));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                nomeSobrenome = NAO_INFORMADO;
                respostaValida = true;
            } else {
                try {
                    nomeSobrenome = ValidaRespostas.validaNomeSobrenome(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return nomeSobrenome;
    }

    public TipoPet retornaTipoPet(){
        String resposta;
        TipoPet tipoPet = null;
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(1));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                System.out.println(ERRO_CAMPO_VAZIO);
            } else {
                try {
                    tipoPet = TipoPet.retornaPetRelatorio(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return tipoPet;
    }

    public TipoSexo retornaTipoSexo(){
        String resposta;
        TipoSexo tipoSexo = null;
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(2));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                System.out.println(ERRO_CAMPO_VAZIO);
            } else {
                try {
                    tipoSexo = TipoSexo.retornaPetRelatorio(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return tipoSexo;
    }

    public Endereco retornaEndereco(){
        GeraEndereco geraEndereco = new GeraEndereco(this.sc);
        Endereco endereco = null;
        System.out.println(this.perguntas.get(3));
        endereco = geraEndereco.gera();
        return endereco;
    }

    public String retornaIdade(){
        String resposta, idade = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(4));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                idade = NAO_INFORMADO;
                respostaValida = true;
            } else {
                try {
                    idade = ProcessaRespostas.processaIdade(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return idade;
    }

    public String retornaPeso(){
        String resposta, peso = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(5));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                peso = NAO_INFORMADO;
                respostaValida = true;
            } else {
                try {
                    peso = ProcessaRespostas.processaPeso(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return peso;
    }

    public String retornaRaca(){
        String resposta, raca = "";
        boolean respostaValida = false;
        while (!respostaValida) {
            System.out.println(this.perguntas.get(6));
            resposta = this.sc.nextLine();

            if (resposta.isEmpty()){
                raca = NAO_INFORMADO;
                respostaValida = true;
            } else {
                try {
                    raca = ValidaRespostas.validaRaca(resposta);
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        return raca;
    }
}
