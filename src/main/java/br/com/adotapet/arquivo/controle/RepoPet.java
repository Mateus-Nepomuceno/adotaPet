package br.com.adotapet.arquivo.controle;

import br.com.adotapet.pet.Pet;

public interface RepoPet {
    void edita(Pet pet);
    void escreve(Pet pet, String nomeArquivo);
    void exclui(Pet pet);
    void gera(Pet pet);
}
