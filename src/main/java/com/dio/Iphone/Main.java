package com.dio.Iphone;

import com.dio.Iphone.Menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String execMenu = "s";
        Menu menu = new Menu();

        do {
            menu.exibirMenu();
            System.out.println("Continuar? Digite 's' para continuar ou qualquer tecla para sair ");
            execMenu = entrada.next().toLowerCase();
        } while (execMenu.equalsIgnoreCase("s"));


    }
}
