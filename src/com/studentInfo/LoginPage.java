/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentInfo;
import java.awt.event.KeyEvent;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class LoginPage extends javax.swing.JFrame {
    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;
    public String stid;

    public LoginPage() {
        this.createTable();
        initComponents();
    }
    
//            try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/jdbctest", "root", "");
//            Statement stmt = con.createStatement();
//
//            String sql2
//                    = "INSERT INTO student VALUES(4,'svnkjsdnf')";
//            String sql3
//                    = "INSERT INTO student VALUES(5,'svnvdvkjsdnf')";
//            String selectAll = "select * from student";
//            String selectCondition = "select * from student";
//
//            stmt.addBatch(sql2);
//            stmt.addBatch(sql3);
//            stmt.executeBatch();
//            con.commit();
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    
    public Connection connect() {
        
        String url = "jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT";
        String uname = "root";
        String pass = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,uname,pass);
        } catch (Exception e) { 
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createTable() {
        String dbName = "CREATE DATABASE IF NOT EXISTS STUDENT_MANAGEMENT";
        String defualtUser = "INSERT INTO users(username,password) SELECT 'admin','admin' WHERE NOT EXISTS(SELECT * from users where username = 'admin')";
        String studentTable = "CREATE TABLE IF NOT EXISTS Student(studentid INT(10) AUTO_INCREMENT, \n" +
                                "studentname VARCHAR(255) NOT NULL,\n" +
                                "batch VARCHAR(255) NOT NULL,\n" +
                                "address VARCHAR(255),\n" +
                                "gender VARCHAR(255) NOT NULL,\n" +
                                "mobile VARCHAR(255),\n" +
                                "bloodgroup VARCHAR(255),\n" +
                                "course_id INT(10),\n" +
                                "coursename VARCHAR(255),\n" +
                                "coursefee VARCHAR(255),\n" +
                                "paidamount VARCHAR(255),\n" +
                                "dueamount VARCHAR(255), \n" +
                                "status VARCHAR(255),\n" +
                                "action_date DATETIME,\n" +
                                "PRIMARY KEY (studentid),\n" +
                                "FOREIGN KEY (course_id) REFERENCES Course(course_id)"+
                                ");";
        String courseTable = "CREATE TABLE IF NOT EXISTS Course(course_id INT(10) AUTO_INCREMENT, \n" +
                                "teacher_name VARCHAR(255) NOT NULL,\n" +
                                "course_name VARCHAR(255) NOT NULL,\n" +
                                "duration VARCHAR(255) NOT NULL,\n" +
                                "fee VARCHAR(255),\n" +
                                "action_date DATETIME,\n" +
                                "PRIMARY KEY (course_id)\n" +
                                ");";
        String teacherTable = "CREATE TABLE IF NOT EXISTS Teacher(teacher_id INT(10) AUTO_INCREMENT, \n" +
                                "teacher_name VARCHAR(255) NOT NULL,\n" +
                                "course_id INT(10),\n" +
                                "course_name VARCHAR(255) NOT NULL,\n" +
                                "gender VARCHAR(255) NOT NULL,\n" +
                                "mobile VARCHAR(255),\n" +
                                "bloodgroup VARCHAR(255),\n" +
                                "action_date DATETIME,\n" +
                                "PRIMARY KEY (teacher_id),\n" +
                                "FOREIGN KEY (course_id) REFERENCES Course(course_id)\n" +
                                ");";
        String userTable = "CREATE TABLE IF NOT EXISTS Users(\n" +
                                "user_id INT(10) AUTO_INCREMENT,\n" +
                                "username VARCHAR(255) ,\n" +
                                "password VARCHAR(255),\n" +
                                "PRIMARY KEY(user_id)\n" +
                                ");";
        String courseDataInsert = "INSERT INTO coursedata (coursename,coursefee,duration) "
                + "VALUES('Graphics Design',5000,4),"
                + "('Web Design',7000,8),"
                + "('Digital Marketing',4000,3),"
                + "('Database',8000,6);";

        try {
            Statement st = this.connect().createStatement();
            st.addBatch(dbName);
            st.addBatch(courseTable);
            st.addBatch(studentTable);
            
            st.addBatch(teacherTable);
            st.addBatch(userTable);
            st.addBatch(defualtUser);
//            st.execute(courseDataInsert);
            st.executeBatch();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        submitBtn = new javax.swing.JButton();
        password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 184, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 190, 40));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 110, 20));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 120, 30));

        username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, 30));

        submitBtn.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        submitBtn.setText("Login");
        submitBtn.setPreferredSize(new java.awt.Dimension(100, 30));
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 110, -1));

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 600, 350));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Studentinfo/login.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 1060, 640));

        setSize(new java.awt.Dimension(1071, 671));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed

            String userText = username.getText();
            String pwdText = password.getText();
            String usern = null;
            String pass = null;
            
            try (Connection conn = this.connect()) {
            pst = conn.prepareStatement("select * from users where username = " + "'" + userText + "'");
            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();
            q = StData.getColumnCount();
            while (rs.next()) {
                for (i = 1; i <= q; i++) {
                   usern = rs.getString("username");
                   pass = rs.getString("password");

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
                    
            if (userText.equals(usern) && pwdText.equals(pass)) {
                username.setText(null);
                password.setText(null);
                EnrollStudents est = new EnrollStudents();
                est.setVisible(true);
                dispose();
            } else {
                password.setText(null);
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){   
        String userText = username.getText();
        String pwdText = password.getText();
        String usern = null;
        String pass = null;

        try (Connection conn = this.connect()) {
        pst = conn.prepareStatement("select * from users where username = " + "'" + userText + "'");
        rs = pst.executeQuery();
        ResultSetMetaData StData = rs.getMetaData();
        q = StData.getColumnCount();
        while (rs.next()) {
            for (i = 1; i <= q; i++) {
               usern = rs.getString("username");
               pass = rs.getString("password");

            }

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

        if (userText.equals(usern) && pwdText.equals(pass)) {
            username.setText(null);
            password.setText(null);
            EnrollStudents est = new EnrollStudents();
            est.setVisible(true);
            dispose();
        } else {
            password.setText(null);
            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
        }
        }
    }//GEN-LAST:event_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
