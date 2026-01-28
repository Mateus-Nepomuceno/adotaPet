package br.com.adotapet.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorDeArquivo implements CarregaPerguntas {
    private String pathname;

    public LeitorDeArquivo(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public List<String> carrega() {
        List<String> perguntas = new ArrayList<>();

        try (FileReader fr = new FileReader(this.pathname); BufferedReader br = new BufferedReader(fr)) {
            String linha;
            while ((linha = br.readLine()) != null) {
                perguntas.add(linha);
            }
        } catch (IOException e){
            throw new RuntimeException("O arquivo não está disponível.");
        }
        return perguntas;
    }
}
