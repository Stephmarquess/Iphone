package com.dio.Iphone.Menu;

import com.dio.Iphone.Classes.AgendaTelefonica;
import com.dio.Iphone.Classes.Iphone;
import com.dio.Iphone.Classes.Musica;

import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner entrada = new Scanner(System.in);
    int opcaoMenu = 0;
    Iphone iphone = new Iphone();

    public void exibirMenu() {
        String info = iphone.toString();
        System.out.println(" ");
        System.out.println(info);
        System.out.println(" ");
        System.out.println("1 - Internet \n" + "2 - Musica \n" + "3 - Telefone \n" + "4 - Correio de Voz");
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
            case 4:
                menuCaixaPostal();
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }

    }

    public void menuInternet() {
        System.out.println("~~~ Internet ~~~");
        System.out.println("1 - Exibir Página \n" + "2 - Abrir Nova Aba \n" + "3 - Atualizar Página \n" + "4 - Conectar Internet \n" );
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
            case 4 :
                iphone.conectarInternet();
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }

    }

    public void menuMusica() {
        System.out.println("~~~ Música ~~~");
        List<Musica> listaMusicas = iphone.carregarMusicas();

        System.out.println("Sua playList: ");
        System.out.println("-------------");

        iphone.listarMusicas(listaMusicas);
        System.out.println("-------------");

        System.out.println("1 - Tocar música \n" + "2 - Pausar Musica \n" + "3 - Ajustar Volume \n ");
        opcaoMenu = entrada.nextInt();

        switch (opcaoMenu) {
            case 1:
                System.out.println("Selecione a faixa:");
                iphone.listarMusicas(listaMusicas);
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

    public void menuCaixaPostal() {
        iphone.abrirCaixaPostal();
    }

}

