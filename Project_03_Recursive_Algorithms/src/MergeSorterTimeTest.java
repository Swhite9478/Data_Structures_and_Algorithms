import java.util.ArrayList;
import java.util.Random;

import static java.lang.System.out;

/**
 * Created by Stephen White on 11/1/2016.
 *
 * Goal: utilize MergeSorter on lists of the following sizes and time them:
 *      -20,000
 *      -100,000
 *      -500,000
 *      -2,500,000
 *
 */
public class MergeSorterTimeTest {
    public static void main(String[] args) {
        //create random for use to use
        Random rand = new Random();

        // create a MergeSorter for us to use to sort items
        MergeSorter<Integer> sorter = new MergeSorter<Integer>();

        // create four separate arrayLists
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        ArrayList<Integer> arr3 = new ArrayList<Integer>();
        ArrayList<Integer> arr4 = new ArrayList<Integer>();

        // properly populate each list

        // List with 20,000 items
        for(int i=0; i<20000; i++){
            arr1.add(rand.nextInt((100) + 1)); // random numbers between 1 and 100
        }

        // List with 100,000 items
        for(int i=0; i<100000; i++){
            arr2.add(rand.nextInt((100) + 1)); // random numbers between 1 and 100
        }

        // List with 500,000 items
        for(int i=0; i<500000; i++){
            arr3.add(rand.nextInt((100) + 1)); // random numbers between 1 and 100
        }

        // List with 2,500,000 items
        for(int i=0; i<2500000; i++){
            arr4.add(rand.nextInt((100) + 1)); // random numbers between 1 and 100
        }

        //-----------------------------------------TIME EACH SORT----------------------------------------------------\\

        // SORT THE LIST OF 20,000
        long startTime = System.nanoTime();
        long startTimeMillis = System.currentTimeMillis();
        sorter.sort(arr1);
        long endTime = System.nanoTime();
        long endTimeMillis = System.currentTimeMillis();
        out.println("\nMergeSort on a list of 20,000 took " + (endTime-startTime) +
                " nanoseconds (" + (endTimeMillis-startTimeMillis) + " milliseconds)" );

        // SORT THE LIST OF 100,000
        startTime = System.nanoTime();
        startTimeMillis = System.currentTimeMillis();
        sorter.sort(arr2);
        endTime = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        out.println("\nMergeSort on a list of 100,000 took " + (endTime-startTime) +
                " nanoseconds (" + (endTimeMillis-startTimeMillis) + " milliseconds)" );

        // SORT THE LIST OF 500,000
        startTime = System.nanoTime();
        startTimeMillis = System.currentTimeMillis();
        sorter.sort(arr3);
        endTime = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        out.println("\nMergeSort on a list of 500,000 took " + (endTime-startTime) +
                " nanoseconds (" + (endTimeMillis-startTimeMillis) + " milliseconds)" );

        // SORT THE LIST OF 2,500,000
        startTime = System.nanoTime();
        startTimeMillis = System.currentTimeMillis();
        sorter.sort(arr4);
        endTime = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        out.println("\nMergeSort on a list of 2,500,000 " + (endTime-startTime) +
                " nanoseconds (" + (endTimeMillis-startTimeMillis) + " milliseconds)" );
    }
}
