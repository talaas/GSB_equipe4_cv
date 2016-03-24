/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;
import modele_DAO.VisiteurDao;
import modele_Metier.MetierVisiteur;

import java.util.Scanner;

/**
 *
 * @author Poulet
 */
public class TestVisiteurDao {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        System.out.println("test getAll() :");
        
        List<MetierVisiteur> liste = VisiteurDao.getAll();
        
        //liste.stream().forEach((unVisiteur) -> {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).getMatricule());
        }
        
        System.out.println("test getOneByMatricule(int matriculeVisiteur) :");
        
        Scanner sc = new Scanner(System.in);
        
        String num = sc.next();
        
        MetierVisiteur leVisiteur = VisiteurDao.getOneByMatricule(num);
        
        System.out.println(leVisiteur);
    }
    /*
    public List<MetierVisiteur> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("test getAll() :");
        
        return VisiteurDao.getAll();
    }*/
    
}
