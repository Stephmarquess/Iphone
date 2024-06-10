package com.dio.Iphone.Interfaces;

import com.dio.Iphone.Classes.AgendaTelefonica;
import com.dio.Iphone.Classes.Contato;

import java.util.ArrayList;

public interface AparelhoTelefonico {

    void ligar(AgendaTelefonica listaContatos, String numero);
    void atender();
    void abrirCaixaPostal();
    void adicionarContato(AgendaTelefonica contatos, String nomeContato, String numeroContato);
    void removerContato(ArrayList<Contato> contatos, String nomeContato);

}
