//imports
import QuizApplication.DatabaseConnection;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.Timer;

public class Database extends javax.swing.JFrame implements Subjects{
    private String questionid = "1";
    private String answer;
    private int min = 0;
    private int sec = 0;
    private int marks = 0;
    private Timer time;
    
    //default constructor
    public Database() {
        initComponents();
       initQuiz();
    }
    
    //parameterized constructor
     public Database(String CMSID) {
        initComponents();
        jLabel17.setText(CMSID);
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
    public void setDate() {
        SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        jLabel4.setText(dFormat.format(date));
    }

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
   
   
    // Method to display student information
    @Override
    public void displayStudentInfo() {
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where CMSID= '" + jLabel17 + "'");
            if (rs.next()) {
                jLabel11.setText(rs.getString(2)); //name
               
            } else {
            JOptionPane.showMessageDialog(null, "Student with CMSID  not found.");
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
        }

        if (studentAnswer.equals(answer)) {
            marks++;
            jLabel13.setText(String.valueOf(marks));
        }

        // Increment question number
        int question_id1 = Integer.parseInt(questionid);
        question_id1++;
        questionid = String.valueOf(question_id1);

        // Clear radio buttons
        buttonGroup1.clearSelection();

        jLabel15.setText(questionid);

        // Check if it's the last question
        if (questionid.equals("11")) {
            jButton1.setVisible(false);
            submit();
        } else {
            loadQuestion();
        }
    }

    // Method to submit the quiz results
    @Override
    public void submit() {
        String CMSID = jLabel17.getText();
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

    // Method to load the current question
    @Override
    public void loadQuestion() {
        try {
            Connection con = DatabaseConnection.getCon();
            Statement st = con.createStatement();

            ResultSet rs1 = st.executeQuery("select * from database_quiz where question_id='" + questionid + "'");
            if (rs1.next()) {
                jLabel15.setText(rs1.getString(1));
                jLabel18.setText(rs1.getString(2));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/index student.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 36)); // NOI18N
        jLabel2.setText("Database Quiz");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel3.setText("Date:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel5.setText("Total Time:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel6.setText("5 min");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel7.setText("Time Taken:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel8.setText("00");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel9.setText("00");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 990, 110));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel10.setText("Name:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel12.setText("Marks:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel13.setText("00");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel14.setText("Question No:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel15.setText("00");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel16.setText("CMS ID:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel17.setText("00");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel19.setText("Total marks:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel21.setText("10");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 230, 570));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel18.setText("Question");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jButton1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Next.png"))); // NOI18N
        jButton1.setText("Next Question");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, -1));

        jButton2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/save.png"))); // NOI18N
        jButton2.setText("Submit Quiz");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, 170, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quizback1.jpg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 90, -1, -1));

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        answerCheck();
        loadQuestion();
    
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        int s = JOptionPane.showConfirmDialog(null, "Do you want to submit", "Select", JOptionPane.YES_NO_OPTION);
        if (s == 0) {
            answerCheck();
            submit();
        }
}
    
 // Clear other radio button selections
    private void clearOtherSelections(JRadioButton selectedButton) {
        if (selectedButton.isSelected()) {
            if (selectedButton != jRadioButton1) jRadioButton1.setSelected(false);
            if (selectedButton != jRadioButton2) jRadioButton2.setSelected(false);
            if (selectedButton != jRadioButton3) jRadioButton3.setSelected(false);
            if (selectedButton != jRadioButton4) jRadioButton4.setSelected(false);
        }
   
    }                                        
// Ensure only one radio button can be selected at a time
    
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
             clearOtherSelections(jRadioButton1);
    }                                             

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                              
           clearOtherSelections(jRadioButton2);
    }                                             

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                              
           clearOtherSelections(jRadioButton3);
    }                                             

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
         clearOtherSelections(jRadioButton4);
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
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Database().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration                   
}
