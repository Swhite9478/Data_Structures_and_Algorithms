import java.io.*;

import static java.lang.System.out;

/**
 * Created by Stephen White on 11/29/2016.
 *
 * Goal: Determine if certain words are actual words
 *
 */
@SuppressWarnings("unchecked")
public class HashSetScrabbleTest {
    public static void main(String args[]) throws FileNotFoundException {
        // create a hash set slightly larger than what we need so we may index properly
        HashSet<String> set = new HashSet<>(178710);

        // read in the text file that contains the words
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("src\\wordlist.txt"));
            String line; // obtain a line
            while ((line = reader.readLine()) != null) // keep reading lines until there are no more
            {
                set.add(line); // add that line (word) to our set
            }
            reader.close(); // don't forget to close the reader
        }
        catch (Exception e) // catch any exceptions that may occur
        {
            System.err.format("Exception occurred trying to read '%s'.", "wordlist.txt");
            e.printStackTrace();
        }

        // SEE IF IT WORKS!!!!!
        /* determine if we can find the following words: Queue, Navient, Aa, Possum
                     Phoney, Bb, Werd, Titi
       */
        out.println();
        out.println("ATTEMPTING TO FIND THE FOLLOWING WORDS:");
        out.println("\tQueue: " + set.has("Queue".toUpperCase()));
        out.println("\tNavient: " + set.has("Navient".toUpperCase()));
        out.println("\tAa: " + set.has("Aa".toUpperCase()));
        out.println("\tPossum: " + set.has("Possum".toUpperCase()));
        out.println("\tPhoney: " + set.has("Phoney".toUpperCase()));
        out.println("\tBb: " + set.has("Bb".toUpperCase()));
        out.println("\tWerd: " + set.has("Werd".toUpperCase()));
        out.println("\tTiti: " + set.has("Titi".toUpperCase()));
        out.println("\tZZZ: " + set.has("zzz".toUpperCase()));
    }
}
