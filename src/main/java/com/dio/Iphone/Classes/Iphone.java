package com.dio.Iphone.Classes;

import com.dio.Iphone.Interfaces.AparelhoTelefonico;
import com.dio.Iphone.Interfaces.NavegadorInternet;
import com.dio.Iphone.Interfaces.ReprodutorMusical;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical {

    private int carga = 100;
    private boolean conexaoInternet = false;
    private int volume = 100;

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

    }

    @Override
    public void adicionarAba() {

    }

    @Override
    public void atualizarPagina() {

    }

    @Override
    public void conectarInternet() {

    }

    @Override
    public void tocarMusica(String nomeMusica) {

    }

    @Override
    public void selecionarMusica(String nomeMusica) {

    }

    @Override
    public void pausarMusica() {

    }

    @Override
    public void controleVolume() {

    }
}
