package com.dio.Iphone.Classes;

import com.dio.Iphone.Interfaces.AparelhoTelefonico;
import com.dio.Iphone.Interfaces.NavegadorInternet;
import com.dio.Iphone.Interfaces.ReprodutorMusical;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private int carga = 100;
    private boolean conexaoInternet = false;
    private int volume = 100;
    private AgendaTelefonica agendaTelefonica;

    public Iphone() {
    }

    public int getCarga() {
        return carga;
    }

    public boolean isConexaoInternet() {
        return conexaoInternet;
    }

    public int getVolume() {
        return volume;
    }

    private void setCarga(int carga) {
        this.carga = carga;
    }

    private void setConexaoInternet(boolean conexaoInternet) {
        this.conexaoInternet = conexaoInternet;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    public AgendaTelefonica carregarContatos() {

        if (agendaTelefonica == null) {
            agendaTelefonica = new AgendaTelefonica();
            List<Contato> contatos = new ArrayList<>();

            Contato c1 = new Contato("David R. Jones", "08011947");
            Contato c2 = new Contato("Lily Rush", "28092003");
            Contato c3 = new Contato("Tommy Vercetti", "29102002");

            contatos.add(c1);
            contatos.add(c2);
            contatos.add(c3);
            agendaTelefonica.setListaContato(contatos);
        }
        return agendaTelefonica;
    }

    public List<Musica> carregarMusicas() {

        List<Musica> listaMusicas = new ArrayList<>();
        Musica m01 = new Musica("Behind Blue Eyes", "The Who");
        listaMusicas.add(m01);
        Musica m02 = new Musica("Starman", "David Bowie");
        listaMusicas.add(m02);
        Musica m03 = new Musica("Sharp Dressed Man", "ZZ Top");
        listaMusicas.add(m03);

        return listaMusicas;
    }

    @Override
    public String toString() {
        return "{Bateria: " + carga + "%" +
                ", Internet: " + conexaoInternet +
                ", Volume:" + volume + "%" +
                '}';
    }

    @Override
    public void listarMusicas(List<Musica> listaMusicas) {

        int indice = 0;
        for (Musica musicas : listaMusicas) {
            System.out.println(indice + " - " + musicas.getNomeMusica() + " (" + musicas.getArtista() + ")");
            indice++;
        }
    }

    @Override
    public void exibirContatos(AgendaTelefonica listaContatos){
        System.out.println(" ~~ Contatos ~~");

        if (!listaContatos.getListaContato().isEmpty()) {
            int indexC = 0;
            for (Contato contato : listaContatos.getListaContato()) {
                System.out.println(indexC + ". " + contato.getNomeContato() + " - " + contato.getNumeroContato());
                indexC++;
            }
        } else {
            System.out.println("Lista de contatos vazia!");
        }
        System.out.println(" ");
    }

    @Override
    public void ligar(AgendaTelefonica contatos, String numero) {
        boolean existe = false;
        String nContato = "";

        for (Contato contato : contatos.getListaContato()) {
            if (numero.equalsIgnoreCase(contato.getNumeroContato())) {
                existe = true;
                nContato = contato.getNomeContato();
            }
        }

        if (existe) {
            System.out.println("Ligando para " + nContato + " ... ");
        } else {
            System.out.println("Ligando para " + numero);
        }

        setCarga(getCarga() -2);

    }

    @Override
    public void atender() {
        System.out.println("Em ligação ...");
        setCarga(getCarga()-2);
    }

    @Override
    public void abrirCaixaPostal() {
        System.out.println("Você tem: 0 mensagens de voz!");
    }

    @Override
    public void adicionarContato(AgendaTelefonica listaContatos, String nomeContato, String numeroContato) {
        Contato novoContato = new Contato(nomeContato, numeroContato);
        listaContatos.getListaContato().add(novoContato);

        System.out.println("Contato salvo na agenda telefônica!");

    }

    @Override
    public void removerContato(int indice) {
        AgendaTelefonica contatos = carregarContatos();
        Contato localizarContato = contatos.getListaContato().get(indice);

            if (localizarContato != null) {
                contatos.getListaContato().remove(localizarContato);
                System.out.println("Contato excluído com sucesso!");
            }

    }

    @Override
    public void exibirPagina(String url) {

        if (!conexaoInternet) {
            System.out.println("Não foi possível carregar a página! O aparelho precisa estar conectado á internet!");
            conectarInternet();
        } else {
            System.out.println("Abrindo endereço: " + url);
            System.out.println("Página aberta!");
            setCarga(getCarga()-2);
        }


    }

    @Override
    public void adicionarAba() {
        Scanner entrada = new Scanner(System.in);

        if (!conexaoInternet) {
            System.out.println("ATENÇÃO: aparelho não conectado à internet. Conecte-se para abrir uma página");
            conectarInternet();
        }

        System.out.println("Nova aba aberta!");
        System.out.println("Digite um endereço:");
        String url = entrada.next();
        exibirPagina(url);

    }

    @Override
    public void atualizarPagina() {

        if (!conexaoInternet) {
            System.out.println("Não foi possível executar. Aparelho não conectado à internet");
            conectarInternet();
        }

        System.out.println("Página atualizada!");
    }

    @Override
    public void conectarInternet() {

        Scanner entrada = new Scanner(System.in);

        if (!isConexaoInternet()) {
            System.out.println("Conectar à internet? s/n");
            String opcao = entrada.next();

            if (opcao.equalsIgnoreCase("s")) {
                setConexaoInternet(true);
                System.out.println("Aparelho conectado!");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("Aparelho não conectado à internet");
            }

        } else {
            System.out.println("Aparelho já conectado à internet!");
            System.out.println("Desconectar da internet? s/n");
            String opcao = entrada.next();

            if (opcao.equalsIgnoreCase("s")) {
                setConexaoInternet(false);
                System.out.println("Aparelho desconectado!");
            } else if (opcao.equalsIgnoreCase("n")) {
                System.out.println("Conexão: " + isConexaoInternet());

            }
        }

    }

    @Override
    public void tocarMusica(String nomeMusica) {
        System.out.println("Tocando: " + nomeMusica);

        if (nomeMusica.equalsIgnoreCase("Starman")) {
            System.out.println("There is starman waiting in the sky ...");
        } else if (nomeMusica.equalsIgnoreCase("Sharp Dressed Man")) {
            System.out.println("Clean shirt, new shoes ...");
        } else if (nomeMusica.equalsIgnoreCase("Behind Blue Eyes")) {
            System.out.println("No one knows what it's like ..");
        }
        setCarga(getCarga()-3);
    }

    @Override
    public void selecionarMusica(String nomeMusica) {
        System.out.println("Selecionada: " + nomeMusica);
        tocarMusica(nomeMusica);
    }

    @Override
    public void pausarMusica() {
        System.out.println("Música pausada.");
    }

    @Override
    public void controleVolume(int opcaoVolume) {

        switch (opcaoVolume) {
            case 1:
                setVolume(getVolume() + 5);
                System.out.println("Volume: " + getVolume());
                break;
            case 2:
                setVolume(getVolume() - 5);
                System.out.println("Volume: " + getVolume());
                break;
            default:
                System.out.println("Selecione uma opção válida");
        }
    }

}

