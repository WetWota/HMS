package project.hms.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import project.hms.models.StaffData;

public class StaffRecordService {
    private static final String CSV_FILE = Paths.get("csv", "staffData.csv").toString();
    
    public StaffData searchStaffRecord(int searchId) {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int staffID = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                char sex = nextLine[2].charAt(0);
                String position = nextLine[3];
                String contactNum = nextLine[4];
                String email = nextLine[5];
                
                if(searchId == staffID) {
                    return new StaffData(
                        staffID,
                        name,
                        sex,
                        position,
                        contactNum,
                        email
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new StaffData(0, null, '\0', null, null, null);
    }

    public boolean addStaffRecord(StaffData staffData) {
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
        int newStaffID = 1;
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) != newStaffID) {
                break;
            }
            newStaffID++;
        }

        // Create the new record
        String[] newRecord = {
            String.valueOf(newStaffID),
            staffData.getName(),
            String.valueOf(staffData.getSex()),
            staffData.getPosition(),
            staffData.getContactNum(),
            staffData.getEmail()
        };

        // Insert the new record in the correct position
        boolean inserted = false;
        List<String[]> updatedRows = new ArrayList<>();
        
        // Keep the header
        if (!allRows.isEmpty()) {
            updatedRows.add(allRows.get(0));
        }
        
        // Insert records in order
        for (int i = 1; i < allRows.size(); i++) {
            String[] row = allRows.get(i);
            int currentId = Integer.parseInt(row[0]);
            
            // Insert before the first ID that's larger than our new ID
            if (!inserted && currentId > newStaffID) {
                updatedRows.add(newRecord);
                inserted = true;
            }
            updatedRows.add(row);
        }
        
        // If we haven't inserted yet (new ID is largest), add at end
        if (!inserted) {
            updatedRows.add(newRecord);
        }

        // Write all rows back to file
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaffRecord(int staffID) {
        List<String[]> updatedRows = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] header = reader.readNext();
            if (header != null) {
                updatedRows.add(header);
            }
            
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) != staffID) {
                    updatedRows.add(nextLine);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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