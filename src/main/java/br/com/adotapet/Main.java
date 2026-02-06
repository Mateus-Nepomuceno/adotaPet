package br.com.adotapet;

import br.com.adotapet.menu.Menu;
import br.com.adotapet.menu.MenuPrincipalValidado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            Menu menu = new MenuPrincipalValidado(sc);
            int opcao = menu.escolheOpcao();
            menu.executaOpcao(opcao);
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}