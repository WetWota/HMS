package project.hms.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;

import project.hms.models.StaffData;

public class StaffRecordService {
    private static final String CSV_FILE = Paths.get("csv", "staffData.csv").toString();
    
    public StaffData searchStaffRecord(int searchId){
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
                
                if(searchId == staffID){
                    StaffData staffData = new StaffData(
                            staffID,
                            name,
                            sex,
                            position,
                            contactNum,
                            email
                    );
                    return staffData;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        StaffData staffData = new StaffData(0,null,'\0',null,null,null);
        return staffData;
    }
    public static boolean addStaffRecord(StaffData staffData) {
        
        int lastStaffID = 0;

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > 0) {
                    try {
                        lastStaffID = Integer.parseInt(nextLine[0]);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int newStaffID = lastStaffID + 1;
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE, true))) {
            String[] newStaffData = {
                String.valueOf(newStaffID),
                staffData.getName(),
                String.valueOf(staffData.getSex()),
                staffData.getPosition(),
                staffData.getContactNum(),
                staffData.getEmail()
            };
            writer.writeNext(newStaffData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
