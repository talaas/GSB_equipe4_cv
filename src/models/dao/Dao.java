package models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Connect;
import models.metier.MetierVisiteur;
/**
 *
 * @author btssio
 */
public class Dao {

  public static List<MetierVisiteur> getAll() throws SQLException, ClassNotFoundException {         
      List<MetierVisiteur> lesVisiteurs = new ArrayList<MetierVisiteur>(); 
      MetierVisiteur unVisiteur;
      Connection con = models.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM visiteur");    
      
      while (res.next()) {
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
            lesVisiteurs.add(unVisiteur);
           
        }
    return lesVisiteurs;
  }
  
  
  
}
