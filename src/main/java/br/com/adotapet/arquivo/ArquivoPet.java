package br.com.adotapet.arquivo;

import br.com.adotapet.arquivo.controle.*;
import br.com.adotapet.pet.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArquivoPet implements RepoPet {
    private static final String PATHNAME = "petsCadastrados/";
    private static final String TIPO_ARQUIVO = ".txt";

    @Override
    public void edita(Pet pet) {
        String nomeAntigo = pet.getNomeArquivo();
        String nomeNovo = GeraNomeArquivo.gera(pet);
        File file = new File(PATHNAME+nomeAntigo+TIPO_ARQUIVO);
        if (file.renameTo(new File(PATHNAME+nomeNovo+TIPO_ARQUIVO))){
            pet.setNomeArquivo(nomeNovo);
            System.out.println("PET ALTERADO COM SUCESSO.");
        }
        escreve(pet,nomeNovo);
    }

    @Override
    public void gera(Pet pet) {
        String nomeArquivo = GeraNomeArquivo.gera(pet);
        pet.setNomeArquivo(nomeArquivo);
        escreve(pet,nomeArquivo);
    }

    @Override
    public void exclui(Pet pet) {
        String nomeArquivo = pet.getNomeArquivo();
        File arquivo = new File(PATHNAME+nomeArquivo+TIPO_ARQUIVO);
        if (arquivo.delete()){
            System.out.println("ARQUIVO DELETADO COM SUCESSO.");
        } else {
            System.out.println("ERRO: FALHA AO DELETAR ARQUIVO");
        }
    }

    @Override
    public void escreve(Pet pet, String nomeArquivo){
        try(FileWriter fw = new FileWriter(PATHNAME+nomeArquivo+TIPO_ARQUIVO); BufferedWriter bw = new BufferedWriter(fw)) {
            List<String> atributos = pet.atributosPet();
            for (int i = 0; i < atributos.size(); i++) {
                bw.write((i+1)+" - "+atributos.get(i));
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException("OCORREU UM ERRO AO GERAR O ARQUIVO");
        }
    }
}
