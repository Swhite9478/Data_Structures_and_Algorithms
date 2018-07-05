import java.util.NoSuchElementException;

/**
 * Created by Stephen White on 11/16/2016.
 *
 * Goal: to implement a properly working Red Black Tree
 *
 */
@SuppressWarnings("unchecked")
public class RedBlackTree <K extends Comparable<K>, E> implements IBinarySearchTree<K, E> {
    private RBNode root;
    private int size;

    // a method that will allow me to properly put a node with a key & an element into this red black tree
    @Override
    public void put(K key, E element) {
        RBNode newNode = new RBNode(key, element); // create a new node so we may place it properly
        if (root == null){ // there are no nodes yet...
            root = newNode; // so the new node is the root!
            root.setBlack(); // make sure the root is always black!
            size = 1;
        }
        else{ // otherwise we gotta do some searching to place it properly
            RBNode current = root; // start from the top
            RBNode parent; // we need to have a reference to the current node's parent for re-wiring
            while(true){ // enter the while loop to allow us to search properly
                parent = current; // this will place parent one step behind current
                // check to see if our key is less than the current key
                if(newNode.getKey().compareTo(current.getKey())<= -1){
                    current = current.getLeft(); // move to the left again
                    if(current == null){ // if there are no more left nodes at this point...
                        parent.setLeft(newNode); // set that left parent reference!
                        newNode.setParent(parent);
                        size += 1;
                        break;
                    }
                } // END GO LEFT
                else { // we are gonna go to the right if our key >= the current key
                    current = current.getRight(); // move to the right
                    if(current == null){ // if we have gone all the way to the right...
                        parent.setRight(newNode); // set that right parent reference!
                        newNode.setParent(parent);
                        size += 1;
                        break;
                    }
                } // END GO RIGHT
            } // END WHILE LOOP
            // BALANCE THE TREE FROM THE NEW NODE WE HAVE JUST PLACED!
            balanceTree(newNode);
            root.setBlack(); // make sure the root is always black!
        } // END ELSE NOT ROOT


    }

    // a helper method that will balance this red black tree by utilizing smaller methods
    private void balanceTree(RBNode currentNode){

        // check to see if this node's parent is the root
        if(currentNode.getParent() == root){
            return; // if it is, then we do nothing!
        }

        // if this node's parent is black (this root will be red)...
        else if(currentNode.getParent().isBlack()){
            return; // then we don't have to balance!
        }

        // if the node we are looking at is black...
        else if(currentNode.isBlack()){
            // we are going to go up the tree and see if we need to balance
            balanceTree(currentNode.getParent());
        }

        // CASE: GRANDPARENT IS THE ROOT
        else if(currentNode.getParent().getParent().getParent() == null){

            // CHECK TO SEE IF THE PARENT IS A LEFT CHILD
            if(currentNode.getParent().getParent().getLeft() == currentNode.getParent()){

                // CHECK TO SEE IF THE PARENT'S SIBLING IS NULL OR BLACK (NULL FIRST)
                if(currentNode.getParent().getParent().getRight() == null ||
                        currentNode.getParent().getParent().getRight().isBlack()){

                    // CHECK TO SEE IF THE CURRENT IS A LEFT CHILD OF ITS PARENT
                    if(currentNode.getParent().getLeft() == currentNode){
                        rootRotateRight(currentNode);
                    }
                    // CHECK TO SEE IF THE CURRENT IS A RIGHT CHILD OF ITS PARENT
                    else if (currentNode.getParent().getRight() == currentNode){
                        rootLeftRestructure(currentNode);
                    }

                }

                // IF THE PARENT'S SIBLING IS RED
                else{
                    rootLeftRecolor(currentNode);
                }
            }

            // CHECK TO SEE IF THE PARENT IS A RIGHT CHILD
            else if (currentNode.getParent().getParent().getRight() == currentNode.getParent()){

                // CHECK TO SEE IF THE PARENT'S SIBLING IS NULL OR BLACK (NULL FIRST)
                if(currentNode.getParent().getParent().getLeft() == null ||
                        currentNode.getParent().getParent().getLeft().isBlack()){

                    // CHECK TO SEE IF THE CURRENT IS A LEFT CHILD OF ITS PARENT
                    if(currentNode.getParent().getLeft() == currentNode){
                        rootRightRestructure(currentNode);
                    }
                    // CHECK TO SEE IF THE CURRENT IS A RIGHT CHILD OF ITS PARENT
                    else if (currentNode.getParent().getRight() == currentNode){
                        rootRotateLeft(currentNode);
                    }

                }

                // IF THE PARENT'S SIBLING IS RED
                else{
                    rootRightRecolor(currentNode);
                }
            }
        }

        // CASE: GRANDPARENT IS NOT THE ROOT
        else if (currentNode.getParent().getParent() != root){

            // CHECK TO SEE IF THE PARENT IS A LEFT CHILD
            if(currentNode.getParent().getParent().getLeft() == currentNode.getParent()){

                // CHECK TO SEE IF THE PARENT'S SIBLING IS NULL OR BLACK (NULL FIRST)
                if(currentNode.getParent().getParent().getRight() == null ||
                        currentNode.getParent().getParent().getRight().isBlack()){

                    // CHECK TO SEE IF THE CURRENT IS A LEFT CHILD OF ITS PARENT
                    if(currentNode.getParent().getLeft() == currentNode){
                        rotateRight(currentNode);
                    }
                    // CHECK TO SEE IF THE CURRENT IS A RIGHT CHILD OF ITS PARENT
                    else if (currentNode.getParent().getRight() == currentNode){
                        leftRestructure(currentNode);
                    }
                }

                // IF THE PARENT'S SIBLING IS RED
                else{
                    leftRecolor(currentNode);
                }
            }

            // CHECK TO SEE IF THE PARENT IS A RIGHT CHILD
            else if (currentNode.getParent().getParent().getRight() == currentNode.getParent()){

                // CHECK TO SEE IF THE PARENT'S SIBLING IS NULL OR BLACK (NULL FIRST)
                if(currentNode.getParent().getParent().getLeft() == null ||
                        currentNode.getParent().getParent().getLeft().isBlack()){

                    // CHECK TO SEE IF THE CURRENT IS A LEFT CHILD OF ITS PARENT
                    if(currentNode.getParent().getLeft() == currentNode){
                        rightRestructure(currentNode);
                    }
                    // CHECK TO SEE IF THE CURRENT IS A RIGHT CHILD OF ITS PARENT
                    else if (currentNode.getParent().getRight() == currentNode){
                        rotateLeft(currentNode);
                    }

                }

                // IF THE PARENT'S SIBLING IS RED
                else{
                    rightRecolor(currentNode);
                }
            }
        }
        if (currentNode.getParent() != null && currentNode.getParent().getParent() != null) {
            balanceTree(currentNode.getParent());
        }
    }

    // A method that will handle a special case for our red black tree balanceTree() method
    private void setRoot(RBNode localRoot){
        // Turn the local root black
        localRoot.setBlack();
        // Remove the parent
        localRoot.removeParent();
        // set the root of this tree to the local root that was entered
        root = localRoot;
    }

    // a helper method to rotate a root right
    private void rootRotateRight(RBNode localRoot){
        RBNode tempLocalRoot = root; // create a copy reference of what was passed in
        tempLocalRoot.setRed(); // set its color to red

        // Check if the "sister" node (child's sibling) (parent's right child) is  NOT null
        if (localRoot.getParent().getRight() != null){
            // add the parent's right child as a left child to the temporary
            tempLocalRoot.setLeft(localRoot.getParent().getRight());
        }

        // otherwise if the "sister" node of the local root IS null
        else { // if (localRoot.getParent().getRight() == null)
            // remove the left child of tempLocalRoot
            tempLocalRoot.removeLeft();
        }

        // set the parent's right child to the temporaryLocalRoot
        localRoot.getParent().setRight(tempLocalRoot);
        // call setRoot method
        setRoot(localRoot.getParent());
    }

    // a helper method to rotate a root left
    private void rootRotateLeft(RBNode localRoot){
        RBNode tempLocalRoot = root; // create a copy reference of what was passed in
        tempLocalRoot.setRed(); // set its color to red

        // Check if the "sister" node (child's sibling) (parent's right child) is  NOT null
        if (localRoot.getParent().getLeft() != null){
            // add the parent's right child as a right child to the temporary
            tempLocalRoot.setRight(localRoot.getParent().getLeft());
        }

        // otherwise if the "sister" node of the local root IS null
        else { // if (localRoot.getParent().getLeft() == null)
            // remove the right child of tempLocalRoot
            tempLocalRoot.removeRight();
        }
        tempLocalRoot.setParent(localRoot.getParent());
        // set the parent's left child to the temporaryLocalRoot
        localRoot.getParent().setLeft(tempLocalRoot);
        // call setRoot method
        setRoot(localRoot.getParent());

    }

    // a method that will restructure the tree when the parent is a left child
    private void rootLeftRestructure(RBNode localRoot){
        RBNode tempRoot = root; // create a temp working copy of the local root
        tempRoot.setRed(); // set the color of temp to red
        tempRoot.removeLeft();// remove temps left child
        localRoot.getParent().removeRight(); // remove parents right child
        localRoot.setLeft(localRoot.getParent()); // add parent as local root's left child
        localRoot.setRight(tempRoot); // add temp as current's right child

        setRoot(localRoot); // call the setRoot() method!
    }

    // a method that will restructure the tree when the parent is a right child
    private void rootRightRestructure(RBNode localRoot){
        RBNode tempRoot = root; // create a temp working copy of the local root
        tempRoot.setRed(); // set the color of temp to red
        tempRoot.removeRight();// remove temps left child
        localRoot.getParent().removeLeft(); // remove parents right child
        localRoot.setRight(localRoot.getParent()); // add parent as local root's left child
        localRoot.setLeft(tempRoot); // add temp as current's right child

        setRoot(localRoot); // call the setRoot() method!
    }

    // a method that will handle re-coloring roots if the grandparent is the root
    private void rootLeftRecolor(RBNode localRoot){
        localRoot.getParent().setBlack(); // set parent to black
        localRoot.getParent().getParent().getRight().setBlack(); // set parent's parent's right sibling to black
    }

    // a method that will handle re-coloring roots if the grandparent is the root
    private void rootRightRecolor(RBNode localRoot){
        localRoot.getParent().setBlack(); // set parent to black
        localRoot.getParent().getParent().getLeft().setBlack(); // set parent's parent's left sibling to black
    }

    // ENTERING THE EXCITING REALM OF NON-ROOT-BASED-RECONSTRUCTION

    // a method that will handle re-coloring roots if the grandparent is NOT the root
    private void leftRecolor(RBNode localRoot){
        localRoot.getParent().setBlack(); // set parent to black
        localRoot.getParent().getParent().getRight().setBlack(); // set parent's parent's right sibling to black

        localRoot.getParent().getParent().setRed(); // set grandparent to RED
    }

    // a method that will handle re-coloring roots if the grandparent is NOT the root
    private void rightRecolor(RBNode localRoot){
        localRoot.getParent().setBlack(); // set parent to black
        localRoot.getParent().getParent().getLeft().setBlack(); // set parent's parent's left sibling to black

        localRoot.getParent().getParent().setRed(); // set grandparent to RED
    }

    // a helper method to rotate the tree RIGHT if the grandparent is NOT the root
    private void rotateRight(RBNode localRoot){
        RBNode tempRoot = localRoot.getParent().getParent(); // save grandparent as temporary local root
        tempRoot.setRed(); // set the temp to red
        localRoot.getParent().setBlack(); // set the parent to black

        if(tempRoot.getParent().getRight() == tempRoot) { // check if the grandparent is a right child
            // add the parent as the right child of the great grandparent
            tempRoot.getParent().setRight(localRoot.getParent());
        }

        else{
            // add the parent as the left child of the great grandparent
            tempRoot.getParent().setLeft(localRoot.getParent());
        }

        if(localRoot.getParent().getRight() != null) {// if the parent's right child is not null
            tempRoot.setLeft(localRoot.getParent().getRight()); // add it to temp's left child
        }

        else{ // remove temp's left child
            tempRoot.removeLeft();
        }

        localRoot.getParent().setRight(tempRoot); // add temp as the right child of the parent
    }

    // a helper method to rotate the tree LEFT if the grandparent is NOT the root
    private void rotateLeft(RBNode localRoot){
        RBNode tempRoot = localRoot.getParent().getParent(); // save grandparent as temporary local root
        tempRoot.setRed(); // set the temp to red
        localRoot.getParent().setBlack(); // set the parent to black

        if(tempRoot.getParent().getLeft() == tempRoot) { // check if the grandparent is a right child
            // add the parent as the left child of the great grandparent
            tempRoot.getParent().setLeft(localRoot.getParent());
        }

        else{
            // add the parent as the right child of the great grandparent
            tempRoot.getParent().setRight(localRoot.getParent());
        }

        if(localRoot.getParent().getLeft() != null) {// if the parent's right child is not null
            tempRoot.setRight(localRoot.getParent().getLeft()); // add it to temp's left child
        }

        else{ // remove temp's left child
            tempRoot.removeRight();
        }

        localRoot.getParent().setLeft(tempRoot); // add temp as the right child of the parent
    }

    // a helper method to restructure the tree if the grandparent is NOT the root
    private void leftRestructure(RBNode localRoot){
        RBNode tempRoot = localRoot.getParent().getParent(); // save the granparent into a temp variable
        tempRoot.setRed(); // set temp to red
        localRoot.setBlack(); // set local root to black
        localRoot.getParent().removeRight(); // remove parent's right child
        tempRoot.removeLeft(); // remove temp's left child
        localRoot.setLeft(localRoot.getParent()); // add the parent as the localRoot's left Child

        // check if temp is right child
        if(tempRoot.getParent().getRight() == tempRoot){
            tempRoot.getParent().setRight(localRoot); // add local root as temps parent's right child
        }

        else { // add local root as temp's parent's left child
            tempRoot.getParent().setLeft(localRoot);
        }

        // add temp as local root's right child
        localRoot.setRight(tempRoot);
    }

    // a helper method to restructure the tree if the grandparent is NOT the root
    private void rightRestructure(RBNode localRoot){
        RBNode tempRoot = localRoot.getParent().getParent(); // save the grandparent into a temp variable
        tempRoot.setRed(); // set temp to red
        localRoot.setBlack(); // set local root to black
        localRoot.getParent().removeLeft(); // remove parent's left child
        tempRoot.removeRight(); // remove temp's right child
        localRoot.setRight(localRoot.getParent()); // add the parent as the localRoot's right Child

        // check if temp is left child
        if(tempRoot.getParent().getRight() == tempRoot){
            tempRoot.getParent().setRight(localRoot); // add local root as temps parent's left child
        }

        else { // add local root as temp's parent's right child
            tempRoot.getParent().setLeft(localRoot);
        }

        // add temp as local root's left child
        localRoot.setLeft(tempRoot);
    }


    // a method that will allow me to grab the element with the specified key in this red black tree
    @Override
    public E get(K key) {
        RBNode current = root; // start from the top of the tree
        while(current.getKey() != key){ // begin searching for an item with the same key
            if(key.compareTo((K) current.getKey()) < 0){ // if what we are looking for is < where we are at...
                current = current.getLeft(); // then we are going to go to the left
            } // END GO LEFT
            else if (key.compareTo((K) current.getKey()) > 0){ // if what we are looking for is > where we are at
                current = current.getRight(); // then we are going to go to the right
            } // END GO RIGHT
            else{
                return (E) current.getParent().getElement();
            }
            if(current == null){ // if we did not find the item we were looking for...
                throw(new NoSuchElementException());
                //return null; // return null to the user
            } // END DID NOT FIND
        } // END WHILE LOOP
        return  (E) current.getElement(); // return the node to the user
    } // END get()

    // a method that will return the size of this red black tree
    @Override
    public int size() {
        return size;
    }


    // a method that will determine the height of this red black tree and return it to the user
    @Override
    public int getHeight() {
        if(size == 0) return 0; // handle tree sizes of 1 or 0
        return getHeightRecursive(root) - 1; // subtract one to handle not counting the root
    }

    // a method that will determine the height of this red black tree through the use of recursion
    private int getHeightRecursive(RBNode localRoot) {
        // if the local root is a null, return 0 (BASE CASE)
        if (localRoot == null){
            return 0;
        }
        // otherwise, find the max height between the left & right side of the tree and return it
        else{
            return 1 + Math.max(getHeightRecursive(localRoot.getLeft()), getHeightRecursive(localRoot.getRight()));
        }
    }

    // a method that will properly print out the tree in the form of a string
    @Override
    public String getTreeString() { // will print out the contents of the tree in order
        if (root == null) return "[]"; // handle the edge case
        return getTreeStringRecursive(root); // otherwise call the recursive method
    }

    public String getTreeStringRecursive(RBNode localRoot){
        String s = "["; // each call means that we are entering a child's branch
        if(localRoot != null) { // if we aren't dealing with an empty root
            s += localRoot.getColor() + ", " + localRoot.getKey() + ", "; // print out the key and a comma
            if(localRoot.getLeft() == null){ // handle the event the the left child is null
                s += "null, ";
            }
            else{ // handle the event the the left child is not null
                s += getTreeStringRecursive(localRoot.getLeft()) + ", "; // append the recursive call to the string
            }
            if(localRoot.getRight() != null){ // check if the right child exists
                s += getTreeStringRecursive(localRoot.getRight()); // append the recursive call to the string
            }
            else{ // if the right child is null, handle it
                s += "null";
            }
            s += "]"; // add a closing bracket
            return s; // return s to the method that called it
        }
        return s; // return the string to the user regardless
    }

    // a method that will properly print out the tree's key and value pairs
    public String toString(){ // this method will call a recursive print method to print the tree's keys & elements
        return "[" + toStringRecursive(root) + "]";
    }

    private String toStringRecursive(RBNode localRoot){
        String s = ""; // initialize an empty string upon each call
        if(localRoot != null){ // if we aren't dealing with an empty root
            if(localRoot.getLeft() != null) { // check to see if the left child exists
                s += toStringRecursive(localRoot.getLeft()) + ", "; // append the recursive call to the string
            }
            s +=  localRoot.getKey() + ": " + localRoot.getElement(); // append ": " and the element to the string
            if(localRoot.getRight() != null){ // check if the right child exists
                s += ", "; // if it does, than we need a comma
                s += toStringRecursive(localRoot.getRight()); // append the recursive call to the string
            }
            return s; // return s to the method that called it
        }
        return ""; // if the local root is null, return an empty string
    }

    public static void main(String[] args) {

        RedBlackTree<Integer, String> tree = new RedBlackTree<>();

        tree.put(2, "Two");
        tree.put(1, "One");
        tree.put(3, "Three");

        System.out.println(tree.getTreeString());
    }
}
