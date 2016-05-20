/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Vues.VueMenu;
import Vues.VuePraticiens;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele_DAO.Dao;
import modele_DAO.PraticienDao;
import modele_Metier.MetierPraticien;
//import modele_Metier.LieuExercice;

/**
 *
 * @author btssio
 */
public class CtrlPraticiens implements ActionListener {

    private VuePraticiens vue;
    private List<MetierPraticien> lesPracticiens;
    //private List<LieuExercice> lesLieus;
    private String login;

    public CtrlPraticiens(VuePraticiens vue, String login) {
        this.vue = vue;
        this.login = login;
        afficherLesPraticiens();
        //afficherLesLieuExercice();
        vue.getjButtonFermer().addActionListener(this);
        vue.getjButtonPrecedent().addActionListener(this);
        vue.getjButtonSuivant().addActionListener(this);
        vue.getjComboBoxRecherche().addActionListener(this);
    }

    public final void afficherLesPraticiens() {
        
        try {
            lesPracticiens = PraticienDao.getAll();
            for (MetierPraticien unPracticien : lesPracticiens) {
            vue.getModeleListePracticiens().addElement(unPracticien);
        }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlPraticiens.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrlPraticiens.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    public final void afficherLesLieuExercice() {
        try {
            lesLieus = Dao.getAllLieuExercice();
            for (LieuExercice unLieu : lesLieus) {
                vue.getjComboBoxLieuExercice().addItem(unLieu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(vue, "Ctrl - erreur SQL");
        }

    }
    */
    
    @Override
   public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == vue.getjComboBoxRecherche()) {
            setVues();
        }
        if (source == vue.getjButtonPrecedent()) {
            int i = vue.getjComboBoxRecherche().getSelectedIndex();
            int z = i - 1;
            if (z > -1) {

                vue.getjComboBoxRecherche().setSelectedIndex(z);
                setVues();
            }
        }
        if (source == vue.getjButtonSuivant()) {
            int i = vue.getjComboBoxRecherche().getSelectedIndex();
            int z = i + 1;
            if (z < vue.getjComboBoxRecherche().getItemCount()) {
                vue.getjComboBoxRecherche().setSelectedIndex(z);
                setVues();
            }
        }
        if (source == vue.getjButtonFermer()) {
            vue.dispose();
        }
    }

    void setVues() {
        MetierPraticien monPraticien = (MetierPraticien) vue.getModeleListePracticiens().getSelectedItem();
        vue.getjTextFieldNumero().setText(monPraticien.getNum());
        vue.getjTextFieldNom().setText(monPraticien.getNom());
        vue.getjTextFieldPrenom().setText(monPraticien.getPrenom());
        vue.getjTextFieldAdresse().setText(monPraticien.getAdresse());
        vue.getjTextFieldCP().setText(monPraticien.getCp());
        vue.getjTextFieldVille().setText(monPraticien.getVille());
        vue.getjTextFieldCN().setText(monPraticien.getCoef());
        //vue.getjComboBoxLieuExercice().setSelectedIndex(getIntIndexLieu(lesLieus, monPraticien, -1));
    }


 int getIntIndexLieu(List<LieuExercice> myLieu, MetierPraticien myPracticien, int index) {

        for (LieuExercice unLieu : myLieu) {
            if (unLieu.getTyp_code().equals(myPracticien.getType())) {
                index = myLieu.indexOf(unLieu);
            }
        }
        return index;
    }

}
