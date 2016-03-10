import Vues.VueVisiteurs;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.Connect;
import controleurs.CtrlVisiteurs;


/**
 *
 * @author btssio test
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        VueVisiteurs vue = new VueVisiteurs();
        CtrlVisiteurs controleurs = new CtrlVisiteurs(vue);
        // afficher la vue
        vue.setVisible(true);
        
    }
    
}
