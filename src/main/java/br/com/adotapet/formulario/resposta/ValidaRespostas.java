package br.com.adotapet.formulario.resposta;

public class ValidaRespostas {
    public static void validaNomeSobrenome(String nomeSobrenome) {
        String regex = "([a-zA-Z])+\\s([a-zA-Z])+";
        if (!nomeSobrenome.matches(regex)){
            throw new IllegalArgumentException("O pet precisa ter nome e sobrenome.");
        }
    }

    public static void validaPeso(double peso) {
        if (peso > 60 || peso < 0.5){
            throw new IllegalArgumentException("O peso do pet é inválido.");
        }
    }

    public static Double validaIdade(double idade) {
        if (idade > 20){
            throw new IllegalArgumentException("A idade do pet é inválida.");
        } else if (idade < 1) {
            idade = 0;
        }
        return idade;
    }
}
