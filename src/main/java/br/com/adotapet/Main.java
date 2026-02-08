package br.com.adotapet;

import br.com.adotapet.menu.Menu;
import br.com.adotapet.menu.MenuPrincipal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            Menu menu = new MenuPrincipal(sc);
            menu.iniciar();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}