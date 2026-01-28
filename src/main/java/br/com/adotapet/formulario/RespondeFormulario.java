package br.com.adotapet.formulario;

import br.com.adotapet.pets.TipoPet;
import br.com.adotapet.pets.TipoSexo;

import java.util.Scanner;

public class RespondeFormulario  implements ValidaRespostas {
    private Scanner sc;
    private Formulario formulario;

    public RespondeFormulario(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void responde() {
        this.sc.nextLine();
        String nomeSobrenome = "", endereco = "", tipo = "", sexo = "", raca = "";
        TipoPet tipoPet = null;
        TipoSexo tipoSexo = null;

        double idade = 0, peso = 0;
        for (int i = 0; i < this.formulario.getPerguntas().size(); i++) {
            String pergunta = this.formulario.getPerguntas().get(i);
            System.out.println(pergunta);

            switch (i) {
                case 0:
                    nomeSobrenome = this.sc.nextLine();
                    this.validaNomeSobrenome(nomeSobrenome);
                    break;
                case 1:
                    tipo = this.sc.nextLine();
                    tipoPet = TipoPet.tipoPetRelatorio(tipo);
                    break;
                case 2:
                    sexo = this.sc.nextLine();
                    tipoSexo = TipoSexo.sexoPetRelatorio(sexo);
                    break;
                case 3:
                    endereco = this.sc.nextLine();
                    break;
                case 4:
                    idade = this.sc.nextDouble();
                    idade = this.validaIdade(idade);
                    break;
                case 5:
                    peso = this.sc.nextDouble();
                    this.validaPeso(peso);
                    break;
                case 6:
                    raca = this.sc.nextLine();
                    break;
            }
        }
        this.formulario.salvaRespostas(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }

    public Formulario getFormulario() {
        return formulario;
    }

    @Override
    public void validaNomeSobrenome(String nomeSobrenome) {
        if (!nomeSobrenome.contains(" ")){
            throw new IllegalArgumentException("O pet precisa ter nome e sobrenome.");
        }
    }

    @Override
    public void validaPeso(double peso) {
        if (peso > 60 || peso < 0.5){
            throw new IllegalArgumentException("O peso do pet é inválido.");
        }
    }

    @Override
    public double validaIdade(double idade) {
        if (idade > 20){
            throw new IllegalArgumentException("A idade do pet é inválida.");
        } else if (idade < 1) {
            idade = 0;
        }
        return idade;
    }
}
