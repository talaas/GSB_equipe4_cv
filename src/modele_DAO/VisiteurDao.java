package modele_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modele.Connect;
import modele_Metier.MetierVisiteur;
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
  
  public static MetierVisiteur getOneByMatricule(String matriculeVisiteur) throws SQLException, ClassNotFoundException {
        MetierVisiteur unVisiteur = null;
        
        Connection con = modele.Connect.Connection();  
        PreparedStatement pstmt;
        
        String requete = "SELECT * FROM visiteur WHERE VIS_MATRICULE= ?";
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, matriculeVisiteur);
        
        ResultSet res = pstmt.executeQuery();
        
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
  
  
    public static MetierVisiteur getConnection(String login, String mdp) throws SQLException, ClassNotFoundException {
        
        Connection con = modele.Connect.Connection();      
        Statement state = con.createStatement();
        
        MetierVisiteur unVisiteur = null;
        
        ResultSet res = state.executeQuery("SELECT * FROM VISITEUR WHERE VIS_NOM ='" + login + "' AND VIS_MATRICULE = '" + mdp + "'");
        
        if (res.next()) {
            String matricule = res.getString("VIS_MATRICULE");
            String nom = res.getString("VIS_NOM");
            String prenom = res.getString("Vis_PRENOM");
            String adresse = res.getString("VIS_ADRESSE");
            String cp = res.getString("VIS_CP");;
            String ville = res.getString("VIS_VILLE");
            Date date = res.getDate("VIS_DATEEMBAUCHE");
            String secCode = res.getString("SEC_CODE");
            String labCode = res.getString("LAB_CODE");
            unVisiteur = new MetierVisiteur(matricule, nom, prenom, adresse, cp, ville, date, secCode, labCode);
        } else {
            
        }
        return unVisiteur;
    }
  
}
