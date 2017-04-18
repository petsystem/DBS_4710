/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petsystem;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import petsystem.AfterLogin;
import petsystem.CurrentUser;
import petsystem.MyConnection;
import petsystem.Pet_Search;

/**
 *
 * @author Brad
 */
public class PetMatchSearchPage extends javax.swing.JFrame {

    public PetMatchSearchPage(JCheckBox CheckBoxMicroChipNumber, JCheckBox CheckBoxPetAge, JCheckBox CheckBoxPetBodyColor, JCheckBox CheckBoxPetBreed, JCheckBox CheckBoxPetEyeColor, JCheckBox CheckBoxPetId, JCheckBox CheckBoxPetName, JCheckBox CheckBoxPetSex, JCheckBox CheckBoxPetType, JScrollPane PetMatchResultTable, ButtonGroup buttonGroup1, JTable jTable1, GraphicsConfiguration gc) {
        super(gc);
        this.CheckBoxPetDescription = CheckBoxMicroChipNumber;
        this.CheckBoxPetBodyColor = CheckBoxPetAge;
        this.CheckBoxPetAge = CheckBoxPetBodyColor;
        this.CheckBoxPetEyeColor = CheckBoxPetBreed;
        this.CheckBoxPetBreed = CheckBoxPetEyeColor;
        this.CheckBoxPetSex = CheckBoxPetId;
        this.CheckBoxPetType = CheckBoxPetName;
        this.CheckBoxPetMicroChip = CheckBoxPetSex;
        this.CheckBoxPetName = CheckBoxPetType;
        this.PetMatchResultPane = PetMatchResultTable;
        this.buttonGroup1 = buttonGroup1;
        this.PetMatchResultTable = jTable1;
    }

    public PetMatchSearchPage(JCheckBox CheckBoxMicroChipNumber, JCheckBox CheckBoxPetAge, JCheckBox CheckBoxPetBodyColor, JCheckBox CheckBoxPetBreed, JCheckBox CheckBoxPetEyeColor, JCheckBox CheckBoxPetId, JCheckBox CheckBoxPetName, JCheckBox CheckBoxPetSex, JCheckBox CheckBoxPetType, JScrollPane PetMatchResultTable, ButtonGroup buttonGroup1, JTable jTable1) throws HeadlessException {
        this.CheckBoxPetDescription = CheckBoxMicroChipNumber;
        this.CheckBoxPetBodyColor = CheckBoxPetAge;
        this.CheckBoxPetAge = CheckBoxPetBodyColor;
        this.CheckBoxPetEyeColor = CheckBoxPetBreed;
        this.CheckBoxPetBreed = CheckBoxPetEyeColor;
        this.CheckBoxPetSex = CheckBoxPetId;
        this.CheckBoxPetType = CheckBoxPetName;
        this.CheckBoxPetMicroChip = CheckBoxPetSex;
        this.CheckBoxPetName = CheckBoxPetType;
        this.PetMatchResultPane = PetMatchResultTable;
        this.buttonGroup1 = buttonGroup1;
        this.PetMatchResultTable = jTable1;
    }
    /**
     * Creates new form PetMatchPage
     */
    public PetMatchSearchPage() {
        initComponents();
        StringJoiner currentUserId = new StringJoiner("");
        currentUserId.add(CurrentUser.CurrentUserId);
        StringJoiner whereClauseString = currentUserId;
        Fetch("put_information.user_id =", whereClauseString);
        
    }

    /**
     *
     */
    public void FetchAllData(StringJoiner sj){
        try {
            ArrayList<Pet_Search> petsearchlist  = new ArrayList<Pet_Search>();
            Connection connect = MyConnection.GetConnection();
            String sqlst = "SELECT lostfound.status_flag,pet.pet_type,pet.pet_name,pet.pet_breed,pet.pet_eyecolor,pet.pet_bodycolor,pet.pet_age,pet.pet_sex,pet.mchip,pet.pet_discription, user.user_name, user.phone_number FROM put_information JOIN lostfound ON lostfound.lf_id=put_information.lf_id JOIN pet ON pet_lfid = put_information.lf_id JOIN user ON user.user_id=put_information.user_id WHERE ";
            PreparedStatement ps = connect.prepareStatement(sqlst + sj);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
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
                Integer u_phone = rs.getInt(12);
                Pet_Search pet_search = new Pet_Search(status_flag,pet_type, pet_name, pet_breed, pet_eyecolor, pet_bodycolor, pet_age, pet_sex, mchip, pet_discription,u_name,u_phone);
                petsearchlist.add(pet_search);
            }
            
            DefaultTableModel dftm = (DefaultTableModel)PetMatchResultTable.getModel();
            dftm.setRowCount(0);
            
            for (int i = 0, n=petsearchlist.size(); i<n; i++){
                Object[] row = new Object[12];
                row[0]= petsearchlist.get(i).getstatusflag();
                row[1] = petsearchlist.get(i).gettype();
                row[2] = petsearchlist.get(i).getname();
                row[3] = petsearchlist.get(i).getbreed();
                row[4] = petsearchlist.get(i).getecolor();
                row[5] = petsearchlist.get(i).getbcolor();
                row[6] = petsearchlist.get(i).getage();
                row[7] = petsearchlist.get(i).getsex();
                row[8] = petsearchlist.get(i).getmchip();
                row[9] = petsearchlist.get(i).getdescription();  
                row[10] = petsearchlist.get(i).getuname(); 
                row[11] = petsearchlist.get(i).getphone(); 
                dftm.addRow(row);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Fetch(String str, StringJoiner whereClause){
          
        try {
            ArrayList<Pet_Search> petsearchlist  = new ArrayList<Pet_Search>();
            Connection connect = MyConnection.GetConnection();
            String sqlst = "SELECT lostfound.status_flag, pet.pet_type,pet.pet_name,pet.pet_breed,pet.pet_eyecolor,pet.pet_bodycolor,pet.pet_age,pet.pet_sex,pet.mchip,pet.pet_discription,user.user_name,user.phone_number FROM put_information JOIN pet ON pet.pet_lfid=put_information.lf_id JOIN user ON user.user_id=put_information.user_id JOIN lostfound ON lostfound.lf_id=put_information.lf_id WHERE ";
            PreparedStatement ps = connect.prepareStatement(sqlst + str + "'" + whereClause + "'");
            ResultSet rs = ps.executeQuery();
            //Connection conn = MyConnection.GetConnection();
            //String currentUserId = CurrentUser.CurrentUserId;
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM pet WHERE user_id=?");
            //ps.setString(3, currentUserId);
           // rs=ps.executeQuery();
            
            while(rs.next()){
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
                Integer u_phone = rs.getInt(12);
                Pet_Search pet_search = new Pet_Search(status_flag,pet_type, pet_name, pet_breed, pet_eyecolor, pet_bodycolor, pet_age, pet_sex, mchip, pet_discription,u_name,u_phone);
                petsearchlist.add(pet_search);
            }
            
            DefaultTableModel dftm = (DefaultTableModel)PetMatchResultTable.getModel();
            dftm.setRowCount(0);
            
            for (int i = 0, n=petsearchlist.size(); i<n; i++){
                Object[] row = new Object[12];
                row[0]= petsearchlist.get(i).getstatusflag();
                row[1] = petsearchlist.get(i).gettype();
                row[2] = petsearchlist.get(i).getname();
                row[3] = petsearchlist.get(i).getbreed();
                row[4] = petsearchlist.get(i).getecolor();
                row[5] = petsearchlist.get(i).getbcolor();
                row[6] = petsearchlist.get(i).getage();
                row[7] = petsearchlist.get(i).getsex();
                row[8] = petsearchlist.get(i).getmchip();
                row[9] = petsearchlist.get(i).getdescription();  
                row[10] = petsearchlist.get(i).getuname(); 
                row[11] = petsearchlist.get(i).getphone(); 
                dftm.addRow(row);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        PetMatchResultPane = new javax.swing.JScrollPane();
        PetMatchResultTable = new javax.swing.JTable();
        jButton_BackToMenu = new javax.swing.JButton();
        CheckBoxPetSex = new javax.swing.JCheckBox();
        CheckBoxPetName = new javax.swing.JCheckBox();
        CheckBoxPetType = new javax.swing.JCheckBox();
        CheckBoxPetEyeColor = new javax.swing.JCheckBox();
        CheckBoxPetBreed = new javax.swing.JCheckBox();
        CheckBoxPetAge = new javax.swing.JCheckBox();
        CheckBoxPetBodyColor = new javax.swing.JCheckBox();
        CheckBoxPetMicroChip = new javax.swing.JCheckBox();
        CheckBoxPetDescription = new javax.swing.JCheckBox();
        jButton1_Search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PetMatchResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Status", "Pet Type", "Pet Name", "Pet Breed", "Eye Color", "Body Color", "Age", "Pet Sex", "Micro chip", "Pet Description", "User Name", "Contact Phone"
            }
        ));
        PetMatchResultTable.getTableHeader().setReorderingAllowed(false);
        PetMatchResultPane.setViewportView(PetMatchResultTable);

        jButton_BackToMenu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_BackToMenu.setText("Back To Menu");
        jButton_BackToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackToMenuActionPerformed(evt);
            }
        });

        CheckBoxPetSex.setText("Pet Sex");
        CheckBoxPetSex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxPetSexActionPerformed(evt);
            }
        });

        CheckBoxPetName.setText("Pet Name");
        CheckBoxPetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxPetNameActionPerformed(evt);
            }
        });

        CheckBoxPetType.setText("Pet Type");

        CheckBoxPetEyeColor.setText("Pet Eye Color");

        CheckBoxPetBreed.setText("Pet Breed");

        CheckBoxPetAge.setText("Pet Age");

        CheckBoxPetBodyColor.setText("Pet Body Color");

        CheckBoxPetMicroChip.setText("Pet Micro Chip");

        CheckBoxPetDescription.setText("Pet Description");
        CheckBoxPetDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxPetDescriptionActionPerformed(evt);
            }
        });

        jButton1_Search.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1_Search.setText("Search");
        jButton1_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PetMatchResultPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1049, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBoxPetName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CheckBoxPetType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckBoxPetEyeColor, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckBoxPetBreed)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckBoxPetAge, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckBoxPetBodyColor)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckBoxPetSex)
                                .addGap(18, 18, 18)
                                .addComponent(CheckBoxPetDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckBoxPetMicroChip, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                .addGap(142, 142, 142)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_BackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckBoxPetSex)
                            .addComponent(CheckBoxPetType)
                            .addComponent(CheckBoxPetBreed)
                            .addComponent(CheckBoxPetBodyColor)
                            .addComponent(CheckBoxPetDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckBoxPetName)
                            .addComponent(CheckBoxPetEyeColor)
                            .addComponent(CheckBoxPetAge)
                            .addComponent(CheckBoxPetMicroChip)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_BackToMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(PetMatchResultPane, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckBoxPetSexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxPetSexActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CheckBoxPetSexActionPerformed

    private void jButton_BackToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackToMenuActionPerformed
        // TODO add your handling code here:
        AfterLogin aflog = new AfterLogin();
        aflog.main();
        dispose();
    }//GEN-LAST:event_jButton_BackToMenuActionPerformed

    private void CheckBoxPetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxPetNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxPetNameActionPerformed

//    public ResultSet SendSqlString(){
//        try {
//            String combinedCheckBoxString = CurrentUser.CurrentUserId;
//            String whereClauseString = combinedCheckBoxString;
//            Connection connect = MyConnection.GetConnection();
//            String sqlst = "SELECT lostfound.status_flag, pet.pet_type,pet.pet_name,pet.pet_breed,pet.pet_eyecolor,pet.pet_bodycolor,pet.pet_age,pet.pet_sex,pet.mchip,pet.pet_discription,user.user_name,user.phone_number FROM put_information JOIN pet ON pet.pet_lfid=put_information.lf_id JOIN user ON user.user_id=put_information.user_id JOIN lostfound ON lostfound.lf_id=put_information.lf_id WHERE put_information.user_id = ";
//            PreparedStatement ps = connect.prepareStatement(sqlst + "'" + whereClauseString + "'");
//            ResultSet rs = ps.executeQuery();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//            
//    }
    private void jButton1_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_SearchActionPerformed
        // TODO add your handling code here:
        StringJoiner sb = new StringJoiner(" AND ");
        try {
            String combinedCheckBoxString = CurrentUser.CurrentUserId;
            String whereClauseString = combinedCheckBoxString;
            Connection connect = MyConnection.GetConnection();
            String sqlst = "SELECT lostfound.status_flag, pet.pet_type,pet.pet_name,pet.pet_breed,pet.pet_eyecolor,pet.pet_bodycolor,pet.pet_age,pet.pet_sex,pet.mchip,pet.pet_discription,user.user_name,user.phone_number FROM put_information JOIN pet ON pet.pet_lfid=put_information.lf_id JOIN user ON user.user_id=put_information.user_id JOIN lostfound ON lostfound.lf_id=put_information.lf_id WHERE put_information.user_id = ";
            PreparedStatement ps = connect.prepareStatement(sqlst + "'" + whereClauseString + "'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            if (CheckBoxPetType.isSelected()){
                try{
                    String pet_type = " pet.pet_type=" + "'"+rs.getString(2)+ "'";
                    sb.add(pet_type);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }

            }      
            if (CheckBoxPetName.isSelected()){
                try{
                    String pet_name =" pet.pet_name = " + "'" + rs.getString(3)+ "'";
                    sb.add(pet_name);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetBreed.isSelected()){
                try{
                    String pet_breed =" pet.pet_breed=" + "'" + rs.getString(4)+ "'";
                    sb.add(pet_breed);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetEyeColor.isSelected()){
                try{
                    String pet_eyecolor =" pet.pet_eyecolor="  + "'" + rs.getString(5)+ "'";
                    sb.add(pet_eyecolor);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetBodyColor.isSelected()){
                try{
                    String pet_bodycolor =" pet.pet_bodycolor="+ "'" + rs.getString(6)+ "'";
                    sb.add(pet_bodycolor);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetAge.isSelected()){
                try{
                    String pet_age =" pet.pet_age="+ "'" + rs.getString(7)+ "'";
                    sb.add(pet_age);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetSex.isSelected()){
                try{
                    String pet_sex =" pet.pet_sex="+ "'" + rs.getString(8)+ "'";
                    sb.add(pet_sex);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetMicroChip.isSelected()){
                try{
                    String mchip =" pet.mchip="+ "'"+ rs.getString(9)+ "'";
                    sb.add(mchip);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            if (CheckBoxPetDescription.isSelected()){
                try{
                    String pet_description = " pet.pet_discription="+ "'" + rs.getString(10)+ "'";
                    sb.add(pet_description);
                }
                catch(SQLException e) {
                    e.printStackTrace();
                }
            }
            else if (CheckBoxPetDescription.isSelected()==false&&CheckBoxPetMicroChip.isSelected()==false&&
                    CheckBoxPetType.isSelected()==false&&CheckBoxPetName.isSelected()==false&& 
                    CheckBoxPetBreed.isSelected()==false&&CheckBoxPetEyeColor.isSelected()==false&&
                    CheckBoxPetBodyColor.isSelected()==false&&CheckBoxPetAge.isSelected()==false&&
                    CheckBoxPetSex.isSelected()==false){
                sb.add("user.user_id = "+ combinedCheckBoxString);
            }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        FetchAllData(sb);
        
            
    }//GEN-LAST:event_jButton1_SearchActionPerformed

    private void CheckBoxPetDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxPetDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckBoxPetDescriptionActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main() {
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
            java.util.logging.Logger.getLogger(PetMatchSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PetMatchSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PetMatchSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PetMatchSearchPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetMatchSearchPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBoxPetAge;
    private javax.swing.JCheckBox CheckBoxPetBodyColor;
    private javax.swing.JCheckBox CheckBoxPetBreed;
    private javax.swing.JCheckBox CheckBoxPetDescription;
    private javax.swing.JCheckBox CheckBoxPetEyeColor;
    private javax.swing.JCheckBox CheckBoxPetMicroChip;
    private javax.swing.JCheckBox CheckBoxPetName;
    private javax.swing.JCheckBox CheckBoxPetSex;
    private javax.swing.JCheckBox CheckBoxPetType;
    private javax.swing.JScrollPane PetMatchResultPane;
    private javax.swing.JTable PetMatchResultTable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1_Search;
    private javax.swing.JButton jButton_BackToMenu;
    // End of variables declaration//GEN-END:variables
}
