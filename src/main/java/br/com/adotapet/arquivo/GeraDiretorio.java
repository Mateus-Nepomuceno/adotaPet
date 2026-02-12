package br.com.adotapet.arquivo;

import java.io.File;

public class GeraDiretorio {
    public static void gera(String pathname){
        File diretorio = new File(pathname);
        if (!diretorio.exists()){
            boolean isDiretorioCriado = diretorio.mkdir();
            if (!isDiretorioCriado){
                throw new RuntimeException("O DIRETÓRIO 'petsCadastrados/' NÃO FOI CRIADO.");
            }
        }
    }
}