/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;
import modele_DAO.RapportVisiteDao;
import modele_Metier.MetierRapportVisite;

import java.util.Scanner;

/**
 *
 * @author Poulet
 */
public class TestRapportVisiteDao {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        
        System.out.println("test getAll() :");
        
        List<MetierRapportVisite> liste = RapportVisiteDao.getAll();
        
        //liste.stream().forEach((unRapportVisite) -> {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).getNum());
            System.out.println(liste.get(i).toStringB(0));
        }
        
        
        System.out.println("test getOneByMatricule(int matriculeRapportVisite) :");
        
        Scanner sc = new Scanner(System.in);
        
        String num = sc.next();
        MetierRapportVisite leRapportVisite = RapportVisiteDao.getOneByNum(num);
        System.out.println(leRapportVisite.toStringB(0));
        
        
        System.out.println("test insert() :");
        
        MetierRapportVisite rapportInsert = new MetierRapportVisite("a17", "20", "86", Date.valueOf("2011-10-20"), "bilan", "motif");
        System.out.println(rapportInsert.toStringB(0));
        int rs = RapportVisiteDao.insert(rapportInsert);
        
        System.out.println(rs);
    }
    /*
    public List<MetierRapportVisite> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("test getAll() :");
        
        return RapportVisiteDao.getAll();
    }*/
    
}
