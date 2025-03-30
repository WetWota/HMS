package project.hms.panels;

import java.awt.Color;
import java.awt.Dimension;
import project.hms.models.PatientData;
import project.hms.services.PatientRecordService;


public class PatientRecord extends javax.swing.JPanel {
    private PatientRecordService patientRecordService = new PatientRecordService();
    
    public PatientRecord() {
        initComponents();
        setPreferredSize(new Dimension(900, 650));
        setBackground(new Color(0, 0, 0, 0.2f));
        patientIdField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameField.requestFocus();
            }
        });
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexField.requestFocus();
            }
        });
        sexField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressField.requestFocus();
            }
        });
        addressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumField.requestFocus();
            }
        });
        contactNumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodGroupField.requestFocus();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        patientIdField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        sexField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        contactNumField = new javax.swing.JTextField();
        bloodGroupField = new javax.swing.JTextField();
        searchPatientBTN = new javax.swing.JToggleButton();
        addBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        searchPatientIdField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Patient ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sex");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact No");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Blood Group");

        patientIdField.setBackground(new java.awt.Color(102, 102, 102));
        patientIdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        patientIdField.setForeground(new java.awt.Color(255, 255, 255));
        patientIdField.setCaretColor(new java.awt.Color(255, 255, 255));

        nameField.setBackground(new java.awt.Color(102, 102, 102));
        nameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setCaretColor(new java.awt.Color(255, 255, 255));

        sexField.setBackground(new java.awt.Color(102, 102, 102));
        sexField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sexField.setForeground(new java.awt.Color(255, 255, 255));
        sexField.setCaretColor(new java.awt.Color(255, 255, 255));

        addressField.setBackground(new java.awt.Color(102, 102, 102));
        addressField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addressField.setForeground(new java.awt.Color(255, 255, 255));
        addressField.setCaretColor(new java.awt.Color(255, 255, 255));

        contactNumField.setBackground(new java.awt.Color(102, 102, 102));
        contactNumField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        contactNumField.setForeground(new java.awt.Color(255, 255, 255));
        contactNumField.setCaretColor(new java.awt.Color(255, 255, 255));

        bloodGroupField.setBackground(new java.awt.Color(102, 102, 102));
        bloodGroupField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bloodGroupField.setForeground(new java.awt.Color(255, 255, 255));
        bloodGroupField.setCaretColor(new java.awt.Color(255, 255, 255));

        searchPatientBTN.setBackground(new java.awt.Color(102, 102, 102));
        searchPatientBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchPatientBTN.setForeground(new java.awt.Color(255, 255, 255));
        searchPatientBTN.setText("Search");
        searchPatientBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.darkGray));
        searchPatientBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPatientBTNActionPerformed(evt);
            }
        });

        addBTN.setBackground(new java.awt.Color(102, 102, 102));
        addBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addBTN.setForeground(new java.awt.Color(255, 255, 255));
        addBTN.setText("Add");
        addBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.darkGray));
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        deleteBTN.setBackground(new java.awt.Color(102, 102, 102));
        deleteBTN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        deleteBTN.setForeground(new java.awt.Color(255, 255, 255));
        deleteBTN.setText("Delete");
        deleteBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.darkGray));
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        searchPatientIdField.setBackground(new java.awt.Color(102, 102, 102));
        searchPatientIdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchPatientIdField.setForeground(new java.awt.Color(255, 255, 255));
        searchPatientIdField.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contactNumField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bloodGroupField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(addBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchPatientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchPatientBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchPatientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchPatientBTN)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBTN))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bloodGroupField))
                .addGap(31, 31, 31)
                .addComponent(addBTN)
                .addGap(111, 111, 111))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchPatientBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPatientBTNActionPerformed
        handleSearch();
    }//GEN-LAST:event_searchPatientBTNActionPerformed

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        handleAdd();
        clearTextField();
    }//GEN-LAST:event_addBTNActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
        int patientId = Integer.parseInt(searchPatientIdField.getText().trim());
        PatientData patientData = patientRecordService.searchPatientRecord(patientId);
        if(patientData.getPatientID() == 0){
            clearTextField();
            patientIdField.setText("No existing record");
        } else {
            handleDelete();
            clearTextField();
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    
    
    private void handleSearch(){
        int patientId = Integer.parseInt(searchPatientIdField.getText().trim());
        PatientData patientData = patientRecordService.searchPatientRecord(patientId);
        if(patientData.getPatientID() == 0){
            clearTextField();
            patientIdField.setText("No existing record");
        } else {
            patientIdField.setText(String.valueOf(patientData.getPatientID()));
            nameField.setText(patientData.getName());
            sexField.setText(String.valueOf(patientData.getSex()));
            addressField.setText(patientData.getAddress());
            contactNumField.setText(patientData.getContactNum());
            bloodGroupField.setText(patientData.getBloodGroup());
            searchPatientIdField.setText("");
        }
    }
    
    private void handleAdd(){
        String name = nameField.getText();
        char sex = sexField.getText().charAt(0);
        String address = addressField.getText();
        String contactNum = contactNumField.getText();
        String bloodGroup = String.valueOf(bloodGroupField.getText().charAt(0));
        
        PatientData patientData = new PatientData(0, name, sex, address, contactNum, bloodGroup);
        boolean addPatientData = patientRecordService.writePatientRecord(patientData);
        if(addPatientData){
            searchPatientIdField.setText("Patient Recorded!");
        }
        
    }
    
    private void handleDelete(){
        int patientId = Integer.parseInt(searchPatientIdField.getText().trim());
        patientRecordService.deletePatientData(patientId);
        searchPatientIdField.setText("Patient Deleted!");
        
    }
    
    private void clearTextField(){
        patientIdField.setText("");
        nameField.setText("");
        sexField.setText("");
        addressField.setText("");
        contactNumField.setText("");
        bloodGroupField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBTN;
    private javax.swing.JTextField addressField;
    private javax.swing.JTextField bloodGroupField;
    private javax.swing.JTextField contactNumField;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField patientIdField;
    private javax.swing.JToggleButton searchPatientBTN;
    private javax.swing.JTextField searchPatientIdField;
    private javax.swing.JTextField sexField;
    // End of variables declaration//GEN-END:variables
}
