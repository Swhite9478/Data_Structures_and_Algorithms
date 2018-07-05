

/**
 * Created by Stephen White on 10/20/2016.
 *
 * A Generic Link Class that will be utilized in stack
 *
 */
public class Link<T> {
    public Link<T> nextLink; // This link knows about the next link
    public T element; // the type of object this Link contains

    public Link(T element){ // pass in the type of object in the Link's constructor
        this.element = element; // the type of element this link contains
    }

    public String toString(){ // what it means to print out a link
        String s = "";
        s += element.toString();
        return s;
    }
}
