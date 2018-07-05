import static java.lang.System.out;
/**
 * Created by Stephen White on 11/3/2016.
 *
 * Goal: Create a knapsack solver that will be able to solve
 *       the knapsack problem for many cases
 */
public class KnapsackSolver implements IKnapsackSolver {

    @Override
    public boolean[] knapsack(double capacity, Item[] items) {
        // create a boolean array of length zero to pass into the recursive call
        boolean[] prior = new boolean[0];
        return knapsackRecursive(capacity, items, prior);
    }

    @Override
    public boolean[] knapsackRecursive(double capacity, Item[] items, boolean[] prior) {
        // BASE CASE: if(prior.length == items.length) return prior
        if (prior.length == items.length) {
            return prior;
        }

        // set up two possibilities, a boolean array with the next item and without the next item
        boolean[] withNextItem = new boolean[prior.length + 1];
        boolean[] withoutNextItem = new boolean[prior.length + 1];

        // fill these two arrays with the same items the the prior boolean array had
        for(int i=0; i <prior.length; i++){
            withNextItem[i] = prior[i];
            withoutNextItem[i] = prior[i];
        }

        // "flip the switch" on withNextItem so that it truly utilize
        withNextItem[prior.length] = true;

        // create two more arrays that will store the "solution" for this recursive call/iteration
        // with and without the next item
        boolean[] solutionWithNextItem = null;
        boolean[] solutionWithoutNextItem = null;

        // these negative "values" for the knapsack will allow me to determine if the value has been set yet
        double withValue = -1.0;
        double withoutValue = -1.0;

        // check to see if the current weight with the next item exceeds capacity
        if(knapsackWieght(withNextItem, items) <= capacity){
            // if it does not, than call the recursive method again with the next item
            solutionWithNextItem = knapsackRecursive(capacity, items,withNextItem);
            // calculate the value of the knapsack
            withValue = knapsackValue(solutionWithNextItem, items);
        }
        // check to see if the current weight without the next item exceeds capacity
        if(knapsackWieght(withoutNextItem, items) <= capacity){
            // if it does not, than call the recursive method again with the next item
            solutionWithoutNextItem = knapsackRecursive(capacity, items, withoutNextItem);
            // calculate the value of the knapsack
            withoutValue = knapsackValue(solutionWithoutNextItem, items);
        }

        // compare the values of the knapsack with the next item and without the next item, and
        // choose whichever has the greatest value
        if(withValue >= withoutValue) { // choose the knapsack with the next item if its value is greater
            return solutionWithNextItem;
        }
        else{
            return solutionWithoutNextItem; // otherwise choose the knapsack without the next item
        }
    }

    // helper method to determine the total weight of a knapsack
    public double knapsackWieght(boolean[] prior, Item[] items){
        double returnWeight = 0.0;
        for(int i=0; i<prior.length; i++){
            if(prior[i] == true) returnWeight += items[i].getWeight();
        }
        return returnWeight;
    }

    // helper method to determine the total value of a knapsack
    public double knapsackValue(boolean[] prior, Item[] items){
        double returnVal = 0.0;
        for(int i=0; i<prior.length; i++){
            if(prior[i] == true) returnVal += items[i].getValue();
        }
        return returnVal;
    }

    // A helper method that will allow you to print out the knapsack
    public void printKnapsack(Item[] items, boolean[] prior){
        out.print("ITEMS: ");
        for(int i=0; i<prior.length; i++){
            if(prior[i] == true){
                out.print(items[i].getWeight());
            }
            out.println();
        }
    }
}
