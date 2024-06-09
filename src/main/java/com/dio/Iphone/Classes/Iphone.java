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

    private void setCarga(int carga) {
        this.carga = carga;
    }

    private void setConexaoInternet(boolean conexaoInternet) {
        this.conexaoInternet = conexaoInternet;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public void ligar(ArrayList<Contato> listaContatos, String numero) {

        for (Contato contato : listaContatos) {
            if (contato.getNumeroContato().equals(numero)) {
                System.out.println("Ligando para " + contato.getNomeContato());
            } else {
                System.out.println("Ligando para " + numero);
            }
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
    public void adicionarContato(String nomeContato, String numeroContato) {
        Contato novoContato = new Contato(nomeContato, numeroContato);
        List<Contato> contatos = new ArrayList<>();
        contatos.add(novoContato);

        System.out.println("Contato salvo na agenda telefônica!");

    }

    @Override
    public void removerContato(ArrayList<Contato> contatos, String nomeContato) {

        for (Contato contato : contatos) {
            if (contato.getNomeContato().equals(nomeContato)) {
                contatos.remove(contato);
            } else {
                System.out.println("Contato não localizado na agenda telefônica!");
            }
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
                setVolume(this.volume--);
                System.out.println("Volume: " + getVolume());
                break;
            case 2:
                setVolume(this.volume++);
                System.out.println("Volume: " + getVolume());
                break;
            default:
                System.out.println("Selecione uma opção válida");
        }
    }
}
