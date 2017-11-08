/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdb;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Moin
 */
public class CheckDb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/afproject", "root", "moin");
        if(con == null)
        {
              JOptionPane.showMessageDialog(null, "No Connection Can't Proceed Sorry");
        }
        else
        {
            new Login().setVisible(true);
        }    
        
        
        // TODO code application logic here
    }
    
}
