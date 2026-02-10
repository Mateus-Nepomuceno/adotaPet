package br.com.adotapet.resposta.controle;

public class ProcessaRespostas {
    public static String processaIdade(String resposta){
        resposta = ValidaRespostas.validaEntradaNumerica(resposta);
        double valor = Double.parseDouble(resposta);
        ValidaRespostas.validaIdade(valor);
        resposta = valor < 1 ? "0.x": resposta;
        return resposta + " anos";
    }

    public static String processaPeso(String resposta){
        resposta = ValidaRespostas.validaEntradaNumerica(resposta);
        double valor = Double.parseDouble(resposta);
        ValidaRespostas.validaPeso(valor);
        return resposta + "kg";
    }
}
