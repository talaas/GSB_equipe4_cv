package modele.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Connect;
import modele.metier.MetierVisiteur;
/**
 *
 * @author btssio
 */
public class VisiteurDao {
    
  public static List<MetierVisiteur> getAll() throws SQLException, ClassNotFoundException {         
      List<MetierVisiteur> lesVisiteurs = new ArrayList<MetierVisiteur>(); 
      MetierVisiteur unVisiteur;
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM visiteur");
      
      while (res.next()) {
            String matricule = res.getString("VIS_MATRICULE");
            String nom = res.getString("VIS_NOM");
            String prenom = res.getString("Vis_PRENOM");
            String adresse = res.getString("VIS_ADRESSE");
            String cp = res.getString("VIS_CP");
            String ville = res.getString("VIS_VILLE");
            Date date = res.getDate("VIS_DATEEMBAUCHE");
            String secCode = res.getString("SEC_CODE");
            String labCode = res.getString("LAB_CODE");
            unVisiteur = new MetierVisiteur(matricule, nom, prenom, adresse, cp, ville, date, secCode, labCode);
            lesVisiteurs.add(unVisiteur);
           
        }
    return lesVisiteurs;
  }
  
  public static MetierVisiteur getOneByMatricule(int matriculeVisiteur) throws SQLException, ClassNotFoundException {
        MetierVisiteur unVisiteur = null;
        
        Connection con = modele.Connect.Connection();      
        Statement state = con.createStatement();
        
        ResultSet res = state.executeQuery("SELECT * FROM ADRESSE WHERE ID= ?");
        
        if (res.next()) {
            String matricule = res.getString("VIS_MATRICULE");
            String nom = res.getString("VIS_NOM");
            String prenom = res.getString("Vis_PRENOM");
            String adresse = res.getString("VIS_ADRESSE");
            String cp = res.getString("VIS_CP");
            String ville = res.getString("VIS_VILLE");
            Date date = res.getDate("VIS_DATEEMBAUCHE");
            String secCode = res.getString("SEC_CODE");
            String labCode = res.getString("LAB_CODE");
            unVisiteur = new MetierVisiteur(matricule, nom, prenom, adresse, cp, ville, date, secCode, labCode);
        }
        return unVisiteur;
    }
  
}
