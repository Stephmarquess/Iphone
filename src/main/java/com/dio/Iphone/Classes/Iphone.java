package com.dio.Iphone.Classes;

import com.dio.Iphone.Interfaces.AparelhoTelefonico;
import com.dio.Iphone.Interfaces.NavegadorInternet;
import com.dio.Iphone.Interfaces.ReprodutorMusical;

import java.util.ArrayList;

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
    public void ligar(String numero) {

    }

    @Override
    public void atender() {

    }

    @Override
    public void abrirCaixaPostal() {

    }

    @Override
    public void adicionarContato() {

    }

    @Override
    public void removerContato() {

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
