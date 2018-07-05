import java.util.Random;

import static java.lang.System.out;

/**
 * Created by Stephen White on 11/9/2016.
 *
 *  Goal:Create a main method which allows you run the Knapsack problem for random items of
 *  quantity 10, 15, 20, and 25. Record the run times for each call.
 *
 *       Each randomly generated item should have a weight and value between 0 and 9. The
 *      capacity for each run should be 3 times the number of items. *
 */
public class KnapsackTimeTest {

    public static void main(String[] args) {
        // create the to variables that will store the start and end time for nanoseconds
        long startTimeNano;
        long endTimeNano;

        // create the to variables that will store the start and end time for milliseconds
        long startTimeMillis;
        long  endTimeMillis;

        // create an instance of KnapsackTimeTest so that we may use our helper methods
        KnapsackTimeTest tester = new KnapsackTimeTest();

        // create an instance of IKnapsackSolver so that we may create an array of Items
        IKnapsackSolver solver;

        // create an instance of KnapsackSolver so that we may solve these upcoming knpasack problems
        KnapsackSolver knapsackSolver = new KnapsackSolver();

        // create 4 separate boolean arrays to store the solved knapsack;
        boolean[] solvedKnapsack1;
        boolean[] solvedKnapsack2;
        boolean[] solvedKnapsack3;
        boolean[] solvedKnapsack4;

        // Create the 4 separate item arrays that we will be testing below

        // create an array of 10 Items with random weight & values between 0-9
        IKnapsackSolver.Item[] items1 = new IKnapsackSolver.Item[10];
        for(int i=0; i<10; i++){
            items1[i] = new IKnapsackSolver.Item(tester.randDouble(), tester.randDouble());
        }

        // create an array of 15 items with random weight & values between 0-9
        IKnapsackSolver.Item[] items2 = new IKnapsackSolver.Item[15];
        for(int i=0; i<15; i++){
            items2[i] = new IKnapsackSolver.Item(tester.randDouble(), tester.randDouble());
        }

        // create an array of 20 items with random weight & values between 0-9
        IKnapsackSolver.Item[] items3 = new IKnapsackSolver.Item[20];
        for(int i=0; i<20; i++){
            items3[i] = new IKnapsackSolver.Item(tester.randDouble(), tester.randDouble());
        }

        // create an array of 25 items with random weight & values between 0-9
        IKnapsackSolver.Item[] items4 = new IKnapsackSolver.Item[25];//{
        for(int i=0; i<25; i++){
            items4[i] = new IKnapsackSolver.Item(tester.randDouble(), tester.randDouble());
        }

        // lets do some calculations!

        // calculate time taken to solve an array of 10 (capacity = 30.0)
        startTimeMillis = System.currentTimeMillis();
        startTimeNano = System.nanoTime();
        solvedKnapsack1 = knapsackSolver.knapsack(30.0, items1);
        endTimeNano = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        tester.printNanoTime(10, startTimeNano, endTimeNano);
        tester.printMillisTime(10, startTimeMillis, endTimeMillis);

        out.println();

        // calculate the time taken to solve an array of 15 (capacity = 45.0)\
        startTimeMillis = System.currentTimeMillis();
        startTimeNano = System.nanoTime();
        solvedKnapsack2 = knapsackSolver.knapsack(45.0, items2);
        endTimeNano = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        tester.printNanoTime(15, startTimeNano, endTimeNano);
        tester.printMillisTime(15, startTimeMillis, endTimeMillis);

        out.println();

        // calculate the time taken to solve an array of 20 (capacity = 60.0)
        startTimeMillis = System.currentTimeMillis();
        startTimeNano = System.nanoTime();
        solvedKnapsack3 = knapsackSolver.knapsack(60.0, items3);
        endTimeNano = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        tester.printNanoTime(20, startTimeNano, endTimeNano);
        tester.printMillisTime(20, startTimeMillis, endTimeMillis);

        out.println();

        // calculate the time taken to solve an array of 25 (capacity = 75.0)
        startTimeMillis = System.currentTimeMillis();
        startTimeNano = System.nanoTime();
        solvedKnapsack4 = knapsackSolver.knapsack(75.0, items4);
        endTimeNano = System.nanoTime();
        endTimeMillis = System.currentTimeMillis();
        tester.printNanoTime(25, startTimeNano, endTimeNano);
        tester.printMillisTime(25, startTimeMillis, endTimeMillis);

        // obtain the string for what is in each knapsack!
        out.println();
        String sack1 = stringifyKnapsack(solvedKnapsack1, items1);
        String sack2 = stringifyKnapsack(solvedKnapsack2, items2);
        String sack3 = stringifyKnapsack(solvedKnapsack3, items3);
        String sack4 = stringifyKnapsack(solvedKnapsack4, items4);

        // print out each knapsack's contents, weight, and value
        out.println("KNAPSACK 1 CAPACITY: 30");
        out.println("Solved knapsack 1 " + sack1);
        out.println("Total weight of knapsack 1: " + tester.weighKnapsack(solvedKnapsack1, items1) + " lbs");
        out.println("Total value of knapsack 1: $" + tester.valueKnapsack(solvedKnapsack1, items2));

        out.println();

        out.println("KNAPSACK 2 CAPACITY: 45");
        out.println("Solved knapsack 2 " + sack2);
        out.println("Total weight of knapsack 2: " + tester.weighKnapsack(solvedKnapsack2, items2) + " lbs");
        out.println("Total value of knapsack 2: $" + tester.valueKnapsack(solvedKnapsack2, items2));

        out.println();

        out.println("KNAPSACK 3 CAPACITY: 60");
        out.println("Solved knapsack 3 " + sack3);
        out.println("Total weight of knapsack 3: " + tester.weighKnapsack(solvedKnapsack3, items3) + " lbs");
        out.println("Total value of knapsack 3: $" + tester.valueKnapsack(solvedKnapsack3, items3));

        out.println();

        out.println("KNAPSACK 1 CAPACITY: 75");
        out.println("Solved knapsack 4 " + sack4);
        out.println("Total weight of knapsack 4: " + tester.weighKnapsack(solvedKnapsack4, items4) + " lbs");
        out.println("Total value of knapsack 4: $" + tester.valueKnapsack(solvedKnapsack4, items4));
    }// END MAIN
    //------------------------------------------------------------------------------------------------------------
    // HELPER METHODS TO THE RESCUE!

    // helper method for generating random doubles for the weight and value of an item up to 2 decimal places
    public double randDouble(){
        Random rand = new Random();
        final int lowerBound = 0;
        final int upperBound = 9;
        final int decimalPlaces = 2;

            if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
                throw new IllegalArgumentException("Put error message here");
            }

            final double dbl =
                    ((rand == null ? new Random() : rand).nextDouble() //
                            * (upperBound - lowerBound))
                            + lowerBound;
            // we only want to decimal places, so make it a string up to 2 decimal places
            String s = String.format("%." + decimalPlaces + "f", dbl);
        // parse that string, and convert it back into a double so that we can return it properly (i.e. 7.22)
        double randomValue = Double.parseDouble(s);

        return randomValue;
    }

    // helper method that will calculate total time taken to do something
    public long timeTaken(long startTime, long endTime){
        long totalTime = endTime - startTime;
        return totalTime;
    }

    // helper method that will print out the total time taken to solve knapsack for n items in nanoseconds
    public void printNanoTime(int numItems, long startTime, long endTime){
        out.println("For an array of " + numItems + " items, it took my algorithm " +
                timeTaken(startTime, endTime) + " nanoseconds to solve.");
    }

    // helper method that will print out the total time taken to solve

    // helper method for turning the array into a human readable string for n items in milliseconds
    public void printMillisTime(int numItems, long startTime, long endTime){
        out.println("For an array of " + numItems + " items, it took my algorithm " +
                timeTaken(startTime, endTime) + " milliseconds to solve.");
    }

    // helper method to return the total weight of the knapsack up to two decimal places
    static public double weighKnapsack(
            boolean[] knapsack,
            IKnapsackSolver.Item[] items)
    {
        // start a counter
        double weight = 0;
        // iterate through the knapsack set
        for(int i = 0; i < knapsack.length; i++)
        {
            // reference the items list to add the weight
            if(knapsack[i]) weight += items[i].getWeight();
        }
        String s = String.format("%." + 2 + "f", weight);
        weight = Double.parseDouble(s);
        // reutrn the result
        return weight;
    }

    // helper method to return the total value of a knapsack up to two decimal places
    static public double valueKnapsack(boolean[] knapsack, IKnapsackSolver.Item[] items){
        double value = 0;

        for(int i=0; i<knapsack.length; i++){
            if(knapsack[i]) value += items[i].getValue();
        }
        String s = String.format("%." + 2 + "f", value);
        value = Double.parseDouble(s);
        return value;
    }

    // helper method to display what is in the knapsack
    static public String stringifyKnapsack(
            boolean[] knapsack,
            IKnapsackSolver.Item[] items)
    {
        // give a null response to prevent empty knapsacks and null knapsacks from
        // returning the same value.
        if(knapsack == null) return "null";
        // start our result
        String result = "[";
        // iterate through the knapsack
        for(int i = 0; i < knapsack.length; i++)
        {
            // if the item is present...
            if(knapsack[i])
            {
                // build a representation for the result.
                result += "(" + items[i].getWeight() + " lbs, $" +
                        items[i].getValue() + ")";
            }
        }
        result += "]";
        return result;
    }
}
