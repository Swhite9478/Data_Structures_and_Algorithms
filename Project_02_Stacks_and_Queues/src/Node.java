import static java.lang.System.out;

/**
 * Created by Stephen White on 10/20/2016.
 *
 * A generic Node class which will be utilized in a singularly linked, circular list
 *
 */
public class Node <T>{
    public T element; // the type of object the Node holds
    public Node<T> nextNode; // every Node must know about the Node in front of it

    public Node(T object){
        element = object;
    } // A constructor allowing me to obtain the object's type


    public String toString(){
        return (element.toString());
    } // will print out the object's toString()
}
