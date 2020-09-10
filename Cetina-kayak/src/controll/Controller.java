/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import java.text.SimpleDateFormat;
import java.util.Date;
import model.Kupac;
import model.Racun;

/**
 *
 * @author Ivana
 */
public class Controller {
    
    public String Test(String imeKupca, String brSjedala, String datum, String cijena){
         Racun rac = new Racun(imeKupca, brSjedala, datum,  cijena);
         rac.setImeKupca(imeKupca);
         rac.setBrSjedala(brSjedala);
         
         rac.setDatum(datum);
         rac.setCijena(cijena);
         
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        
        SimpleDateFormat danasnji = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String danasnjiDat = danasnji.format(new Date());
        
        String ispis="***********RENT    KAYAK*******************\n"+
        "***************RAČUN**********************\n"+"DATUM: "+ danasnjiDat +"\n"+
        "*********************************************\n"+"Ime kupca: "+"\t"+ rac.getImeKupca() +"\n"+
        "Prezime kupca: "+"\t"+ rac.getImeKupca() +"\n"+"*********************************************\n"+
        "Kayak za: "+"\t"+ rac.getBrSjedala() +" osobu/e \n"+"Datum rezervacije: "+ rac.getDatum() +"\n"+
        "*********************************************\n"+"Ukupan iznos: "+"\t"+ rac.getCijena() +" kn\n"+
        "*********************************************\n";
       
        return ispis;
    }
    
    
    
}
