/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

import javax.swing.JOptionPane;
import static petsystem.Login.login;

/**
 *
 * @author xumc
 */
public class AfterLogin extends javax.swing.JFrame {

    static public AfterLogin afterlogin;
    /**
     * Creates new form AfterLogin
     */
    public AfterLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1B_info = new javax.swing.JButton();
        jButton2_Fp = new javax.swing.JButton();
        jButton3_LPET = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton_Myaccount = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PET SYSTEM");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1B_info.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton1B_info.setText("Browsing Information");
        jButton1B_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1B_infoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1B_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 270, 50));

        jButton2_Fp.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton2_Fp.setText("Report Found Pet");
        jButton2_Fp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_FpActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_Fp, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 270, 50));

        jButton3_LPET.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton3_LPET.setText("Report Lost Pet");
        jButton3_LPET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_LPETActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3_LPET, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 270, 50));

        jButton4.setText("Log Out");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jButton_Myaccount.setText("My Account");
        jButton_Myaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MyaccountActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Myaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petsystem/pet1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-110, 0, 880, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1B_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1B_infoActionPerformed
        // TODO add your handling code here:
        ShowInformation sh=new ShowInformation();
        sh.main();
        dispose();
    }//GEN-LAST:event_jButton1B_infoActionPerformed
    
    
    private void jButton3_LPETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_LPETActionPerformed
        // TODO add your handling code here:
      Lost_information l1 = new Lost_information();
	l1.main();
        dispose();
        
    }//GEN-LAST:event_jButton3_LPETActionPerformed

    private void jButton2_FpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_FpActionPerformed
        // TODO add your handling code here:
         Found_information f1 = new Found_information();
	 f1.main();
         //Found_information.main();
         dispose();
         
    }//GEN-LAST:event_jButton2_FpActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Login login=new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_MyaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MyaccountActionPerformed
        
        MyAccount myAccount=new MyAccount();
        myAccount.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton_MyaccountActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfterLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                afterlogin = new AfterLogin();
                afterlogin.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1B_info;
    private javax.swing.JButton jButton2_Fp;
    private javax.swing.JButton jButton3_LPET;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Myaccount;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}