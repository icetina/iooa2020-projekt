/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import model.Kupac;
import model.Racun;

/**
 *
 * @author Ivana
 */
public class Controller {
    
    public int generirajSifru(int šifraKupca){
        Random rand = new Random();
        int randomInt = rand.nextInt(1000);
        return randomInt;
    }
    
    public String ispisRacuna(int šifraKupca, String brSjedala, String sati, String datum, String cijena){
         Racun rac = new Racun(šifraKupca, brSjedala, sati, datum,  cijena);
         rac.setŠifraKupca(šifraKupca);
         rac.setBrSjedala(brSjedala);
         rac.setSati(sati);
         rac.setDatum(datum);
         rac.setCijena(cijena);
         
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        
        SimpleDateFormat danasnji = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String danasnjiDat = danasnji.format(new Date());
        
        String ispis="*********************RENT KAYAK*******************\n"+"\n"+
        "*******************OCEAN VENTURES**************\n"+"\n"+
        "************************RACUN*********************\n"+"\n**************"
        + "**************************************\n"+"DATUM: \t\t"+ danasnjiDat +"\n"+
        "****************************************************\n"+"ŠIFRA KUPCA: \t\t\t"+" "+rac.getŠifraKupca()
        +"\n"+"****************************************************\n"+
        "KAYAK ZA:               "+"\t"+ rac.getBrSjedala() +" OSOBU/E \n"+"DATUM REZERVACIJE:               \t"+ 
        rac.getCijena() +"\n"+ "VRIJEME TRAJANJA REZERVACIJE:\t    "+ rac.getSati() +"h \n"+
        "*****************************************************\n"+"UKUPAN IZNOS:                         \t"+" "+ 
        rac.getDatum() +" KN\n"+"*****************************************************\n"+"\n"+
        "**************HVALA I DOVIDENJA*******************\n";
       
        return ispis;
    }
    
    public int izrSati(String sati, String brSjedala){
   
        int ukupno = 0;
        
        if(brSjedala == "1"){
            if(sati=="1"){ukupno+=70;}
            else if(sati == "3"){ukupno+=150;}
            else {ukupno+=210;}
        }
        else if (brSjedala=="2"){ 
            if(sati=="1"){ukupno+=90;}
            else if(sati=="3"){ukupno+=170;}
            else {ukupno+=230;}
        }
        else if (brSjedala=="3"){
            if(sati=="1"){ukupno+=120;}
            else if(sati=="3"){ukupno+=200;}
            else {ukupno+=260;}
        }
        return ukupno;
    }
    
    public void spremiKupca( int šifraKupca, String imeKupca, String prezimeKupca, String brMob, String email ){
        
       Kupac kup = new Kupac (  šifraKupca, imeKupca,  prezimeKupca,  brMob,  email);
       kup.setŠifraKupca(šifraKupca);
       kup.setImeKupca(imeKupca);
       kup.setPrezimeKupca(prezimeKupca);
       kup.setBrMob(brMob);
       kup.setEmail(email);
       SpajanjeDB.spremiKupca(kup);
    }
    
    public List dohvatiKupca(){
        return SpajanjeDB.dohvatiKupca();
    }
    
    public static boolean provjeriKupca( int šifraKupca, String imeKupca, String prezimeKupca, String brojMobitela, String email){
        return SpajanjeDB.provjeriKupca(šifraKupca, imeKupca, prezimeKupca, brojMobitela, email);
    }
    
    
    public void kreirajRacun(int šifraKupca, String brSjedala, String sati, String datum, String cijena) throws SQLException, ClassNotFoundException{
        Racun rac = new Racun(šifraKupca, brSjedala, sati, datum, cijena);
        rac.setŠifraKupca(šifraKupca);
        rac.setBrSjedala(brSjedala);
        rac.setSati(sati);
        rac.setDatum(datum);
        rac.setCijena(cijena);
        SpajanjeDB.kreirajRacun(rac);
    }

      
}
