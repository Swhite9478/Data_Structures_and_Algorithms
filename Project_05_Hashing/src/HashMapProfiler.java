import static java.lang.System.out;

/**
 * Created by Stephen White on 11/30/2016.
 *
 * Goal: To profile the HashMap class that I have made
 *
 */
public class HashMapProfiler <E> {
    public static void main(String[] args){

        // create a profiler to utilize its methods
        HashMapProfiler profiler = new HashMapProfiler();

        // create 3 hash maps
        HashMap<String, Integer> map1 = new HashMap<>(300110);
        HashMap<String, Integer> map2 = new HashMap<>(300110);
        HashMap<String, Integer> map3 = new HashMap<>(300110);

        // create variables to utilize nanoTime
        long startNano;
        long endNano;

        // add 100,000 items to map1
        for(int i=1; i<=100000; i++){
            map1.put("element" + String.valueOf(i), i);
        }

        // add 200,000 items to set2
        for(int i=1; i<=200000; i++){
            map2.put("element" + String.valueOf(i), i);
        }

        // add 300,000 items to set3
        for(int i=1; i<=300000; i++){
            map3.put("element" + String.valueOf(i), i);
        }

        // time how long it takes to find 10x the number of items in each set

        // time set 1
        out.println("Time Taken to find a total of 100,000 items 10x in a Hash Map:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=100000; j++){
                map1.get("element" + String.valueOf(j));
            }
            endNano = System.nanoTime();
            profiler.printTime(startNano, endNano);
        }

        out.println();

        // time set 2
        out.println("Time Taken to find a total of 200,000 items 10x in a Hash Map:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=200000; j++){
                map2.get("element" + String.valueOf(j));
            }
            endNano = System.nanoTime();
            profiler.printTime(startNano, endNano);
        }

        out.println();

        // time set 3
        out.println("Time Taken to find a total of 300,000 items 10x in a Hash Map:");
        for (int i=0; i<10; i++){
            startNano = System.nanoTime();
            for(int j=1; j<=300000; j++){
                map3.get("element" + String.valueOf(j));
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
    public void printArray(HashMap map){
        Object[] array = map.getInternalArray();
        for (int i=1; i<=map.size(); i++){
            if (array[i] != null){
                out.println(i + " " + array[i]);
            }
            else{
                out.println(i + " null");
            }
        }
    }
}
