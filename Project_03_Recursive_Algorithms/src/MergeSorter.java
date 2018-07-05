import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static java.lang.System.out;

/**
 * Created by Stephen White on 10/26/2016.
 *
 * Goal: Implement a a generic Merge Sort that can take in a comparator, as well as
 *       a starting index and an ending index to sort.
 *
 */
public class MergeSorter<T extends Comparable> implements IMergeSorter{
    private int numberOfOps = 0;
    private int count;
    public int originalFrom = 0;
    public int originalTo = 0;

    // A method that will keep track of the original "from" passed into MergeSortRecursive
    public void setOriginalFrom(int from){
        this.originalFrom = from;
    }
    // A method that will keep track of the original "to" passed into MergeSortRecursive
    public void setOriginalTo(int to){
        this.originalTo = to;
    }

    /* public int sort(List<T> list)
     *
     * takes in a list and will call the overloaded sort method that takes in a comparator.
     * The comparator that will be used is defined within this method.
     *
     * Returns the number of merges that have taken place back to the user.
     */
    @Override
    public <T extends Comparable<T>> int sort(List<T> list) {
        // build a simple nested generic comparator;
        Comparator<T> comparator = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1.compareTo(o2) <= -1) return -1; // if o1 is smaller
                else if (o1.compareTo(o2) >= 1) return 1; // if 01 is bigger
                return 0; // if the objects are the same
            }
        };
        return sort(list, comparator);
    } // END sort(list) method

    /* public int sort(List<T> list, Comparator<T> comparator
     *
     * this method takes in the same list that sort() above passes it, or a user may call this method
     * with their list, as well as their own comparator to sort generic lists in any fashion they choose.
     *
     * Returns the number of merges that have taken place back to sort() defined above.
     */
    @Override
    public <T> int sort(List<T> list, Comparator<T> comparator) {
        return mergeSortRecursive(list, 0, list.size()-1, comparator);
    } // END sort(list, comparator) method

    /* public void merge(List<T> leftList, List<T> rightList, List<T> originalList, Comparator<T> comparator
     *
     * a method that is utilized within mergeSortRecursive. It takes in two lists (left and right), and
     * merges them properly back into the original list that was also passed into this method.
     * All merging occurs properly with the comparator that is passed to it.
     *
     * Returns the number of operations that have occurred in the event the user wishes to see how many
     * merges have actually taken place.
     */
    public <T> void merge(List<T> leftList, List<T> rightList,
                          List<T> originalList, Comparator<T> comparator){
        int iLeft = 0; // an index for my left list when I break the original list in half
        int iRight = 0; // in index for my right list when I break the original list in half
        int iMerged = 0; // an index for placing the merged items back into a list

        // Re-write my original list while my pointers are in bounds
        while (iLeft < leftList.size() && iRight < rightList.size()){ // if left list object < right list object
            if(comparator.compare(leftList.get(iLeft),(rightList.get(iRight))) < 0){
                originalList.set(iMerged, leftList.get(iLeft)); // re-set my original list's values accordingly
                iLeft++; // increment that left pointer by one
            }
            else{ // if eight list object < left list object
                originalList.set(iMerged, rightList.get(iRight)); // re-set my original list's values accordingly
                iRight++; // increment that right pointer by one
            }
            iMerged++; // no matter what I need to increment my pointer for my merging index to re-set values correctly
        }
        // what if one pointer goes out of bounds before we have all of our objects in the merged list?
        while (iLeft < leftList.size()){ // put the remaining items from my left list in my merged list
            originalList.set(iMerged, leftList.get(iLeft));
            iLeft++;
            iMerged++;
        }
        while (iRight < rightList.size()){ // put the remaining items from my right list in my merged list
            originalList.set(iMerged, rightList.get(iRight));
            iRight++;
            iMerged++;
        }
        numberOfOps++; // increase the number of merges
    } // END merge()method


    /* public int mergeSortRecursive(List<T> list, int from, int to, Comparator<T> comparator
     *
     * a method that takes in a generic list, a starting value, an ending value, and a comparator.
     * This method is repsonsible for recursivley dividing the passed list down to a base case of
     * length one, and passing the divided lists into the merge method.
     *
     * Returns the number of merges that have taken place.
     */
    @Override
    public <T> int mergeSortRecursive(List<T> list, int from, int to, Comparator<T> comparator){
        if (list.size() <= 1) { // BASE CASE
            //count += 1;
            return 0;
        }
        // Handle the case that somebody calls MergeSort directly, and "from" and "to"
        // are not equal to "0" or "list.size()" respectively
        if(count == 0 && from !=0 && to != list.size()){ // check that condition
            // keep track of the original to and from to be able to overwrite values in the original list
            setOriginalFrom(from);
            setOriginalTo(to);
            // create a new array that will store the values of the original list from "from" to "to"
            List<T> copyList = new ArrayList<T>();
            for (int i=originalFrom; i<=originalTo; i++){ // put those items in that array
                copyList.add(list.get(i));
            }
            int mid = copyList.size()/2; // locate the middle of that sub-list
            // create a left list and a right list that will be divided even further
            List<T> leftList = new ArrayList<T>() ;
            List<T> rightList = new ArrayList<T>();

            // put the proper items in the left list
            for (int i=0; i<mid; i++){
                leftList.add(copyList.get(i));
            }
            // put the proper items in the right list
            for(int j=mid; j<copyList.size()-1; j++) {
                rightList.add(copyList.get(j));
            }
            // increment the count by the appropriate amount
            count+= leftList.size();
            count+= rightList.size();

            // call merge sort on the left and right lists
            mergeSortRecursive(leftList, 0, leftList.size(), comparator);
            mergeSortRecursive(rightList, 0, rightList.size(), comparator);

            // merge those two lists back into the sub-list we created
            merge(leftList, rightList, copyList, comparator);

            // overwrite the proper values in the original list with those from our sub-list
            int k =0;
            for(int a =originalFrom; a <= originalTo; a++){
                list.set(a, copyList.get(k)); // overwrite that value!
                k++;
            }
            return count; // decrement 4 because WHY NOT!? :)
        }

        // ELSE handle the case that the user did not call merge sort directly with different "from" and "to"
        // values other than 0 and list.size() respectively
        else {
            count += list.size();
            // split the list into two lists, a left and right list.
            List<T> leftList = new ArrayList<T>();
            List<T> rightList = new ArrayList<T>();
            // split the list at its halfway point
            int mid = list.size() / 2;
            // properly populate the left list up to the mid point
            for (int i = 0; i < mid; i++) {
                leftList.add(list.get(i));
            }
            // properly populate the right list from the mid point to the end
            for (int j = mid; j < list.size(); j++) {
                //out.println("J: " + j);
                rightList.add(list.get(j));
            }
            // continually split each list in half by calling merge sort again and again
            mergeSortRecursive(leftList, from, to, comparator);
            mergeSortRecursive(rightList, from, to, comparator);
            // eventually we want to merge our left list and right list into the original list.
            merge(leftList, rightList, list, comparator);

            return count; // return how many merges took place
        }
    } // END mergeSortRecursive() method

    // MAIN METHOD FOR TESTING
    public static void main(String[] args){
        MergeSorter sorter = new MergeSorter();
        List<Integer> myList = new ArrayList<Integer>();
        class ReverseComparator<T extends Comparable<T>> implements Comparator<T>
        {
            public int compare(T a, T b)
            {
                return -a.compareTo(b);
            }
        }
        myList.add(2);
        myList.add(3);
        myList.add(5);
        myList.add(9);
        myList.add(5);
        myList.add(8);
        myList.add(9);
        myList.add(2);
        myList.add(1);
        myList.add(3);
        out.println("Original List:\t" + myList);
        out.println(sorter.mergeSortRecursive(myList, 2, 8, new ReverseComparator<Integer>()));
        out.println("SORTED LIST:\t" + myList);
    } // END main() method
} // END MergeSorter class
