package br.com.adotapet.menu.controle;

import br.com.adotapet.pet.controle.FiltraPets;
import br.com.adotapet.pet.Pet;
import br.com.adotapet.pet.TipoPet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBusca extends Menu {
    private Scanner sc;
    private List<Pet> petsCadastrados;
    private List<Pet> petsBusca;

    public MenuBusca(Scanner sc, List<Pet> petsCadastrados) {
        this.sc = sc;
        this.petsCadastrados = petsCadastrados;
        this.petsBusca = new ArrayList<>(this.petsCadastrados);
    }

    public List<Pet> getPetsBusca() {
        return petsBusca;
    }

    @Override
    public void iniciar(){
        TipoPet tipoPet = recebeTipo();
        FiltraPets.filtraPorTipo(tipoPet, this.petsBusca);
        recebeCriterio(this.petsBusca);
        System.out.print("Deseja adicionar outro critério (s/n)? ");
        String resposta = this.sc.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            recebeCriterio(this.petsBusca);
        }
        if (!this.petsBusca.isEmpty()) {
            printaPetsEncontrados(this.petsBusca);
        } else {
            System.out.println("NENHUM PET ENCONTRADO.");
        }
    }

    @Override
    protected void printa() {
        System.out.println("_________________________________________________________________________________");
        System.out.println("|||||||||               BUSCA DE PET - CRITÉRIOS DE BUSCA               |||||||||");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|  1. Nome ou sobrenome   2. Sexo   3. Endereço   4. Idade   5. Peso   6. Raca  |");
        System.out.println("---------------------------------------------------------------------------------");
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

    private void executaOpcao(int opcao, String pesquisa, List<Pet> listaPets) {
        switch (opcao){
            case 1: FiltraPets.filtraPorNomeSobrenome(pesquisa, listaPets); break;
            case 2: FiltraPets.filtraPorSexo(pesquisa, listaPets); break;
            case 3: FiltraPets.filtraPorEndereco(pesquisa, listaPets); break;
            case 4: FiltraPets.filtraPorIdade(pesquisa, listaPets); break;
            case 5: FiltraPets.filtraPorPeso(pesquisa, listaPets); break;
            case 6: FiltraPets.filtraPorRaca(pesquisa, listaPets); break;
        }
    }

    protected void printaPetsEncontrados(List<Pet> petsEncontrados){
        System.out.println("_________________________________________________________________________________");
        System.out.println("|||||||||                BUSCA DE PETS - PETS ENCONTRADOS               |||||||||");
        System.out.println("---------------------------------------------------------------------------------");
        for (int i = 0; i < petsEncontrados.size(); i++) {
            System.out.println((i+1)+". "+petsEncontrados.get(i));
        }
    }

    private void recebeCriterio(List<Pet> listaPets){
        int opcao = escolheOpcao();
        System.out.print("Digite o critério: ");
        String pesquisa = this.sc.nextLine();
        executaOpcao(opcao, pesquisa, listaPets);
    }

    private TipoPet recebeTipo(){
        boolean tipoValido = false;
        TipoPet tipoPet = null;
        String resposta;
        while (!tipoValido) {
            try {
                System.out.println("___________________________________________________________");
                System.out.println("|||||||||              BUSCA DE PETS              |||||||||");
                System.out.println("-----------------------------------------------------------");
                System.out.print("Qual o tipo do pet (Cachorro/Gato)? ");
                resposta = this.sc.nextLine();
                tipoPet = TipoPet.retornaPetRelatorio(resposta);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return tipoPet;
    }
}
