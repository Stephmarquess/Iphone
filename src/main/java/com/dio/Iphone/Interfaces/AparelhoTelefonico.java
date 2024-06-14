package com.dio.Iphone.Interfaces;

import com.dio.Iphone.Classes.AgendaTelefonica;


public interface AparelhoTelefonico {


    void exibirContatos(AgendaTelefonica listaContatos);
    void ligar(AgendaTelefonica listaContatos, String numero);
    void atender();
    void abrirCaixaPostal();
    void adicionarContato(AgendaTelefonica contatos, String nomeContato, String numeroContato);
    void removerContato(int indice);

}
