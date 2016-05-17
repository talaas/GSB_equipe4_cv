/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele_Metier;

/**
 *
 * @author flevesque
 */

import java.sql.Date;
import java.util.List;

/*
 *
 * /!\ attributs arbitraires
 * /!\ type Date à tester avec la DAO
 *
*/

public class MetierRapportVisite {
    
    private String visMatricule;
    private String num;
    private String numPraticien;
    private Date date;
    private String bilan;
    private String motif;
    //private List<String> medicaments;

    public MetierRapportVisite(String visMatricule, String num, String numPraticien, Date date, String bilan, String motif) {
        this.visMatricule = visMatricule;
        this.num = num;
        this.numPraticien = numPraticien;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
    }
    
    public String getVisMatricule() {
        return visMatricule;
    }

    public void setVisMatricule(String visMatricule) {
        this.visMatricule = visMatricule;
    }
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    
    public String getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(String numPraticien) {
        this.numPraticien = numPraticien;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String toString() {
        return toStringB(1);
    }
    public String toStringB(int a) {
        switch (a) {
            case 1:
                return "Rapport "+num;
            default:
                return "MetierRapportVisite{" + "visMat=" + visMatricule +", num=" + num + ", numPraticien=" + numPraticien + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + '}';
        }    
    }
}
