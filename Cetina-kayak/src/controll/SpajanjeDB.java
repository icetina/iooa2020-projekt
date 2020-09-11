/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controll;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import model.Kupac;

/**
 *
 * @author Ivana
 */
public class SpajanjeDB {
    
    
       public static void spremiKupca(Kupac kup) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/iaoo", "root","");
            PreparedStatement stmt = (PreparedStatement) con.prepareStatement("INSERT INTO kupac ("
                    + "šifra_kupca,ime_kupca, prezime_kupca, broj_mobitela, email) VALUES"
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
       
}
