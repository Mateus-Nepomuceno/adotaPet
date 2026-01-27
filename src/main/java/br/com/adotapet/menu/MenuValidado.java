package br.com.adotapet.menu;

import java.util.Scanner;

public class MenuValidado extends Menu {

    public MenuValidado(Scanner sc) {
        super(sc);
    }

    @Override
    public int escolheOpcao() {
        boolean isPermitido = false;
        int valor = 0;
        while (!isPermitido) {
            valor = super.escolheOpcao();
            if (valor >= 1 && valor <= 6) {
                isPermitido = true;
            }
        }
        return valor;
    }
}
