/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_managmentsystem;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;


/**
 *
 * @author ankit
 */
public class UpdateFeesDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddFees
     */
    public UpdateFeesDetails() {
        initComponents();
        displayCashFirst();  
        fillComboBox();
  
        txt_ReceiptNo.setText(Integer.toString(getReceiptNo()));
        setRecord();
    }
    public void displayCashFirst(){
        lbl_ddNo.setVisible(false);
        lbl_ChequeNo.setVisible(false);
        lbl_BankName.setVisible(false);
        
        txt_ddNo.setVisible(false);
        txt_ChequeNo.setVisible(false);
        txt_gstNo.setVisible(false);
        
    }
    
    public boolean validation(){
         if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
           if(txt_gstNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter the Bank Name ");
            return false;
           }
            if( txt_ChequeNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter the  Cheque Number  ");
            return false;
           }
        }
         if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("DD")){
           if(txt_gstNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter the Bank Name ");
            return false;
           }
            if( txt_ddNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter the DD Number  ");
            return false;
           }
        }
         if(combo_PaymentMode.getSelectedItem().toString().equalsIgnoreCase("card")){
           if(txt_gstNo.getText().equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter the Bank Name ");
            return false;
           }
          
        }
        if(txt_ReceivedFrom.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter the UserName ");
            return false;
        }
        if(datechooser.getDate()==null){
            JOptionPane.showMessageDialog(this,"Please select a Date ");
            return false;
        }
        if(txt_Amount.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Please Enter the Amount(in Number) ");
            return false;
        }
       
        
        return true;
    }
    
    public void fillComboBox(){
        try{
               Connection con =DBConnection.getConnection();
              String sql = "select cname from course";
             PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs =pst.executeQuery();
            while(rs.next()){
                combo_Course.addItem(rs.getString("cname"));
            }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getReceiptNo(){
        int receipt=0;
        try{
            Connection con =DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement("select max(receipt_no) from fees_Details");
            ResultSet rs =pst.executeQuery();
            if(rs.next()==true){
                receipt=rs.getInt(1);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return receipt+1;
    }
    
    
    public String updateData(){
        
        String status ="";
        int receiptNo=Integer.parseInt(txt_ReceiptNo.getText());
        String studentName=txt_ReceivedFrom.getText();
        String rollNo =txt_RollNo.getText();
        String paymentMode=combo_PaymentMode.getSelectedItem().toString();
        String chequeNo= txt_ChequeNo.getText();
        String bankName = txt_BankName.getText();
        String ddNO =txt_ddNo.getText();
        String courseName =txt_CourseName.getText();
        String gstin = txt_gstNo.getText();
        double totalAmount = Double.parseDouble(txt_Total.getText()); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date =dateFormat.format(datechooser.getDate());
        double initialAmount = Double.parseDouble(txt_Amount.getText());
        double cgst = Double.parseDouble(txt_CGST.getText());
        double sgst = Double.parseDouble(txt_SGST.getText());
        String totalInWords =txt_Totalinwords.getText();
        String remark = txt_Remark.getText();
        int year1 =Integer.parseInt(txt_Year1.getText());
        int year2 =Integer.parseInt(txt_Year2.getText());
        
         try{
            Connection con =DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement("update fees_Details set student_name = ? , roll_no = ? , payment_mode = ? ,"
                     + "cheque_no = ? , bank_name = ? , dd_no = ? , course_name = ? , gstin = ? , total_amount = ? , date = ? ,amount = ? , cgst = ? ,sgst = ?, total_in_words = ?,"
                     + "remarks = ? , year1 = ?, year2=? where receipt_no = ? ");
            
             pst.setString(1, studentName);
             pst.setString(2,rollNo);
             pst.setString(3, paymentMode);
             pst.setString(4, chequeNo);
             pst.setString(5, bankName);
             pst.setString(6,ddNO);
             pst.setString(7, courseName);
             pst.setString(8, gstin);
             pst.setDouble(9, totalAmount);
             pst.setString(10,date);
             pst.setDouble(11, initialAmount);
             pst.setDouble(12, cgst);
             pst.setDouble(13, sgst);
             pst.setString(14,totalInWords);
             pst.setString(15,remark);
             pst.setInt(16, year1);
             pst.setInt(17, year2);
              pst.setInt(18, receiptNo);
             
             
            int rowCount =pst.executeUpdate();
            if (rowCount==1){
                status = "Success";
            }
            else {
                status ="Failed";
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
          
        return status ;
    }
    
    
    public void setRecord(){
        try{
            Connection con =DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from  fees_details order by receipt_no desc fetch first 1 rows only");
            ResultSet rs =pst.executeQuery();
            rs.next();
            txt_ReceiptNo.setText(rs.getString("receipt_no"));
            combo_PaymentMode.setSelectedItem(rs.getString("payment_mode"));
             txt_ChequeNo.setText(rs.getString("cheque_no"));
              txt_ddNo.setText(rs.getString("dd_no"));
            txt_BankName.setText(rs.getString("bank_name"));
             txt_ReceivedFrom.setText(rs.getString("student_name"));
            datechooser.setDate(rs.getDate("date"));
             txt_gstNo.setText(rs.getString("gstin"));
             txt_Year1.setText(rs.getString("year1"));
             txt_Year2.setText(rs.getString("year2"));
             txt_RollNo.setText(rs.getString("roll_no"));
              combo_Course.setSelectedItem(rs.getString("course_name"));
             txt_CourseName.setText(rs.getString("course_name"));
             txt_Amount.setText(rs.getString("amount"));
             txt_CGST.setText(rs.getString("cgst"));
             txt_SGST.setText(rs.getString("sgst"));
             txt_Total.setText(rs.getString("total_amount"));
             txt_Totalinwords.setText(rs.getString("total_in_words"));
             txt_Remark.setText(rs.getString("remarks"));
            
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

        panelSidebar = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelEditCourse = new javax.swing.JPanel();
        btnEditCourse = new javax.swing.JLabel();
        panelCourseList = new javax.swing.JPanel();
        btnCourseList = new javax.swing.JLabel();
        panelViewRecord = new javax.swing.JPanel();
        btnViewRecord = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelParent = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_ddNo = new javax.swing.JLabel();
        gstNo = new javax.swing.JLabel();
        lbl_ChequeNo = new javax.swing.JLabel();
        lbl_BankName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_gstNo = new javax.swing.JTextField();
        txt_ReceiptNo = new javax.swing.JTextField();
        txt_ChequeNo = new javax.swing.JTextField();
        combo_PaymentMode = new javax.swing.JComboBox<>();
        datechooser = new com.toedter.calendar.JDateChooser();
        panel_child = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_ReceivedFrom = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Year1 = new javax.swing.JTextField();
        txt_Year2 = new javax.swing.JTextField();
        txt_RollNo = new javax.swing.JTextField();
        combo_Course = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_Total = new javax.swing.JTextField();
        txt_Totalinwords = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_Amount = new javax.swing.JTextField();
        txt_CGST = new javax.swing.JTextField();
        txt_SGST = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txt_CourseName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Remark = new javax.swing.JTextArea();
        btn_Print = new javax.swing.JButton();
        txt_ddNo = new javax.swing.JTextField();
        txt_BankName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSidebar.setBackground(new java.awt.Color(0, 51, 51));
        panelSidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(0, 51, 51));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/home.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 60));

        panelSidebar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 230, 70));

        panelLogout.setBackground(new java.awt.Color(0, 51, 51));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/logout.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelLogout.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 60));

        panelSidebar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 640, 230, 80));

        panelSearch.setBackground(new java.awt.Color(0, 51, 51));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/search2.png"))); // NOI18N
        btnSearch.setText("Search Record");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        panelSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        panelSidebar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 230, 80));

        panelEditCourse.setBackground(new java.awt.Color(0, 51, 51));
        panelEditCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelEditCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditCourse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEditCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/edit2.png"))); // NOI18N
        btnEditCourse.setText("Edit Course");
        btnEditCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseExited(evt);
            }
        });
        panelEditCourse.add(btnEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 70));

        panelSidebar.add(panelEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 230, 80));

        panelCourseList.setBackground(new java.awt.Color(0, 51, 51));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/list.png"))); // NOI18N
        btnCourseList.setText("Course List");
        btnCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCourseListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCourseListMouseExited(evt);
            }
        });
        panelCourseList.add(btnCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 60));

        panelSidebar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 230, 80));

        panelViewRecord.setBackground(new java.awt.Color(0, 51, 51));
        panelViewRecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelViewRecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewRecord.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnViewRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnViewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/view all record.png"))); // NOI18N
        btnViewRecord.setText("View Record");
        btnViewRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewRecordMouseExited(evt);
            }
        });
        panelViewRecord.add(btnViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 70));

        panelSidebar.add(panelViewRecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 230, 80));

        panelBack.setBackground(new java.awt.Color(0, 51, 51));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managmentsystem/imageicon/left-arrow.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 60));

        panelSidebar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 230, 80));

        getContentPane().add(panelSidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 750));

        panelParent.setBackground(new java.awt.Color(0, 102, 102));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(0, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 204));
        jLabel8.setText("Receipt No. :   SOC  -");
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 204));
        jLabel1.setText("Mode of Payment :");
        panelParent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 30));

        lbl_ddNo.setBackground(new java.awt.Color(0, 153, 153));
        lbl_ddNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ddNo.setForeground(new java.awt.Color(255, 255, 204));
        lbl_ddNo.setText("DD No. :");
        panelParent.add(lbl_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 30));

        gstNo.setBackground(new java.awt.Color(0, 153, 153));
        gstNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gstNo.setForeground(new java.awt.Color(255, 255, 204));
        gstNo.setText("GSTN : ");
        panelParent.add(gstNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 60, 30));

        lbl_ChequeNo.setBackground(new java.awt.Color(0, 153, 153));
        lbl_ChequeNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_ChequeNo.setForeground(new java.awt.Color(255, 255, 204));
        lbl_ChequeNo.setText("Cheque No. :");
        panelParent.add(lbl_ChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 30));

        lbl_BankName.setBackground(new java.awt.Color(0, 153, 153));
        lbl_BankName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_BankName.setForeground(new java.awt.Color(255, 255, 204));
        lbl_BankName.setText("Bank Name :");
        panelParent.add(lbl_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 30));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 204));
        jLabel6.setText("Date :");
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 90, 30));

        txt_gstNo.setBackground(new java.awt.Color(0, 204, 204));
        txt_gstNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_gstNo.setForeground(new java.awt.Color(204, 0, 0));
        txt_gstNo.setText("76***$***67AT");
        txt_gstNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gstNoActionPerformed(evt);
            }
        });
        panelParent.add(txt_gstNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 170, 30));

        txt_ReceiptNo.setBackground(new java.awt.Color(0, 204, 204));
        txt_ReceiptNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ReceiptNo.setForeground(new java.awt.Color(204, 0, 0));
        panelParent.add(txt_ReceiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 210, 30));

        txt_ChequeNo.setBackground(new java.awt.Color(0, 204, 204));
        txt_ChequeNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ChequeNo.setForeground(new java.awt.Color(204, 0, 0));
        panelParent.add(txt_ChequeNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        combo_PaymentMode.setBackground(new java.awt.Color(0, 204, 204));
        combo_PaymentMode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_PaymentMode.setForeground(new java.awt.Color(0, 51, 51));
        combo_PaymentMode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_PaymentMode.setSelectedIndex(2);
        combo_PaymentMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_PaymentModeActionPerformed(evt);
            }
        });
        panelParent.add(combo_PaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 210, 30));

        datechooser.setBackground(new java.awt.Color(0, 204, 204));
        datechooser.setForeground(new java.awt.Color(255, 255, 204));
        panelParent.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 160, 30));

        panel_child.setBackground(new java.awt.Color(0, 102, 102));
        panel_child.setForeground(new java.awt.Color(255, 255, 0));
        panel_child.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 204));
        jLabel7.setText("The following payment in the office for the Year ");
        panel_child.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 204));
        jLabel9.setText("Roll No.  :");
        panel_child.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 90, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 204));
        jLabel10.setText("Received From :");
        panel_child.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 204));
        jLabel11.setText("Course :");
        panel_child.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 30));

        txt_ReceivedFrom.setBackground(new java.awt.Color(0, 204, 204));
        txt_ReceivedFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_ReceivedFrom.setForeground(new java.awt.Color(255, 255, 255));
        panel_child.add(txt_ReceivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 260, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("-");
        panel_child.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 30, -1));

        txt_Year1.setBackground(new java.awt.Color(0, 204, 204));
        txt_Year1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Year1.setForeground(new java.awt.Color(255, 255, 255));
        txt_Year1.setText("2024");
        panel_child.add(txt_Year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 90, 30));

        txt_Year2.setBackground(new java.awt.Color(0, 204, 204));
        txt_Year2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Year2.setForeground(new java.awt.Color(255, 255, 255));
        txt_Year2.setText("2025");
        panel_child.add(txt_Year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 90, 30));

        txt_RollNo.setBackground(new java.awt.Color(0, 204, 204));
        txt_RollNo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_RollNo.setForeground(new java.awt.Color(255, 255, 153));
        txt_RollNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_RollNoActionPerformed(evt);
            }
        });
        panel_child.add(txt_RollNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 190, 30));

        combo_Course.setBackground(new java.awt.Color(0, 204, 204));
        combo_Course.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        combo_Course.setForeground(new java.awt.Color(0, 51, 51));
        combo_Course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseActionPerformed(evt);
            }
        });
        panel_child.add(combo_Course, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 210, 40));

        jSeparator1.setForeground(new java.awt.Color(153, 255, 255));
        panel_child.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 800, 10));

        jSeparator2.setBackground(new java.awt.Color(153, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(153, 255, 255));
        panel_child.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 800, 10));

        jLabel13.setBackground(new java.awt.Color(0, 204, 204));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 153));
        jLabel13.setText("Amount(Rs.)");
        panel_child.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 153));
        jLabel14.setText("S. No.");
        panel_child.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        jLabel15.setBackground(new java.awt.Color(0, 204, 204));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 153));
        jLabel15.setText("Heads");
        panel_child.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, -1, 30));

        txt_Total.setBackground(new java.awt.Color(0, 204, 204));
        txt_Total.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Total.setForeground(new java.awt.Color(153, 0, 51));
        panel_child.add(txt_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 150, 30));

        txt_Totalinwords.setBackground(new java.awt.Color(0, 204, 204));
        txt_Totalinwords.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Totalinwords.setForeground(new java.awt.Color(255, 255, 255));
        panel_child.add(txt_Totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 420, 30));

        jLabel16.setBackground(new java.awt.Color(0, 204, 204));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 153));
        jLabel16.setText("Remarks :");
        panel_child.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 110, 30));

        jLabel17.setBackground(new java.awt.Color(0, 204, 204));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 153));
        jLabel17.setText("CGST 9%");
        panel_child.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 140, 30));

        txt_Amount.setBackground(new java.awt.Color(0, 204, 204));
        txt_Amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_Amount.setForeground(new java.awt.Color(255, 0, 0));
        txt_Amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AmountActionPerformed(evt);
            }
        });
        panel_child.add(txt_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 150, 30));

        txt_CGST.setBackground(new java.awt.Color(0, 204, 204));
        txt_CGST.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_CGST.setForeground(new java.awt.Color(255, 0, 51));
        panel_child.add(txt_CGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 150, 30));

        txt_SGST.setBackground(new java.awt.Color(0, 204, 204));
        txt_SGST.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_SGST.setForeground(new java.awt.Color(255, 0, 0));
        panel_child.add(txt_SGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 150, 30));

        jSeparator3.setForeground(new java.awt.Color(153, 255, 255));
        panel_child.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 320, -1));

        jLabel18.setBackground(new java.awt.Color(0, 204, 204));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 153));
        jLabel18.setText("SGST 9%");
        panel_child.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 140, 30));

        jLabel19.setBackground(new java.awt.Color(0, 153, 153));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 153));
        jLabel19.setText("Reciever Signature");
        panel_child.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 170, 30));

        jLabel20.setBackground(new java.awt.Color(0, 153, 153));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 153));
        jLabel20.setText("Total in Words :");
        panel_child.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 140, 30));

        jSeparator4.setForeground(new java.awt.Color(153, 255, 255));
        panel_child.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 220, 10));

        txt_CourseName.setBackground(new java.awt.Color(0, 204, 204));
        txt_CourseName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_CourseName.setForeground(new java.awt.Color(255, 255, 255));
        panel_child.add(txt_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 270, 30));

        jScrollPane1.setBackground(new java.awt.Color(0, 204, 204));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        txt_Remark.setColumns(20);
        txt_Remark.setForeground(new java.awt.Color(0, 51, 51));
        txt_Remark.setRows(5);
        jScrollPane1.setViewportView(txt_Remark);

        panel_child.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 340, 80));

        btn_Print.setBackground(new java.awt.Color(0, 51, 51));
        btn_Print.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_Print.setText("Print");
        btn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PrintActionPerformed(evt);
            }
        });
        panel_child.add(btn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 130, 40));

        panelParent.add(panel_child, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 820, 550));

        txt_ddNo.setBackground(new java.awt.Color(0, 204, 204));
        txt_ddNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ddNo.setForeground(new java.awt.Color(204, 0, 0));
        panelParent.add(txt_ddNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 210, 30));

        txt_BankName.setBackground(new java.awt.Color(0, 204, 204));
        txt_BankName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_BankName.setForeground(new java.awt.Color(204, 0, 0));
        panelParent.add(txt_BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 210, 30));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 840, 750));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnEditCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCourseMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelEditCourse.setBackground(clr);
    }//GEN-LAST:event_btnEditCourseMouseEntered

    private void btnEditCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCourseMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelEditCourse.setBackground(clr);
    }//GEN-LAST:event_btnEditCourseMouseExited

    private void btnCourseListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseEntered

    private void btnCourseListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseExited

    private void btnViewRecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseEntered

    private void btnViewRecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewRecordMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelViewRecord.setBackground(clr);
    }//GEN-LAST:event_btnViewRecordMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        // TODO add your handling code here:
         Color clr =new Color(0,61,65);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        // TODO add your handling code here:
         Color clr =new Color(0,51,51);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
      Home home = new Home();
      home.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
       
        login login = new login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void txt_RollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_RollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_RollNoActionPerformed

    private void btn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PrintActionPerformed
        if(validation()==true){
            
            String result =updateData();
            if (result.equals("Success")){
                JOptionPane.showMessageDialog(this, " Record Successfully Updated.");
                
                PrintPage printpage =new PrintPage();
                printpage.setVisible(true);
                this.dispose();
                
                
            }
            else{
                JOptionPane.showMessageDialog(this, "Record Updation Failed.");
            }
        }
    }//GEN-LAST:event_btn_PrintActionPerformed

    private void combo_PaymentModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_PaymentModeActionPerformed
        
        if(combo_PaymentMode.getSelectedIndex()==0){
             lbl_ddNo.setVisible(true);
             txt_ddNo.setVisible(true);
             lbl_ChequeNo.setVisible(false);
             txt_ChequeNo.setVisible(false);
             lbl_BankName.setVisible(true);
             txt_gstNo.setVisible(true);
        }
          if(combo_PaymentMode.getSelectedIndex()==1){
             lbl_ChequeNo.setVisible(true);
             txt_ChequeNo.setVisible(true);
             
             lbl_BankName.setVisible(true);
             txt_gstNo.setVisible(true);
             lbl_ddNo.setVisible(false);
             txt_ddNo.setVisible(false);
        }
            if(combo_PaymentMode.getSelectedIndex()==2){
             lbl_ChequeNo.setVisible(false);
             txt_ChequeNo.setVisible(false);
             lbl_BankName.setVisible(false);
             txt_gstNo.setVisible(false);
             lbl_ddNo.setVisible(false);
             txt_ddNo.setVisible(false);
             
        }
             if(combo_PaymentMode.getSelectedIndex()==3){
             lbl_ChequeNo.setVisible(false);
             txt_ChequeNo.setVisible(false);
             lbl_BankName.setVisible(true);
             txt_gstNo.setVisible(true);
             lbl_ddNo.setVisible(false);
             txt_ddNo.setVisible(false);
             
        }
        
    }//GEN-LAST:event_combo_PaymentModeActionPerformed

    private void txt_AmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AmountActionPerformed
        // TODO add your handling code here:
        float amount = Float.parseFloat(txt_Amount.getText());
        float cgst = amount * 0.09f;
        float sgst = amount * 0.09f;
        float total = amount + cgst + sgst;

        txt_CGST.setText(String.format("%.2f", cgst));
        txt_SGST.setText(String.format("%.2f", sgst));
        txt_Total.setText(String.format("%.2f", total));
        
        txt_Totalinwords.setText(NumberToWords.convertNumberToWords(total)+" only.");
    }//GEN-LAST:event_txt_AmountActionPerformed

    private void combo_CourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseActionPerformed
        // TODO add your handling code here:
        txt_CourseName.setText(combo_Course.getSelectedItem().toString());
    }//GEN-LAST:event_combo_CourseActionPerformed

    private void txt_gstNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gstNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gstNoActionPerformed

    private void btnCourseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseClicked
         ViewCourse editcourse = new ViewCourse ();
        editcourse.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCourseListMouseClicked

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
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateFeesDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateFeesDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEditCourse;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnViewRecord;
    private javax.swing.JButton btn_Print;
    private javax.swing.JComboBox<String> combo_Course;
    private javax.swing.JComboBox<String> combo_PaymentMode;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JLabel gstNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_BankName;
    private javax.swing.JLabel lbl_ChequeNo;
    private javax.swing.JLabel lbl_ddNo;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEditCourse;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JPanel panelViewRecord;
    private javax.swing.JPanel panel_child;
    private javax.swing.JTextField txt_Amount;
    private javax.swing.JTextField txt_BankName;
    private javax.swing.JTextField txt_CGST;
    private javax.swing.JTextField txt_ChequeNo;
    private javax.swing.JTextField txt_CourseName;
    private javax.swing.JTextField txt_ReceiptNo;
    private javax.swing.JTextField txt_ReceivedFrom;
    private javax.swing.JTextArea txt_Remark;
    private javax.swing.JTextField txt_RollNo;
    private javax.swing.JTextField txt_SGST;
    private javax.swing.JTextField txt_Total;
    private javax.swing.JTextField txt_Totalinwords;
    private javax.swing.JTextField txt_Year1;
    private javax.swing.JTextField txt_Year2;
    private javax.swing.JTextField txt_ddNo;
    private javax.swing.JTextField txt_gstNo;
    // End of variables declaration//GEN-END:variables
}
