package br.com.adotapet.arquivo;

import br.com.adotapet.pets.Pet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeraArquivoPet {
    private String pathname;

    public GeraArquivoPet(String pathname) {
        this.pathname = pathname;
    }

    public void geraArquivo(Pet pet){
        String nomeArquivo = geraNomeArquivo(pet);
        try(FileWriter fw = new FileWriter(this.pathname+nomeArquivo); BufferedWriter bw = new BufferedWriter(fw)) {
            List<String> atributos = pet.atributosPet();
            for (int i = 0; i < atributos.size(); i++) {
                bw.write(i+1+" - "+atributos.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu um erro ao gerar o arquivo.");
        }
    }

    private String geraNomeArquivo(Pet pet){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy'T'Hmm");
        String data = LocalDateTime.now().format(dateTimeFormatter);
        String nomePet = pet.getNomeSobrenome().toUpperCase().replace(" ", "");
        return data+"-"+nomePet+".txt";
    }
}
