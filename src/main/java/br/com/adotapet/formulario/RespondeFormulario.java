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

    public RespondeFormulario(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void responde() {
        String nomeSobrenome = "", raca = "", resposta = "";
        Double peso = 0.0, idade = 0.0;
        TipoPet tipoPet = null;
        TipoSexo tipoSexo = null;
        Endereco endereco = null;

        List<String> perguntas = this.formulario.getPerguntas();

        for (int i = 0; i < perguntas.size(); i++) {
            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.println(perguntas.get(i));
                if (i != 3) {
                    resposta = this.sc.nextLine();
                }
                try {
                    switch (i) {
                        case 0: ValidaRespostas.validaNomeSobrenome(resposta); nomeSobrenome = resposta; break;
                        case 1: tipoPet = TipoPet.tipoPetRelatorio(resposta); break;
                        case 2: tipoSexo = TipoSexo.sexoPetRelatorio(resposta); break;
                        case 3: endereco = identificaEndereco(); break;
                        case 4: idade = ProcessaRespostas.processaIdade(resposta); break;
                        case 5: peso = ProcessaRespostas.processaPeso(resposta); break;
                        case 6: raca = resposta; break;
                    }
                    respostaValida = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            }
        }
        this.formulario.criaPet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }

    public Endereco identificaEndereco() {
        String numCasa, cidade, rua;
        System.out.println("Digite o número da casa: ");
        numCasa = this.sc.nextLine();
        System.out.println("Digite a cidade: ");
        cidade = this.sc.nextLine();
        System.out.println("Digite a rua: ");
        rua = this.sc.nextLine();

        return new Endereco(numCasa, cidade, rua);
    }
}
