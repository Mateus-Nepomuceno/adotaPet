package br.com.adotapet.menu;

import br.com.adotapet.arquivo.ArquivoPet;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.menu.controle.Menu;
import br.com.adotapet.pet.controle.EditaPet;
import br.com.adotapet.pet.Pet;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuEdicao extends Menu {
    private Scanner sc;
    private Formulario formulario;
    private List<Pet> opcoesPet;
    private List<Pet> petsCadastrados;

    public MenuEdicao(Scanner sc, Formulario formulario, List<Pet> petsCadastrados, List<Pet> opcoesPet) {
        this.sc = sc;
        this.formulario = formulario;
        this.opcoesPet = opcoesPet;
        this.petsCadastrados = petsCadastrados;
    }

    @Override
    public void iniciar() {
        int numPet = escolheNumPet();
        Pet pet = this.opcoesPet.get(numPet);
        int opcao = escolheOpcao();
        for (Pet petCadastrado : this.petsCadastrados) {
            if (petCadastrado == pet){
                executaOpcao(opcao, petCadastrado);
                ArquivoPet arquivoPet = new ArquivoPet();
                arquivoPet.edita(petCadastrado);
            }
        }
    }

    @Override
    protected void printa() {
        System.out.println("""
                _________________________________________________________________________________
                |||||||||             EDIÇÃO DE PET - OPÇÕES PARA ALTERAÇÃO             |||||||||
                ---------------------------------------------------------------------------------
                |   1. Nome ou sobrenome     2. Endereço     3. Idade     4. Peso     5. Raca   |
                ---------------------------------------------------------------------------------""");
        System.out.print("Digite o número da opção que deseja: ");
    }

    @Override
    protected int recebeOpcao() {
        int opcao = 0;
        try {
            this.printa();
            opcao = this.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Digite apenas números.");
            this.sc.next();
        }
        return opcao;
    }

    @Override
    protected int escolheOpcao() {
        boolean isPermitido = false;
        int valor = 0;
        while (!isPermitido) {
            valor = recebeOpcao();
            if (valor >= 1 && valor <= 5) {
                isPermitido = true;
            }
        }
        this.sc.nextLine();
        return valor;
    }

    private void executaOpcao(int opcao, Pet pet) {
        EditaPet editaPet = new EditaPet(this.sc, this.formulario);
        switch (opcao){
            case 1: editaPet.editaNomeSobrenome(pet); break;
            case 2: editaPet.editaEndereco(pet); break;
            case 3: editaPet.editaIdade(pet); break;
            case 4: editaPet.editaPeso(pet); break;
            case 5: editaPet.editaRaca(pet); break;
        }
    }

    private int escolheNumPet(){
        int numPet = -1;
        int tamanhoLista = this.opcoesPet.size();
        while (numPet < 1 || numPet > tamanhoLista){
            try {
                System.out.print("Digite o número do pet que deseja: ");
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
