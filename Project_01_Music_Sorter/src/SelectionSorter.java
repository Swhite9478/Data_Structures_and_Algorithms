import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Created by Stephen White 9/25/2016
 *
 * A class that will utilize the selection sort algorithm on generic lists, as well
 * as generic lists presented with a comparator
 *
 */
public class SelectionSorter implements ISorter
{   private List list;
    private int swaps = 0;

    public <T extends Comparable<T>> int sort(List<T> list)
    {
        this.list = list; // The list we will be working on
        int out; // A pointer for our outer loop
        int in; //  A pointer for our inner loop
        int min; // A pointer for our minimum object

        // Begin sorting
        for(out=0; out<list.size()-1; out++)   // outer loop
        {
            T outer = list.get(out);
            min = out;                     // set minimum and outer equal
            T minimum = list.get(min);
            for (in = out + 1; in < list.size(); in++) { // inner loop starting a i = 1
                T inner = list.get(in);
                if (inner.compareTo(list.get(min)) == -1) { // if min greater,
                    //if the value of in < value of min...
                    min = in;               // we have a new min, so min = in
                } // DONE WITH INNER FOR LOOP WHILE OUTER IS STILL i=0
            }
            swap(out, min); // swap the outer with the min
        }
        return swaps; // return the number of swaps to the user
    }

    // A helper method that will swap two items
    private <T> void swap(int outer, int min)
    {
        if(outer == min) return; // We dont want to swap equal items
        T temp = (T) list.get(outer); // Create a temporary object for swapping
        list.set(outer, list.get(min)); // Set outer object to the minimum object
        list.set(min, temp); // Set the minimum object to the temp object we created above
        swaps++; // increment the number of swaps that have taken place by 1
    }

    // Sort a list when we are also given a comparator
    @Override
    public <T> int sort(List<T> list, Comparator<T> comparator) {
        this.list = list;
        int out; // Outer pointer
        int in; // Inner pointer
        int min; // Minimum pointer

        // Begin sorting
        for(out=0; out<list.size()-1; out++)   // outer loop
        {
            min = out;                     // set minimum and outer equal
            for (in = out + 1; in < list.size(); in++) { // inner loop starting a i = 1
                T inner = list.get(in); // object at inner pointer
                T minimum = list.get(min); // object at minimum pointer
                if (comparator.compare(inner, minimum) <= -1) { // if min greater,
                    //if the value of in < value of min...
                    min = in;               // we have a new min, so min = in
                } // END OF IF STATEMENT
            } // END OF INNER LOOP
            swap(out, min); // swap the outer with the min
            //continue to next iteration of outer loop
        } // END OF OUTER LOOP
        return swaps; // return the number of swaps to the user
    } // END OF SORT METHOD

    // A separate main() method for testing
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0);

        SelectionSorter sorter = new SelectionSorter();
        System.out.println("LIST: [ 5 3,1,6,0]");
        //System.out.println("SIZE OF LIST: " + list.size());
        //System.out.println("NUMBER OF SORTS: " + sorter.sort(list));
        sorter.sort(list);
    } // END OF MAIN METHOD
} // END OF CLASS SELECTION SORTER
