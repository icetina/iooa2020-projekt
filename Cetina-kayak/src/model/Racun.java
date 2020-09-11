/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ivana
 */
public class Racun {
    int šifraKupca;
    String brSjedala;
    String sati;
    String datum;
    String cijena;

    public Racun(int šifraKupca, String brSjedala, String sati, String datum, String cijena) {
        this.šifraKupca = šifraKupca;
        this.brSjedala = brSjedala;
        this.sati = sati;
        this.datum = datum;
        this.cijena = cijena;
    }
    
    

    public int getŠifraKupca() {
        return šifraKupca;
    }

    public void setŠifraKupca(int šifraKupca) {
        this.šifraKupca = šifraKupca;
    }

    public String getBrSjedala() {
        return brSjedala;
    }

    public void setBrSjedala(String brSjedala) {
        this.brSjedala = brSjedala;
    }

    public String getSati() {
        return sati;
    }

    public void setSati(String sati) {
        this.sati = sati;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }

    
    
}

