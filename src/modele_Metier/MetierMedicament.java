
package modele.metier;

 /**
 *
 * @author flevesque
 */

public class MetierMedicament {
    private String depot;
    private String nom;
    private String composition;
    private String effets; 
    private String contreindic;
    private String prix;

    public MetierMedicament(String depot, String nom, String composition, String effets, String contreindic, String prix) {
        this.depot = depot;
        this.nom = nom;
        this.composition = composition;
        this.effets = effets;
        this.contreindic = contreindic;
        this.prix = prix;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContreindic() {
        return contreindic;
    }

    public void setContreindic(String contreindic) {
        this.contreindic = contreindic;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "MetierMedicament{" + "depot=" + depot + ", nom=" + nom + ", composition=" + composition + ", effets=" + effets + ", contreindic=" + contreindic + ", prix=" + prix + '}';
    }
    
}
