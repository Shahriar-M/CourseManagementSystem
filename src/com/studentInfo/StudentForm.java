package com.studentInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends javax.swing.JFrame {

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    public StudentForm() {
        initComponents();
        this.getCourseList();
    }

    public void getCourseList() {
        ArrayList<String> courseName = new ArrayList<String>();
        courseName.add("");
        try ( Connection conn = this.connect()) {
            pst = conn.prepareStatement("select * from course");
            rs = pst.executeQuery();
            ResultSetMetaData StData = rs.getMetaData();
            q = StData.getColumnCount();
            while (rs.next()) {
                if (rs.getString("course_name") != null) {
                    courseName.add(rs.getString("course_name"));
                }
//                for (i = 1; i <= q; i++) {
//                    if (rs.getString("course_name") != null) {
//                        courseName.add(rs.getString("course_name"));
//                    }
//                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        course.setModel(new DefaultComboBoxModel<>(courseName.toArray()));
    }

    public Connection connect() {

        String url = "jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT";
        String uname = "root";
        String pass = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, uname, pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        batch = new javax.swing.JTextField();
        bloodGroup = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        courseFee = new javax.swing.JTextField();
        dueAmount = new javax.swing.JTextField();
        studentName = new javax.swing.JTextField();
        studentId = new javax.swing.JTextField();
        mobile = new javax.swing.JTextField();
        startDate = new javax.swing.JTextField();
        paidAmount = new javax.swing.JTextField();
        duration = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox();
        course = new javax.swing.JComboBox();
        stFormBackBtn = new javax.swing.JButton();
        status = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(128, 184, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tech Training Center Student Management Sysytem");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 670, 60));

        jLabel2.setBackground(new java.awt.Color(51, 255, 204));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Student Form");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 180, 40));

        jLabel3.setText("NAME");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 100, 20));

        jLabel4.setText("STUDENT ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 100, 20));

        jLabel5.setText("BATCH");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 100, 20));

        jLabel6.setText("GENDER");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 100, 20));

        jLabel7.setText("BLOOD GROUP");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 100, 20));

        jLabel8.setText("COURSE");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 20));

        jLabel9.setText("ADDRESS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, 100, 20));

        jLabel10.setText("DATE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 100, 20));

        jLabel11.setText("COURSE FEE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 90, 20));

        jLabel12.setText("DURATION");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 100, 20));

        jLabel13.setText("PAID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 20));

        jLabel14.setText("MOBILE");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 100, 20));

        jLabel15.setText("DUE");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 100, 20));

        jLabel16.setText("STATUS");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 100, 20));

        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 70, -1));
        jPanel1.add(batch, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 220, -1));
        jPanel1.add(bloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 220, -1));
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 220, -1));

        courseFee.setEditable(false);
        jPanel1.add(courseFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 220, -1));

        dueAmount.setEditable(false);
        jPanel1.add(dueAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 220, -1));
        jPanel1.add(studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 220, -1));

        studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 220, -1));

        mobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileActionPerformed(evt);
            }
        });
        mobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mobileKeyPressed(evt);
            }
        });
        jPanel1.add(mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 220, -1));
        jPanel1.add(startDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 220, -1));

        paidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountActionPerformed(evt);
            }
        });
        paidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paidAmountKeyPressed(evt);
            }
        });
        jPanel1.add(paidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 220, -1));

        duration.setEditable(false);
        jPanel1.add(duration, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, 220, -1));

        gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Male", "Female" }));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        jPanel1.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 220, -1));

        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 220, -1));

        stFormBackBtn.setText("Back");
        stFormBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stFormBackBtnActionPerformed(evt);
            }
        });
        jPanel1.add(stFormBackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 70, -1));

        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Running", "Complete" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 567, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileActionPerformed

    }//GEN-LAST:event_mobileActionPerformed

    private void stFormBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stFormBackBtnActionPerformed
        EnrollStudents est = new EnrollStudents();
        est.setVisible(true);
        dispose();
    }//GEN-LAST:event_stFormBackBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String insert = "insert into student(studentid,studentname,batch,address,"
                + "gender,mobile,bloodgroup,coursename,coursefee,paidamount,dueamount,status)values"
                + "(?,?,?,?,?,?,?,?,?,?,?,?)";

        if (studentId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Student Id should not be empty");
        } else if (studentName.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Student Name should not be empty");
        }

        if (!studentId.getText().equals("") && !studentName.getText().equals("")) {

            try ( Connection conn = this.connect()) {
                PreparedStatement pstmt = conn.prepareStatement(insert);

                int i = 1;
//            pstmt.setInt(i++, 1);
                pstmt.setString(i++, studentId.getText());
                pstmt.setString(i++, studentName.getText());
                pstmt.setString(i++, batch.getText());
                pstmt.setString(i++, address.getText());
                pstmt.setString(i++, (String) gender.getSelectedItem());
                pstmt.setString(i++, mobile.getText());
//            i++;
//            pstmt.setString(i++, startDate.getText());
                pstmt.setString(i++, bloodGroup.getText());
                pstmt.setString(i++, (String) course.getSelectedItem());
                pstmt.setString(i++, courseFee.getText());
//            pstmt.setString(i++, duration.getText());
                pstmt.setString(i++, paidAmount.getText());
                pstmt.setString(i++, dueAmount.getText());
                pstmt.setString(i++, (String) status.getSelectedItem());

                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Student Record Added");
                resetFieldAfterSave();
//            updateDB();
                System.out.println("Insert successful....");

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Field should not be empty");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void resetFieldAfterSave() {
        startDate.setText("");
        mobile.setText("");
        address.setText("");
        batch.setText("");
        studentName.setText("");
        studentId.setText("");
        courseFee.setText("");
        duration.setText("");
        paidAmount.setText("");
        course.setSelectedIndex(0);
        status.setSelectedIndex(0);
        gender.setSelectedIndex(0);
        dueAmount.setText("");
        bloodGroup.setText("");
    }
    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed

        try (Connection conn = this.connect()) {
            if ((String) course.getSelectedItem() == " " || (String) course.getSelectedItem() == null) {
                duration.setText("");
                courseFee.setText("");
            } else {
                pst = conn.prepareStatement("select * from course where course_name = " + "'" + (String) course.getSelectedItem() + "'");
                rs = pst.executeQuery();
                ResultSetMetaData StData = rs.getMetaData();
                q = StData.getColumnCount();
                while (rs.next()) {
                    for (i = 1; i <= q; i++) {
                        duration.setText(rs.getString("duration"));
                        courseFee.setText(rs.getString("fee"));
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_courseActionPerformed

    private void paidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountActionPerformed
        String paidAmt = paidAmount.getText();
        String feeAmt = courseFee.getText();
        if (paidAmt != null) {
            if (Integer.parseInt(feeAmt) < Integer.parseInt(paidAmt)) {
                JOptionPane.showMessageDialog(null, "Paid amount should not be greater than Due amount");
                paidAmount.setText(null);
                dueAmount.setText(null);
            } else {
                int dueAmt = Integer.parseInt(feeAmt) - Integer.parseInt(paidAmt);
                dueAmount.setText("" + dueAmt + "");
            }
        }

    }//GEN-LAST:event_paidAmountActionPerformed

    private void mobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mobileKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            JOptionPane.showMessageDialog(null, "Please Enter number only");
            mobile.setText(null);
        }
    }//GEN-LAST:event_mobileKeyPressed

    private void paidAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyPressed
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            JOptionPane.showMessageDialog(null, "Please Enter number only");
            paidAmount.setText(null);
        }
    }//GEN-LAST:event_paidAmountKeyPressed

    private void studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdActionPerformed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(StudentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StudentForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField batch;
    private javax.swing.JTextField bloodGroup;
    private javax.swing.JComboBox course;
    private javax.swing.JTextField courseFee;
    private javax.swing.JTextField dueAmount;
    private javax.swing.JTextField duration;
    private javax.swing.JComboBox gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JButton stFormBackBtn;
    private javax.swing.JTextField startDate;
    private javax.swing.JComboBox status;
    private javax.swing.JTextField studentId;
    private javax.swing.JTextField studentName;
    // End of variables declaration//GEN-END:variables
}
