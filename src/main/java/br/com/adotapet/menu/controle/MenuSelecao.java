package br.com.adotapet.menu.controle;

import br.com.adotapet.pet.Pet;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class MenuSelecao extends Menu {
    protected Scanner sc;
    protected List<Pet> opcoesPet;

    public MenuSelecao(Scanner sc, List<Pet> opcoesPet) {
        this.sc = sc;
        this.opcoesPet = opcoesPet;
    }

    public int escolheNumPet(){
        int numPet = -1;
        int tamanhoLista = this.opcoesPet.size();
        while (numPet < 1 || numPet > tamanhoLista){
            try {
                System.out.print("Digite o número do pet que deseja alterar os dados: ");
                numPet = sc.nextInt();
                if (numPet < 1 || numPet > tamanhoLista){
                    System.out.println("Erro: digite um número entre 1 e "+tamanhoLista);
                }
            } catch (InputMismatchException e){
                System.out.println("Digite apenas números.");
                this.sc.next();
            }
        }
        return numPet - 1;
    }
}
