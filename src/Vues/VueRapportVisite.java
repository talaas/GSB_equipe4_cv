/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Controleurs.CtrlRapportVisite;
import javax.swing.DefaultCellEditor;
import javax.swing.*;


/**
 *
 * @author btssio
 */
public class VueRapportVisite extends javax.swing.JFrame {

    //private CtrlRapportVisite controleur;
    DefaultComboBoxModel modeleListeRapportVisites;
    DefaultComboBoxModel modeleListePraticiens;
    JComboBox jComboBoxMedicament= new JComboBox();
    
    /**
     * Creates new form rapportVisite
     */
    public VueRapportVisite() {
        initComponents();
        modeleListeRapportVisites = new DefaultComboBoxModel();
        jComboBoxListeRapportVisites.setModel(modeleListeRapportVisites);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxPracticien = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMotifVisite = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaBilan = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButtonDetails = new javax.swing.JButton();
        jButtonSuivant = new javax.swing.JButton();
        jButtonNouveau = new javax.swing.JButton();
        jButtonPrecedent = new javax.swing.JButton();
        jButtonFermer = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOffreEchantillon = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxListeRapportVisites = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Numéro Rapport");

        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroActionPerformed(evt);
            }
        });

        jLabel2.setText("Practicien");

        jComboBoxPracticien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPracticien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPracticienActionPerformed(evt);
            }
        });

        jLabel3.setText("Date Rapport");

        jLabel4.setText("Motif Visite");

        jLabel5.setText("Bilan");

        jTextAreaBilan.setColumns(20);
        jTextAreaBilan.setRows(5);
        jScrollPane1.setViewportView(jTextAreaBilan);

        jLabel6.setText("Offre echantillon");

        jButtonDetails.setText("Details");

        jButtonSuivant.setText("Suivant");

        jButtonNouveau.setText("Nouveau");

        jButtonPrecedent.setText("Précédent");

        jButtonFermer.setText("Fermer");
        jButtonFermer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFermerActionPerformed(evt);
            }
        });

        jTableOffreEchantillon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Médicaments", "Nb Enregistrements"
            }
        ));
        jScrollPane2.setViewportView(jTableOffreEchantillon);
        if (jTableOffreEchantillon.getColumnModel().getColumnCount() > 0) {
            jTableOffreEchantillon.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jComboBoxMedicament));
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Rapport de visite");

        jComboBoxListeRapportVisites.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxListeRapportVisites.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxListeRapportVisitesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldNumero)
                                        .addComponent(jComboBoxPracticien, 0, 91, Short.MAX_VALUE)
                                        .addComponent(jTextFieldMotifVisite))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jButtonDetails)
                                        .addComponent(jComboBoxListeRapportVisites, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(213, 213, 213))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonPrecedent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSuivant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonNouveau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFermer)
                .addGap(18, 18, 18))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxListeRapportVisites, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPracticien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDetails))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldMotifVisite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSuivant)
                    .addComponent(jButtonNouveau)
                    .addComponent(jButtonPrecedent)
                    .addComponent(jButtonFermer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxPracticienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPracticienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPracticienActionPerformed

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void jButtonFermerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFermerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonFermerActionPerformed

    private void jComboBoxListeRapportVisitesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxListeRapportVisitesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxListeRapportVisitesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VueRapportVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VueRapportVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VueRapportVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VueRapportVisite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VueRapportVisite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDetails;
    private javax.swing.JButton jButtonFermer;
    private javax.swing.JButton jButtonNouveau;
    private javax.swing.JButton jButtonPrecedent;
    private javax.swing.JButton jButtonSuivant;
    private javax.swing.JComboBox jComboBoxListeRapportVisites;
    private javax.swing.JComboBox jComboBoxPracticien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableOffreEchantillon;
    private javax.swing.JTextArea jTextAreaBilan;
    private javax.swing.JTextField jTextFieldMotifVisite;
    private javax.swing.JTextField jTextFieldNumero;
    // End of variables declaration//GEN-END:variables
    
    public DefaultComboBoxModel getModeleListeRapportVisites() {
        return modeleListeRapportVisites;
    }
    
    public DefaultComboBoxModel getModeleListePraticiens() {
        return modeleListePraticiens;
    }
    
    public JComboBox getjComboBoxListeRapportVisites() {
        return jComboBoxListeRapportVisites;
    }
    
    public JButton getjButtonNouveau() {
            return jButtonNouveau;
        }

    public JComboBox getjComboBoxMedicament() {
        return jComboBoxMedicament;
    }

    public void setjComboBoxMedicament(JComboBox jComboBoxMedicament) {
        this.jComboBoxMedicament = jComboBoxMedicament;
    }

    public JButton getjButtonDetails() {
        return jButtonDetails;
    }

    public void setjButtonDetails(JButton jButtonDetails) {
        this.jButtonDetails = jButtonDetails;
    }

    public JButton getjButtonFermer() {
        return jButtonFermer;
    }

    public void setjButtonFermer(JButton jButtonFermer) {
        this.jButtonFermer = jButtonFermer;
    }

    public JButton getjButtonPrecedent() {
        return jButtonPrecedent;
    }

    public void setjButtonPrecedent(JButton jButtonPrecedent) {
        this.jButtonPrecedent = jButtonPrecedent;
    }

    public JButton getjButtonSuivant() {
        return jButtonSuivant;
    }

    public void setjButtonSuivant(JButton jButtonSuivant) {
        this.jButtonSuivant = jButtonSuivant;
    }

    public JComboBox getjComboBoxPracticien() {
        return jComboBoxPracticien;
    }

    public void setjComboBoxPracticien(JComboBox jComboBoxPracticien) {
        this.jComboBoxPracticien = jComboBoxPracticien;
    }

    public JTable getjTableOffreEchantillon() {
        return jTableOffreEchantillon;
    }

    public void setjTableOffreEchantillon(JTable jTableOffreEchantillon) {
        this.jTableOffreEchantillon = jTableOffreEchantillon;
    }

    public JTextArea getjTextAreaBilan() {
        return jTextAreaBilan;
    }

    public void setjTextAreaBilan(JTextArea jTextAreaBilan) {
        this.jTextAreaBilan = jTextAreaBilan;
    }

    public JTextField getjTextFieldMotifVisite() {
        return jTextFieldMotifVisite;
    }

    public void setjTextFieldMotifVisite(JTextField jTextFieldMotifVisite) {
        this.jTextFieldMotifVisite = jTextFieldMotifVisite;
    }

    public JTextField getjTextFieldNumero() {
        return jTextFieldNumero;
    }

    public void setjTextFieldNumero(JTextField jTextFieldNumero) {
        this.jTextFieldNumero = jTextFieldNumero;
    }

}
