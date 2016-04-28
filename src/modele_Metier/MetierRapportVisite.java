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

import java.util.Date;
import java.util.List;

/*
 *
 *
 * /!\ attributs arbitraires
 * /!\ type Date à tester avec la DAO
 *
*/





public class MetierRapportVisite {
    
    private String num;
    private String date;
    private String bilan;
    private String motif;
    private String numPraticien;
    //private List<String> medicaments;

    public MetierRapportVisite(String num, String date, String bilan, String motif, String numPraticien) {
        this.num = num;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
        this.numPraticien = numPraticien;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getNumPraticien() {
        return numPraticien;
    }

    public void setNumPraticien(String numPraticien) {
        this.numPraticien = numPraticien;
    }

    @Override
    public String toString() {
        return toStringB(1);
    }
    public String toStringB(int a) {
        switch (a)
            {
            case 1:
                return "Rapport "+num;
            default:
                return "MetierRapportVisite{" + "num=" + num + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", numPraticien=" + numPraticien + '}';
        }    
    }
}
