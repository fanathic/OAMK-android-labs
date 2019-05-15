package com.example.artti.oodemo.henkilot;

public class Pelaaja extends Henkilo{
    private int peliNumero;
    private String peliPaikka;

    public int getPeliNumero() {
        return peliNumero;
    }

    public void setPeliNumero(int peliNumero) {
        if(peliNumero > 0) {
            this.peliNumero = peliNumero;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getPeliPaikka() {
        return peliPaikka;
    }

    public void setPeliPaikka(String peliPaikka) {
        this.peliPaikka = peliPaikka;
    }
}