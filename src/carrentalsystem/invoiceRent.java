package carrentalsystem;

import javax.swing.*;
 import java.awt.*;
 import java.sql.*;
 import java.util.*;
 import java.io.*;

 import net.sf.jasperreports.engine.*;
 import net.sf.jasperreports.engine.design.*;
 import net.sf.jasperreports.view.*;

 public class invoiceRent extends JFrame
 {

 public invoiceRent(String fileName)
 {
 this(fileName,null);
 }

 public invoiceRent(String fileName,HashMap parameter)
 {
 super("View Report");
 try
 {

 /* load the required JDBC driver and create the connection
 here JDBC-ODBC Bridge Driver is used*/
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");

 //Way 1
 /*JasperDesign jasperDesign = JasperManager.loadXmlDesign(fileName);
 JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
 JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, con);*/

 //Way 2
 /*JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
 JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, con);*/

 /*Way 3 (Here the parameter file should be in .jasper extension i.e., the compiled report)*/
 JasperPrint print = JasperFillManager.fillReport(fileName, parameter, con);

 JRViewer viewer=new JRViewer(print);

 Container c=getContentPane();
 c.add(viewer);
 }
 catch(ClassNotFoundException cnfe)
 {
 cnfe.printStackTrace();
 }
 catch(SQLException sqle)
 {
 sqle.printStackTrace();
 }
 catch(JRException jre)
 {
 jre.printStackTrace();
 }

 setBounds(10,10,600,500);
 setDefaultCloseOperation(DISPOSE_ON_CLOSE);


 }

 public static void main(String args[])
 {
 /* A sample calling */
 /*HashMap param=new HashMap();
 param.put("@rid",4);
 invoiceRent viewer=new invoiceRent("F:\\Desktop\\ST PROJECT\\CarRentalSystem\\report1.jasper",param);
 viewer.setVisible(true);*/
 }
 }