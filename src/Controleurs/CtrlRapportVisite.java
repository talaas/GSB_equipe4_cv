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
    //private List<MetierPraticien> lesPraticiens;
    
    public CtrlRapportVisite(VueRapportVisite vue) {
        this.vue=vue;
        afficherLesRapportVisites();
        //afficherLesPraticiens();
        vue.getjButtonOK().addActionListener(this);
        vue.getjButtonFermer().addActionListener(this);
        vue.getjButtonPrecedent().addActionListener(this);
        vue.getjButtonSuivant().addActionListener(this);
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
        try {
            lesRapports = RapportVisiteDao.getAll();
            for (MetierRapportVisite rapport : lesRapports){
                vue.getModeleListeRapportVisites().addElement(rapport);
                MetierPraticien praticien = PraticienDao.getOneByNum(rapport.getNumPraticien());
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
        if (source == vue.getjButtonNouveau()) {
            setVues(0);
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
        if (source == vue.getjButtonFermer()) {
            vue.dispose();
        }
    }
    
     void setVues(int z) {
        MetierRapportVisite monRapportVisite = (MetierRapportVisite) vue.getModeleListeRapportVisites().getSelectedItem();
        MetierPraticien monPraticien = (MetierPraticien)vue.getModeleListePraticiens().getElementAt(z);
        vue.getjTextFieldPraticien().setText(monPraticien.getNom());
       
        vue.getjTextFieldMotifVisite().setText(monRapportVisite.getMotif());
        vue.getjTextFieldDate().setText(monRapportVisite.getDate());
        vue.getjTextAreaBilan().setText(monRapportVisite.getBilan());
        
    }
     
     int getIntIndexPraticien(List<MetierPraticien> mesPraticiens, MetierRapportVisite monRapportVisite, int index){
        
        for(MetierPraticien praticien : mesPraticiens){
            if(praticien.getNum().equals(monRapportVisite.getNum())){
               index = mesPraticiens.indexOf(praticien);
            }
        }
        return index;        
    }
}