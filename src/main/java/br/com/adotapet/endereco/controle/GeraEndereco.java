package br.com.adotapet.endereco.controle;

import br.com.adotapet.endereco.Endereco;

import java.util.Scanner;

public class GeraEndereco {
    private Scanner sc;
    private static final String NAO_INFORMADO = "NÃO INFORMADO";
    private static final String ERRO_CAMPO_VAZIO = "Erro: Este campo não pode ficar vazio.";

    public GeraEndereco(Scanner sc) {
        this.sc = sc;
    }

    public Endereco gera(){
        String numCasa, cidade = "", rua = "";
        System.out.println("Digite o número da casa: ");
        numCasa = this.sc.nextLine();
        if (numCasa.isEmpty()){
            numCasa = NAO_INFORMADO;
        }

        cidade = repetirCampo(cidade,"cidade");
        rua = repetirCampo(rua,"rua");

        return new Endereco(numCasa, cidade, rua);
    }

    private String repetirCampo(String resposta, String campo){
        while (resposta.isEmpty()){
            System.out.println("Digite a "+campo+": ");
            resposta = this.sc.nextLine();
            if (resposta.isEmpty()){
                System.out.println(ERRO_CAMPO_VAZIO);
            }
        }
        return resposta;
    }
}
