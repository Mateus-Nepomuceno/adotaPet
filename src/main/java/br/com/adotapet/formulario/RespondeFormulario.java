package br.com.adotapet.formulario;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.formulario.resposta.ProcessaRespostas;
import br.com.adotapet.formulario.resposta.ValidaRespostas;
import br.com.adotapet.pets.TipoPet;
import br.com.adotapet.pets.TipoSexo;

import java.util.List;
import java.util.Scanner;

public class RespondeFormulario {
    private Scanner sc;
    private Formulario formulario;
    private static final String NAO_INFORMADO = "NÃO INFORMADO";
    private static final String ERRO_CAMPO_VAZIO = "Erro: Este campo não pode ficar vazio.";

    public RespondeFormulario(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void responde() {
        String resposta, nomeSobrenome = "", raca = "", peso = "", idade = "";
        TipoPet tipoPet = null;
        TipoSexo tipoSexo = null;
        Endereco endereco = null;

        List<String> perguntas = this.formulario.getPerguntas();

        for (int i = 0; i < perguntas.size(); i++) {
            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.println(perguntas.get(i));
                if (i == 3) {
                    endereco = criaEndereco();
                    respostaValida = true;
                    continue;
                }

                resposta = this.sc.nextLine();

                if (resposta.isEmpty()){
                    if(i == 0 || i == 4 || i == 5 || i == 6){
                        switch (i) {
                            case 0: nomeSobrenome = NAO_INFORMADO; break;
                            case 4: idade = NAO_INFORMADO; break;
                            case 5: peso = NAO_INFORMADO; break;
                            case 6: raca = NAO_INFORMADO; break;
                        }
                        respostaValida = true;
                    } else {
                        System.out.println(ERRO_CAMPO_VAZIO);
                    }
                } else {
                    try {
                        switch (i) {
                            case 0: nomeSobrenome = ValidaRespostas.validaNomeSobrenome(resposta); break;
                            case 1: tipoPet = TipoPet.retornaPetRelatorio(resposta); break;
                            case 2: tipoSexo = TipoSexo.retornaPetRelatorio(resposta); break;
                            case 4: idade = ProcessaRespostas.processaIdade(resposta); break;
                            case 5: peso = ProcessaRespostas.processaPeso(resposta); break;
                            case 6: raca = ValidaRespostas.validaRaca(resposta); break;
                        }
                        respostaValida = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                }
            }
        }
        this.formulario.criaPet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }

    private Endereco criaEndereco(){
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
