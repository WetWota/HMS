package project.hms.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import project.hms.models.BookingData;

public class BookingService {
    private static final String CSV_FILE = Paths.get("csv", "bookingData.csv").toString();
    
    public BookingData searchSched(int searchId){
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int bookingID = Integer.parseInt(nextLine[0]);
                int patientID = Integer.parseInt(nextLine[1]);
                int staffID = Integer.parseInt(nextLine[2]);
                LocalDate date = LocalDate.parse(nextLine[3]);
                LocalTime time = LocalTime.parse(nextLine[4]);
                String status = nextLine[5];
                String handler = nextLine[6];
                if(searchId == staffID){
                    BookingData bookData = new BookingData(
                            bookingID,
                            patientID,
                            staffID,
                            date,
                            time,
                            status,
                            handler
                    );
                    return bookData;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        BookingData bookData = new BookingData(0,0,0,null,null,null,null);
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
                String.valueOf(bookingData.getAppointmentDate()),
                String.valueOf(bookingData.getAppointmentTime()),
                bookingData.getStatus()
            };
            System.out.println("Book");

            writer.writeNext(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
