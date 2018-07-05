import static java.lang.System.out;

/**
 * Created by Stephen White on 11/15/2016.
 *
 * A generic Node class to be used with a BST
 */
public class Node<K extends Comparable<K>,E> {

        E element; // each node will be of a specific type
        K key;     // each node will have a key associated with it
        Node leftChild;  // each node will have a reference to a left child
        Node rightChild; // each node will have a reference to a right child

        // constructor for the node class
        public Node(K key, E element){ // pass in the element first, than its key
            this.element = element; // assign it the type of element that it is
            this.key = key;         // assign it its corresponding key
            this.leftChild = null;  // upon creation, it has no left child reference
            this.rightChild =null;  // upon creation it has no right child reference
        }

        // a similar method to displayNode(), just a different way of doing so
        public String toString(){
            String s = "";
            s += '{';
            s += key;
            s += ", ";
            s += element;
            s += "} ";
            return s;
        }

        // we must be able to display the node's contents as such:  "{key, element}"
        public void displayNode(){
            out.print('[');
            out.print(key);
            out.print(": ");
            out.print(element);
            out.print(", ");
            out.print("] ");
        }
} // END CLASS NODE
