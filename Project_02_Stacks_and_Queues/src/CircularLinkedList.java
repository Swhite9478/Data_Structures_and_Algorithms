import static java.lang.System.out;

/**
 * Created by Stephen White on 10/20/2016.
 *
 * A generic class that models a circular liked list.
 *
 */
public class CircularLinkedList<T> {
    private int maxNodes; // the maximum # of nodes in this list
    private int numNodes = 0; // when a list is created, there are no nodes
    public Node<T> firstNode; // The list will always know what node is first
    private Node<T> lastNode; // The list will always know what node is last
    private Node<T> CurrentNode; // The list will always know the current node after an elimination
    private Node<T> printStartingPoint; // will be utilized to print out the linked list

    public String toString(){ // format for printing out this list
        String s = ""; // create an empty string 's'
        this.printStartingPoint = firstNode; // create a reference node for stepping through nodes
        for (int i=0; i <numNodes; i++){ // go through every node that is linked together
            s += printStartingPoint; // add that node to the string
            s+= " ";
            printStartingPoint = printStartingPoint.nextNode; // increment the current node;
        }
        return s; // return the string representation of the linked list
    }

    // the linked list has the ability to set the max # nodes
    public void setMaxNodes(int numberOfMaxNodes){
        this.maxNodes = numberOfMaxNodes;
    }

    public boolean isEmpty(){ // allows us to determine if the linked list is empty or not
        return (numNodes == 0);
    } // if there are no nodes, then list is empty

    public Node<T> getFirstNode(){
        return firstNode;
    } // allow us to grab the first node

    public Node<T> getLastNode(){
        return lastNode;
    } // allow us to grab the last node

    public int getNumNodes(){
        return numNodes;
    } // allow us to see how many nodes are currently in the list

    public void addNode(Node<T> node){ // will allow us to add a node to this linked list
        Node<T> newNode = node;
        // check to see if the list is empty before we try adding a node, and handle it
        if (isEmpty()){
            firstNode = node; // set first node
            lastNode =node; // last node == first node
            firstNode.nextNode = lastNode; // firstNode.nextNode references itself
            numNodes++; // increment the # nodes
        }
        // if the list is not empty, insert a node at the end and have it reference the first node
        else{
            Node<T> tempNode = lastNode;
            lastNode = node;
            tempNode.nextNode = lastNode;
            lastNode.nextNode = firstNode;
            numNodes++;
        }
    }

    public Node<T> getNode(int index){ // obtain a specific Node
        int counter = 1;
        Node<T> compareNode =firstNode;
        while(counter != index){
            compareNode = compareNode.nextNode;
        }
        return compareNode;
    }

    public Node<T> removeNode(int indexToRemove){ // will allow us to remove a node from the list at a specific point
        if (CurrentNode == null) CurrentNode = firstNode;
        if (numNodes == 1){
            return firstNode; // return proper node
        }
        Node<T> nodeBeforeCurrent;
        if(numNodes == maxNodes) {
            CurrentNode = firstNode;
            nodeBeforeCurrent = firstNode;
        }

        nodeBeforeCurrent = firstNode;
        int counter = 1;

        if (indexToRemove == getNumNodes()){ // we are removing the last item
            CurrentNode = lastNode.nextNode;
            nodeBeforeCurrent = CurrentNode;
            counter = 1; // reset counter to find item before last item
            while (counter != getNumNodes() -1){
                nodeBeforeCurrent = nodeBeforeCurrent.nextNode; // travel along Nodes
                counter++; // increment the counter
            }
            Node<T> nodeToReturn = lastNode;
            nodeBeforeCurrent.nextNode = firstNode;
            lastNode = nodeBeforeCurrent;
            numNodes--; // decrement # nodes
            return nodeToReturn; // return the proper node

        }

        else if (indexToRemove == 1){ // we are removing the first item
            Node<T> returnNode = firstNode;
            firstNode = firstNode.nextNode;
            lastNode.nextNode = firstNode;
            numNodes--; // decrement # nodes
            return returnNode; // return the proper node
        }

        else { // if we are removing an item in the middle of the circle
            counter = 1;
            while (counter != indexToRemove) { // obtain the correct node to remove
                nodeBeforeCurrent = CurrentNode;
                CurrentNode = CurrentNode.nextNode; // travel along links
                counter++; // increment the counter
            }
        }
        // time to re-wire these links
        Node<T> nodeToReturn = CurrentNode;
        if (CurrentNode == firstNode) {
            firstNode = firstNode.nextNode;
        }
        nodeBeforeCurrent.nextNode = CurrentNode.nextNode;
        CurrentNode = CurrentNode.nextNode;
        numNodes--;

        return nodeToReturn;
    }

    public boolean isWinner(){ // determine if there is a winner based on if there is one person left
        if(numNodes == 1) return true;
        return false;
    }

    // Main method for testing
    public static void main(String[] args){
        CircularLinkedList<Integer> list = new CircularLinkedList<Integer>();

        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        Node<Integer> node5 = new Node<Integer>(5);
        Node<Integer> node6 = new Node<Integer>(6);
        Node<Integer> node7 = new Node<Integer>(7);
        Node<Integer> node8 = new Node<Integer>(8);
        Node<Integer> node9 = new Node<Integer>(9);
        Node<Integer> node10 = new Node<Integer>(10);

        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);
        list.addNode(node5);
        list.addNode(node6);
        list.addNode(node7);
        list.addNode(node8);
        list.addNode(node9);
        list.addNode(node10);

        out.println("Printing out Linked List: " + list);
        out.println("First Node: " + list.getFirstNode());
        out.println("Last Node: " + list.getLastNode());
        out.println("Last node.nextNode(): " + list.getLastNode().nextNode);
        out.println("First node.nextNode(): " + list.getFirstNode().nextNode);
        out.println("Num Nodes: " + list.getNumNodes());
        out.println(list);
        list.removeNode(3);
        out.println(list);
        list.removeNode(3);
        out.println(list);
        list.removeNode(3);
        out.println(list);
        list.removeNode(3);
        out.println(list);
    }
}
