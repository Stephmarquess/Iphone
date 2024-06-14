package com.dio.Iphone.Interfaces;

import com.dio.Iphone.Classes.Musica;

import java.util.List;

public interface ReprodutorMusical {

    void listarMusicas(List<Musica> listaMusicas);
    void tocarMusica(String nomeMusica);
    void selecionarMusica(String nomeMusica);
    void pausarMusica();
    void controleVolume(int opcaoVolume);
    
}
