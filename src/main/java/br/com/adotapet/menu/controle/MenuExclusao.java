package br.com.adotapet.menu.controle;

import br.com.adotapet.arquivo.ArquivoPet;
import br.com.adotapet.pet.Pet;

import java.util.List;
import java.util.Scanner;

public class MenuExclusao extends MenuSelecao {
    private Scanner sc;
    private List<Pet> opcoesPet;
    private List<Pet> petsCadastrados;

    public MenuExclusao(Scanner sc, List<Pet> opcoesPet, List<Pet> petsCadastrados) {
        super(sc, opcoesPet);
        this.petsCadastrados = petsCadastrados;
    }

    @Override
    public void iniciar() {
        int numPet = escolheNumPet();
        this.sc.nextLine();
        Pet pet = this.opcoesPet.get(numPet);
        int opcao = escolheOpcao();
        for (Pet petCadastrado : this.petsCadastrados) {
            if (petCadastrado.equals(pet)){
                executaOpcao(opcao, petCadastrado);
                break;
            }
        }
    }

    @Override
    protected void printa() {
        System.out.println("""
                _________________________________________________________________
                |||||||||                EXCLUSÃO DE PET                |||||||||
                -----------------------------------------------------------------
                |          DESEJA REALMENTE EXCLUIR O PET SELECIONADO?          |
                -----------------------------------------------------------------""");
        System.out.print("Digite (SIM/NÃO): ");
    }

    @Override
    protected int recebeOpcao() {
        int opcao = -1;

        this.printa();
        String resposta = this.sc.nextLine();
        if (resposta.equalsIgnoreCase("não")){
            opcao = 0;
        } else if (resposta.equalsIgnoreCase("sim")) {
            opcao = 1;
        }

        return opcao;
    }

    @Override
    protected int escolheOpcao() {
        boolean isPermitido = false;
        int valor = 0;
        while (!isPermitido) {
            valor = recebeOpcao();
            if (valor == 0 || valor == 1) {
                isPermitido = true;
            }
        }
        return valor;
    }

    private void executaOpcao(int opcao, Pet pet){
        if (opcao == 1){
            ArquivoPet arquivoPet = new ArquivoPet();
            this.petsCadastrados.remove(pet);
            arquivoPet.exclui(pet);
            System.out.println("PET DELETADO COM SUCESSO.");
        } else {
            System.out.println("EXCLUSÃO DE PET CANCELADA.");
        }
    }
}
