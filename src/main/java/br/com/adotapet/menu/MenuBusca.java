package br.com.adotapet.menu;

import br.com.adotapet.menu.filtra.FiltraPets;
import br.com.adotapet.pets.Pet;
import br.com.adotapet.pets.TipoPet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuBusca extends Menu {
    private Scanner sc;
    private List<Pet> petsCadastrados;

    public MenuBusca(Scanner sc, List<Pet> petsCadastrados) {
        this.sc = sc;
        this.petsCadastrados = petsCadastrados;
    }

    @Override
    protected void printa() {
        System.out.println("""
                _________________________________________________________________________________
                |||||||||               BUSCA DE PET - CRITÉRIOS DE BUSCA               |||||||||
                ---------------------------------------------------------------------------------
                |  1. Nome ou sobrenome   2. Sexo   3. Idade   4. Endereço   5. Raca   6. Peso  |
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
            if (valor >= 1 && valor <= 6) {
                isPermitido = true;
            }
        }
        this.sc.nextLine();
        return valor;
    }

    public List<Pet> executaOpcao(int opcao, String pesquisa, List<Pet> listaPets) {
        switch (opcao){
            case 1: FiltraPets.filtraPorNomeSobrenome(pesquisa, listaPets); break;
            case 2: FiltraPets.filtraPorSexo(pesquisa, listaPets); break;
            case 3: FiltraPets.filtraPorIdade(pesquisa, listaPets); break;
            case 4: FiltraPets.filtraPorEndereco(pesquisa, listaPets); break;
            case 5: FiltraPets.filtraPorRaca(pesquisa, listaPets); break;
            case 6: FiltraPets.filtraPorPeso(pesquisa, listaPets); break;
        }
        return listaPets;
    }

    @Override
    public void iniciar(){
        List<Pet> petsBusca = new ArrayList<>(this.petsCadastrados);
        TipoPet tipoPet = recebeTipo();
        FiltraPets.filtraPorTipo(tipoPet,petsBusca);
        recebeCriterio(petsBusca);
        System.out.print("Deseja adicionar outro critério (s/n)? ");
        String resposta = this.sc.nextLine();
        if (resposta.equalsIgnoreCase("s")){
            recebeCriterio(petsBusca);
        }
        printaPetsEncontrados(petsBusca);
    }

    private void printaPetsEncontrados(List<Pet> petsEncontrados){
        System.out.println("""
                _________________________________________________________________________________
                |||||||||                BUSCA DE PETS - PETS ENCONTRADOS               |||||||||
                ---------------------------------------------------------------------------------""");
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
        String resposta = "";
        while (!tipoValido) {
            try {
                System.out.println("""
                        ______________________________________________________
                        |||||||||            BUSCA DE PETS           |||||||||
                        ------------------------------------------------------""");
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
