/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import static ConnectDatabase.DatabaseConnection.connect;
import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import static ConnectDatabase.DatabaseConnection.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Osuri Dunuwila
 */
public class functionsO {
    
    Connection con=connect();
     
    
    PreparedStatement pst=null;
    ResultSet rst=null;
    
    
    
    public void mesbox(String m){
    
    JOptionPane.showMessageDialog(null, m);
    
    }
    public ResultSet searchCl(String key)
    {
        String Srch="Select * from joblb where client like '%"+key+"%'";
       
        try
        {
            pst=con.prepareStatement(Srch);
            rst=pst.executeQuery();
            
            return rst;
        }
        catch(SQLException e)
        {
            System.out.println("Error in search : "+e );
        }
        
        return null;
    }
    
    
    public void deleteCli(int id)
    {
        String dltQ="DELETE FROM client WHERE clientID='"+id+"'";
        
        
        try
        {
            pst=con.prepareStatement(dltQ);
            pst.execute();
            
            mesbox("Record deleted!");
        }
        catch(SQLException e)
        {
            mesbox("Error in Delete:"+e);
        }
    }
    
    
    
    
    
    public boolean validateTAC(String word){
          if(!word.matches("TAC\\d{3}")){
          
          mesbox("ID must include TAC at the beginning ");
          return false;
          }
     
          
    else
              return true;
   
    }
    
    
    public boolean validateLB(String word){
          if(!word.matches("LB\\d{3}")){
          
          mesbox("ID must include LB at the beginning ");
          return false;
          }
    
    else
              return true;
   
    }
    
}
    

