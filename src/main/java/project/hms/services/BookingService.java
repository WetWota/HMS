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

    public BookingData searchSched(int searchId) {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int bookingID = Integer.parseInt(nextLine[0]);
                if(searchId == bookingID) {
                    return new BookingData(
                        bookingID,
                        Integer.parseInt(nextLine[1]),
                        Integer.parseInt(nextLine[2]),
                        LocalDate.parse(nextLine[3], dateFormatter),
                        LocalTime.parse(nextLine[4], timeFormatter),
                        nextLine[5],
                        nextLine[6],
                        LocalDate.parse(nextLine[7], dateFormatter),
                        LocalTime.parse(nextLine[8], timeFormatter)
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BookingData(0, 0, 0, null, null, null, null, null, null);
    }

    public boolean BookAppointment(BookingData bookingData) {
        List<String[]> allRows = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();

        // Read all existing rows and collect IDs
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > 0) {
                    try {
                        idList.add(Integer.parseInt(nextLine[0]));
                    } catch (NumberFormatException ignored) {}
                }
                allRows.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // Find the first available ID
        int newBookingID = 1;
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) != newBookingID) {
                break;
            }
            newBookingID++;
        }

        // Create the new record
        String[] newRecord = {
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

        boolean inserted = false;
        List<String[]> updatedRows = new ArrayList<>();
        
        if (!allRows.isEmpty()) {
            updatedRows.add(allRows.get(0));
        }
        
        for (int i = 1; i < allRows.size(); i++) {
            String[] row = allRows.get(i);
            int currentId = Integer.parseInt(row[0]);
            
            if (!inserted && currentId > newBookingID) {
                updatedRows.add(newRecord);
                inserted = true;
            }
            updatedRows.add(row);
        }
        if (!inserted) {
            updatedRows.add(newRecord);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean editSchedule(int bookingID, String status) {
        List<String[]> updatedRows = new ArrayList<>();
        boolean found = false;

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] header = reader.readNext();
            if (header != null) {
                updatedRows.add(header);
            }

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) == bookingID) {
                    nextLine[5] = status;
                    found = true;
                }
                updatedRows.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (!found) {
            return false;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBooking(int bookingID) {
        List<String[]> updatedRows = new ArrayList<>();
        boolean found = false;

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] header = reader.readNext();
            if (header != null) {
                updatedRows.add(header);
            }
            
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) != bookingID) {
                    updatedRows.add(nextLine);
                } else {
                    found = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (!found) {
            return false;
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}