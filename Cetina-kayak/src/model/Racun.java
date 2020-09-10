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
    String brSjedala;
    String brSati;
    String datum;
    String cijena;
    String ukupno;

    public Racun(String brSjedala, String brSati, String datum, String cijena, String ukupno) {
        this.brSjedala = brSjedala;
        this.brSati = brSati;
        this.datum = datum;
        this.cijena = cijena;
        this.ukupno = ukupno;
    }

    
    
    public String getBrSjedala() {
        return brSjedala;
    }

    public void setBrSjedala(String brSjedala) {
        this.brSjedala = brSjedala;
    }

    public String getBrSati() {
        return brSati;
    }

    public void setBrSati(String brSati) {
        this.brSati = brSati;
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

    public String getUkupno() {
        return ukupno;
    }

    public void setUkupno(String ukupno) {
        this.ukupno = ukupno;
    }
    
    
    
}
