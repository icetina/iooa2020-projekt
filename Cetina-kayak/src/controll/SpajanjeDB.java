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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Kupac;
import model.Racun;
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
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO kupac ("
                    + "sifra_kupca,ime_kupca, prezime_kupca, broj_mobitela, email) VALUES"
                    + "(?,?,?,?,?);");

            stmt.setInt(1, kup.getŠifraKupca());
            stmt.setString(2, kup.getImeKupca());
            stmt.setString(3, kup.getPrezimeKupca());
            stmt.setString(4, kup.getBrMob());
            stmt.setString(5, kup.getEmail());

            stmt.execute();
            stmt.close();
        } catch (Exception ex) {
            System.out.println("Greška!!!" + ex.toString());
        }
    
    }   
       
       public static void kreirajRacun(Racun rac) throws SQLException, ClassNotFoundException{
      
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://student.veleri.hr:3306/icetina","icetina","11"); 
            pst = (PreparedStatement) con.prepareStatement("Select * from rezervacija where datum_rezervacije = ? and broj_sjedala = ?"); //ista stvar ko za con
            pst.setString(1, rac.getDatum());
            pst.setString(2, rac.getBrSjedala());
            rs = pst.executeQuery();
            
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
            System.out.println("Greška!!!" + ex.toString());
        }
            }
            
            
       
       
           
            
       
       
}
