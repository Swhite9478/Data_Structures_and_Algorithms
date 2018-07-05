import static java.lang.System.out;

/**
 * Created by Stephen White on 11/29/2016.
 *
 * Goal: to create a data structure that models a Hash Set
 *
 */
@SuppressWarnings("unchecked")
public class HashSet <E> implements ISet<E> {
    private E[] hashArray; // will store the array we are working with
    private int size;

    public HashSet(int size){ // pass in the size of the array you would like

        hashArray =  (E[]) new Object[size]; // instantiate a generic (Object) Array
        this.size = 0;
    }

    @Override
    public void add(E element) { // to add an element to our set...
        int hashCode = element.hashCode(); // obtain its hash code
        int hashedIndex = Math.floorMod(element.hashCode(), hashArray.length); // get its index
        while(hashArray[hashedIndex] != null) { // handle any collisions by double hashing
            String hashString = String.valueOf(hashCode); // convert previous hash code to a string
             hashCode = hashString.hashCode(); // hash that hash code
            hashedIndex = Math.floorMod(hashCode, hashArray.length); // find a new index
        }
        hashArray[hashedIndex] = element; // place the element
        size++; // increment size by one
    }

    @Override
    public boolean has(E element) { // determine if an element is in our set
        if (size == 0) return false;    // don't do anything if there is nothing in the set
        int hashCode = element.hashCode();  // generate the hash code
        int hashedIndex = Math.floorMod(hashCode, hashArray.length);    // get the proper index
        if(hashArray[hashedIndex] == null){     // if there is not an object @ this index then --> false
            return false;
        }
        else{   // otherwise check and properly handle collisions
            while(hashArray[hashedIndex] != null){
                if (hashArray[hashedIndex].equals(element)) return true;    // if it is the object, --> true
                String hashString = String.valueOf(hashCode);       // else turn prior hashchode into a string
                hashCode = hashString.hashCode();       // obtain that string's hash code
                hashedIndex = Math.floorMod(hashCode, hashArray.length);    // re-evaluate index
            }
            return false;   // if all else fails and we have run out of collisions, this item is not in the set
        }
    }

    @Override
    public int size() { // return the total number of non-null items in the set
        return size;
    }

    @Override
    public Object[] getInternalArray() { // obtain the complete representaiton of the array (including nulls)
        return hashArray;
    }

    public String toString(){ // format a to string so we can easily print out the items in the set
        int tempSize = size();
        String s = "[";
        for (int i=0; i<hashArray.length; i++){
            if(hashArray[i] == null) continue;
            tempSize--;
            if(tempSize == 0) {
                s += hashArray[i].toString();
                break;
            }
            s += (hashArray[i]).toString() + ", ";
        }
        s += "]";
        return s;
    }

    // MAIN METHOD UTILIZED FOR TESTING PURPOSES
    public static void main(String[] args) {

        HashSet set = new HashSet(10);
        out.println(set.toString());
        set.add("Alpha");
        set.add("Alpha2");
        Object[] internalSet = set.getInternalArray();
        out.println(set.toString());
        String s = "[ ";
        for (int i = 0; i < internalSet.length; i++) {
            if (internalSet[i] == null) s += "null ";
            else {
                s += (internalSet[i]).toString() + " ";
            }
        }
        s += "]";
        out.println(s);
    }

}
