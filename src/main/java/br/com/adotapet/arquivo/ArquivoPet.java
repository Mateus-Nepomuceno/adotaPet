package br.com.adotapet.arquivo;

import br.com.adotapet.arquivo.controle.EditaArquivo;
import br.com.adotapet.arquivo.controle.EscreveArquivo;
import br.com.adotapet.arquivo.controle.GeraArquivo;
import br.com.adotapet.arquivo.controle.GeraNomeArquivo;
import br.com.adotapet.pet.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoPet implements EditaArquivo, GeraArquivo, EscreveArquivo {
    private static final String PATHNAME = "petsCadastrados/";

    public ArquivoPet() {
        File diretorio = new File(PATHNAME);
        if (!diretorio.exists()){
            boolean isDiretorioCriado = diretorio.mkdir();
            if (isDiretorioCriado){
                System.out.println("DIRETÓRIO 'PETSCADASTRADOS/' CRIADO COM SUCESSO.");
            }
        }

    }

    @Override
    public void edita(Pet pet) {
        String nomeArquivo = pet.getNomeArquivo();
        escreve(pet, PATHNAME, nomeArquivo);
    }

    @Override
    public void gera(Pet pet) {
        String nomeArquivo = GeraNomeArquivo.gera(pet);
        pet.setNomeArquivo(nomeArquivo);
        escreve(pet, PATHNAME, nomeArquivo);
    }

    @Override
    public void escreve(Pet pet, String pathname, String nomeArquivo){
        try(FileWriter fw = new FileWriter(PATHNAME +nomeArquivo); BufferedWriter bw = new BufferedWriter(fw)) {
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
