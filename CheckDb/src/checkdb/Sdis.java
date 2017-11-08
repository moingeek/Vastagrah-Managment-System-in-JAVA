/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkdb;

import com.mysql.jdbc.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moin
 */
public class Sdis extends JFrame {

    Sdis()
    {
        try
        {
          JTable table;
          Object data [][];
          PreparedStatement pst;
          JFrame f1 = new JFrame();
          f1.setSize(500,500);
          f1.setVisible(true);
          String col [] ={"Dress_id","Dress_Type","No_Dress"};   
          DefaultTableModel model = new DefaultTableModel();
          model.setColumnIdentifiers(col);
          table = new JTable();
          table.setModel(model);
          table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
          table.setFillsViewportHeight(true);
          
          JScrollPane scroll = new JScrollPane(table);
          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
          
          String Dress_id;
          String Dress_type;
          String No_Dress;
          
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/afproject", "root", "moin");
            pst = con.prepareStatement("select * from stocks");
            ResultSet rs=(ResultSet) pst.executeQuery();
            
            while(rs.next())
                {
                        Dress_id = rs.getString("dress_id");
                        Dress_type = rs.getString("dress_type");
                        No_Dress =rs.getString("no_dress");
                        
                        model.addRow(new Object[]{Dress_id,Dress_type,No_Dress});
                }
            rs.close();
            pst.close();
            con.close();
            f1.add(scroll);
        }
      
        catch(Exception e){
        }
        
    }
   
 public static void main(String args[])
 {
     new Sdis();
 }
    
    
    
    
    
    
    public void setVisible(boolean b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
