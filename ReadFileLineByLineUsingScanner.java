import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileLineByLineUsingScanner {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("sample.txt"));
            String file = null;

            while (scanner.hasNextLine()) {
                file = file + scanner.nextLine();
            }

            int count = 0;

            for (int i = 0; i < file.length(); i++) {
                if (file.charAt(i) == ' ' || file.charAt(i) == '\n' || file.charAt(i) == '\t'
                        || file.charAt(i) == '\r') {
                } else {

                    // Count the number of characters in the file
                    count++;
                }
            }

            System.out.println("Number of characters in the file: " + count);

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}