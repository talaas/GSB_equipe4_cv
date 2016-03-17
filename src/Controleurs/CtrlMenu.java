/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleurs;

import Vues.VueMenu;
import Vues.VueVisiteurs;
import Vues.VueRapportVisite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CtrlMenu implements ActionListener {
    private VueMenu vue;
    
    public CtrlMenu(VueMenu vue){
        this.vue = vue;
        vue.getjButtonMenuVisiteur().addActionListener(this);
        vue.getjButtonRDV().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source =e.getSource();
        if (source == vue.getjButtonMenuVisiteur()){
        VueVisiteurs vueVisiteur = new VueVisiteurs();
        CtrlVisiteurs controllers = new CtrlVisiteurs(vueVisiteur);        
        vueVisiteur.setVisible(true); 
        }
        
        if(source == vue.getjButtonRDV()){
            VueRapportVisite vueRapportVisiteur = new VueRapportVisite();
            CtrlRapportVisite controllers = new CtrlRapportVisite(vueRapportVisiteur);
            vueRapportVisiteur.setVisible(true);
        }
    }
}
