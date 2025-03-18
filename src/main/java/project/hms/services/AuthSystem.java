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
                String firstName = nextLine[1];
                String lastName = nextLine[2];
                String hashedPass = nextLine[3];
                String role = nextLine[4];
                String Username = firstName + " " + lastName;
                
                if (Username.toLowerCase().equals(username.toLowerCase()) && BCrypt.checkpw(password, hashedPass)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean registerAccount(AccountData accountData) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE, true))) {
            String hashedPassword = BCrypt.hashpw(accountData.getPassword(), BCrypt.gensalt());

            String[] newAccount = {
                String.valueOf(accountData.getAccountID()),
                accountData.getFirstName(),
                accountData.getLastName(),
                hashedPassword,
                accountData.getRole()
            };

            writer.writeNext(newAccount);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

