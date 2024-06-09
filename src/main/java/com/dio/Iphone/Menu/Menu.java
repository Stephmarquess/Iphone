package com.dio.Iphone.Menu;

import com.dio.Iphone.Classes.Iphone;

import java.util.Scanner;

public class Menu {
    Scanner entrada = new Scanner(System.in);
    int opcaoMenu = 0;
    Iphone iphone = new Iphone();

    public void exibirMenu() {

        System.out.println("1 - Internet \n" + "2 - Musica \n" + "3 - Telefone");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                menuInternet();
                break;
            case 2:
                menuMusica();
                break;
            case 3:
                menuTelefone();
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }

    }

    public void menuInternet() {

        System.out.println("1 - Exibir Página \n" + "2 - Atualizar Página \n" + "3 - Adicionar Página ");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("Digite a URL:");
                String url = entrada.next();
                iphone.exibirPagina(url);
                break;
            case 2:
                iphone.adicionarAba();
                break;
            case 3:
                iphone.atualizarPagina();
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }

    }

    public void menuMusica() {

    }

    public void menuTelefone() {

    }
}