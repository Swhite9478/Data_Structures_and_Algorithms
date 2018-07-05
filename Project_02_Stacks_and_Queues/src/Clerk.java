import java.util.NoSuchElementException;

/**
 * Created by smw44 on 10/17/2016.
 *
 * Models a store clerk. Responsible for one single checkout line
 *
 * has a line capacity
 */
public class Clerk {
    private int lineCapacity; // will determine how many customers can stand in this line
    private int numOfCustomersInThisLine;
    private Customer[] checkoutLine;
    private int firstCustomerInLineIndex;
    private int lastCustomerInLineIndex;

    public Clerk(int lineCapacity){
        this.lineCapacity = lineCapacity;
        this.numOfCustomersInThisLine = 0; // no customers in this line yet
        this.firstCustomerInLineIndex = 0; // front of the line is @ index 0
        this.lastCustomerInLineIndex = 0; // end of the line is @ index 0
        checkoutLine = new Customer[lineCapacity]; // create the checkout line
    }

    public String toString(){
        String s = "";
        s +=("PEOPLE IN THIS LINE: ");
        for(int i=0; i < checkoutLine.length; i++){
            if (checkoutLine[i] == null) s += "NULL ";
            else s +=  (Customer)(checkoutLine[i]);
        }
        return s;
    }

    public int getLineCapacity(){ // in the event we want to know how long this line can be
        return this.lineCapacity;
    }

    public boolean lineIsEmpty(){ // allows us to determine if the line is empty or not
        if (numOfCustomersInThisLine == 0) return true; // if there are no customers in this line, it is empty
        else return false; // if people are in this line, return false
    }

    public boolean lineIsFull(){ // allows us to determine if the line is full or not
        if (numOfCustomersInThisLine >= lineCapacity)return true; // if the line is at capacity, it is full
        else return false; // otherwise there is space open
    }

    public int getFirstCustomerInLineIndex(){ // will be altered when we remove customers from the line
        return  firstCustomerInLineIndex;
    }

    public int getLastCustomerInLineIndex(){ // will be altered when we add customers to the line
        return lastCustomerInLineIndex;
    }

    public void addCustomerToThisLine(Customer customer){ // we only add to the back of the line
        // we can only add to the line if it is empty or not full
        if (!lineIsFull()) {
            if (lastCustomerInLineIndex >= lineCapacity) {
                lastCustomerInLineIndex = 0;
                checkoutLine[lastCustomerInLineIndex] = customer;
                lastCustomerInLineIndex++;
                numOfCustomersInThisLine++;
                return;
            }
            else {
                checkoutLine[lastCustomerInLineIndex] = customer; // place that customer in the next spot
                lastCustomerInLineIndex++; // increment the index to keep track of the last person
                numOfCustomersInThisLine++;
                return;
            }
        }
        System.out.println("ERROR: LINE IS FULL, & PERSON CANNOT BE ADDED TO THE LINE AT THIS TIME.");
        return;
    }

    // allow the clerk to take each individual item from the customer upon a tick() of time
    public int takeItemFromCustomer(){
        int numberOfPeopleCheckingOut = 0;

        if(checkoutLine[firstCustomerInLineIndex] == null){
            return 0;
        }

        if (firstCustomerInLineIndex >= lineCapacity){
            firstCustomerInLineIndex = 0;
        }
        else if(checkoutLine[firstCustomerInLineIndex].getNumItems() <= 0) { // if the customer is out of items...
            removeCustomerFromLine(); // check them out and remove them from the line
            numberOfPeopleCheckingOut++;
            return numberOfPeopleCheckingOut; // no items are taken from the customer, they are checking out
            }
        else {
            //System.out.println("TAKING ITEM");
            checkoutLine[firstCustomerInLineIndex].removeItem(); // take one item from that customer
            //} catch (ArrayIndexOutOfBoundsException e){}
            return 0; // return 0 if nobody has been checked out from this line upon this tick()
        }
        return numberOfPeopleCheckingOut;
    }

    public void removeCustomerFromLine(){ // we only want to remove customers from the front of the line
        // don't do anything if the object being referenced does not exist
        if(checkoutLine[firstCustomerInLineIndex] == null){
            return;
        }
        // don't allow a user to remove a customer from an empty line
        if(numOfCustomersInThisLine <= 0){
            System.out.println("ERROR: LINE IS EMPTY, NOBODY ELSE CAN BE REMOVED.");
            return; // if there are not customers in the line
        }
        // reset the first customer index to the beginning of the line if it's out of bounds
        if (firstCustomerInLineIndex >= lineCapacity){
            firstCustomerInLineIndex = 0;
            checkoutLine[firstCustomerInLineIndex] = null;
            numOfCustomersInThisLine--;
            firstCustomerInLineIndex++;
            return;
        }
        else { // overwrite the first customer in line index
            checkoutLine[firstCustomerInLineIndex] = null;
            firstCustomerInLineIndex++;
            numOfCustomersInThisLine--;
            return;
        }
    }

    public int getNumOfCustomersInThisLine(){
        return numOfCustomersInThisLine;
    }

}
