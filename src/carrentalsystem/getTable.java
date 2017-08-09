/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Krishnamohan
 */
public class getTable {
    Connection con=null;
    PreparedStatement st=null;
    ResultSet res=null;
    String result;
    public getTable(String query){
        con=dbconnect.connect();
        try{
            st=con.prepareStatement(query);
            res=st.executeQuery();
            
            
        }
        catch (Exception e){
            
        }
    }
    
    public String getData(){
        try{
            res.absolute(1);
            result=res.getString(1);
            
        }
        catch (Exception e){
            
        }
        return result;
    }
}
