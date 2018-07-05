import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Stephen White on 9/28/2016.
 *
 * A class that will utilize the insertion sort algorithm on generic lists, as well
 * as generic lists presented with a comparator
 */
public class InsertionSorter implements ISorter {
    private List list;
    @Override
    public <T extends Comparable<T>> int sort(List<T> list) {
        this.list = list; // set our list equal to the one passed in to us
        int swaps = 0; // no swaps have been made yet
        for (int j = 1; j < list.size(); j++) { // Outer loop
            T key = list.get(j); // our temporary object 'key' == whatever our outer loop points to
            int i = j-1; // new variable i that references the object before our outer loop's index
            while ( (i > -1) && ( list.get(i).compareTo(key)>= 1) ) {
                // we don't want i to be negative (ArrayIndexOutOfBounds), and we want
                // to make sure there is a bigger item at index i than what our key is
                list.set((i+1), list.get(i)); // if so, we want to swap outer with inner
                i--; // decrement our inner counter
                swaps++; // increment the number of swaps
            }
            list.set((i+1),key); // when we have run out of items bigger than key, set i+1 to key

        }
        return swaps; // return the number of swaps
    }

    // Sort the list if we are also given a comparator
    @Override
    public <T> int sort(List<T> list, Comparator<T> comparator) {
        this.list = list; // set our list equal to the one passed in to us
        int swaps = 0; // no swaps have been made yet
        for (int j = 1; j < list.size(); j++) { // Outer loop
            T key = list.get(j); // our temporary object 'key' == whatever our outer loop points to
            int i = j-1; // new variable i that references the object before our outer loop's index
            while ( (i > -1) && ( comparator.compare(list.get(i), key) >= 1) ) {
                // we don't want i to be negative (ArrayIndexOutOfBounds), and we want
                // to make sure there is a bigger item at index i than what our key is
                list.set((i+1), list.get(i)); // if so, we want to swap outer with inner
                i--; // decrement our inner counter
                swaps++; // increment the number of swaps
            }
            list.set((i+1),key); // when we have run out of items bigger than key, set i+1 to key

        }
        return swaps; // return the number of swaps
    }

    // A separate Main() method for testing
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(13); // index 0
        list.add(15); // index 1
        list.add(17); // index 2
        list.add(11); // index 3
        list.add(33); // index 4 ...
        list.add(1);
        list.add(99);
        list.add(2);
        list.add(0);
        list.add(17);
        list.add(6);
        list.add(69);
        list.add(1);
        list.add(55);
        list.add(83);
        list.add(25);
        list.add(4);
        list.add(6);
        list.add(69);
        list.add(76);
        /*
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(5);*/
        System.out.println("SIZE OF THIS LIST: " + list.size());

        InsertionSorter sorter = new InsertionSorter();
        System.out.println("NUMBER OF SWAPS MADE: " + sorter.sort(list));
        System.out.print("LIST CONTENTS: [ ");
        for (int i=0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.print("]");
    }
}
