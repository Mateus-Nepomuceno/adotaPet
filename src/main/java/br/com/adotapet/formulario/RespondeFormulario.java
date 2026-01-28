package br.com.adotapet.formulario;

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
        String nomeSobrenome = "", endereco = "", tipo = "", sexo = "", raca = "";
        TipoPet tipoPet = null;
        TipoSexo tipoSexo = null;
        double idade = 0, peso = 0;

        List<String> perguntas = this.formulario.getPerguntas();

        for (int i = 0; i < perguntas.size(); i++) {
            System.out.println(perguntas.get(i));

            String resposta = this.sc.nextLine();

            switch (i) {
                case 0:
                    nomeSobrenome = resposta;
                    ValidaRespostas.validaNomeSobrenome(nomeSobrenome);
                    break;
                case 1:
                    tipo = resposta;
                    tipoPet = TipoPet.tipoPetRelatorio(tipo);
                    break;
                case 2:
                    sexo = resposta;
                    tipoSexo = TipoSexo.sexoPetRelatorio(sexo);
                    break;
                case 3:
                    endereco = resposta;
                    break;
                case 4:
                    idade = Double.parseDouble(resposta);
                    idade = ValidaRespostas.validaIdade(idade);
                    break;
                case 5:
                    resposta = resposta.replace(",",".");
                    peso = Double.parseDouble(resposta);
                    ValidaRespostas.validaPeso(peso);
                    break;
                case 6:
                    raca = resposta;
                    break;
            }
        }
        this.formulario.criaPet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }
}
