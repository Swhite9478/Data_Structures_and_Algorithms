import java.io.*;
import java.util.*;
import static java.lang.System.out;

/*
 * Created by Stephen White on 11/15/2016.
 *
 * Goal: profile the binary search tree I have created and time how long
 * it takes to find the numbers 1-10,000 in random order as well as ascending order
 * in nanoseconds, and prints the results to 2 separate text files
 */
public class BST_Profiler {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<Integer>(); // a set that contains the #'s 1-10,000
        BinarySearchTree linearTree = new BinarySearchTree(); // ascending order from 1-10,000
        BinarySearchTree randomTree = new BinarySearchTree(); // random order from 1-10,000
        long startTimeNano; // will be used to time execution
        long endTimeNano; // will be used to time execution
        Random rand = new Random(); // will be used to randomly insert numbers

        // add the 10,000 numbers in ascending order to tree 1
        for(int i=1; i<=10000; i++){
            linearTree.put(i, ("element_" + i));
        }

        // add the 10,000 numbers in random order (no repeats) to tree 2
        while (randomTree.size() != 10000){
            int numToBeInserted = rand.nextInt(10000) + 1; // this is a random # between 1 - 10,000
            if (!set.contains(numToBeInserted)) {// we don't want repeats
                set.add(numToBeInserted); // if it is not in our set, add it to our set
                randomTree.put(numToBeInserted, ("element_" + numToBeInserted)); // add it to tree 2
            }
        }


        PrintStream fileStream = null;
        try {
            //create a temporary file
            fileStream = new PrintStream(new File("Linear_Binary_Search_Tree_Time.txt"));

            //File logFile = new File("Time Results for tree2.txt");
            //writer = new PrintWriter(new FileWriter(logFile));
            for(int i=1; i<=linearTree.size(); i++) {
                startTimeNano = System.nanoTime();
                linearTree.get(i);
                endTimeNano = System.nanoTime();
                fileStream.println("find key " + i + ": " +
                                    (endTimeNano - startTimeNano) + " nanoseconds\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                fileStream.close();
            } catch (Exception e) {
            }
        }
        try {
            //create a temporary file
            fileStream = new PrintStream(new File("Random_Binary_Search_Tree_Time.txt"));

            //File logFile = new File("Time Results for tree2.txt");
            //writer = new PrintWriter(new FileWriter(logFile));
            for(int i=1; i<=randomTree.size(); i++) {
                startTimeNano = System.nanoTime();
                randomTree.get(i);
                endTimeNano = System.nanoTime();
                fileStream.println("find key " + i + ": " +
                        (endTimeNano - startTimeNano) + " nanoseconds\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                fileStream.close();
            } catch (Exception e) {
            }
        }

        out.println("\nTwo files have been generated to track time in nanoseconds." +
                " Check them to see final results.");
    }
}
