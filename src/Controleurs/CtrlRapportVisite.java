/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Vues.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele_DAO.*;
import modele_Metier.*;

/**
 *
 * @author btssio
 */
public class CtrlRapportVisite implements ActionListener {
    private VueRapportVisite vue;
    
    private List<MetierRapportVisite> lesRapports;
    private List<MetierPraticien> lesPraticiens;
    
    private boolean set = false;
    
    public CtrlRapportVisite(VueRapportVisite vue) {
        this.vue=vue;
        afficherLesRapportVisites();
        //afficherLesPraticiens();
        vue.getjButtonOK().addActionListener(this);
        vue.getjButtonFermer().addActionListener(this);
        vue.getjButtonPrecedent().addActionListener(this);
        vue.getjButtonSuivant().addActionListener(this);
        vue.getjButtonNouveau().addActionListener(this);
    }
    
    /*
    public final void afficherLesPraticiens() {
        try {
            lesPraticiens = PraticienDao.getAll();
            for (MetierPraticien praticien : lesPraticiens){
                vue.getModeleListePraticiens().addElement(praticien);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(vue, "Ctrl - erreur SQL");
        }                        
    }
    */
    
    public final void afficherLesRapportVisites() {
        //vue.getModeleListeRapportVisites().addElement("");
        //vue.getModeleListePraticiens().addElement("");
        try {
            lesRapports = RapportVisiteDao.getAll();
            for (MetierRapportVisite rapport : lesRapports){
                vue.getModeleListeRapportVisites().addElement(rapport);
                //MetierPraticien praticien = PraticienDao.getOneByNum(rapport.getNumPraticien());
                //vue.getModeleListePraticiens().addElement(praticien);
            }
            lesPraticiens = PraticienDao.getAll();
            for (MetierPraticien praticien : lesPraticiens){
                vue.getModeleListePraticiens().addElement(praticien);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(vue, "Ctrl - erreur SQL");
        }                        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == vue.getjButtonOK()) {
            int z = vue.getjComboBoxListeRapportVisites().getSelectedIndex();
            setVues(z);
        }
        if (source == vue.getjButtonPrecedent()){
            int i =vue.getjComboBoxListeRapportVisites().getSelectedIndex();
            int z = i-1;
            if(z >-1){
                vue.getjComboBoxListeRapportVisites().setSelectedIndex(z);
                setVues(z);
            }            
        }  
        if (source == vue.getjButtonSuivant()) {
            int i = vue.getjComboBoxListeRapportVisites().getSelectedIndex();
            int z = i+1;
            if(z< vue.getjComboBoxListeRapportVisites().getItemCount()){
                vue.getjComboBoxListeRapportVisites().setSelectedIndex(z);
                setVues(z);
            }      
        }
        if (source == vue.getjButtonNouveau()) {
            if(set) {
                //vue.getjComboBoxListePraticiens().setSelectedIndex(getIntIndexPraticien(newRapport));
                MetierRapportVisite monRapport = (MetierRapportVisite) vue.getjComboBoxListeRapportVisites().getItemAt(vue.getjComboBoxListeRapportVisites().getItemCount()-1);
                String num = Integer.toString(Integer.parseInt(monRapport.getNum())+1);
                String date = vue.getjTextFieldDate().getText();
                String motif = vue.getjTextFieldMotifVisite().getText();
                String bilan = vue.getjTextAreaBilan().getText();
                MetierPraticien monPraticien = (MetierPraticien) vue.getjComboBoxListePraticiens().getSelectedItem();
                String numPraticien = monPraticien.getNum();
                
                MetierRapportVisite newRapport = new MetierRapportVisite(num, date, bilan, motif, numPraticien);
                System.out.println(newRapport.toStringB(0));
                set = false;
            } else {
                clearVues();
                vue.getjButtonNouveau().setLabel("Valider");
                vue.getjButtonOK().setEnabled(false);
                vue.getjButtonPrecedent().setEnabled(false);
                vue.getjButtonSuivant().setEnabled(false);
                vue.getjComboBoxListeRapportVisites().setEnabled(false);
                set = true;
            }
            
            
        }
        
        if (source == vue.getjButtonFermer()) {
            vue.dispose();
        }
    }
    
    void setVues(int z) {
        MetierRapportVisite monRapportVisite = (MetierRapportVisite) vue.getModeleListeRapportVisites().getSelectedItem();
        //MetierPraticien monPraticien = (MetierPraticien)vue.getModeleListePraticiens().getElementAt(z);
        
        vue.getjComboBoxListePraticiens().setSelectedIndex(getIntIndexPraticien(monRapportVisite));
        vue.getjTextFieldMotifVisite().setText(monRapportVisite.getMotif());
        vue.getjTextFieldDate().setText(monRapportVisite.getDate());
        vue.getjTextAreaBilan().setText(monRapportVisite.getBilan());
    }
    
    void clearVues() {
        //vue.getjComboBoxListePraticiens().set
        vue.getjTextFieldMotifVisite().setText("");
        vue.getjTextFieldDate().setText("");
        vue.getjTextAreaBilan().setText("");
    }
     
    int getIntIndexPraticien(MetierRapportVisite monRapportVisite){
        
        int index = 0;
        
        try {
            List<MetierPraticien> mesPraticiens = PraticienDao.getAll();
            for(MetierPraticien praticien : mesPraticiens){
                if(praticien.getNum().equals(monRapportVisite.getNumPraticien())){
                   index = mesPraticiens.indexOf(praticien);
                   return index;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CtrlRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CtrlRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return index;        
    }
}