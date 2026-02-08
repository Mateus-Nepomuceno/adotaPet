package br.com.adotapet.menu;

public abstract class Menu {
    public abstract void iniciar();
    protected abstract void printa();
    protected abstract int recebeOpcao();
    protected abstract int escolheOpcao();
}