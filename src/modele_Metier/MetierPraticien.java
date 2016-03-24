
package modele_Metier;

 /**
 *
 * @author flevesque
 */

public class MetierPraticien {
    private String num;
    private String nom;
    private String prenom;
    private String adresse; 
    private String cp;
    private String ville;
    private String coef;

    public MetierPraticien(String num, String nom, String prenom, String adresse, String cp, String ville, String coef) {
        this.num = num;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.cp = cp;
        this.ville = ville;
        this.coef = coef;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCoef() {
        return coef;
    }

    public void setCoef(String coef) {
        this.coef = coef;
    }

    @Override
    public String toString() {
        return "MetierPraticien{" + "num=" + num + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + ", coef=" + coef + '}';
    }

}
