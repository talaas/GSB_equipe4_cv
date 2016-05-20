/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Vues.VuePraticiens;
import Vues.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private String login;
    
    private List<MetierRapportVisite> lesRapports;
    private List<MetierPraticien> lesPraticiens;
    private List<MetierMedicament> lesMedicaments;
    
    private boolean set = false;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    public CtrlRapportVisite(VueRapportVisite vue, String login) {
        this.vue=vue;
        this.login = login;
        afficherLesRapportVisites();
        //afficherLesPraticiens();
        vue.getjButtonFermer().addActionListener(this);
        vue.getjButtonPrecedent().addActionListener(this);
        vue.getjButtonSuivant().addActionListener(this);
        vue.getjButtonNouveau().addActionListener(this);
        vue.getjComboBoxListeRapportVisites().addActionListener(this);
        vue.getjButtonDetails().addActionListener(this);
    }
    
    public final void afficherLesRapportVisites() {
        
        vue.getjTableOffreEchantillon().setEnabled(false);
        
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
            lesMedicaments = MedicamentDao.getAll();
            int i=0;
            for (MetierMedicament medicament : lesMedicaments){
                vue.getModeleListeMedicaments().addElement(medicament);
                //vue.getjTextFieldNbMedicaments().setText("a");
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
        
        if (source == vue.getjComboBoxListeRapportVisites()) {
            int z = vue.getjComboBoxListeRapportVisites().getSelectedIndex();
            setVues(z);
        }
        if (source == vue.getjButtonDetails()){
            VuePraticiens vuePraticiens = new VuePraticiens();
            CtrlPraticiens controllers = new CtrlPraticiens(vuePraticiens, login);
            vuePraticiens.setVisible(true);
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
                Date date = Date.valueOf(dateFormat.format(vue.getjDateChooser().getDate()).toString());
                String motif = vue.getjTextFieldMotifVisite().getText();
                String bilan = vue.getjTextAreaBilan().getText();
                MetierPraticien monPraticien = (MetierPraticien) vue.getjComboBoxListePraticiens().getSelectedItem();
                String numPraticien = monPraticien.getNum();
                
                MetierRapportVisite newRapport = new MetierRapportVisite(login, num, numPraticien, date, bilan, motif);
                System.out.println(newRapport.toStringB(0));
                try {
                    RapportVisiteDao.insert(newRapport);
                    vue.getModeleListeRapportVisites().addElement(newRapport);
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CtrlRapportVisite.class.getName()).log(Level.SEVERE, null, ex);
                }
                vue.getjButtonNouveau().setLabel("Nouveau");
                vue.getjButtonPrecedent().setEnabled(true);
                vue.getjButtonSuivant().setEnabled(true);
                vue.getjComboBoxListeRapportVisites().setEnabled(true);
                vue.getjTableOffreEchantillon().setEnabled(false);
                set = false;
            } else {
                clearVues();
                vue.getjButtonNouveau().setLabel("Valider");
                vue.getjButtonPrecedent().setEnabled(false);
                vue.getjButtonSuivant().setEnabled(false);
                vue.getjComboBoxListeRapportVisites().setEnabled(false);
                vue.getjTableOffreEchantillon().setEnabled(true);
                set = true;
            }
            
        }
        
        if (source == vue.getjButtonFermer()) {
            vue.dispose();
        }
    }
    
    void setVues(int z) {
        MetierRapportVisite monRapportVisite = (MetierRapportVisite) vue.getModeleListeRapportVisites().getSelectedItem();
        System.out.println(monRapportVisite.toStringB(0));
        
        vue.getjComboBoxListePraticiens().setSelectedIndex(getIntIndexPraticien(monRapportVisite));
        vue.getjTextFieldMotifVisite().setText(monRapportVisite.getMotif());
        vue.getjDateChooser().setDate((monRapportVisite.getDate()));
        vue.getjTextAreaBilan().setText(monRapportVisite.getBilan());
    }
    
    void clearVues() {
        vue.getjTextFieldMotifVisite().setText("");
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