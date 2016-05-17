package modele_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
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
        
        PreparedStatement pstmt;
        
        ResultSet res = state.executeQuery("SELECT * FROM RAPPORT_VISITE ORDER BY RAP_NUM");
        
        //lancer une 2e requete pour remplir la liste medicaments de l'objet MetierRapportVisite (?)
        
        while (res.next()) {
            String visMat = res.getString("VIS_MATRICULE");
            String num = res.getString("RAP_NUM");
            String numPraticien = res.getString("PRA_NUM");
            Date date = res.getDate("RAP_DATE");
            String bilan = res.getString("RAP_BILAN");
            String motif = res.getString("RAP_MOTIF");
            
            /*
            String requete = "SELECT MED_DEPOTLEGAL, OFF_QTE FROM OFFRIR WHERE RAP_NUM = ?";
            
            pstmt = con.prepareStatement(requete);
            pstmt.setString(1, num);
            
            ResultSet res2 = pstmt.executeQuery();
            
            while (res2.next()) {
                String depot = res.getString("MED_DEPOTLEGAL");
                String qte = res.getString("OFF_QTE");
                
                List<String> medicaments;
                medicaments.
            }*/
            
            unRapportVisite = new MetierRapportVisite(visMat, num, numPraticien, date, bilan, motif);
            lesRapportVisites.add(unRapportVisite);
        }
      
        return lesRapportVisites;
    }
  
    public static MetierRapportVisite getOneByNum(String numRapportVisite) throws SQLException, ClassNotFoundException {
        MetierRapportVisite unRapportVisite = null;
        
        Connection con = modele.Connect.Connection();  
        PreparedStatement pstmt;
        
        String requete = "SELECT * FROM RAPPORT_VISITE WHERE RAP_NUM= ?";
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, numRapportVisite);
        
        ResultSet res = pstmt.executeQuery();
        
        if (res.next()) {
            
            String visMat = res.getString("VIS_MATRICULE");
            String num = res.getString("RAP_NUM");
            String numPraticien = res.getString("PRA_NUM");
            Date date = res.getDate("RAP_DATE");
            String bilan = res.getString("RAP_BILAN");
            String motif = res.getString("RAP_MOTIF");
            
            unRapportVisite = new MetierRapportVisite(visMat, num, numPraticien, date, bilan, motif);
        }
        return unRapportVisite;
    }
    
    public static int insert(MetierRapportVisite rapport) throws SQLException, ClassNotFoundException {
        int nb;
        
        Connection con = modele.Connect.Connection();  
        String requete;
        //ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO RAPPORT_VISITE (VIS_MATRICULE, RAP_NUM, PRA_NUM, RAP_DATE, RAP_BILAN, RAP_MOTIF)"
                + "VALUES (?, ?, ?, TO_DATE(?,'yyyy-mm-dd'), ?, ?)";
        //TO_DATE('2011-10-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS')
        pstmt = con.prepareStatement(requete);
        pstmt.setString(1, rapport.getVisMatricule());
        pstmt.setInt(2, Integer.parseInt(rapport.getNum()));
        pstmt.setInt(3, Integer.parseInt(rapport.getNumPraticien()));
        pstmt.setDate(4, rapport.getDate());
        pstmt.setString(5, rapport.getBilan());
        pstmt.setString(6, rapport.getMotif());
        System.out.println(pstmt);
        nb = pstmt.executeUpdate();
        return nb;
    }
}
