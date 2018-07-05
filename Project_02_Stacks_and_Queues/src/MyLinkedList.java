import static java.lang.System.out;

/**
 * Created by Stephen White on 10/20/2016.
 *
 * A singly linked list that will be the basis for a simple stack
 *
 */
public class MyLinkedList<T> {
    public Link<T> firstLink; // the whole list keeps track of what the first link is
    public int numLinks; // keep track of the # links in list

    public MyLinkedList(){ // constructor explicitly sets values
        firstLink = null;
        numLinks = 0;
    }

    public boolean isEmpty(){
        return (firstLink == null);
    } // empty if first link has no value

    public int getNumLinks(){
        return this.numLinks;
    } // return # links in the list

    public void addLink(T object){ // add an object of type T to the list
        Link<T> link = new Link<T>(object); // attach that object to a Link/Node
        link.nextLink = firstLink; // set its next reference to first
        firstLink = link; // overwrite first link to be the new link
        numLinks++; // increment # links
    }

    public T removeLink(){ // take the first item out of the list to simulate stack-like behavior
        if (numLinks < 0) return null; // do not allow removal in an empty list
        Link<T> linkToReturn = firstLink; // want to return the first link (top of stack)
        T elementToReturn = linkToReturn.element; // obtain its element (type of object)
        firstLink = firstLink.nextLink; // overwrite first link's reference (simulate removal)
        return elementToReturn; // return the element from top of stack (simulate pop() behavior)
    }

    public T peek(){
        return firstLink.element;
    } // view what is on top of the "stack" (first in list)

    // Main method for testing linked list "stack" simulation
    public static void main(String[] args){
        MyLinkedList<Customer> list = new MyLinkedList<Customer>();
        Customer c = new Customer(3);
        Customer d = new Customer(2);
        Customer e = new Customer(1);

        list.addLink(c);
        list.addLink(d);
        list.addLink(e);
        for(int i=0; i<list.numLinks; i++){
            out.println(list.removeLink());
        }
        try{out.println(list.removeLink());}
        catch (NullPointerException f){}

    }
}
