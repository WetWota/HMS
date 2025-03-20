package project.hms.services;

import com.opencsv.CSVReader;
import java.io.FileReader;
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
                
                if(searchId == staffID){
                    BookingData bookData = new BookingData(
                            bookingID,
                            patientID,
                            staffID,
                            date,
                            time,
                            status
                    );
                    return bookData;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        BookingData bookData = new BookingData(0,0,0,null,null,null);
        return bookData;
    }
}
