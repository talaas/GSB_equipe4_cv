/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;
import modele.dao.VisiteurDao;
import modele.metier.MetierVisiteur;

/**
 *
 * @author Poulet
 */
public class TestVisiteurDao {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        System.out.println("test getAll() :");
        
        List<MetierVisiteur> liste = VisiteurDao.getAll();
        
        liste.stream().forEach((unVisiteur) -> {
            System.out.println(unVisiteur.getMatricule());
        });
        
    }
    /*
    public List<MetierVisiteur> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("test getAll() :");
        
        return VisiteurDao.getAll();
    }*/
    
}