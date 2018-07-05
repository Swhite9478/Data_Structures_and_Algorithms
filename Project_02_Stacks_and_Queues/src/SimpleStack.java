import javax.xml.soap.Node;

/**
 * Created by Stephen White on 10/19/2016.
 *
 * Goal: to simulate a generic stack through a singly linked list
 *
 */
public class SimpleStack <T> implements Stack<T>{
    private int numberOfItemsOnThisStack;
    MyLinkedList<T> stack; // the stack is an instance of a singly linked list

    public SimpleStack(){ // the constructor will create a generic stack
        this.numberOfItemsOnThisStack = 0;
        stack = new MyLinkedList<T>();
    }

    @Override
    public void push(T new_item) { // push the item onto the stack through linked list method addLink()
        stack.addLink(new_item);
        numberOfItemsOnThisStack++;

    }

    @Override
    public T pop() { // pop an item off the stack through linked list method removeLink()
        if (stack.isEmpty()) return null;
        numberOfItemsOnThisStack--;
        return stack.removeLink();
    }

    @Override
    public T peek() {
        return stack.peek();
    } // peek at the top of the stack through linked list peek() method

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    } // check to see if there is nothing on the stack

    @Override
    public int size() {
        return stack.getNumLinks();
    } // obtain the stack's size
}
