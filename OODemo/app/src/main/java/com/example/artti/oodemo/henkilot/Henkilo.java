package com.example.artti.oodemo.henkilot;

public class Henkilo {

    private String nimi;
    private String hloTunnus;

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        if (nimi != null && nimi.length() > 2) {
            this.nimi = nimi;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public String getHloTunnus() {
        return hloTunnus;
    }

    public void setHloTunnus(String hloTunnus) {
        if(hloTunnus != null && hloTunnus.length() == 11){
            this.hloTunnus = hloTunnus;
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}