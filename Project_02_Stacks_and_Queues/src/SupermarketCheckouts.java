import java.util.ArrayList;

/**
 * Created by smw44 on 10/17/2016.
 */
public class SupermarketCheckouts implements Supermarket {
    ArrayList<Clerk> clerkArray = new ArrayList<Clerk>();


    public SupermarketCheckouts(){
        // creates an empty supermarket
    }

    public String toString(){
        String s = "\nTotal number of lines in this market: " + clerkArray.size() + "\n";
        for (int i=0; i<clerkArray.size(); i++){
            s += (clerkArray.get(i) + "\n");
        }
        return s;
    }

    @Override
    public void buildMarket(int numClerks, int lineCapacity) {
        // check to make sure valid numbers were entered for numClerks and lineCapacity
        if(numClerks <=0 || lineCapacity <= 0) return; // don't allow stupidity!

        // add clerks to an array list of clerks (an array list of queues)
        for (int i=0; i<numClerks; i++){
            Clerk clerk = new Clerk(lineCapacity);
            clerkArray.add(clerk);
        }
    }
    @Override
    public boolean addCustomer(int numItems) throws ArrayIndexOutOfBoundsException{
        //System.out.println("LINE FULL?: " + clerkArray.get(0).getNumOfCustomersInThisLine());
        for(int i=0; i<clerkArray.size(); i++){ // check to see if every line is full
            if(!clerkArray.get(i).lineIsFull()) { // if any one line is not full, break the loop
                break;
            }
            // if any one line is full and we are not looking at the final line,
            // continue with another iteration and check the next line
            else if (clerkArray.get(i).lineIsFull() && i < clerkArray.size()-1){
                //System.out.println("This line is full, checking next line.");
                continue;
            }
            // if we have checked all prior lines and they are all full, return false
            else if (clerkArray.get(i).lineIsFull()  && i == clerkArray.size()-1) {
                //System.out.println("ERROR: LINE IS FULL, & PERSON CANNOT BE ADDED AT THIS TIME");
                return false;
            }

            else break;
        }

        Customer customer = new Customer(numItems); // create a new customer with # items

        // make sure the customer has at LEAST one item!
        if (customer.getNumItems() <= 0) return false;


        // try to find the smallest line
        int smallestLineIndex = 0; // an index in the clerk array that signifies the smallest line
        for (int i=0; i<clerkArray.size(); i++){
            if (clerkArray.get(i).getNumOfCustomersInThisLine() <
                    clerkArray.get(smallestLineIndex).getNumOfCustomersInThisLine()){
                        smallestLineIndex = i;
                }
            //System.out.println("i = : " + i);
            /*try{ // utilize a try block to try and find the the smallest line
                if(clerkArray.get(i).getNumOfCustomersInThisLine() <=
                        clerkArray.get(i+1).getNumOfCustomersInThisLine()){
                    smallestLineIndex = i; // obtain its index
                }
            }
            catch (ArrayIndexOutOfBoundsException e){System.out.println("ERROR");}
            // we know we will go beyond the arraylist bounds*/
        }
        Clerk smallestLine = clerkArray.get(smallestLineIndex); // the index of the smallest line
        // last ditch effort to check and see if we can add a person to this line
        smallestLine.addCustomerToThisLine(customer); // place that customer in the smallest line
        return true; // return true because we were able to add to this line
    }

    @Override
    public int tick() {
        int numberOfPeopleCheckingOutUponThisTick = 0;
        // check to see if no customers are in ANY line
        for(int i=0; i<clerkArray.size(); i++){
            // if there is nobody in the current line,  and we havent checked all lines,
            // continue through to the next iteration
            if (!clerkArray.get(i).lineIsEmpty() && !clerkArray.get(i).lineIsFull()) break;

            else if(clerkArray.get(i).lineIsEmpty() && i < clerkArray.size()-1)continue;

            // but if we have checked every single line, and every single line is empty,
            // return -1
            else if (clerkArray.get(i).lineIsEmpty() &&
                    i == clerkArray.size()-1) return -1;
        }

        // let's remove an item from each person in each check out line!
        for(int i=0; i<clerkArray.size(); i++){
            numberOfPeopleCheckingOutUponThisTick += clerkArray.get(i).takeItemFromCustomer();
        }
        if(numberOfPeopleCheckingOutUponThisTick == 0) return 0;
        else {
            return numberOfPeopleCheckingOutUponThisTick;
        }
    }
}
