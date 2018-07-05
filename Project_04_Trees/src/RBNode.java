import static java.lang.System.out;

/**
 * Created by Stephen White on 11/16/2016.
 *
 * Goal: To create a Node that models a Red Black Tree Node
 *
 */
public class RBNode<K extends Comparable<K>,E>  {
    private K key;         // key
    private E element;         // associated data
    private RBNode left;   // link to a left child/subtree
    private RBNode right;  // links to right child/subtree
    private RBNode parent;
    private String colorString; // "Black" or "Red"
    private boolean color; // color of parent link (true = red, false = black)

    // setRed(), setBlack()
    // getLeft(), getRight(), getParent
    // changeToRoot()

    // Constructor for the RBNode class
    public RBNode(K key, E element){
        this.key = key;
        this.element = element;
        this.left = null;
        this.right = null;
        this.parent = null;
        setRed();
    }

     /**************************************
     * helper methods for the RBNode class *
     ***************************************/

     // a method that will allow me to obtain this Node's key
     public K getKey(){
         return this.key;
     }

     // a method that will allow me to obtain this Node's element
    public E getElement(){
        return this.element;
    }

    // be able to determine if the current node is red or not
    public boolean isRed() {
        return this.color;
    }

    // be able to determine if the current node is black or not
    public boolean isBlack(){
        return !this.color;
    }

    // a method to make the current node red
    public void setRed(){
        this.color = true;
        this.colorString = "Red";
    }

    // a method to make the current node black
    public void setBlack(){
        this.color = false;
        this.colorString = "Black";
    }

    public String getColor(){
        return this.colorString;
    }

    // a method that will set the left child of this current node
    public void setLeft(RBNode node){
        this.left = node; // set the left reference of this node
        node.setParent(this); // the left node's parent is whatever this node is
    }

    // a method that will set the left child of this current node
    public void setRight(RBNode node){
        this.right = node;
        node.setParent(this);
    }

    // a method that will set the left child of this current node
    public void setParent(RBNode node){
        this.parent = node;
    }


    // a method to get the left child of the current node
    public RBNode getLeft(){
        return this.left;
    }

    // a method to remove the left child of the current node
    public void removeLeft(){
        this.left = null;
    }

    // a method to get the right child of the current node
    public RBNode getRight(){
        return this.right;
    }

    // a method to remove the right child of the current node
    public void removeRight(){
        this.right = null;
    }

    // a method to get the parent of the current node
    public RBNode getParent(){
        return parent;
    }

    // a method to remove the parent of the current node
    public void removeParent(){
        this.parent = null;
    }

    public String toString(){
        return String.format("%s: %s", key, element);
    }


    public static void main(String[] args){
        RBNode node1 = new RBNode(50, "node1");
        RBNode node2 = new RBNode(25, "node2");
        RBNode node3 = new RBNode(75, "node3");

        // print out node 1 before setting anything up
        out.println("PRINTING NODE 1 AND CHILD NODES BEFORE SETTING ANY INFO");
        out.println("Node1: [" + node1 + "]"); // {50, "node1"}
        out.println("Node1 left child: [" + node1.left + "]"); // should be null
        out.println("Node1 right child: [" + node1.right + "]"); // should be null
        out.println("Node1 color: " + node1.color); // should be true

        out.println();

        // Initializing children for node1
        node1.left = node2;
        node1.right = node3;

        out.println("INITIALIZING CHILDREN FOR NODE1");
        out.println("Node1 left child:  [" + node1.left + "]");  // should be node2
        out.println("Node1 right child: [" + node1.right + "]"); // should be node3

        out.println();

        out.println("CHECKING LEFT AND RIGHT CHILDREN OF NODE2 & NODE3");
        out.println("Node2 left child: [" + node2.left + "]"); // should be null
        out.println("Node2 right child: [" + node2.right + "]"); // should be null

        out.println();

        out.println("Node3 left child: [" + node3.left + "]"); // should be null
        out.println("Node3 right child: [" + node3.right + "]"); // should be null
    }
}
