package br.com.adotapet.formulario.resposta;

public class ValidaRespostas {
    public static String validaNomeSobrenome(String nomeSobrenome) {
        String regex = "([a-zA-Z])+(\\s([a-zA-Z])+)+";
        if (!nomeSobrenome.matches(regex)){
            throw new IllegalArgumentException("O pet precisa ter nome e sobrenome e não pode utilizar números ou símbolos.");
        }
        return nomeSobrenome;
    }

    public static String validaEntradaNumerica(String resposta){
        String regex = "([0-9])+([.,]([0-9])+)*";
        if (!resposta.matches(regex)){
            throw new IllegalArgumentException("O peso do pet é inválido, use apenas números e . ou ,");
        }
        if (resposta.contains(",")){
            resposta = resposta.replace(",",".");
        }
        return resposta;
    }

    public static void validaPeso(double peso) {
        if (peso > 60 || peso < 0.5){
            throw new IllegalArgumentException("O peso do pet é inválido, não pode ser superior a 60 nem inferior a 0,5");
        }
    }

    public static void validaIdade(double idade) {
        if (idade > 20){
            throw new IllegalArgumentException("A idade do pet é inválida, precisa ser menor que 20.");
        }
    }

    public static String validaRaca(String raca){
        String regex = "([a-zA-Z\\s])+";
        if (!raca.matches(regex)){
            throw new IllegalArgumentException("A raça do pet é inválida, use apenas letras.");
        }
        return raca;
    }
}
