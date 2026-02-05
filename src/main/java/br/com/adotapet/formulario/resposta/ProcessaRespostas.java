package br.com.adotapet.formulario.resposta;

public class ProcessaRespostas {
    public static String processaIdade(String resposta){
        double valor = Double.parseDouble(resposta);
        return ValidaRespostas.validaIdade(valor);
    }

    public static String processaPeso(String resposta){
        resposta = ValidaRespostas.validaEntradaPeso(resposta);
        double valor = Double.parseDouble(resposta);
        return ValidaRespostas.validaPeso(valor);
    }
}
