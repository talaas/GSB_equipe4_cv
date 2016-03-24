/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Vues.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modele_DAO.*;
import modele_Metier.*;

/**
 *
 * @author btssio
 */
public class CtrlRapportVisite implements ActionListener {
    private VueRapportVisite vue;
    
    public CtrlRapportVisite(VueRapportVisite vue) {
        this.vue=vue;
    }
    public final void afficherLesLabos(){}
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == vue.getjButtonNouveau()) {
            setVues();
        }
    }
    
    
    
    void setVues(){}
    
}
