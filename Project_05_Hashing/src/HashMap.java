import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by Stephen White on 11/29/2016.
 *
 */

@SuppressWarnings("all")
public class HashMap <K, E> implements IMap<K, E> {
    private E[] hashArray; // will store the array we are working with
    private int size;     // will store the size of the hash map

    public HashMap(int size){ // pass in the size of the array you would like
        hashArray =  (E[]) new Object[size]; // instantiate a generic (Object) Array
    }

    private class Node<K,E> implements IMap.IMapPair{ // a generic Node class to handle collisions
        private K key;      // each node contains a key
        private E element;  // each node contains an element
        private Node<K, E> nextNode;    // each node has a reference to another node

        public Node(K key, E element){      // pass in a key and an element to make a node
            this.key = key;
            this.element = element;
            setNextNode(null);
        }

        public void setNextNode(Node node){ // be able to set a reference to the next node
            this.nextNode = node;
        }

        @Override
        public K getKey() {         // be able to obtain the key from this node
            return this.key;
        }

        @Override
        public E getElement() {     // be able to obtain the element from this node
            return this.element;
        }

        @Override
        public IMapPair next() {    // be able to obtain the next node in the sequence
            return this.nextNode;
        }

        public String toString(){   // be able to display this node
            return(key + ": " + element);
        }
    }

    // a method that will put a node in the hash array & use separate chaining to handle collisions
    @Override
    public void put(K key, E element) {
        size++; // every time we add a node, increment the "size" reference to the array
        Node<K, E> newNode = new Node<>(key, element); // create a new node from the key & element

        int hashCode = key.hashCode(); // obtain its hash code
        int hashedIndex = Math.floorMod(hashCode, hashArray.length); // get its index

        if(hashArray[hashedIndex] == null){ // if there is not an item already present at this index...
            hashArray[hashedIndex] = (E) newNode; // place the node at that index
        }

        else if(hashArray[hashedIndex] != null){// Handle a possible collision through creating a linked list
            Node current = (Node) hashArray[hashedIndex]; // start from the "top" of the linked list
            Node beforeCurrent = null;      // have a reference to the node before current for wiring purposes

            // travel along the links until we hit an empty space
            while(current != null){
                beforeCurrent = current;
                current = (Node) current.next();
            }
            beforeCurrent.setNextNode(newNode); // add the new node as the latest link in this structure
        }
    }

    // A method to obtain an item @ a hashed index. travel along links to handle a collision
    @Override
    public E get(K key) {
        int hashCode = key.hashCode(); // obtain the hash code of the key passed in
        int hashIndex = Math.floorMod(hashCode, hashArray.length); // calculate the index

        // if there is an item present at that hashed index
        if(hashArray[hashIndex] != null){
            Node<K,E> comparisonNode = (Node) hashArray[hashIndex]; // we want the node @ the hashed index

            // see if the first key in the linked structure is the key we are looking for
            if(key.equals(comparisonNode.getKey())){
                return comparisonNode.getElement(); // obtain the element, and return it to the user
            }

            // otherwise travel along the linked structure to see if it exists
            while(comparisonNode != null){
                if(key.equals(comparisonNode.getKey())){ // if it does, return the element
                    return comparisonNode.getElement();
                }
                comparisonNode = (Node) comparisonNode.next(); // otherwise, keep traveling along links
            }
        }
        throw new NoSuchElementException(); // in the event it doesn't exist, throw an exception
    }

    @Override
    public int size() {     // obtain the number of nodes in this hash map
        return this.size;
    }

    @Override
    public Object[] getInternalArray() {    // obtain the actual array corresponding to the hash map
        return hashArray;
    }

    public String toString(){ // format a to string so we can easily print out the items in the set
        int tempSize = size(); // reference size to determine if we should add a comma & a space or not
        String s = "["; // start off the string with a bracket

        // go through every index in this hash array
        for (int i=0; i<hashArray.length; i++){
            if(hashArray[i] == null) continue;  // if the value @ the index is null, go to next iteration
            else if(hashArray[i] != null){      // otherwise, travel along links and print out nodesa
                Node current = (Node) hashArray[i]; // obtain the first node @ the index

                // continue traveling down the links until there are no more links
                while (current != null){
                    tempSize--;     // with every time current is not null, decrement our temp size

                    // check to see if we have visited all items
                    if(tempSize == 0) {
                        s += current.toString() + ""; // if so, get the element's toString w/out a comma and break
                        break;
                    }
                    s += current.toString() + ", ";   // otherwise, we have more items to add so include a comma & space
                    current = (Node) current.next();  // continue traveling down links
                }
            }
        }
        s += "]"; // cap it all off with another bracket
        return s; // return that string to the user
    }


    public static void main(String[] args){
        HashMap map = new HashMap<>(10);
        String key = "Alpha";
        Integer element = 1;
        String key2 = "Beta";
        Integer element2 = 2;
        String key3 = "Delta8"; // chosen to collide with alpha
        Integer element3 = 3;
        map.put(key, element);
        map.put(key2, element2);
        map.put(key3, element3);
        map.put("Alpha", 4);
        map.put("Delta8", 5);
        Object[] internalSet = map.getInternalArray();
        out.println("TO STRING: " + map.toString() + "\n");
        String s = "[ ";
        for (int i = 0; i < internalSet.length; i++) {
            if (internalSet[i] == null) s += "null ";
            else {
                s += (internalSet[i]).toString() + " ";
            }
        }
        s += "]";
        out.println(s);

        out.println(map.get("Alpha"));
    }
}
