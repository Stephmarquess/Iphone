package com.dio.Iphone.Menu;

import com.dio.Iphone.Classes.AgendaTelefonica;
import com.dio.Iphone.Classes.Contato;
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
        //iphone.toString();
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
        System.out.println("~~~ Internet ~~~");
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
        System.out.println("~~~ Música ~~~");
        List<Musica> listaMusicas = new ArrayList<>();
        Musica m01 = new Musica("Behind Blue Eyes", "The Who");
        listaMusicas.add(m01);
        Musica m02 = new Musica("Starman", "David Bowie");
        listaMusicas.add(m02);
        Musica m03 = new Musica("Sharp Dressed Man", "ZZ Top");
        listaMusicas.add(m03);

        System.out.println("Sua playList: ");
        System.out.println("-------------");
        for (Musica musicas : listaMusicas) {
            System.out.println(musicas.getNomeMusica() + " - " + musicas.getArtista());

        }
        System.out.println("-------------");

        System.out.println("1 - Tocar música \n" + "2 - Pausar Musica \n" + "3 - Ajustar Volume \n ");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("Selecione a faixa:");
                int indice = 0;
                for (Musica musicas : listaMusicas) {
                    System.out.println(indice + " - " + musicas.getNomeMusica() + " (" + musicas.getArtista() + ")");
                    indice++;
                }
                int indiceMusica = entrada.nextInt();
                Musica localizarMusica = listaMusicas.get(indiceMusica);
                String nomeMusica = localizarMusica.getNomeMusica();

                iphone.selecionarMusica(nomeMusica.toUpperCase());
                break;
            case 2:
                iphone.pausarMusica();
                break;
            case 3:
                System.out.println("Volume: " + iphone.getVolume());
                System.out.println("1 - Aumentar Volume \n" + "2 - Diminuir Volume");
                int opcaoVolume = entrada.nextInt();
                iphone.controleVolume(opcaoVolume);
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }

    public void menuTelefone() {

        System.out.println("~~~ Telefone ~~~");
        AgendaTelefonica listaContatos = iphone.carregarContatos();

        System.out.println(" ");
        System.out.println("1 - Fazer ligação \n" + "2 - Atender Ligação \n" + "3 - Adicionar Contato \n" + "4 - Listar Contatos \n" + "5 - Excluir contato \n");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("Seus contatos: ");
                System.out.println("-------------");
                iphone.exibirContatos(listaContatos);
                System.out.println("-------------");
                System.out.println(" ");
                System.out.println("Digite o número: ");
                String numero = entrada.next();
                iphone.ligar(listaContatos, numero);
                break;
            case 2:
                iphone.atender();
                break;
            case 3:
                System.out.println("Nome do contato: ");
                String nomeContato = entrada.next();
                System.out.println("Número: ");
                String numeroContato = entrada.next();
                iphone.adicionarContato(listaContatos, nomeContato, numeroContato);
                break;
            case 4:
                iphone.exibirContatos(listaContatos);
                break;
            case 5:
                if (!listaContatos.getListaContato().isEmpty()) {
                    iphone.exibirContatos(listaContatos);
                    int indice = entrada.nextInt();
                    iphone.removerContato(indice);
                } else {
                    System.out.println("Lista de contatos vazia!");
                }
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
    }
}