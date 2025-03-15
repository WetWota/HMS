
package project.hms;

import java.io.File;


public class dirTest {
    public static void main(String[] args) {
        String[] testDirs = {
            "src",                          // Source folder
            "src/main",                     // Main source folder
            "src/main/java",                // Java source folder
            "src/main/resources",           // Resources folder
            "src/main/resources/images",    // Images inside resources
            "target",                       // Compiled output folder
            "target/classes",               // Compiled classes folder
            "bin",                          // Eclipse output folder
            "out"                           // Some IDEs use "out"
        };

        // Check each directory
        System.out.println("Checking directories...");
        for (String dir : testDirs) {
            File file = new File(dir);
            if (file.exists() && file.isDirectory()) {
                System.out.println("[✔] Exists: " + file.getAbsolutePath());
            } else {
                System.out.println("[✘] Not found: " + dir);
            }
        }
    }
}