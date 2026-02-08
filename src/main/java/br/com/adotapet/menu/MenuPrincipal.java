package br.com.adotapet.menu;

import br.com.adotapet.arquivo.GeraArquivoPet;
import br.com.adotapet.arquivo.LeitorDeArquivo;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.formulario.RespondeFormulario;
import br.com.adotapet.pets.Pet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal extends Menu {
    private Scanner sc;
    private Formulario formulario;
    private List<Pet> petsCadastrados;

    public MenuPrincipal(Scanner sc) {
        this.sc = sc;
        LeitorDeArquivo leitorDeArquivo = new LeitorDeArquivo("src/main/resources/formulario.txt");
        this.formulario = new Formulario(leitorDeArquivo.carrega());
        this.petsCadastrados = new ArrayList<>();
    }

    @Override
    protected void printa() {
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
            if (valor >= 1 && valor <= 6) {
                isPermitido = true;
            }
        }
        this.sc.nextLine();
        return valor;
    }

    public void executaOpcao(int opcao) {
        switch (opcao){
            case 1: cadastraPet(); break;
            case 4: listaPets(); break;
            case 5: buscaPet(); break;
        }
    }

    @Override
    public void iniciar(){
        int opcao = 0;
        while (opcao != 6){
            opcao = escolheOpcao();
            executaOpcao(opcao);
            if (opcao != 6) {
                System.out.print("\nAPERTE ENTER PARA CONTINUAR.");
                this.sc.nextLine();
            }
        }

    }

    private void cadastraPet() {
        RespondeFormulario respondeFormulario = new RespondeFormulario(this.sc, this.formulario);
        respondeFormulario.responde();
        Pet pet = this.formulario.getPet();
        GeraArquivoPet geraArquivoPet = new GeraArquivoPet("petsCadastrados/");
        geraArquivoPet.geraArquivo(pet);
        this.petsCadastrados.add(pet);
    }

    private void listaPets(){
        System.out.println("""
                _________________________________________________________________________________
                |||||||||              SISTEMA ADOTAPET - PETS CADASTRADOS              |||||||||
                ---------------------------------------------------------------------------------""");
        for (int i = 0; i < this.petsCadastrados.size(); i++) {
            System.out.println((i+1)+". "+this.petsCadastrados.get(i));
        }
    }

    private void buscaPet(){
        Menu menuBusca = new MenuBusca(this.sc,this.petsCadastrados);
        menuBusca.iniciar();
    }
}