/**
 * Created by smw44 on 10/17/2016.
 *
 * A class that models a customer in a supermarket
 *
 */
public class Customer {
    private int numItems;

    public Customer(){ // constructor for a new customer
        this.numItems = 0; // when they enter the store, they do not have any items yet
    }

    public String toString(){
        String s = "";
        s += "A person with " + numItems + " items. ";
        return s;
    }

    public Customer(int numItems){
        this.numItems = numItems;
    }

    public void addItem(int item){ // add any # of items to their cart
        numItems++; // increment the number of items in the customer's cart
    }

    public void removeItem(){ // allow the clerk to take an item out of the customer's cart
        numItems--; // decrement the number of items in the customer's cart
    }

    public int getNumItems(){ // allow the clerk to see how many items the customer has.
        return this.numItems;
    } // obtain the # items that a person has

}
