/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  xumc
 */
public class ShowInformation extends javax.swing.JFrame {
    static public ShowInformation showInformation;

    /**
     * Creates new form ShowInformation
     */
    public ShowInformation() {
        initComponents();
        petsearchList("");
    }
    
    public void petsearchList( String whereClause)
    {
        try {
            ArrayList<Pet_Search> petsearchList = new ArrayList<Pet_Search>();
            PreparedStatement ps = MyConnection.GetConnection().prepareStatement("SELECT * FROM petsearch "+whereClause);

            ResultSet rs = ps.executeQuery();
						
            while( rs.next() ){
                String status_flag=rs.getString(1);
                String pet_type = rs.getString(2);
                String pet_name = rs.getString(3);
                String pet_breed = rs.getString(4);
                String pet_eyecolor = rs.getString(5);
                String pet_bodycolor = rs.getString(6);
                String pet_age = rs.getString(7);
                String pet_sex = rs.getString(8);
                String mchip = rs.getString(9);
                String pet_discription = rs.getString(10);
                String u_name = rs.getString(11);
                int u_phone = rs.getInt(12);
                
                Pet_Search pet_search = new Pet_Search(status_flag,pet_type, pet_name, pet_breed, pet_eyecolor, pet_bodycolor, pet_age, pet_sex, mchip, pet_discription,u_name,u_phone);
                petsearchList.add(pet_search);
            }
            
       
            DefaultTableModel dtm = (DefaultTableModel)PetSearchTable.getModel();
            dtm.setRowCount(0);
            
            for( int i=0, n=petsearchList.size(); i<n; i++){
                Object[] row = new Object[12];
                row[0]=petsearchList.get(i).getstatusflag();
                row[1] = petsearchList.get(i).gettype();
                row[2] = petsearchList.get(i).getname();
                row[3] = petsearchList.get(i).getbreed();
                row[4] = petsearchList.get(i).getecolor();
                row[5] = petsearchList.get(i).getbcolor();
                row[6] = petsearchList.get(i).getage();
                row[7] = petsearchList.get(i).getsex();
                row[8] = petsearchList.get(i).getmchip();
                row[9] = petsearchList.get(i).getdescription();  
                row[10] = petsearchList.get(i).getuname(); 
                row[11] = petsearchList.get(i).getphone(); 
                dtm.addRow(row);
            }
            
            
        
            //st=MyConnection.createStatement();
            //rs=st.executeQuery(ps);
            
            
            
        
        
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
	}
        
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PetSearchTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton_mainpage = new javax.swing.JButton();
        jRadioButton_Lost = new javax.swing.JRadioButton();
        jRadioButton_Foundpet = new javax.swing.JRadioButton();
        jButton_Search = new javax.swing.JButton();
        jRadioButton_Lost1 = new javax.swing.JRadioButton();
        jButton_Reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PetSearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Pet Type", "Pet Name", "Pet Breed", "Eye Color", "Body Color", "Age", "Pet Sex", "Micro chip", "Pet Description", "User Name", "Contact Phone"
            }
        ));
        PetSearchTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(PetSearchTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1170, 340));

        jLabel1.setText("Pet Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 54));

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 10, -1, -1));

        jButton_mainpage.setText("Main Page");
        jButton_mainpage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_mainpageActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_mainpage, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, -1));

        jRadioButton_Lost.setText("Lost Pet");
        jRadioButton_Lost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_LostActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_Lost, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jRadioButton_Foundpet.setText("Found Pet");
        jRadioButton_Foundpet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_FoundpetActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_Foundpet, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, -1, -1));

        jButton_Search.setText("Search");
        jButton_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, 30));

        jRadioButton_Lost1.setText("Lost Pet");
        jRadioButton_Lost1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_Lost1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_Lost1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jButton_Reset.setText("Reset");
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 140, -1, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        showInformation.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_mainpageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_mainpageActionPerformed
        
                    AfterLogin afterLogin=new AfterLogin();
                    afterLogin.setVisible(true);
                    dispose();
    }//GEN-LAST:event_jButton_mainpageActionPerformed

    private void jRadioButton_LostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_LostActionPerformed
         if(jRadioButton_Lost.isSelected())
             jRadioButton_Foundpet.setSelected(false);
                     
                
        
    }//GEN-LAST:event_jRadioButton_LostActionPerformed

    private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchActionPerformed
        
        
        String whereClause = "";
        if(jRadioButton_Lost.isSelected())
        {
            whereClause = "WHERE status_flag = 'L'";
        }
        
        if(jRadioButton_Foundpet.isSelected()){
            whereClause = "WHERE status_flag = 'F'";
        }
        
        petsearchList(whereClause);
   
            
    }//GEN-LAST:event_jButton_SearchActionPerformed

    private void jRadioButton_FoundpetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_FoundpetActionPerformed
           if(jRadioButton_Foundpet.isSelected())
             jRadioButton_Lost.setSelected(false);
    }//GEN-LAST:event_jRadioButton_FoundpetActionPerformed

    private void jRadioButton_Lost1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_Lost1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_Lost1ActionPerformed

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed


        petsearchList("");



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_ResetActionPerformed

    
    
    
    
    public static void main() {
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
            java.util.logging.Logger.getLogger(ShowInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                showInformation=new ShowInformation();
                showInformation.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PetSearchTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_Search;
    private javax.swing.JButton jButton_mainpage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton_Foundpet;
    private javax.swing.JRadioButton jRadioButton_Lost;
    private javax.swing.JRadioButton jRadioButton_Lost1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
