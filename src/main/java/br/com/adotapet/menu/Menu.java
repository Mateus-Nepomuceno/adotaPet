package br.com.adotapet.menu;

import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.formulario.LeitorDeArquivo;
import br.com.adotapet.formulario.RespondeFormulario;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Menu {
    private Scanner sc;

    public Menu(Scanner sc) {
        this.sc = sc;
    }

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

    public int escolheOpcao() {
        int opcao = 0;
            try {
                this.printaOpcoes();
                opcao = this.sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        return opcao;
    }

    public void executaOpcao(int opcao) {
        switch (opcao){
            case 1:
                cadastraPet();
                break;
        }
    }

    public void cadastraPet() {
        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo("C:\\Temp\\ws-intellij\\adotaPet\\src\\main\\resources\\formulario.txt");
        Formulario formulario = new Formulario(leitorDeArquivo.carregaPerguntas());
        RespondeFormulario respondeFormulario = new RespondeFormulario(this.sc,formulario);
        respondeFormulario.responde();
    }
}
