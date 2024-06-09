package com.dio.Iphone.Interfaces;

import com.dio.Iphone.Classes.Contato;

import java.util.ArrayList;

public interface AparelhoTelefonico {

    void ligar(ArrayList<Contato> listaContatos, String numero);
    void atender();
    void abrirCaixaPostal();
    void adicionarContato(String nomeContato, String numeroContato);
    void removerContato(ArrayList<Contato> contatos, String nomeContato);

}
