package project.hms.panels;

import project.hms.MainFrame;

public class DashboardPanel extends javax.swing.JPanel {

    public DashboardPanel(MainFrame frame) {
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

        mainMenuPanel1 = new project.hms.panels.MainMenuPanel();
        mainMenuList1 = new project.hms.panels.MainMenuList();
        patientRecord1 = new project.hms.panels.PatientRecord();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout mainMenuPanel1Layout = new javax.swing.GroupLayout(mainMenuPanel1);
        mainMenuPanel1.setLayout(mainMenuPanel1Layout);
        mainMenuPanel1Layout.setHorizontalGroup(
            mainMenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(mainMenuList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        mainMenuPanel1Layout.setVerticalGroup(
            mainMenuPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(mainMenuList1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(400, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainMenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(patientRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainMenuPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private project.hms.panels.MainMenuList mainMenuList1;
    private project.hms.panels.MainMenuPanel mainMenuPanel1;
    private project.hms.panels.PatientRecord patientRecord1;
    // End of variables declaration//GEN-END:variables
}
