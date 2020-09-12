/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Kupac;
import model.Racun;
import view.JFrameProvjera;
import view.JFrameRent;

/**
 *
 * @author Ivana
 */
public class SpajanjeDB {
    
    
    public static void spremiKupca(Kupac kup) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/icetina","icetina","11");
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("INSERT INTO kupac ("
                    + "sifra_kupca,ime_kupca, prezime_kupca, broj_mobitela, email) VALUES"
                    + "(?,?,?,?,?)");

            pst.setInt(1, kup.getŠifraKupca());
            pst.setString(2, kup.getImeKupca());
            pst.setString(3, kup.getPrezimeKupca());
            pst.setString(4, kup.getBrMob());
            pst.setString(5, kup.getEmail());
            pst.execute();
            pst.close();
        } catch (Exception ex) {
            System.out.println("Greška!" + ex.toString());
        }
    
    }   
    
     
     public static List dohvatiKupca(){
        List <Kupac> listaKupca = new ArrayList<Kupac>();
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/icetina","icetina","11");
            Statement stmt = conn.createStatement();
            String sql= "SELECT * FROM kupac";
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                int šifraKupca = rs.getInt("sifra_kupca");
                String imeKupca = rs.getString("ime_kupca");
                String prezimeKupca = rs.getString("prezime_kupca");
                String brojMobitela = rs.getString("broj_mobitela");
                String email = rs.getString("email");
                
                
                Kupac kup = new Kupac(šifraKupca, imeKupca, prezimeKupca,brojMobitela, email);
                listaKupca.add(kup);
            }
            conn.close();
            return listaKupca;
        }catch(Exception ex){
            System.out.println("Greška kod spajanja kupca: "+ex.toString());
            return null;
        }
    }
    
     public static boolean provjeriKupca( int šifraKupca, String imeKupca, String prezimeKupca, String brojMobitela, String email){
        return false;
    }
       
    public static void kreirajRacun(Racun rac) throws SQLException, ClassNotFoundException{
         try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/icetina","icetina","11"); 
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("Select * from rezervacija where datum_rezervacije = ? and broj_sjedala = ?"); //ista stvar ko za con
            pst.setString(1, rac.getDatum());
            pst.setString(2, rac.getBrSjedala());
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()==true){
                JOptionPane.showMessageDialog(null, "Ova vrsta kayaka je već rezervirana!");
            }
            else {
            pst = (PreparedStatement) con.prepareStatement("insert into rezervacija(sifra_kupca,broj_sjedala,sati,cijena,datum_rezervacije) values(?,?,?,?,?)");
            pst.setInt(1, rac.getŠifraKupca());
            pst.setString(2, rac.getBrSjedala());
            pst.setString(3, rac.getSati());
            pst.setString(4, rac.getCijena());
            pst.setString(5,rac.getDatum());
            int k = pst.executeUpdate();
                if(k==1){
                    JOptionPane.showMessageDialog(null, "Kayak rezerviran");
                 }
            
                else{
                    System.out.println("Greška!");
                }
            }
             } catch (Exception ex) {
            System.out.println("Greška!" + ex.toString());
        }
       
       }
   
    
}
