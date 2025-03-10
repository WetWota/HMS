/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.hms.models;

import org.mindrot.jbcrypt.BCrypt;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class accoundDataTest {
    
     private static final String FILE_PATH = Paths.get("csv", "accountData.csv").toString();
     
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while(running){
            System.out.print("===========Account Data Test================\n" +
                    "1. Write Data\n" +
                    "2. Read Data\n" +
                    "3. Exit\n" +
                    "Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    writeCSV(scanner);
                    break;
                case 2:
                    readCSV();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }
    }

    private static void writeCSV(Scanner scanner) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(FILE_PATH, true))) {
            String[] row = new String[5]; 
            int nextId = getNextId();   
            
            row[0] = String.valueOf(nextId);
            System.out.print("Enter First Name: ");
            row[1] = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            row[2] = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();
            row[3] = BCrypt.hashpw(password, BCrypt.gensalt());
            System.out.print("Enter Role: ");
            row[4] = scanner.nextLine();
            
            writer.writeNext(row);

            System.out.println("CSV file written successfully: " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getNextId() {
        int lastId = 0;
        
        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            List<String[]> allRows = reader.readAll();
            if (allRows.size() > 1) {
                String[] lastRow = allRows.get(allRows.size() - 1);
                lastId = Integer.parseInt(lastRow[0]);
            }
        } catch (Exception e) {
            System.out.println(" No previous data found. Starting at ID 1.");
        }
        
        return lastId + 1;
    }
    
    // 📖 Read CSV file
    private static void readCSV() {
        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            String[] nextLine;
            System.out.println("\nReading CSV File:");
                if ((nextLine = reader.readNext()) != null) {
               System.out.printf("%-12s %-12s %-12s %-12s %-12s%n", 
                   nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4]);
               System.out.println("----------------------------------------------------------");
           }

           while ((nextLine = reader.readNext()) != null) {
               System.out.printf("%-5s %-15s %-15s %-60s %-12s%n", 
                   nextLine[0], nextLine[1], nextLine[2], nextLine[3], nextLine[4]);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
     
}
