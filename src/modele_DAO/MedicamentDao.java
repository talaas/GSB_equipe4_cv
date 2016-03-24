package modele_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import modele_Metier.MetierMedicament;
/**
 *
 * @author btssio
 */
public class MedicamentDao {
    
  public static List<MetierMedicament> getAll() throws SQLException, ClassNotFoundException {         
      List<MetierMedicament> lesMedicaments = new ArrayList<MetierMedicament>(); 
      MetierMedicament unMedicament;
      Connection con = modele.Connect.Connection();      
      Statement state = con.createStatement();
      
      ResultSet res = state.executeQuery("SELECT * FROM Medicament");
      
      while (res.next()) {
        String depot = res.getString("MED_DEPOTLEGAL");
        String nom = res.getString("MED_NOMCOMMERCIAL");
        String composition = res.getString("MED_COMPOSITION");
        String effets = res.getString("MED_EFFETS");
        String contreindic = res.getString("MED_CONTREINDIC");
        String prix = res.getString("MED_PRIXECHANTILLON");
        unMedicament = new MetierMedicament(depot, nom, composition, effets, contreindic, prix);
        lesMedicaments.add(unMedicament);
        }
      
    return lesMedicaments;
  }
  
  public static MetierMedicament getOneByDepot(String depotMedicament) throws SQLException, ClassNotFoundException {
        MetierMedicament unMedicament = null;
        
        Connection con = modele.Connect.Connection();  
        PreparedStatement pstmt;
        
        String requete = "SELECT * FROM Medicament WHERE MED_DEPOTLEGAL= ?";
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, depotMedicament);
        
        ResultSet res = pstmt.executeQuery();
        
        if (res.next()) {
            String depot = res.getString("MED_DEPOTLEGAL");
            String nom = res.getString("MED_NOMCOMMERCIAL");
            String composition = res.getString("MED_COMPOSITION");
            String effets = res.getString("MED_EFFETS");
            String contreindic = res.getString("MED_CONTREINDIC");
            String prix = res.getString("MED_PRIXECHANTILLON");
            unMedicament = new MetierMedicament(depot, nom, composition, effets, contreindic, prix);
        }
        return unMedicament;
    }
}
