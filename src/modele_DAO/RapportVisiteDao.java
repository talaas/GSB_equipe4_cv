package modele_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modele_Metier.MetierRapportVisite;
/**
 *
 * @author btssio
 */
public class RapportVisiteDao {
    
    public static List<MetierRapportVisite> getAll() throws SQLException, ClassNotFoundException {         
        List<MetierRapportVisite> lesRapportVisites = new ArrayList<>(); 
        MetierRapportVisite unRapportVisite;
        Connection con = modele.Connect.Connection();      
        Statement state = con.createStatement();

        ResultSet res = state.executeQuery("SELECT * FROM RAPPORT_VISITE R INNER JOIN OFFRIR O ON R.RAP_NUM = O.RAP_NUM");
        
        //lancer une 2e requete pour remplir la liste medicaments de l'objet MetierRapportVisite (?)
        
        while (res.next()) {
            String matricule = res.getString("VIS_MATRICULE");
            String num = res.getString("RAP_NUM");
            String numPraticien = res.getString("PRA_NUM");
            String date = res.getString("RAP_DATE");
            String bilan = res.getString("RAP_BILAN");
            String motif = res.getString("RAP_MOTIF");

            unRapportVisite = new MetierRapportVisite(/* ATTRIBUTS */);
            lesRapportVisites.add(unRapportVisite);
        }
      
    return lesRapportVisites;
  }
  
  public static MetierRapportVisite getOneByDepot(String depotRapportVisite) throws SQLException, ClassNotFoundException {
        MetierRapportVisite unRapportVisite = null;
        
        Connection con = modele.Connect.Connection();  
        PreparedStatement pstmt;
        
        String requete = "SELECT * FROM RapportVisite WHERE MED_DEPOTLEGAL= ?";
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, depotRapportVisite);
        
        ResultSet res = pstmt.executeQuery();
        
        if (res.next()) {
            /*
                SAJOUTER ATTRIBUTS
            */
            unRapportVisite = new MetierRapportVisite(/* ATTRIBUTS */);
        }
        return unRapportVisite;
    }
}
