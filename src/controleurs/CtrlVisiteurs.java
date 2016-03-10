/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import Vues.VueVisiteurs;
import java.sql.SQLException;
import modele.metier.MetierVisiteur;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.VisiteurDao;

/**
 *
 * @author btssio
 */
public class CtrlVisiteurs {
    private VueVisiteurs vue;
    private List<MetierVisiteur> lesVisiteurs;

    public CtrlVisiteurs(VueVisiteurs vue) {
        this.vue = vue;
        afficherLesVisiteurs();
    }

        
     public final void afficherLesVisiteurs() {
        try {
            lesVisiteurs = VisiteurDao.getAll();
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
//        MetierVisiteur unVisiteur = VisiteurDao.lireUnVisiteur(matricule);
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
