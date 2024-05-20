
import QuizApplication.DatabaseConnection;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class OOP extends javax.swing.JFrame implements Subjects {

    public String questionid = "1";
    public String answer;
    public int min = 0;
    public int sec = 0;
    public int marks = 0;
    Timer time;

    //this creates a new oop form
    public OOP() {
        initComponents();
        initQuiz();

    }

    public OOP(String CMSID) {
        initComponents();
        jLabel21.setText(CMSID);
        initQuiz();

    }

    @Override
    public void initQuiz() {
        setLocationRelativeTo(this);
        setDate();
        setupTimer();
        loadQuestion();
        displayStudentInfo();
    }

    // Method to set the current date
    @Override
    public void setDate() {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
    }

    // Method to set up the timer
    @Override
    public void setupTimer() {
        time = new Timer(1000, (ActionEvent e) -> {
            jLabel9.setText(String.format("%02d", sec));
            jLabel8.setText(String.format("%02d", min));
            if (sec == 60) {
                sec = 0;
                min++;
                if (min == 5) {
                    time.stop();
                    answerCheck();
                    submit();
                }
            }
            sec++;
        });
        time.start();
    }

    /* @Override
    // Method to display student information
    public void displayStudentInfo() {
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where CMSID= '" + jLabel21.getText() + "'");
            if (rs.next()) {
                jLabel19.setText(rs.getString(2)); //name
                jLabel21.setText(rs.getString(1)); //cmsid
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    @Override
    public void displayStudentInfo() {
        String cmsId = jLabel21.getText();
        if (cmsId == null || cmsId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "CMS ID is not set. Please restart the application.");
            return;
        }

        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where CMSID= '" + cmsId + "'");
            if (rs.next()) {
            String studentName = rs.getString(2); // 2nd column is the name
            String returnedCmsId = rs.getString(1); // 1st column is the CMSID
               // jLabel19.setText(rs.getString(2)); //  name
               // jLabel21.setText(rs.getString(1)); // CMSID 
                if (studentName != null && !studentName.isEmpty()) {
                    jLabel19.setText(studentName);
                } else {
                    jLabel19.setText("Name not found");
                }
                jLabel21.setText(returnedCmsId); // Ensure CMSID is set properly

                // Debug output
                System.out.println("CMS ID: " + returnedCmsId + ", Name: " + studentName);
                } else {
                JOptionPane.showMessageDialog(this, "Student with CMS ID " + cmsId + " not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    // Method to check the student's answer
    public void answerCheck() {
        String studentAnswer = "";
        if (jRadioButton1.isSelected()) {
            studentAnswer = jRadioButton1.getText();
        } else if (jRadioButton2.isSelected()) {
            studentAnswer = jRadioButton2.getText();
        } else if (jRadioButton3.isSelected()) {
            studentAnswer = jRadioButton3.getText();
        } else if (jRadioButton4.isSelected()) {
            studentAnswer = jRadioButton4.getText();
        } else {
            // if no option is selected print error message
            JOptionPane.showMessageDialog(null, "Please select an option before proceeding.");
            return;
        }

        if (studentAnswer.equals(answer)) {
            marks++;
            jLabel16.setText(String.valueOf(marks));
        }

        // Increment question number
        int question_id1 = Integer.parseInt(questionid);
        question_id1++;
        questionid = String.valueOf(question_id1);

        // Clear radio buttons
        buttongroupoop.clearSelection();

        jLabel14.setText(questionid);

        // Check if it's the last question
        if (questionid.equals("11")) { // Assuming there are 10 questions
            jButton1.setVisible(false);
            submit();
        } else {
            loadQuestion();
        }
    }

    @Override
    // Method to submit the quiz results
    public void submit() {
        String CMSID = jLabel21.getText();
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("update student set marks='" + marks + "'where CMSID ='" + CMSID + "'");
            setVisible(false);
            String marks1 = Integer.toString(marks);
            new Submittedquiz(marks1).setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    // Method to load the current question
    public void loadQuestion() {
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("select * from oop_quiz where question_id ='" + questionid + "'");
            if (rs1.next()) {
                jLabel14.setText(rs1.getString(1));//question id
                jLabel17.setText(rs1.getString(2));///question 
                jRadioButton1.setText(rs1.getString(3));
                jRadioButton2.setText(rs1.getString(4));
                jRadioButton3.setText(rs1.getString(5));
                jRadioButton4.setText(rs1.getString(6));
                answer = rs1.getString(7);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttongroupoop = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 17, 62, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel2.setText("OOP QUIZ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 25, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, 40, 56, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 40, 100, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Time:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 15, 51, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("10 Min");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(879, 15, 64, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("Time Taken:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("00");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 40, 25, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("00");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 90));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("Total Questions:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("10");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 43, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("Question No:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setText("00");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 43, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setText("Marks:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 99, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setText("00");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 43, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel18.setText("Name:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel19.setText("jLabel19");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel20.setText("CMS ID:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel21.setText("jLabel21");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 220, 490));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel17.setText("Question:");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        buttongroupoop.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 85, -1, -1));

        buttongroupoop.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 152, -1, -1));

        buttongroupoop.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 226, -1, -1));

        buttongroupoop.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 294, -1, -1));

        jButton1.setBackground(java.awt.SystemColor.activeCaption);
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Next.png"))); // NOI18N
        jButton1.setText("Next Question");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 375, 172, 40));

        jButton2.setBackground(java.awt.SystemColor.activeCaption);
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Submit Quiz");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(456, 375, 160, 40));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizback1.jpg"))); // NOI18N
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -70, 960, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 750, 510));

        pack();
    }// </editor-fold>                        

    //the next question button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        answerCheck();

    }                                        

    //the submit button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int s = JOptionPane.showConfirmDialog(null, "Do you want to submit", "Select", JOptionPane.YES_NO_OPTION);
        if (s == 0) {
            answerCheck();
            submit();

        }
    }                                        

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        clearOtherSelections(jRadioButton1);
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        clearOtherSelections(jRadioButton2);

    }                                             

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        clearOtherSelections(jRadioButton3);

    }                                             

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        clearOtherSelections(jRadioButton4);
    }                                             

    // Clear other radio button selections
    private void clearOtherSelections(JRadioButton selectedButton) {
        if (selectedButton.isSelected()) {
            if (selectedButton != jRadioButton1) {
                jRadioButton1.setSelected(false);
            }
            if (selectedButton != jRadioButton2) {
                jRadioButton2.setSelected(false);
            }
            if (selectedButton != jRadioButton3) {
                jRadioButton3.setSelected(false);
            }
            if (selectedButton != jRadioButton4) {
                jRadioButton4.setSelected(false);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(OOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OOP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OOP().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.ButtonGroup buttongroupoop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration                   

}
