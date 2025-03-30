package project.hms.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import project.hms.models.BookingData;
import project.hms.utils.SessionManager;

public class BookingService {
    private static final String CSV_FILE = Paths.get("csv", "bookingData.csv").toString();
    private static final SessionManager sessionManager = new SessionManager();
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh a");

    
    public BookingData searchSched(int searchId){
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int bookingID = Integer.parseInt(nextLine[0]);
                int patientID = Integer.parseInt(nextLine[1]);
                int staffID = Integer.parseInt(nextLine[2]);
                LocalDate appointmentDate = LocalDate.parse(nextLine[3], dateFormatter);
                LocalTime appointmentTime = LocalTime.parse(nextLine[4], timeFormatter);
                String status = nextLine[5];
                String handler = nextLine[6];
                LocalDate creationDate = LocalDate.parse(nextLine[7], dateFormatter);
                LocalTime creationTime = LocalTime.parse(nextLine[8], timeFormatter);
                if(searchId == bookingID){
                    BookingData bookData = new BookingData(
                            bookingID,
                            patientID,
                            staffID,
                            appointmentDate,
                            appointmentTime,
                            status,
                            handler,
                            creationDate,
                            creationTime
                    );
                    return bookData;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        BookingData bookData = new BookingData(0,0,0,null,null,null,null,null,null);
        return bookData;
    }
    
    public boolean BookAppointment(BookingData bookingData){
        
        int lastBookingID = 0;

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > 0) {
                    try {
                        lastBookingID = Integer.parseInt(nextLine[0]);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Increment the last account ID
        int newBookingID = lastBookingID + 1;
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE, true))) {
            String[] book = {
                String.valueOf(newBookingID),
                String.valueOf(bookingData.getPatientID()),
                String.valueOf(bookingData.getStaffID()),
                bookingData.getAppointmentDate().format(dateFormatter),
                bookingData.getAppointmentTime().format(timeFormatter),
                bookingData.getStatus(),
                SessionManager.getUsername(),
                bookingData.getCreationDate().format(dateFormatter),
                bookingData.getCreationTime().format(timeFormatter)
            };
            System.out.println("Book");

            writer.writeNext(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void editSchedule(int bookingID, String status){
        List<String[]> updatedRows = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] header = reader.readNext();
            if (header != null) {
                updatedRows.add(header); // Keep header
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) == bookingID) {
                    nextLine[5] = status;
                }
                updatedRows.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
