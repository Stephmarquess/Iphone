package com.dio.Iphone.Menu;

import com.dio.Iphone.Classes.Iphone;
import com.dio.Iphone.Classes.Musica;

import java.util.ArrayList;
import java.util.List;
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

        List<Musica> listaMusicas = new ArrayList<>();
        Musica m01 = new Musica("Behind Blue Eyes", "The Who");
        listaMusicas.add(m01);
        Musica m02 = new Musica("Starman", "David Bowie");
        listaMusicas.add(m02);
        Musica m03 = new Musica("Sharp Dressed Man", "ZZ Top");
        listaMusicas.add(m03);

        System.out.println("1 - Tocar música \n" + "2 - Pausar Musica \n" + "3 - Ajustar Volume \n ");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println(listaMusicas);
                String nomeMusica = entrada.next();
                iphone.selecionarMusica(nomeMusica);
                break;
            case 2:
                iphone.pausarMusica();
                break;
            case 3:
                System.out.println("Volume: " + iphone.getCarga());
                System.out.println("1 - Aumentar Volume \n" + "2 - Diminuir Volume");
                int opcaoVolume = entrada.nextInt();
                iphone.controleVolume(opcaoVolume);
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    public void menuTelefone() {

    }
}