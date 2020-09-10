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
public class Kupac {
    String imeKupca;
    String prezimeKupca;
    String brMob;
    String email;

    public Kupac(String imeKupca, String prezimeKupca, String brMob, String email) {
        this.imeKupca = imeKupca;
        this.prezimeKupca = prezimeKupca;
        this.brMob = brMob;
        this.email = email;
    }
    
    
    public String getImeKupca() {
        return imeKupca;
    }

    public void setImeKupca(String imeKupca) {
        this.imeKupca = imeKupca;
    }

    public String getPrezimeKupca() {
        return prezimeKupca;
    }

    public void setPrezimeKupca(String prezimeKupca) {
        this.prezimeKupca = prezimeKupca;
    }

    public String getBrMob() {
        return brMob;
    }

    public void setBrMob(String brMob) {
        this.brMob = brMob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
    
    
    
    
}
