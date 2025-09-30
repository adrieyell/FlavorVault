package flavorvault;

import flavorvault.LoginPage;
import java.sql.*;
import javax.swing.JOptionPane;

public class RegistrationPage extends javax.swing.JFrame {

    public RegistrationPage() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NeedHelpButton = new javax.swing.JLabel();
        LoginInsteadButton = new javax.swing.JLabel();
        GetStartedButton = new javax.swing.JButton();
        RegUsername = new javax.swing.JTextField();
        RegPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NeedHelpButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        NeedHelpButton.setForeground(new java.awt.Color(0, 0, 0));
        NeedHelpButton.setText("<html><u>Need Help?</u></html>");
        NeedHelpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NeedHelpButtonMouseClicked(evt);
            }
        });
        getContentPane().add(NeedHelpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, -1, -1));

        LoginInsteadButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        LoginInsteadButton.setForeground(new java.awt.Color(0, 0, 0));
        LoginInsteadButton.setText("<html><u>Log-In Instead</u></html>");
        LoginInsteadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginInsteadButtonMouseClicked(evt);
            }
        });
        getContentPane().add(LoginInsteadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, -1, -1));

        GetStartedButton.setBackground(new java.awt.Color(0, 0, 0));
        GetStartedButton.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        GetStartedButton.setForeground(new java.awt.Color(255, 255, 255));
        GetStartedButton.setText("GET STARTED");
        GetStartedButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GetStartedButtonMouseClicked(evt);
            }
        });
        GetStartedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetStartedButtonActionPerformed(evt);
            }
        });
        getContentPane().add(GetStartedButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 180, 50));

        RegUsername.setBackground(new java.awt.Color(255, 255, 255));
        RegUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegUsername.setText("Enter Username");
        RegUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(RegUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 220, 50));

        RegPassword.setBackground(new java.awt.Color(255, 255, 255));
        RegPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        RegPassword.setText("jPasswordField1");
        RegPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(RegPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 220, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Welcome Text.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo No Text.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/[OOP] Flavor Vault Prototype.gif"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1240, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GetStartedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetStartedButtonActionPerformed
            String username = RegUsername.getText().trim(); // Trim to remove leading/trailing spaces
            String password = new String(RegPassword.getPassword()).trim(); // If using JPasswordField

            // Validation check
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username and password fields cannot be empty!", "Input Error", JOptionPane.WARNING_MESSAGE);
                return; // Stop execution
            }

            // Database connection variables
            String url = "jdbc:mysql://localhost:3306/flavor_vault";
            String dbUser = "root";
            String dbPass = "8472252Adrielle!";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url, dbUser, dbPass);

                String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Registration successful!");
                    LoginPage login2 = new LoginPage();
                    login2.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to register.");
                }

                stmt.close();
                conn.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
                e.printStackTrace();
}

    }//GEN-LAST:event_GetStartedButtonActionPerformed

    private void LoginInsteadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginInsteadButtonMouseClicked
        LoginPage login = new LoginPage();
        login.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_LoginInsteadButtonMouseClicked

    private void GetStartedButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetStartedButtonMouseClicked


    }//GEN-LAST:event_GetStartedButtonMouseClicked

    private void RegUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegUsernameActionPerformed

    private void RegPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegPasswordActionPerformed

    private void NeedHelpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NeedHelpButtonMouseClicked
        NeedHelpRegister help = new NeedHelpRegister();
        help.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NeedHelpButtonMouseClicked

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
            java.util.logging.Logger.getLogger(RegistrationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new RegistrationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GetStartedButton;
    private javax.swing.JLabel LoginInsteadButton;
    private javax.swing.JLabel NeedHelpButton;
    private javax.swing.JPasswordField RegPassword;
    private javax.swing.JTextField RegUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    private void setVisible(LoginPage login) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
