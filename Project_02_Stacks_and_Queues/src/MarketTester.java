/**
 * Created by Stephen White on 10/17/2016.
 *
 * A class designed by me to test my market in any way that I please.
 *
 */
public class MarketTester {
    public static void main(String[] args) {
        SupermarketCheckouts market = new SupermarketCheckouts();
       market.buildMarket(3,3);
        Customer c = new Customer((3));
        Customer d = new Customer(2);
        Customer e = new Customer(1);
        System.out.println(market);
        market.addCustomer(3);
        System.out.println(market);
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);

/*
        System.out.println("---------------------------------------");
        System.out.println("POPULATING THE MARKETPLACE\n");

        market.addCustomer(3);
        System.out.println(market);
        market.addCustomer(2);
        System.out.println(market);
        market.addCustomer(1);
        System.out.println(market);

        market.addCustomer(2);
        System.out.println(market);
        market.addCustomer(1);
        System.out.println(market);
        market.addCustomer(2);
        System.out.println(market);

        market.addCustomer(1);
        System.out.println(market);
        market.addCustomer(3);
        System.out.println(market);
        market.addCustomer(3);
        System.out.println(market);

        System.out.println("---------------------------------------");
        System.out.println("Attempting overflow");

        market.addCustomer(1);
        market.addCustomer(3);
        market.addCustomer(2);
        System.out.println("---------------------------------------");
        System.out.println("\n" + market);

        System.out.println("---------------------------------------");
        System.out.println("BEGIN TICKING NOW");
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);
        System.out.println("ADDING CUSTOMER WITH 3 ITEMS");
        market.addCustomer(3);
        System.out.println(market);
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);
        market.tick();
        System.out.println(market);
        System.out.println("ADDING CUSTOMER WITH 5 ITEMS");
        market.addCustomer(5);
        System.out.println(market);*/




        Clerk clerk = new Clerk(3);
        /*System.out.println("THIS LINE HAS A CAPACITY OF: " + clerk.getLineCapacity());
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        System.out.println("Is this line empty: " + clerk.lineIsEmpty());
        System.out.println("Is this line full: " + clerk.lineIsFull());
        System.out.println("\n------------------------------------------------------");
        System.out.println("LET'S ADD SOME ITEMS");
        System.out.println(clerk);
        clerk.addCustomerToThisLine(c);
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        clerk.addCustomerToThisLine(d);
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        clerk.addCustomerToThisLine(e);
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
       // System.out.println(c);
       // System.out.println(d);
        //System.out.println(e);
        System.out.println("Is this line empty: " + clerk.lineIsEmpty());
        System.out.println("Is this line full: " + clerk.lineIsFull());
        System.out.println("Attempting to add one more person: ");
        clerk.addCustomerToThisLine(new Customer(3));
        System.out.println("\n------------------------------------------------------");
        System.out.println("LET'S REMOVE SOME ITEMS");
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        clerk.removeCustomerFromLine();
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        clerk.removeCustomerFromLine();
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        clerk.removeCustomerFromLine();
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        System.out.println("Attempting to remove one more person...");
        clerk.removeCustomerFromLine();
        System.out.println("Number of people in this line: " + clerk.getNumOfCustomersInThisLine());
        System.out.println(clerk);
        System.out.println("\n------------------------------------------");
        System.out.println("Let's Check our pointers with a new clerk");
        Clerk clerk2 = new Clerk(3);
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());
        System.out.println("\nAdding one person (F = 0, B = 1)...");
        clerk2.addCustomerToThisLine(c);
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println("\nAdding one person (F = 0, B = 2)...");
        clerk2.addCustomerToThisLine(d);
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println("\nAdding one person (F = 0, B = 3)...");
        clerk2.addCustomerToThisLine(e);
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println("\nRemoving one person (F = 1, B = 3)...");
        clerk2.removeCustomerFromLine();
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println("\nRemoving one person (F = 2, B = 3)...");
        clerk2.removeCustomerFromLine();
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println("\nAdding one person (F = 2, B = 0)...");
        clerk2.addCustomerToThisLine(c);
        System.out.println("Front pointer: " + clerk2.getFirstCustomerInLineIndex());
        System.out.println("Back pointer: " + clerk2.getLastCustomerInLineIndex());

        System.out.println(clerk2);*/



    }
}
