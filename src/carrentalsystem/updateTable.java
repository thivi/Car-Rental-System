/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Krishnamohan
 */
public class updateTable {
    Connection con=null;
    PreparedStatement st=null;
    public updateTable(String tableName, String colsvals, String condition){
        String query="UPDATE "+tableName+" set "+colsvals+" where "+condition;
        
        con=dbconnect.connect();
        try{
           st=con.prepareStatement(query);
           st.execute(); 
        }
        
        catch (Exception e) {
            
        }
       
    }
}
