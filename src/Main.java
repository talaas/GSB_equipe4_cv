import Controleurs.CtrlConnexion;
import Vues.VueMenu;
import Vues.VueVisiteurs;
import Controleurs.CtrlMenu;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modele.Connect;
import Controleurs.CtrlVisiteurs;
import Vues.VueConnexion;
import javax.swing.UIManager;
import javax.swing.UIManager.*;



/**
 *
 * @author btssio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        
        VueMenu vue = new VueMenu();
        CtrlMenu controllers = new CtrlMenu(vue);
        vue.setVisible(true);       
       /*
        VueConnexion vue = new VueConnexion ();
        CtrlConnexion controllers = new CtrlConnexion(vue);
        vue.setVisible(true);
             */
    }
    
}
