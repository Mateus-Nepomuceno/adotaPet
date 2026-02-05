package br.com.adotapet.menu;

public abstract class Menu {
    public abstract void printaOpcoes();
    public abstract int escolheOpcao();
    public abstract void executaOpcao(int opcao);
}