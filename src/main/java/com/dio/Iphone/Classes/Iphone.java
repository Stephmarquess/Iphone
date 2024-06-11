package com.dio.Iphone.Classes;

import com.dio.Iphone.Interfaces.AparelhoTelefonico;
import com.dio.Iphone.Interfaces.NavegadorInternet;
import com.dio.Iphone.Interfaces.ReprodutorMusical;

import java.util.ArrayList;
import java.util.List;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private int carga = 100;
    private boolean conexaoInternet = false;
    private int volume = 100;
    private AgendaTelefonica agendaTelefonica;

    public Iphone() {
    }

    public Iphone(int carga, boolean conexaoInternet, int volume) {
        this.carga = carga;
        this.conexaoInternet = conexaoInternet;
        this.volume = volume;
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

    public AgendaTelefonica getAgendaTelefonica() {
        return agendaTelefonica;
    }

    public void setAgendaTelefonica(AgendaTelefonica agendaTelefonica) {
        this.agendaTelefonica = agendaTelefonica;
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

    }

    @Override
    public void atender() {
        System.out.println("Em ligação ...");
    }

    @Override
    public void abrirCaixaPostal() {
        System.out.println("Abrindo caixa postal");
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
        System.out.println("Abrindo endereço: " + url);
        System.out.println("Página aberta!");
    }

    @Override
    public void adicionarAba() {
        System.out.println("Nova aba aberta!");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Página atualizada!");
    }

    @Override
    public void conectarInternet() {

        if (!isConexaoInternet()) {
            setConexaoInternet(true);
            System.out.println("Aparelho conectado à internet");
        } else {
            setConexaoInternet(false);
            System.out.println("Aparelho já está conectado à internet");
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

