// Step 2 - Import file input statements
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // TEST FOR STEP 1 (CSV constructor)
        Plant test = new Plant("Stinging Nettle,65,anti-inflammatory and culinary");
        System.out.println("test plant:\n" + test + "\n\n");

        // Step 2 - Declare + initialize variables for file input
        Scanner fileScanner = null;
        ArrayList<Plant> plants = new ArrayList<>();

        try {
            // Step 2 - Connect input stream to file
            FileInputStream fis = new FileInputStream("Forage.csv");
            fileScanner = new Scanner(fis);

            // Step 2 - create loop to read through whole file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                // TIP: print line first to confirm reading works
                System.out.println("Read line: " + line);

                // Step 3 - build Plant Objects and store into ArrayList
                try {
                    Plant p = new Plant(line);
                    plants.add(p);
                } catch (IllegalArgumentException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

            // Step 2 - close the input stream
            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Forage.csv file not found.");
            return;
        }

        // Step 3 - print contents of ArrayList
        System.out.println("\nLab Summary");
        for (Plant p : plants) {
            System.out.println(p + "\n");
        }
    }
}
