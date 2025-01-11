/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_managmentsystem;

import java.beans.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

 


/**
 *
 * @author ankit
 */
public class SignUpPage extends javax.swing.JFrame {

    /**
     * Creates new form SignUpPage
     */
    
    String fname,lname,uname,password,con_password,contact_no;
    
    Date dob;
    int id;
    
    public SignUpPage() {
        initComponents();
    }
    
    
    public int getId(){
        ResultSet rs =null;
        
        try{
             Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
             Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/FeesManagementSystem","ankit","ankit");
             String sql ="select max(id) from signup";
             java.sql.Statement st =con.createStatement();
             rs = st.executeQuery(sql);
             while(rs.next()){
                 id =rs.getInt(1);
                 id++;
             }
             
         }      
         catch(Exception e){
             e.printStackTrace();
         }
        return id;
    }
     boolean validation(){
         fname = txt_firstname.getText();
         lname =txt_lastname.getText();
         uname= txt_username.getText();
         password =txt_password.getText();
         con_password =txt_confirmpassword.getText();
         contact_no=txt_contact.getText();
         dob =txt_dob.getDate();
         
         if(fname.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the First Name.");
             return false;
         }
         
         if(lname.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the Last Name.");
             return false;
         }
         
         if(uname.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the Username.");
             return false;
         }
         if(password.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the Password.");
             return false;
         }
         if(con_password.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the Confirm Password.");
             return false;
         }
         
          if(dob.equals(null)){
             JOptionPane.showMessageDialog(this, "Please enter the Date Of Birth.");
             return false;
         }
          
         if(contact_no.equals("")){
             JOptionPane.showMessageDialog(this, "Please enter the Contact Number.");
             return false;
         }
            
          if(!password.equals(con_password)){
              JOptionPane.showMessageDialog(this,"The Confirm Password is not Same as Password.");
              return false;
          }
         
         return true;
      }

     
     public void checkPassword(){
          password =txt_password.getText();
           if(password.length()<8){
                lbl_password.setText("Not Valid");
                
             }
           else{
               lbl_password.setText(" ");
           }
               
        }
     public void checkContact(){
         contact_no = txt_contact.getText();
         if(contact_no.length()!= 10){
             lbl_contact.setText("Not Valid");
         }
         else{
             lbl_contact.setText(" ");
         }
     }
     
     void  insertDetails(){
         SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
         String mydob =format.format(dob);
         try{
             Class.forName("org.apache.derby.iapi.jdbc.AutoloadedDriver");
             Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/FeesManagementSystem","ankit","ankit");
             String sql = "INSERT INTO signup VALUES (?, ?, ?, ?, ?, ?, ?)";
             PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setInt(1,getId());
             stmt.setString(2,fname);
             stmt.setString(3,lname);
             stmt.setString(4,uname);
             stmt.setString(5,password);
             stmt.setString(6,mydob);
             stmt.setString(7,contact_no);
             int i =stmt.executeUpdate();
             if(i>0){
                 JOptionPane.showMessageDialog(this, "Record Inserted Successfully .");
             }
             else{
                 JOptionPane.showMessageDialog(this, "Record Not Inserted ");
             }
         }      
         catch(Exception e){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_lastname = new javax.swing.JTextField();
        txt_firstname = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_confirmpassword = new javax.swing.JPasswordField();
        txt_dob = new com.toedter.calendar.JDateChooser();
        txt_contact = new javax.swing.JTextField();
        btn_signup = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        lbl_password = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("SIGN UP");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 27, 193, 55));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 110));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("First Name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 38, 183, 37));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Last Name :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 93, 183, 37));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Username :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 142, 183, 37));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Password :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 197, 183, 37));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Confirm Password :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 248, -1, 37));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("D.O.B :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 305, 183, 37));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Contact No. :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 360, 183, 37));

        txt_lastname.setBackground(new java.awt.Color(0, 153, 153));
        txt_lastname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 93, 188, 37));

        txt_firstname.setBackground(new java.awt.Color(0, 153, 153));
        txt_firstname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txt_firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 38, 188, 37));

        txt_username.setBackground(new java.awt.Color(0, 153, 153));
        txt_username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 142, 188, 37));

        txt_password.setBackground(new java.awt.Color(0, 153, 153));
        txt_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });
        jPanel2.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 199, 194, 37));

        txt_confirmpassword.setBackground(new java.awt.Color(0, 153, 153));
        txt_confirmpassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_confirmpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confirmpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txt_confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 248, 200, 39));

        txt_dob.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 305, 253, 37));

        txt_contact.setBackground(new java.awt.Color(0, 153, 153));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactKeyTyped(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 362, 235, 37));

        btn_signup.setBackground(new java.awt.Color(0, 51, 51));
        btn_signup.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btn_signup.setText("Sign Up");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        jPanel2.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 434, 182, 53));

        btn_login.setBackground(new java.awt.Color(0, 51, 51));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        btn_login.setText("Login");
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        jPanel2.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(356, 434, 185, 53));

        lbl_password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 197, 156, 30));

        lbl_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_contact.setForeground(new java.awt.Color(153, 0, 51));
        jPanel2.add(lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 360, 115, 39));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 600, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_confirmpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confirmpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirmpasswordActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        // TODO add your handling code here:
       if( validation()){
           insertDetails();
       }
        
        
    }//GEN-LAST:event_btn_signupActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_loginActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
        // TODO add your handling code here:
        checkPassword();
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyPressed
        // TODO add your handling code here:
        checkContact();
    }//GEN-LAST:event_txt_contactKeyPressed

    private void txt_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyReleased
        // TODO add your handling code here:
        checkContact();
    }//GEN-LAST:event_txt_contactKeyReleased

    private void txt_contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactKeyTyped
        // TODO add your handling code here:
        checkContact();
    }//GEN-LAST:event_txt_contactKeyTyped

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        // TODO add your handling code here:
        login login =new login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginMouseClicked

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JPasswordField txt_confirmpassword;
    private javax.swing.JTextField txt_contact;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
