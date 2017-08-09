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
public class deleteData {
    
    Connection con=null;
    PreparedStatement st=null;
    public deleteData(String tableName, String fieldName, String identity){
        String query="DELETE from "+tableName+" WHERE "+fieldName+"="+identity;
        System.out.println(query);
        con=dbconnect.connect();
        try{
           st=con.prepareStatement(query);
           st.execute(); 
        }
        
        catch (Exception e) {
            
        }
        
    }
}
