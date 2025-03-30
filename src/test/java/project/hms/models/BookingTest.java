package project.hms.models;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BookingTest {
    private static final String CSV_FILE = Paths.get("csv", "bookingData.csv").toString();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh a");

    public static void main(String[] args) {
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

                System.out.printf("Booking ID: %d, Patient ID: %d, Staff ID: %d, Date: %s, Time: %s, Status: %s, Handler: %s, Created: %s %s%n",
                        bookingID, patientID, staffID, appointmentDate, appointmentTime, status, handler, creationDate, creationTime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
