package br.com.adotapet;

import br.com.adotapet.menu.Menu;
import br.com.adotapet.menu.MenuValidado;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Menu menu = new MenuValidado(sc);
        int opcao = menu.escolheOpcao();
        menu.executaOpcao(opcao);
        sc.close();
    }
}