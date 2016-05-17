package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author btssio
 */
public class Connect {

  public static Connection Connection() throws SQLException, ClassNotFoundException {
    
      Class.forName("oracle.jdbc.driver.OracleDriver");
            
            //parametres prod joliverie
            //String url = "jdbc:oracle:thin:@172.15.11.102:1521:orcl";
            //String user = "ora_2slamppe_eq4";
            
            //parametres flavien local laptop
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "flevesque";
            String password = "btssio";
            
            //parametres flavien local desktop
//            String url = "jdbc:oracle:thin:@localhost:1521:xe";
//            String user = "GSB_E4";
//            
//            String password = "equipe04";
        
      Connection con = DriverManager.getConnection(url, user, password);

      return con;
      
  }
}
