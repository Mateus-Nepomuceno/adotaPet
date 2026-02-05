package br.com.adotapet.formulario.resposta;

public class ProcessaRespostas {
    public static Double processaIdade(String resposta){
        double valor = Double.parseDouble(resposta);
        return ValidaRespostas.validaIdade(valor);
    }

    public static Double processaPeso(String resposta){
        double valor = Double.parseDouble(resposta.replace(",","."));
        ValidaRespostas.validaPeso(valor);
        return valor;
    }
}
