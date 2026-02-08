package br.com.adotapet.formulario.resposta;

public class ProcessaRespostas {
    public static String processaIdade(String resposta){
        resposta = ValidaRespostas.validaEntradaNumerica(resposta);
        double valor = Double.parseDouble(resposta);
        ValidaRespostas.validaIdade(valor);
        return resposta + " anos";
    }

    public static String processaPeso(String resposta){
        resposta = ValidaRespostas.validaEntradaNumerica(resposta);
        double valor = Double.parseDouble(resposta);
        ValidaRespostas.validaPeso(valor);
        return resposta + "kg";
    }
}
