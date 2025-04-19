package project.hms.models;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;
import project.hms.models.BookingData;
import project.hms.services.PatientRecordService;
import project.hms.services.StaffRecordService;

public class BookingTableModel extends AbstractTableModel {
    private final List<BookingData> bookings;
    private final StaffRecordService staffService = new StaffRecordService();
    private final PatientRecordService patientService = new PatientRecordService();
    private final String[] columns = {
        "B. ID", "Patient", "Staff", "A. Date", "A. Time",
        "Status", "Handler", "C. Date", "C. Time"
    };

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

    public BookingTableModel(List<BookingData> bookings) {
        this.bookings = bookings;
    }

    @Override
    public int getRowCount() {
        return bookings.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        BookingData booking = bookings.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> booking.getBookingID();
            case 1 -> {
                    PatientData patient = patientService.searchPatientRecord(booking.getPatientID());
                    yield patient != null && patient.getName() != null ? 
                          patient.getName() : "Deleted Patient";
                }
                case 2 -> {
                    StaffData staff = staffService.searchStaffRecord(booking.getStaffID());
                    yield staff != null && staff.getName() != null ? 
                          staff.getName() : "Deleted Staff";
                }
            case 3 -> booking.getAppointmentDate().format(dateFormatter);
            case 4 -> booking.getAppointmentTime().format(timeFormatter);
            case 5 -> booking.getStatus();
            case 6 -> booking.getHandler();
            case 7 -> booking.getCreationDate().format(dateFormatter);
            case 8 -> booking.getCreationTime().format(timeFormatter);
            default -> null;
        };
    }
}
