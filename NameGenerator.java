import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
    // Lists to hold the prefixes and suffies imported from txt file.
    private ArrayList<String> prefixes = new ArrayList<String>();
    private ArrayList<String> suffixes = new ArrayList<String>();
    // Random object.
    Random rand = new Random();

    public static void main(String args[]) {
        NameGenerator nameGen = new NameGenerator();

        // Initialize the ArrayLists with txt file information.
        nameGen.getPrefixes();
        nameGen.getSuffixes();

        // Set int variables to the int size of the list.
        int prefixListLength = nameGen.prefixes.size();
        int suffixListLenth = nameGen.suffixes.size();

        // Set int variables to a random number relating to given list index.
        int randPrefixIndex = nameGen.rand.nextInt(prefixListLength);
        int randSuffixIndex = nameGen.rand.nextInt(suffixListLenth);

        // Print the randomly generated name.
        System.out.println(nameGen.prefixes.get(randPrefixIndex) + nameGen.suffixes.get(randSuffixIndex));
    }

    public void getPrefixes() {
        try {
            File myObj = new File("Prefixes.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String prefix = myReader.nextLine();
                prefixes.add(prefix);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public void getSuffixes() {
        try {
            File myObj = new File("Suffixes.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String suffix = myReader.nextLine();
                suffixes.add(suffix);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}