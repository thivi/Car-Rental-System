/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrentalsystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Krishnamohan
 */
public class modifyRental extends javax.swing.JFrame {

    /**
     * Creates new form modifyRental
     */
    public modifyRental() {
        initComponents();
        String query="select * from rental where handoverID IS NULL";
        tableload tl= new tableload(query,jTable1,"just");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rid = new javax.swing.JTextField();
        nfdr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Add Staff");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify Rental");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 610, 360));

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));

        jLabel11.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Modify Rental");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));
        getContentPane().add(rid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 101, -1));
        getContentPane().add(nfdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 114, -1));

        jLabel1.setText("Rental ID");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        jLabel2.setText("No. of Days Rented");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 114, -1));

        modify.setText("Modify");
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        getContentPane().add(modify, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        getContentPane().add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/carrentalsystem/bg.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        if (rid.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter a Retal ID");
        }
        else if (rid.getText().matches(".*\\D.*") || Double.parseDouble(rid.getText())!=(int) Double.parseDouble(rid.getText())){
            JOptionPane.showMessageDialog(this, "Rental ID may only contain inetgers!");
        }
        else{
            tableload tl1=new tableload("select * from rental where handoverID IS NULL and rentalID="+rid.getText(),jTable1,"just");
        }
    }//GEN-LAST:event_searchActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int r=jTable1.getSelectedRow();
        String due=jTable1.getValueAt(r, 3).toString();
        String rent=jTable1.getValueAt(r, 4).toString();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
        long rentdays;
        String rdays;
        try{
            Date rented=sf.parse(rent);
            Date dued=sf.parse(due);
            rentdays=dued.getTime()-rented.getTime();
            long ndays=rentdays /(24 * 60 * 60 * 1000);
            rdays=Long.toString(ndays);
            
            nfdr.setText(rdays);
        }
        catch (Exception e){
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int r=jTable1.getSelectedRow();
        if (r>=0){
            String rentid=jTable1.getValueAt(r, 0).toString();
            int res=JOptionPane.showConfirmDialog(this, "Are you sure that you want to complete this process?");
                    if (res==0){
                         deleteData dd= new deleteData("rental", "rentalid",rentid);
                         String query="select * from rental where handoverID IS NULL";
                         tableload tl= new tableload(query,jTable1,"just");
                    }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please select a row");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed
        // TODO add your handling code here:
        Calendar c=Calendar.getInstance();
        if (nfdr.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please enter the new No. of Days Rented!");
        }
        else if (nfdr.getText().matches(".*\\D.*") || Double.parseDouble(nfdr.getText())!=(int)Double.parseDouble(nfdr.getText())){
            JOptionPane.showMessageDialog(this, "No. of Days Rented can only be an integer");
        }
        else {
            int r=jTable1.getSelectedRow();
            if (r>=0){
                SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd");
                String rentid=jTable1.getValueAt(r, 0).toString();
                String rent=jTable1.getValueAt(r, 4).toString();
                String carid=jTable1.getValueAt(r, 2).toString();
                int rentd=Integer.parseInt(nfdr.getText());
                String aquery="Select rentalfee from car where carid="+carid;
                getTable gt=new getTable(aquery);
                double rentalfee=Double.parseDouble(gt.getData());
                double total=rentalfee*rentd;
                try{
                    Date rented=sf.parse(rent);
                    
                    c.setTime(rented);
                    c.add(Calendar.DATE,rentd);
                    String duedate=sf.format(c.getTime());
                    
                    String set="dueDate='"+duedate+"', totalAmount="+total;

                    String cond="rentalID="+rentid;

                    int res=JOptionPane.showConfirmDialog(this, "Are you sure that you want to complete this process?");
                    if (res==0){
                        updateTable ut=new updateTable("rental",set,cond);
                        String query="select * from rental where handoverID IS NULL";
                        tableload tl= new tableload(query,jTable1,"just");
                        
                        int rentidi=Integer.parseInt(rentid);
                        HashMap param=new HashMap();
                        param.put("rid",rentidi);
                        invoiceRent mr=new invoiceRent("F:\\Desktop\\ST PROJECT\\CarRentalSystem\\report2.jasper",param);
                        mr.setVisible(true);
                        
                        
                        
                    }

                }
                catch (Exception e){

                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Please select a row");
            }
        }
    }//GEN-LAST:event_modifyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(modifyRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modifyRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modifyRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modifyRental.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modifyRental().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modify;
    private javax.swing.JTextField nfdr;
    private javax.swing.JTextField rid;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}