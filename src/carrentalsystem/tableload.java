/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Krishnamohan
 */
public class tableload {
    
    Connection con=null;
    PreparedStatement st=null;
    ResultSet res=null;
    public tableload(String tableName, JTable j){
        String query= "SELECT * from "+tableName;
        con=dbconnect.connect();
        try{
            st=con.prepareStatement(query);
            res=st.executeQuery();
            j.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch (Exception e){
            
        }
    }
    
    public tableload(String tableName, String fieldName, String searchName, JTable j){
        String query="SELECT * from "+tableName+" WHERE "+fieldName+" ='"+searchName+"'";
        con=dbconnect.connect();
        try{
            st=con.prepareStatement(query);
            res=st.executeQuery();
            j.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch (Exception e){
            
        }
    }
    public tableload(String sql, JTable j,String just){
        con=dbconnect.connect();
        try{
            st=con.prepareStatement(sql);
            res=st.executeQuery();
            j.setModel(DbUtils.resultSetToTableModel(res));
        }
        catch (Exception e){
            
        }
    }
}
