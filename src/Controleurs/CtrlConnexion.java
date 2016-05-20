/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Controleurs.CtrlMenu;
import Vues.VueConnexion;
import Vues.VueMenu;
//import Vues.Menu;
import Vues.VueVisiteurs;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele_DAO.Dao;
import modele_Metier.MetierVisiteur;
import modele_DAO.VisiteurDao;

/**
 *
 * @author btssio
 */
public class CtrlConnexion implements ActionListener {

    private final VueConnexion vue;
    private MetierVisiteur myVisiteur;

    public CtrlConnexion(VueConnexion vue) {
        this.vue = vue;
        vue.getjButtonConnection().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vue.getjButtonConnection()) {

            try {
                String login = vue.getjTextFieldLogin().getText();
                String vis =  vue.getjTextFieldMDP().getText();
                myVisiteur = VisiteurDao.getConnection(login, vis);
                if (myVisiteur != null) {
                    VueMenu vue = new VueMenu();
                    CtrlMenu controllers = new CtrlMenu(vue, vis);
                    vue.setVisible(true);
                    this.vue.setVisible(false);
                } else {
                    System.out.println("erreur");
                    vue.getJLabelErreurCo().setText("Erreur Connexion");
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
                vue.getJLabelErreurCo().setText("Erreur Connexion");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CtrlMenu.class.getName()).log(Level.SEVERE, null, ex);
                vue.getJLabelErreurCo().setText("Erreur Connexion");
            }

        }
        
    }
    
    public MetierVisiteur getVisiteur(MetierVisiteur unVisiteur) {
        unVisiteur = myVisiteur;
        return unVisiteur;
        
    }

}
