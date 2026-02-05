package br.com.adotapet.menu;

import br.com.adotapet.arquivo.LeitorDeArquivo;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.formulario.RespondeFormulario;
import br.com.adotapet.pets.Pet;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuPrincipal extends Menu {
    protected Scanner sc;
    protected Formulario formulario;

    public MenuPrincipal(Scanner sc) {
        this.sc = sc;
        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo("src/main/resources/formulario.txt");
        this.formulario = new Formulario(leitorDeArquivo.carrega());
    }

    @Override
    public void printaOpcoes() {
        System.out.println("""
                __________________________________________________________
                |||||||||            SISTEMA ADOTAPET            |||||||||
                ----------------------------------------------------------
                | 1. Cadastrar um novo pet.                              |
                | 2. Alterar os dados do pet cadastrado.                 |
                | 3. Deletar um pet cadastrado.                          |
                | 4. Listar todos os pets cadastrados.                   |
                | 5. Listar pets por algum critério (idade, nome, raça). |
                | 6. Sair.                                               |
                ----------------------------------------------------------""");
        System.out.print("Digite o número opção que deseja: ");
    }

    @Override
    public int escolheOpcao() {
        int opcao = 0;
            try {
                this.printaOpcoes();
                opcao = this.sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
            }
        return opcao;
    }

    @Override
    public void executaOpcao(int opcao) {
        switch (opcao){
            case 1:
                cadastraPet();
                break;
        }
    }

    public void cadastraPet() {
        RespondeFormulario respondeFormulario = new RespondeFormulario(this.sc, this.formulario);
        respondeFormulario.responde();
        Pet pet = this.formulario.getPet();
        System.out.println(pet);
    }
}