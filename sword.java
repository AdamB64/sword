import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sword {

    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(System.in);
            Scanner scanner = new Scanner(new File(args[0]));
            System.out.println("do you which for this to be case sensitive? (y): ");
            String caseSensitive = reader.nextLine();
            reader.close();
            String file = "";

            while (scanner.hasNextLine()) {
                file = file + scanner.nextLine();
            }

            // System.out.println(file.length() + "\n");
            // System.out.println(file.charAt(0) + "\n");

            if (!caseSensitive.equals("y")) {
                file = file.toLowerCase();
            }

            int count = 0;

            for (int i = 0; i < file.length(); i++) {
                // System.out.println(file.charAt(i));
                if (file.charAt(i) == ' ' || file.charAt(i) == '\n' || file.charAt(i) == '\t'
                        || file.charAt(i) == '\r') {
                } else {
                    // Count the number of characters in the file
                    count++;
                }
            }

            System.out.println("Number of characters in the file: " + count);
            countCharacters(file);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void countCharacters(String file) {
        // initialize a map to store the count of each character
        Map<Character, Integer> charCountMap = new HashMap<>();

        // initialize a string to store the top 10 characters
        String topCharacters = "\n";

        // iterate through the file and count the characters
        for (char c : file.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Create a list from the entries of the map
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(charCountMap.entrySet());

        // Sort the list by values (frequencies) in descending order
        entryList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print the top 10 characters and their counts
        for (int i = 0; i < Math.min(10, entryList.size()); i++) {
            Map.Entry<Character, Integer> entry = entryList.get(i);
            if (entry.getKey() == ' ' || entry.getKey() == '\n' || entry.getKey() == '\t'
                    || entry.getKey() == '\r') {
                continue; // Skip spaces
            } else {
                topCharacters = topCharacters + entry.getKey() + " : " + entry.getValue() + "\n";
            }
        }

        System.out.println("Character count: " + topCharacters);
    }

}
