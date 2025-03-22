package project.hms.panels;

import java.util.Arrays;
import project.hms.MainFrame;
import project.hms.models.AccountData;
import project.hms.services.AuthSystem;

public class SignupPanel extends javax.swing.JPanel {
    
    private MainFrame parentFrame;
    public SignupPanel(MainFrame frame) {
        this.parentFrame = frame;
        
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
        java.awt.GridBagConstraints gridBagConstraints;

        passwordField1 = new javax.swing.JPasswordField();
        firstNameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        passwordField2 = new javax.swing.JPasswordField();
        passwordLabel1 = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        usernameLabel2 = new javax.swing.JLabel();
        signupBTN = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();
        usernameLabel3 = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        roleMenu = new javax.swing.JComboBox<>();

        passwordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordField1ActionPerformed(evt);
            }
        });

        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });

        usernameLabel.setText("First Name:");

        passwordLabel.setText("Password:");

        statusLabel.setText("ErrorLabel");

        passwordField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordField2ActionPerformed(evt);
            }
        });

        passwordLabel1.setText("Confirm password:");

        lastNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameFieldActionPerformed(evt);
            }
        });

        usernameLabel2.setText("Last Name:");

        signupBTN.setText("Sign up");
        signupBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBTNActionPerformed(evt);
            }
        });

        backBTN.setText("Back");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        usernameLabel3.setText("Username:");

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        roleMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(signupBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backBTN)
                                .addGap(28, 28, 28)
                                .addComponent(statusLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(passwordLabel1)
                                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(usernameLabel3))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(roleMenu, 0, 100, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passwordField2)
                                        .addComponent(firstNameField)
                                        .addComponent(usernameField)
                                        .addComponent(lastNameField)
                                        .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))))))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(backBTN))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(statusLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(signupBTN)
                .addGap(0, 65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void passwordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordField1ActionPerformed
        passwordField2.requestFocus();
    }//GEN-LAST:event_passwordField1ActionPerformed

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        passwordField1.requestFocus();
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void passwordField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordField2ActionPerformed
        handleSignup();
    }//GEN-LAST:event_passwordField2ActionPerformed

    private void lastNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameFieldActionPerformed

    private void signupBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBTNActionPerformed
        handleSignup();
    }//GEN-LAST:event_signupBTNActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        parentFrame.showLogin();
    }//GEN-LAST:event_backBTNActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void handleSignup(){
        String username = usernameField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String role = (String) roleMenu.getSelectedItem();
        if(Arrays.equals(passwordField1.getPassword(), passwordField2.getPassword())){
            String password = new String(passwordField2.getPassword());
            
                AccountData accountData = new AccountData(0, username, firstName, lastName, password, role);
                boolean isAccountCreated = AuthSystem.registerAccount(accountData);
                parentFrame.showLogin();
                
        } else {
            // Handle password mismatch
            System.out.println("Passwords do not match.");
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBTN;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JComboBox<String> roleMenu;
    private javax.swing.JButton signupBTN;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel2;
    private javax.swing.JLabel usernameLabel3;
    // End of variables declaration//GEN-END:variables
}
