import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Created by Stephen White 9/25/2016
 *
 * A class that will utilize the bubble sort algorithm on generic lists, as well
 * as generic lists presented with a comparator
 */
public class BubbleSorter implements ISorter
{
    private List list; // the list we are dealing with
    private int swaps; // the number of swaps made

    // Sort a generic list with Bubble Sorter
    public <T extends Comparable<T>> int sort(List<T> list)
    {
        // Begin sorting
        this.list = list;
        for(int i = 0; i < list.size()-1; i++){ // # of loops over the list
            for(int j=0; j < list.size()-1; j++ ){ // # of checks/comparisons
                if(list.get(j).compareTo(list.get(j+1)) >= 1){ // -1 means <, 0 means ==, 1 means >
                    // if list[j-1] > list[j]... SWAP THEM
                    T temp = list.get(j+1); // temporary value for swapping
                    list.set(j+1, list.get(j)); // move list[i] forward
                    list.set(j, temp);    // replace the item at I with what j was (temp)
                    swaps++;    // document the number of swaps we have made so far
                }
            }

        }
        return swaps; // return this to the user
    }

    // Be able to sort if we are given a comparator
    @Override
    public <T> int sort(List<T> list, Comparator<T> comparator)
    {
        // Begin sorting
        this.list = list;
        for(int i = 0; i < list.size()-1; i++){ // # of loops over the list
            for(int j=0; j < list.size()-1; j++ ){ // # of checks/comparisons
                if(comparator.compare(list.get(j),(list.get(j+1))) >=1){ // -1 means <, 0 means ==, 1 means >
                    // if list[j-1] > list[j]... SWAP THEM
                    T temp = list.get(j+1); // temporary value for swapping
                    list.set(j+1, list.get(j)); // move list[i] forward
                    list.set(j, temp);    // replace the item at I with what j was (temp)
                    swaps++;    // document the number of swaps we have made so far
                }
            }
        }
        return swaps; // return this to the user
    }

    // A separate main() method for testing
    public static void main(String[] args){
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(1);
        list.add(99);
        list.add(3);
        list.add(0);
        System.out.println(list.size());
        BubbleSorter sorter = new BubbleSorter();
        sorter.sort(list);
    }
}
