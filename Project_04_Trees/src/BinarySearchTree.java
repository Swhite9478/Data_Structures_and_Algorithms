
import java.util.NoSuchElementException;

/*
 * Created by Stephen White on 11/15/2016.
 *
 * Goal: to create a working data structure for a binary search tree
 */

public class BinarySearchTree <K extends Comparable<K>,E> implements IBinarySearchTree<K,E>{
    Node rootNode;
    int size = 0;

    @Override
    public void put(K key, E element) {
        Node newNode = new Node(key, element); // create a new node so we may place it properly
        if (rootNode == null){ // there are no nodes yet...
            rootNode = newNode; // so the new node is the root!
            size += 1;
        }
        else{ // otherwise we gotta do some searching to place it properly
            Node current = rootNode; // start from the top
            Node parent; // we need to have a reference to the current node's parent for re-wiring
            while(true){ // enter the while loop to allow us to search properly
                parent = current; // this will place parent one step behind current
                // check to see if our key is less than the current key
                if(newNode.key.compareTo(current.key)<= -1){
                    current = current.leftChild; // move to the left again
                    if(current == null){ // if there are no more left nodes at this point...
                        parent.leftChild = newNode; // set that left parent reference!
                        size += 1;
                        return; // we are done here
                    }
                } // END GO LEFT
                else { // we are gonna go to the right if our key >= the current key
                    current = current.rightChild; // move to the right
                    if(current == null){ // if we have gone all the way to the right...
                        parent.rightChild = newNode; // set that right parent reference!
                        size += 1;
                        return; // we are done here
                    }
                } // END GO RIGHT
            } // END WHILE LOOP
        } // END ELSE NOT ROOT
    } // END insert()

    @Override
    public E get(K key) throws NoSuchElementException{ // Find a node with a given key, and return the element to the user
        Node current = rootNode; // start from the top of the tree
        while(current.key != key){ // begin searching for an item with the same key
            if(key.compareTo((K) current.key) <= -1){ // if what we are looking for is < where we are at...
               current = current.leftChild; // then we are going to go to the left
            } // END GO LEFT
            else if (key.compareTo((K) current.key) >= 1){ // if what we are looking for is > where we are at
                current = current.rightChild; // then we are going to go to the right
            } // END GO RIGHT
            else{
                return (E) current.element;
            }
            if(current == null){ // if we did not find the item we were looking for...
                throw(new NoSuchElementException());
                //return null; // return null to the user
            } // END DID NOT FIND
        } // END WHILE LOOP
        return  (E) current.element; // return the node to the user
    } // END get()

    @Override
    public int size() { // return the number of elements in this tree
        return size;
    }

    @Override
    public int getHeight() {
        if(size() == 0 || size() == 1) return 0; // handle tree sizes of 1 or 0
        return getHeightRecursive(rootNode) - 1; // subtract one to handle not counting the root
    }

    public int getHeightRecursive(Node localRoot){
        int leftHeight = 0; // uses this variable for comparison
        int rightHeight = 0; // use this variable for comparison
        if(localRoot.leftChild!=null) // make sure that there is still a left child to look at
            leftHeight = getHeightRecursive(localRoot.leftChild); // find that height with a recursive-left call
        if(localRoot.rightChild!=null) // make sure that there is still a right child to look at
            rightHeight = getHeightRecursive(localRoot.rightChild); // find that height with a recursive-right call
        if(leftHeight > rightHeight){ // compare left and right height and take whichever is bigger
            return leftHeight+1; // return left height
        }
        else{
            return rightHeight+1; // return height
        }
    }

    @Override
    public String getTreeString() { // will print out the contents of the tree in order
        if (rootNode == null) return "[]"; // handle the edge case
        return getTreeStringRecursive(rootNode); // otherwise call the recursive method
    }

    public String getTreeStringRecursive(Node localRoot){
        String s = "["; // each call means that we are entering a child's branch
        if(localRoot != null) { // if we aren't dealing with an empty root
            s += localRoot.key + ", "; // print out the key and a comma
            if(localRoot.leftChild == null){ // handle the event the the left child is null
                s += "null, ";
            }
            else{ // handle the event the the left child is not null
                s += getTreeStringRecursive(localRoot.leftChild) + ", "; // append the recursive call to the string
            }
            if(localRoot.rightChild != null){ // check if the right child exists
                s += getTreeStringRecursive(localRoot.rightChild); // append the recursive call to the string
            }
            else{ // if the right child is null, handle it
                s += "null";
            }
            s += "]"; // add a closing bracket
            return s; // return s to the method that called it
        }
        return s; // return the string to the user regardless
    }

    public String toString(){ // this method will call a recursive print method to print the tree's keys & elements
        return "[" + toStringRecursive(rootNode) + "]";
    }

    public String toStringRecursive(Node localRoot){
        String s = ""; // initialize an empty string upon each call
        if(localRoot != null){ // if we aren't dealing with an empty root
            if(localRoot.leftChild != null) { // check to see if the left child exists
                s += toStringRecursive(localRoot.leftChild) + ", "; // append the recursive call to the string
            }
            s +=  localRoot.key + ": " + localRoot.element; // append ": " and the element to the string
            if(localRoot.rightChild != null){ // check if the right child exists
                s += ", "; // if it does, than we need a comma
                s += toStringRecursive(localRoot.rightChild); // append the recursive call to the string
            }
            return s; // return s to the method that called it
        }
        return ""; // if the local root is null, return an empty string
    }
}
