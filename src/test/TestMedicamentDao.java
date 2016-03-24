/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.SQLException;
import java.util.List;
import modele_DAO.MedicamentDao;
import modele_Metier.MetierMedicament;

import java.util.Scanner;

/**
 *
 * @author Poulet
 */
public class TestMedicamentDao {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        System.out.println("test getAll() :");
        
        List<MetierMedicament> liste = MedicamentDao.getAll();
        
        //liste.stream().forEach((unMedicament) -> {
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).getDepot());
        }
        
        System.out.println("test getOneByDepot(String depotMedicament) :");
        
        Scanner sc = new Scanner(System.in);
        
        String num = sc.next();
        
        MetierMedicament leMedicament = MedicamentDao.getOneByDepot(num);
        
        System.out.println(leMedicament);
    }
    /*
    public List<MetierMedicament> getAll() throws SQLException, ClassNotFoundException {
        System.out.println("test getAll() :");
        
        return MedicamentDao.getAll();
    }*/
    
}
