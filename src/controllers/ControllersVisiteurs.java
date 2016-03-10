/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Vues.Visiteurs;
import java.sql.SQLException;
import models.metier.MetierVisiteur;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.dao.Dao;

/**
 *
 * @author btssio
 */
public class ControllersVisiteurs {
    private Visiteurs vue;
    private List<MetierVisiteur> lesVisiteurs;

    public ControllersVisiteurs(Visiteurs vue) {
        this.vue = vue;
        afficherLesVisiteurs();
    }

        
     public final void afficherLesVisiteurs() {
        try {
            lesVisiteurs = Dao.getAll();
            for (MetierVisiteur visiteur : lesVisiteurs){
                vue.getModeleListeVisiteurs().addElement(visiteur.getNom() + " " + visiteur.getPrenom());
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(vue, "Ctrl - erreur SQL");
        }

    }
     
     
//     public void chargerDonneesVisiteur(String matricule) throws DaoException {
//        
//        MetierVisiteur unVisiteur = Dao.lireUnVisiteur(matricule);
//        
//        vue.getjTextFieldAdresseVisiteur().setText(unVisiteur.getAdresse());
//        vue.getjTextFieldCPVisiteur().setText(unVisiteur.getCp());
//        vue.getjTextFieldNomVisiteur().setText(unVisiteur.getNom());
//        vue.getjTextFieldPrenomVisiteur().setText(unVisiteur.getPrenom());
//        vue.getjTextFieldVilleVisiteur().setText(unVisiteur.getVille());
//        vue.getjComboBoxLaboVisiteur().setText(unVisiteur.getCodeLabo());
//        vue.getjComboBoxSecteurVisiteur().setText(unVisiteur.getCodeSecteur());
//
//    }
}
