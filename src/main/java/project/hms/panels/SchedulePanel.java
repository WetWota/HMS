package project.hms.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;
import project.hms.services.PatientRecordService;
import project.hms.services.StaffRecordService;
import project.hms.services.BookingService;
import project.hms.models.PatientData;
import project.hms.models.StaffData;
import project.hms.models.BookingData;

public class SchedulePanel extends javax.swing.JPanel {
    
    private final PatientRecordService patientRecordService = new PatientRecordService();
    private final StaffRecordService staffRecordService = new StaffRecordService();
    private final BookingService bookingService = new BookingService();
    
    public SchedulePanel() {
        initComponents();
        setPreferredSize(new Dimension(900, 650));
        setBackground(new Color(0, 0, 0, 0.2f));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchBTN = new javax.swing.JButton();
        bookIdField = new javax.swing.JTextField();
        patientInfoField = new javax.swing.JTextField();
        creationField = new javax.swing.JTextField();
        staffInfoField = new javax.swing.JTextField();
        appointmentField = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patient:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Staff:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Created:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Appointed at:");

        searchBTN.setBackground(new java.awt.Color(102, 102, 102));
        searchBTN.setForeground(new java.awt.Color(255, 255, 255));
        searchBTN.setText("Search");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });

        bookIdField.setBackground(new java.awt.Color(102, 102, 102));
        bookIdField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookIdField.setForeground(new java.awt.Color(255, 255, 255));
        bookIdField.setToolTipText("Booking ID:");
        bookIdField.setCaretColor(new java.awt.Color(255, 255, 255));

        patientInfoField.setBackground(new java.awt.Color(102, 102, 102));
        patientInfoField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        patientInfoField.setForeground(new java.awt.Color(255, 255, 255));
        patientInfoField.setToolTipText("Booking ID:");
        patientInfoField.setCaretColor(new java.awt.Color(255, 255, 255));

        creationField.setBackground(new java.awt.Color(102, 102, 102));
        creationField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        creationField.setForeground(new java.awt.Color(255, 255, 255));
        creationField.setToolTipText("Booking ID:");
        creationField.setCaretColor(new java.awt.Color(255, 255, 255));

        staffInfoField.setBackground(new java.awt.Color(102, 102, 102));
        staffInfoField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        staffInfoField.setForeground(new java.awt.Color(255, 255, 255));
        staffInfoField.setToolTipText("Booking ID:");
        staffInfoField.setCaretColor(new java.awt.Color(255, 255, 255));

        appointmentField.setBackground(new java.awt.Color(102, 102, 102));
        appointmentField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        appointmentField.setForeground(new java.awt.Color(255, 255, 255));
        appointmentField.setToolTipText("Booking ID:");
        appointmentField.setCaretColor(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBTN)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(appointmentField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                        .addComponent(staffInfoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(patientInfoField, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(creationField, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(creationField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(staffInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(appointmentField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        searchSched(Integer.parseInt(bookIdField.getText()));
    }//GEN-LAST:event_searchBTNActionPerformed

    public void searchSched(int searchBookID){
        BookingData bookingData = bookingService.searchSched(searchBookID);
        int patientId = bookingData.getPatientID();
        int staffId = bookingData.getStaffID();
        
        PatientData patientData = patientRecordService.searchPatientRecord(patientId);
        StaffData staffData = staffRecordService.searchStaffRecord(staffId);
        String patientName = patientData.getName();
        String staffName = staffData.getName();
        String staffPosition = staffData.getPosition();
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM:dd:yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh a");

        String creationDate = bookingData.getCreationDate().format(dateFormatter);
        String creationTime = bookingData.getCreationTime().format(timeFormatter);
        String appointmentDate = bookingData.getAppointmentDate().format(dateFormatter);
        String appointmentTime = bookingData.getAppointmentTime().format(timeFormatter);
        String creationDateTime = creationDate + " | " + creationTime;
        String dateTime = appointmentDate + " | " + appointmentTime;
        
        creationField.setText(creationDateTime);
        patientInfoField.setText("ID: " + patientId + " | Name: " + patientName);
        staffInfoField.setText("ID: " + staffId + " | Name: " + staffName + " | Position: " + staffPosition );
        appointmentField.setText(dateTime);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField appointmentField;
    private javax.swing.JTextField bookIdField;
    private javax.swing.JTextField creationField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField patientInfoField;
    private javax.swing.JButton searchBTN;
    private javax.swing.JTextField staffInfoField;
    // End of variables declaration//GEN-END:variables
}
