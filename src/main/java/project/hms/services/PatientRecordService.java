
package project.hms.services;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.nio.file.Paths;

import project.hms.models.PatientData;


public class PatientRecordService {
    
    private static final String CSV_FILE = Paths.get("csv", "patientData.csv").toString();
    
    public PatientData searchPatientRecord(int searchId){
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                int patientID = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                char sex = nextLine[2].charAt(0);
                String address = nextLine[3];
                String contactNum = nextLine[4];
                String bloodGroup = nextLine[5];
                
                if(searchId == patientID){
                    PatientData patientData = new PatientData(
                            patientID,
                            name,
                            sex,
                            address,
                            contactNum,
                            bloodGroup
                    );
                    return patientData;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
