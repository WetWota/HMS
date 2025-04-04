package project.hms.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingData {
    private int bookingID;
    private int patientID;
    private int staffID;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private String handler;
    private LocalDate creationDate;
    private LocalTime creationTime;
    
    public BookingData(int bookingID, int patientID, int staffID, LocalDate appointmentDate, LocalTime appointmentTime,
            String status, String handler, LocalDate creationDate, LocalTime creationTime){
        this.bookingID = bookingID;
        this.patientID = patientID;
        this.staffID = staffID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
        this.handler = handler;
        this.creationDate = creationDate;
        this.creationTime = creationTime;
    }
    
    public int getBookingID(){ return bookingID; }
    public int getPatientID() { return patientID; }
    public int getStaffID() { return staffID; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public LocalTime getAppointmentTime() { return appointmentTime; }
    public String getStatus() { return status; }
    public String getHandler() { return handler; }
    public LocalDate getCreationDate() { return creationDate; }
    public LocalTime getCreationTime() { return creationTime; }
    
    public void setBookingID() { this.bookingID = bookingID; }
    public void setPatientID() { this.patientID = patientID; }
    public void setStaffID() { this.staffID = staffID; }
    public void setAppointmentDate() { this.appointmentDate = appointmentDate; }
    public void setAppointmentTime() { this.appointmentTime = appointmentTime; }
    public void setStatus() { this.status = status; }
    public void setHandler() { this.handler = handler; }
    public void setCreationDate() { this.creationDate = creationDate; }
    public void setCreationTime() { this.creationTime = creationTime; }
}
