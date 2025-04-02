package project.hms.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import project.hms.models.PatientData;


public class PatientRecordService {
    
    private static final String CSV_FILE = Paths.get("csv", "patientData.csv").toString();
    
    public PatientData searchPatientRecord(int searchId){
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext();

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
        PatientData patientData = new PatientData(0,null,'\0',null,null,null);
        return patientData;
    }
    
    public boolean writePatientRecord(PatientData patientData) {
        List<String[]> updatedRows = new ArrayList<>();
        List<Integer> idList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > 0) {
                    try {
                        idList.add(Integer.parseInt(nextLine[0]));
                    } catch (NumberFormatException ignored) {}
                }
                updatedRows.add(nextLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        int newPatientID = 1;
        for (int i = 0; i < idList.size(); i++) {
            if (idList.get(i) != newPatientID) {
                break;
            }
            newPatientID++;
        }

        String[] record = {
            String.valueOf(newPatientID),
            patientData.getName(),
            String.valueOf(patientData.getSex()),
            patientData.getAddress(),
            patientData.getContactNum(),
            patientData.getBloodGroup()
        };
        updatedRows.add(record);

        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE))) {
            writer.writeAll(updatedRows);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deletePatientData(int patientID) {
        List<String[]> updatedRows = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] header = reader.readNext();
            if (header != null) {
                updatedRows.add(header);
            }
            
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (Integer.parseInt(nextLine[0]) != patientID) {
                    updatedRows.add(nextLine);
                }
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
