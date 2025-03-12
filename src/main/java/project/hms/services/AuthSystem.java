package project.hms.services;

import java.io.FileReader;
import com.opencsv.CSVReader;
import java.nio.file.Paths;
import org.mindrot.jbcrypt.BCrypt;

public class AuthSystem {
    private static final String CSV_FILE = Paths.get("csv", "accountData.csv").toString();

    public static boolean authenticate(String username, String password) {
        try (CSVReader reader = new CSVReader(new FileReader(CSV_FILE))) {
            String[] nextLine;
            reader.readNext(); // Skip header row

            while ((nextLine = reader.readNext()) != null) {
                String accountID = nextLine[0];
                String firstName = nextLine[1];
                String lastName = nextLine[2];
                String hashedPass = nextLine[3];
                String role = nextLine[4];
                String Username = firstName + " " + lastName;
                
                if (Username.equals(username) && BCrypt.checkpw(password, hashedPass)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

