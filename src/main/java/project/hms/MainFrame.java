package project.hms;

import project.hms.panels.LoginPanel;
import project.hms.panels.DashboardPanel;
import project.hms.panels.SignupPanel;

public class MainFrame extends javax.swing.JFrame {
    private LoginPanel loginPanel;
    private DashboardPanel dashboardPanel;
    private SignupPanel signupPanel;
    
    public MainFrame() {
    initComponents();
    dashboardPanel = new DashboardPanel(this);

    loginPanel = new LoginPanel(this);
    loginPanel.setBounds(0, 0, 1280, 720);
    add(loginPanel);
    
    dashboardPanel = new DashboardPanel(this);
    dashboardPanel.setBounds(0,0, 1280, 720);
    dashboardPanel.setBackground(java.awt.Color.pink); // for debugging purpose
    add(dashboardPanel);
    
    signupPanel = new SignupPanel(this);
    signupPanel.setBounds(0,0, 1280, 720);
    add(signupPanel);
    
    loginPanel.setVisible(true);
    dashboardPanel.setVisible(false);
    signupPanel.setVisible(false);
}
    public void showDashboard() {
        loginPanel.setVisible(false);
        signupPanel.setVisible(false);
        dashboardPanel.setVisible(true);
    }

    public void showLogin() {
        dashboardPanel.setVisible(false);
        signupPanel.setVisible(false);
        loginPanel.setVisible(true);
    }
    public void showSignup(){
        loginPanel.setVisible(false);
        dashboardPanel.setVisible(false);
        signupPanel.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setName("MainFrame"); // NOI18N
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
