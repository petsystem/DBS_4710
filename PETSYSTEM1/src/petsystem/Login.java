/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

/**
 *
 * @author xumc
 */
import java.awt.Window;
import java.sql.*;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {

    static public Login login;
    /**
     * Creates new form Login
     */
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1_name = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jButton1_login = new javax.swing.JButton();
        jButton2_signup = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Log In");
        setSize(new java.awt.Dimension(782, 517));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Menlo", 1, 13)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 70, 74, 32);

        jLabel2.setFont(new java.awt.Font("Menlo", 1, 13)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(290, 190, 80, 32);

        jTextField1_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_nameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1_name);
        jTextField1_name.setBounds(290, 110, 205, 32);
        getContentPane().add(jPassword);
        jPassword.setBounds(290, 230, 205, 32);

        jButton1_login.setFont(new java.awt.Font("Menlo", 1, 14)); // NOI18N
        jButton1_login.setText("Log In");
        jButton1_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_loginActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_login);
        jButton1_login.setBounds(280, 300, 90, 30);

        jButton2_signup.setFont(new java.awt.Font("Menlo", 1, 14)); // NOI18N
        jButton2_signup.setText("Sign Up");
        jButton2_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2_signupActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2_signup);
        jButton2_signup.setBounds(400, 300, 100, 29);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/petsystem/The-Secret-Life-of-Pets-Review-Header.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 782, 517);

        setSize(new java.awt.Dimension(782, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nameActionPerformed

    private void jButton1_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_loginActionPerformed
        // TODO add your handling code here:
        String uname=jTextField1_name.getText();
        String pasw=jPassword.getText();
        
        try {
						
						
		PreparedStatement ps = MyConnection.GetConnection().prepareStatement("SELECT user_id, user_name, password FROM USER WHERE user_name=? AND password=?");//check the user name and password
						
		ps.setString(1, uname);
		ps.setString(2, pasw);
		ResultSet rs = ps.executeQuery();
						
		if( rs.next() ){
		String currentUserId = rs.getString(1);
		CurrentUser.CurrentUserId = currentUserId;		
                    AfterLogin af = new AfterLogin();
		    JOptionPane.showMessageDialog(null, "Welcome!");
				af.main();
				dispose();
							
				}
		else{
			JOptionPane.showMessageDialog(null, "Your username and password is not correct!");
                        jTextField1_name.setText(null);
                        jPassword.setText(null);
						
						}
					
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
   
        
      
    }//GEN-LAST:event_jButton1_loginActionPerformed

    private void jButton2_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2_signupActionPerformed
        // TODO add your handling code here:
        Register r1 = new Register();
	r1.main();
        
        dispose();
    }//GEN-LAST:event_jButton2_signupActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                login = new Login();
                login.setVisible(true);
                login.setResizable(false);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_login;
    private javax.swing.JButton jButton2_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextField1_name;
    // End of variables declaration//GEN-END:variables
}
