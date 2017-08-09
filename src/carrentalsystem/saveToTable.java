/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Krishnamohan
 */
public class saveToTable {
    Connection con=null;
    PreparedStatement st=null;
    ResultSet res=null;
    protected String autid="";
    public saveToTable(String tableName, String values, String columns){
        String query="Insert into "+tableName+" ("+columns+")"+" values("+values+")";
        
        con=dbconnect.connect();
        try{
           st=con.prepareStatement(query);
           st.execute(); 
        }
        
        catch (Exception e) {
            
        }
        
        
    }
    
     public saveToTable(){
        
        
        con=dbconnect.connect();
        
        
        
    }
    public String getID(String tableName, String values, String columns){
        try{
           String query="Insert into "+tableName+" ("+columns+")"+" values("+values+")";
           String col[]={"rentalID"};
           st=con.prepareStatement(query, col);
           st.execute();
           System.out.println(st);
           res=st.getGeneratedKeys();
           System.out.println(res);
           res.next();
           autid=Integer.toString(res.getInt(1));
           System.out.println(autid);
           
           return autid;
           
        }
        
        catch (Exception e) {
            return autid;
        }
    }
}
