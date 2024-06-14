package com.dio.Iphone.Classes;

public class Contato {

    private String nomeContato;
    private String numeroContato;

    public Contato() {
    }

    public Contato(String nomeContato, String numeroContato) {
        this.nomeContato = nomeContato;
        this.numeroContato = numeroContato;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNumeroContato() {
        return numeroContato;
    }

    public void setNumeroContato(String numeroContato) {
        this.numeroContato = numeroContato;
    }
}
