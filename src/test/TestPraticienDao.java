/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;
import modele.dao.PraticienDao;
import modele.metier.MetierPraticien;

import java.util.Scanner;

/**
 *
 * @author Poulet
 */
public class TestPraticienDao {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        System.out.println("test getAll() :");
        
        List<MetierPraticien> liste = PraticienDao.getAll();
        
        
        System.out.println("liste Praticiens :");
        
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i));
        }
        
        System.out.println("liste Praticiens num :");
        
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).getNum());
        }
        
        System.out.println("test getOneByNum(int numPracticien) :");
        
        Scanner sc = new Scanner(System.in);
        
        String num = sc.next();
        
        MetierPraticien lePracticien = PraticienDao.getOneByNum(num);
        
        System.out.println(lePracticien);
    }
    /*
    public List<MetierPracticien> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("test getAll() :");
        
        return PraticienDao.getAll();
    }*/
    
}
