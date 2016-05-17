package modele_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modele_Metier.MetierPraticien;
/**
 *
 * @author btssio
 */
public class PraticienDao {
    
  public static List<MetierPraticien> getAll() throws SQLException, ClassNotFoundException {         
      List<MetierPraticien> lesPraticiens = new ArrayList<MetierPraticien>(); 
      MetierPraticien unPraticien;
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM PRATICIEN");
      
      while (res.next()) {
            String num = res.getString("PRA_NUM");
            String nom = res.getString("PRA_NOM");
            String prenom = res.getString("PRA_PRENOM");
            String adresse = res.getString("PRA_ADRESSE");
            String cp = res.getString("PRA_CP");
            String ville = res.getString("PRA_VILLE");
            String coef = res.getString("PRA_COEFNOTORIETE");
            String type = res.getString("TYP_CODE");
            unPraticien = new MetierPraticien(num, nom, prenom, adresse, cp, ville, coef, type);
            lesPraticiens.add(unPraticien);
        }
      
    return lesPraticiens;
  }
  
  public static MetierPraticien getOneByNum(String numPraticien) throws SQLException, ClassNotFoundException {
        MetierPraticien unPraticien = null;
        
        Connection con = modele.Connect.Connection();  
        PreparedStatement pstmt;
        
        String requete = "SELECT * FROM Praticien WHERE PRA_NUM= ?";
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, numPraticien);
        
        ResultSet res = pstmt.executeQuery();
        
        if (res.next()) {
            String num = res.getString("PRA_NUM");
            String nom = res.getString("PRA_NOM");
            String prenom = res.getString("PRA_PRENOM");
            String adresse = res.getString("PRA_ADRESSE");
            String cp = res.getString("PRA_CP");
            String ville = res.getString("PRA_VILLE");
            String coef = res.getString("PRA_COEFNOTORIETE");
            String type = res.getString("TYP_CODE");
            unPraticien = new MetierPraticien(num, nom, prenom, adresse, cp, ville, coef, type);
        }
        return unPraticien;
    }
}
