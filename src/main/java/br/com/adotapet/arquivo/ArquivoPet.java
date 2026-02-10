package br.com.adotapet.arquivo;

import br.com.adotapet.arquivo.controle.EditaArquivo;
import br.com.adotapet.arquivo.controle.EscreveArquivo;
import br.com.adotapet.arquivo.controle.GeraArquivo;
import br.com.adotapet.arquivo.controle.GeraNomeArquivo;
import br.com.adotapet.pet.Pet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoPet implements EditaArquivo, GeraArquivo, EscreveArquivo {
    private String pathname;
    public ArquivoPet(String pathname) {
        this.pathname = pathname;
    }

    @Override
    public void edita(Pet pet) {
        String nomeArquivo = pet.getNomeArquivo();
        escreve(pet, this.pathname, nomeArquivo);
    }

    @Override
    public void gera(Pet pet) {
        String nomeArquivo = GeraNomeArquivo.gera(pet);
        pet.setNomeArquivo(nomeArquivo);
        escreve(pet, this.pathname, nomeArquivo);
    }

    @Override
    public void escreve(Pet pet, String pathname, String nomeArquivo){
        try(FileWriter fw = new FileWriter(this.pathname+nomeArquivo); BufferedWriter bw = new BufferedWriter(fw)) {
            List<String> atributos = pet.atributosPet();
            for (int i = 0; i < atributos.size(); i++) {
                bw.write((i+1)+" - "+atributos.get(i));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu um erro ao gerar o arquivo.");
        }
    }
}
