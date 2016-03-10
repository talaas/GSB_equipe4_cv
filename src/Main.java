import Vues.Visiteurs;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.Connect;
import controllers.ControllersVisiteurs;


/**
 *
 * @author btssio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Visiteurs vue = new Visiteurs();
        ControllersVisiteurs controllers = new ControllersVisiteurs(vue);
        // afficher la vue
        vue.setVisible(true);
        
    }
    
}
