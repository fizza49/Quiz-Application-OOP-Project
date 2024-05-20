//imports 
import QuizApplication.DatabaseConnection;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Java extends javax.swing.JFrame implements Subjects {

    public String questionid = "1";
    public String answer;
    public int min = 0;
    public int sec = 0;
    public int marks = 0;
    Timer time;

    
    /*default constructor*/
    public Java() {
        initComponents();
        initQuiz();

    }

    //parameterized constructor
    public Java(String CMSID) {
        initComponents();
        jLabel20.setText(CMSID);
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

   @Override
    // Method to set the current date
    public void setDate() {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
    }

    @Override
    // Method to set up the timer
    public void setupTimer() {
        time = new Timer(1000, (ActionEvent e) -> {
            jLabel17.setText(String.format("%02d", sec));
            jLabel16.setText(String.format("%02d", min));
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

    @Override
    // Method to display student information
    public void displayStudentInfo() {
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where CMSID= '" + jLabel20.getText() + "'");
            if (rs.next()) {
                jLabel17.setText(rs.getString(2)); // name
                jLabel20.setText(rs.getString(1)); // cmsid
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
@Override
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
        }else {
        // No option selected
        JOptionPane.showMessageDialog(null, "Please select an option before proceeding.");
        return; 
        }
        if (studentAnswer.equals(answer)) {
            marks++;
            jLabel10.setText(String.valueOf(marks));
        }

        // Increment question number
        int question_id1 = Integer.parseInt(questionid);
        question_id1++;
        questionid = String.valueOf(question_id1);

        // Clear radio buttons
        javabuttongroup.clearSelection();

        jLabel12.setText(questionid);

        // Check if it's the last question
        if (questionid.equals("11")) {
            jButton2.setVisible(false);
            time.stop();  // Stop the timer
            submit();
        } else {
            loadQuestion();
        }
    }

    @Override
    // Method to submit the quiz results
 public void submit() {
        String CMSID = jLabel20.getText();
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
    //loading the nextquestion when we click next button
    public void loadQuestion() {
        if (Integer.parseInt(questionid) > 10) {
            return; // Do not load more than 10 questions
        }

        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("select * from java_quiz where question_id='" + questionid + "'");
            if (rs1.next()) {
                jLabel12.setText(rs1.getString(1));  //question id
                jLabel18.setText(rs1.getString(2));  //question
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

        javabuttongroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 37, 63, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("JAVA QUIZ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 32, 258, 65));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel3.setText("Date: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("Total time: ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setText("Time taken:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setText("5 min");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setText("00");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, -1, 20));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel17.setText("00");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1000, 110));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 209, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Name:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("Total Question:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 110, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("10");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 110, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("Marks:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 20));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setText("00");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 40, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("Question no:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("00");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 40, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel19.setText("CMSID:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel20.setText("00");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 250, 480));

        jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Next.png"))); // NOI18N
        jButton2.setText("Next Question");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 487, 180, 40));

        jButton3.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton3.setText("Submit Quiz");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 487, 200, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel18.setText("Question :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        javabuttongroup.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 730, -1));

        javabuttongroup.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 740, -1));

        javabuttongroup.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 740, -1));

        javabuttongroup.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 740, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizback1.jpg"))); // NOI18N
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 10, -1, -1));

        pack();
    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        answerCheck();
      
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
         int s = JOptionPane.showConfirmDialog(null, "Do you want to submit", "Select", JOptionPane.YES_NO_OPTION);
        if (s == 0) {
            answerCheck();
            submit();
        }
    }                                        

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
            java.util.logging.Logger.getLogger(Java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Java.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Java().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.ButtonGroup javabuttongroup;
    // End of variables declaration                   
}
