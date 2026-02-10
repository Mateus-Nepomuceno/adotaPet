package br.com.adotapet.arquivo.controle;

import br.com.adotapet.pet.Pet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeraNomeArquivo {
    public static String gera(Pet pet){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyy'T'Hmm");
        String data = LocalDateTime.now().format(dateTimeFormatter);
        String nomePet = pet.getNomeSobrenome().toUpperCase().replace(" ", "");
        return data+"-"+nomePet+".txt";
    }
}
