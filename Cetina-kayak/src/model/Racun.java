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
    String imeKupca;
    String brSjedala;
   
    String datum;
    String cijena;

    public Racun(String imeKupca, String brSjedala, String datum, String cijena) {
        this.imeKupca = imeKupca;
        this.brSjedala = brSjedala;
        this.datum = datum;
        this.cijena = cijena;
    }
    
    

    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getBrSjedala() {
        return brSjedala;
    }

    public void setBrSjedala(String brSjedala) {
        this.brSjedala = brSjedala;
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

