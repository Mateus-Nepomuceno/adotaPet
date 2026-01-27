package br.com.adotapet.formulario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo implements Carrega {
    private String pathname;

    public LeitorDeArquivo(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public List<String> carregaPerguntas() {
        List<String> perguntas = new ArrayList<>();
        try (FileReader fr = new FileReader(this.pathname); BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                perguntas.add(linha);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return perguntas;
    }
}
