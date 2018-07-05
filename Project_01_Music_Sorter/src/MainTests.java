import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

/**
 * Created by Stephen White on 9/28/2016.
 */
public class MainTests {
    public static void main(String[] args){
        // Create three sorters to test their efficiencies.
        InsertionSorter inSorter = new InsertionSorter();
        SelectionSorter selSorter = new SelectionSorter();
        BubbleSorter bubSorter = new BubbleSorter();

        // Create 12 different arrays (3 length 20, 3 100, 3 500, 3 2500
        ArrayList<Integer> intSortList1 = new ArrayList<>();
        ArrayList<Integer> intSortList2 = new ArrayList<>();
        ArrayList<Integer> intSortList3 = new ArrayList<>();
        ArrayList<Integer> intSortList4 = new ArrayList<>();

        ArrayList<Integer> bubSortList1 = new ArrayList<>();
        ArrayList<Integer> bubSortList2 = new ArrayList<>();
        ArrayList<Integer> bubSortList3 = new ArrayList<>();
        ArrayList<Integer> bubSortList4 = new ArrayList<>();

        ArrayList<Integer> selectSortList1 = new ArrayList<>();
        ArrayList<Integer> selectSortList2 = new ArrayList<>();
        ArrayList<Integer> selectSortList3 = new ArrayList<>();
        ArrayList<Integer> selectSortList4 = new ArrayList<>();

        // Create random object to create random numbers for insertion
        Random rnd = new Random();


        // Insert random numbers in each ArrayList BELOW

        //--------------------------------------------------------------------------------------------------

        //INSERTION SORT ARRAY FILL
        //For intSortList1 of length 20:
        for(int i=0; i<20; i++){intSortList1.add(rnd.nextInt(20) + 1);} // numbers range from 1-20

        //For intSortList2 of length 100:
        for(int i=0; i<100; i++){intSortList2.add(rnd.nextInt(100) + 1);} // numbers range from 1-100

        //For intSortList3 of length 500:
        for(int i=0; i<500; i++){intSortList3.add(rnd.nextInt(500) + 1);}; // numbers range from 1-500

        //For intSortList4 of length 2500:
        for(int i=0; i<2500; i++){intSortList4.add(rnd.nextInt(2500) + 1);} // numbers range from 1-2500
        //For list1 of length 20:
        //--------------------------------------------------------------------------------------------------

        //BUBBLE SORT ARRAY FILL
        // For bubSortList1 of length 20
        for(int i=0; i<20; i++){bubSortList1.add(rnd.nextInt(20) + 1);} // numbers range from 1-20

        //For bubSortList2 of length 100:
        for(int i=0; i<100; i++){bubSortList2.add(rnd.nextInt(100) + 1);} // numbers range from 1-100

        //For bubSortList3 of length 500:
        for(int i=0; i<500; i++){bubSortList3.add(rnd.nextInt(500) + 1);}; // numbers range from 1-500

        //For bubSortList4 of length 2500:
        for(int i=0; i<2500; i++){bubSortList4.add(rnd.nextInt(2500) + 1);} // numbers range from 1-2500
        //--------------------------------------------------------------------------------------------------

        // SELECTION SORT ARRAY FILL
        // For selectSortList1 lf length 20
        for(int i=0; i<20; i++){selectSortList1.add(rnd.nextInt(20) + 1);} // numbers range from 1-20

        //For selectSortList2 of length 100:
        for(int i=0; i<100; i++){selectSortList2.add(rnd.nextInt(100) + 1);} // numbers range from 1-100

        //For selectSortList3 of length 500:
        for(int i=0; i<500; i++){selectSortList3.add(rnd.nextInt(500) + 1);}; // numbers range from 1-500

        //For selectSortList14 of length 2500:
        for(int i=0; i<2500; i++){selectSortList4.add(rnd.nextInt(2500) + 1);} // numbers range from 1-2500
        //--------------------------------------------------------------------------------------------------

        // TIME EACH SORT PROCESS BELOW

        //--------------------------------------------------------------------------------------------------

        // TIME INSERTION SORT FOR 20 ITEMS (IN MILLISECONDS)
        long startTime = System.currentTimeMillis();
        inSorter.sort(intSortList1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nINSERTION SORT on list 1(20) took " + (endTime-startTime) + " milliseconds");

        // TIME INSERTION SORT FOR 100 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        inSorter.sort(intSortList2);
        endTime = System.currentTimeMillis();
        System.out.println("INSERTION SORT on list 2(100) took " + (endTime-startTime) + " milliseconds");

        // TIME INSERTION SORT FOR 500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        inSorter.sort(intSortList3);
        endTime = System.currentTimeMillis();
        System.out.println("INSERTION SORT on list 3(500) took " + (endTime-startTime) + " milliseconds");

        // TIME INSERTION SORT FOR 2500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        inSorter.sort(intSortList4);
        endTime = System.currentTimeMillis();
        System.out.println("INSERTION SORT on list 4(2500) took " + (endTime-startTime) + " milliseconds");
        //--------------------------------------------------------------------------------------------------

        // TIME BUBBLE SORT FOR 20 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        bubSorter.sort(bubSortList1);
        endTime = System.currentTimeMillis();
        System.out.println("\nBUBBLE SORT on list 1(20) took " + (endTime-startTime) + " milliseconds");

        // TIME BUBBLE SORT FOR 100 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        bubSorter.sort(bubSortList2);
        endTime = System.currentTimeMillis();
        System.out.println("BUBBLE SORT on list 2(100) took " + (endTime-startTime) + " milliseconds");

        // TIME BUBBLE SORT FOR 500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        bubSorter.sort(bubSortList3);
        endTime = System.currentTimeMillis();
        System.out.println("BUBBLE SORT on list 3(500) took " + (endTime-startTime) + " milliseconds");

        // TIME BUBBLE SORT FOR 2500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        bubSorter.sort(bubSortList4);
        endTime = System.currentTimeMillis();
        System.out.println("BUBBLE SORT on list 4(2500) took " + (endTime-startTime) + " milliseconds");
        //--------------------------------------------------------------------------------------------------

        // TIME SELECTION SORT FOR 20 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        selSorter.sort(selectSortList1);
        endTime = System.currentTimeMillis();
        System.out.println("\nSELECTION SORT on list 1(20) took " + (endTime-startTime) + " milliseconds");

        // TIME SELECTION SORT FOR 100 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        selSorter.sort(selectSortList2);
        endTime = System.currentTimeMillis();
        System.out.println("SELECTION SORT on list 2(100) took " + (endTime-startTime) + " milliseconds");

        // TIME SELECTION SORT FOR 500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        selSorter.sort(selectSortList3);
        endTime = System.currentTimeMillis();
        System.out.println("SELECTION SORT on list 3(500) took " + (endTime-startTime) + " milliseconds");

        // TIME SELECTION SORT FOR 2500 ITEMS (IN MILLISECONDS)
        startTime = System.currentTimeMillis();
        selSorter.sort(selectSortList4);
        endTime = System.currentTimeMillis();
        System.out.println("SELECTION SORT on list 4(2500) took " + (endTime-startTime) + " milliseconds");
        /*for(int i =0; i < bubSortList4.size(); i++){
            System.out.print(" " + bubSortList4.get(i));
        }*/
        //--------------------------------------------------------------------------------------------------

    }
}
