package project.hms.services;

import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Paths;
import org.mindrot.jbcrypt.BCrypt;
import project.hms.models.AccountData;

public class AuthSystem {
    private static final String CSV_FILE = Paths.get("csv", "accountData.csv").toString();

    public static boolean authenticate(String username, String password) {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row
            while ((nextLine = reader.readNext()) != null) {
                int accountID = Integer.parseInt(nextLine[0]);
                String Username = nextLine[1];
                String firstName = nextLine[2];
                String lastName = nextLine[3];
                String storedPass = nextLine[4];
                String role = nextLine[5];
                if (Username.toLowerCase().equals(username.toLowerCase()) && password.equals(storedPass)){
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean registerAccount(AccountData accountData) {
        
        int lastAccountID = 0;

        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length > 0) {
                    try {
                        lastAccountID = Integer.parseInt(nextLine[0]);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int newAccountID = lastAccountID + 1;
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE, true))) {
            String[] newAccount = {
                String.valueOf(newAccountID),
                accountData.getUsername(),
                accountData.getFirstName(),
                accountData.getLastName(),
                accountData.getPassword(),
                accountData.getRole()
            };
            writer.writeNext(newAccount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public String getRole(String username){
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))){
            String[] nextLine;
            boolean found = false;
            while((nextLine = reader.readNext()) != null){
                if (username.equals(nextLine[1])) {
                    String role = nextLine[5];
                    return role;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

