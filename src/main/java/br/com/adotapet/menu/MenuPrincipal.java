package br.com.adotapet.menu;

import br.com.adotapet.arquivo.ArquivoPet;
import br.com.adotapet.arquivo.GeraDiretorio;
import br.com.adotapet.formulario.LeitorDeFormulario;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.formulario.controle.RespondeFormulario;
import br.com.adotapet.menu.controle.Menu;
import br.com.adotapet.menu.controle.MenuBusca;
import br.com.adotapet.menu.controle.MenuEdicao;
import br.com.adotapet.menu.controle.MenuExclusao;
import br.com.adotapet.pet.Pet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal extends Menu {
    private Scanner sc;
    private Formulario formulario;
    private List<Pet> petsCadastrados;
    private static final String ERRO_NENHUM_PET = "NENHUM PET CADASTRADO NO SISTEMA.";

    public MenuPrincipal(Scanner sc) {
        this.sc = sc;
        LeitorDeFormulario leitorDeFormulario = new LeitorDeFormulario("src/main/resources/formulario.txt");
        this.formulario = new Formulario(leitorDeFormulario.carrega());
        this.petsCadastrados = new ArrayList<>();
        GeraDiretorio.gera("petsCadastrados/");
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
        System.out.println("ENCERRANDO ADOTAPET.");
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

    private void executaOpcao(int opcao) {
        switch (opcao){
            case 1: cadastraPet(); break;
            case 2: alterarDadosPet(); break;
            case 3: deletarPet(); break;
            case 4: listaPets(); break;
            case 5: buscaPet(); break;
        }
    }

    private void cadastraPet() {
        ArquivoPet arquivoPet = new ArquivoPet();
        RespondeFormulario respondeFormulario = new RespondeFormulario(this.sc, this.formulario);
        respondeFormulario.responde();
        Pet pet = this.formulario.getPet();
        arquivoPet.gera(pet);
        this.petsCadastrados.add(pet);
        System.out.println("PET CADASTRADO COM SUCESSO.");
    }

    private void listaPets(){
        if (!this.petsCadastrados.isEmpty()) {
            System.out.println("""
                        __________________________________________________________
                        |||||||||            PETS CADASTRADOS            |||||||||
                        ----------------------------------------------------------""");
            for (int i = 0; i < this.petsCadastrados.size(); i++) {
                System.out.println((i + 1) + ". " + this.petsCadastrados.get(i));
            }
            return;
        }

        System.out.println(ERRO_NENHUM_PET);
    }

    private void buscaPet(){
        if (!this.petsCadastrados.isEmpty()) {
            Menu menuBusca = new MenuBusca(this.sc, this.petsCadastrados);
            menuBusca.iniciar();
            return;
        }
        System.out.println(ERRO_NENHUM_PET);
    }

    private void alterarDadosPet(){
        if (!this.petsCadastrados.isEmpty()) {
            MenuBusca menuBusca = new MenuBusca(this.sc, this.petsCadastrados);
            menuBusca.iniciar();
            List<Pet> petsBusca = new ArrayList<>(menuBusca.getPetsBusca());
            Menu menuEdicao = new MenuEdicao(this.sc, this.formulario, this.petsCadastrados, petsBusca);
            menuEdicao.iniciar();
            return;
        }
        System.out.println(ERRO_NENHUM_PET);
    }

    private void deletarPet(){
        if (!this.petsCadastrados.isEmpty()) {
            MenuBusca menuBusca = new MenuBusca(this.sc, this.petsCadastrados);
            menuBusca.iniciar();
            List<Pet> petsBusca = new ArrayList<>(menuBusca.getPetsBusca());
            Menu menuExclusao = new MenuExclusao(this.sc, petsBusca, this.petsCadastrados);
            menuExclusao.iniciar();
            return;
        }
        System.out.println(ERRO_NENHUM_PET);
    }
}