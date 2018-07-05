import static java.lang.System.out;

/**
 * Created by Stephen White on 11/29/2016.
 *
 * Goal: Create a profiler to test my HashSet class
 *
 */

public class HashSetProfiler {
    public static void main(String[] args){

        // create a profiler to utilize its methods
        HashSetProfiler profiler = new HashSetProfiler();

        // create 3 hash sets
        HashSet<Integer> set1 = new HashSet<Integer>(300110);
        HashSet<Integer> set2 = new HashSet<Integer>(300110);
        HashSet<Integer> set3 = new HashSet<Integer>(300110);

        // create variables to utilize nanoTime
        long startNano;
        long endNano;

        // add 100,000 items to set1
        for(int i=1; i<=100000; i++){
            set1.add(i);
        }

        // add 200,000 items to set2
        for(int i=1; i<=200000; i++){
            set2.add(i);
        }

        // add 300,000 items to set3
        for(int i=1; i<=300000; i++){
            set3.add(i);
        }

        // time how long it takes to find 10x the number of items in each set

        // time set 1
        out.println("Time Taken to find a total of 100,000 items 10x in a Hash Set:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=100000; j++){
                set1.has(j);
            }
            endNano = System.nanoTime();
            profiler.printTime(startNano, endNano);
        }

        out.println();

        // time set 2
        out.println("Time Taken to find a total of 200,000 items 10x in a Hash Set:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=200000; j++){
                set2.has(j);
            }
            endNano = System.nanoTime();
            profiler.printTime(startNano, endNano);
        }

        out.println();

        // time set 3
        out.println("Time Taken to find a total of 300,000 items 10x in a Hash Set:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=300000; j++){
                set3.has(j);
            }
            endNano = System.nanoTime();
            profiler.printTime(startNano, endNano);
        }


    }

    // calculate the time taken
    public long timeTaken(long start, long end){
        return end-start;
    }
    // stringify the time taken and print out a line that describes it
    public void printTime(long start, long end){
        out.println("\tIt took " + timeTaken(start, end) + " nanoseconds");
    }
}
