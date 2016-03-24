package modele_DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Connect;
import modele_Metier.Labo;
import modele_Metier.MetierVisiteur;
import modele_Metier.Secteur;

public class Dao {
  
  public static List<Labo> getAllLab() throws SQLException, ClassNotFoundException {         
      List<Labo> lesLabos = new ArrayList<Labo>(); 
      Labo unLabo;
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM LABO");    
      
      while (res.next()) {
            String labCode = res.getString("LAB_CODE");
            String labNom = res.getString("LAB_NOM");
            String labChefVente = res.getString("LAB_CHEFVENTE");
            
            unLabo = new Labo(labCode, labNom, labChefVente);
            lesLabos.add(unLabo);
           
        }
    return lesLabos;
  }
  
  public static List<Secteur> getAllSecteurs() throws SQLException, ClassNotFoundException {         
      List<Secteur> lesSecteurs = new ArrayList<Secteur>(); 
      Secteur unSecteur;
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM SECTEUR");    
      
      while (res.next()) {
            String codeSecteur = res.getString("SEC_CODE");
            String libelleSecteur = res.getString("SEC_LIBELLE");
            
            
            unSecteur = new Secteur(codeSecteur, libelleSecteur);
            lesSecteurs.add(unSecteur);
           
        }
        return lesSecteurs;
  }
  
  
  
  public static String getLabById(MetierVisiteur myVisiteur) throws SQLException, ClassNotFoundException {
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();      
      ResultSet res = state.executeQuery("Select LAB_NOM FROM LABO WHERE LAB_CODE = "+"'"+myVisiteur.getLabCode()+"'");
      return res.toString();
  }
  
  public static String getSecById(MetierVisiteur myVisiteur)throws SQLException, ClassNotFoundException {
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();      
      ResultSet res = state.executeQuery("Select LAB_NOM FROM LABO WHERE LAB_CODE = "+"'"+myVisiteur.getLabCode()+"'");
      return res.toString();
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
