package project.hms.services;

import com.opencsv.CSVReader;
import java.io.FileReader;
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
    
}
