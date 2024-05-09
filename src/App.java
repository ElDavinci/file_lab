import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
public class App {
    public static void main(String[] args) throws Exception {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        if (!(file1.exists() && file2.exists())) {
            System.out.println("One of the files does not exist.");
            System.exit(0);
        }
        File outputFile = new File("file1-file2.txt");

        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);

        PrintWriter output = new PrintWriter(outputFile);
        int[] letters = new int[26];

        while(input1.hasNext() && input2.hasNext()) {
            String firstName = input1.next();
            String lastName = input2.next();
            String lowerLine = (firstName+lastName).toLowerCase();
            letterCounter(letters, lowerLine);
            output.println(firstName + " " + lastName);
        }

        printLetters(letters);

        input1.close();
        input2.close();
        output.close();
        output.flush();

    }
    public static void letterCounter(int[] letters, String s) {

        for (int i = 0; i < s.length(); i++) {

            letters[s.charAt(i) - 'a']++;
        }
    }
    public static void printLetters(int[] letters) {
        for(int i = 0; i < letters.length; i++) {
            System.out.println(letters[i] + ": " + (char)(i + 'a'));
        }
    }
}
