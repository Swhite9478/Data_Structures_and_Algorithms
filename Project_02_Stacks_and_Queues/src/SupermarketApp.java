import java.util.Scanner;
import static java.lang.System.out;
import java.util.Random;

/**
 * Created by Stephen White on 10/19/2016.
 *
 * Goal: A class that models a supermarket that can add customers, and check customers out.
 *
 */
public class SupermarketApp {
    public static void main(String[] args){
        String input = ""; // whatever the user enters for commands will be pushed into this variable
        Scanner scanner = new Scanner(System.in); // this is our scanner to parse user input
        int numberOfDesiredClerks; // when the user enters a clerk number it will be stored here
        int desiredLineCapcity; // when a user enters a line capacity, it will be stored here
        Random rand = new Random(); // will be utilized to generate customers

        out.print("\nWelcome to Stephen's Super Market Express! Press 'c' to continue, or 'q' to quit: ");
        while (true ) {
            input = scanner.next();

            // If the user wishes to continue on with the program
            if (input.equalsIgnoreCase("c")) {
                out.println("\nENTERING MARKET...");
                // prompt the user for their desired number of clerks
                out.print("\nAlright boss, how many clerks are working today?: ");
                numberOfDesiredClerks = scanner.nextInt();
                out.print("Awesome! " + numberOfDesiredClerks + " is perfect!\n");
                out.print("\nNow remind me... what's the max number of people allowed in each line?: ");
                desiredLineCapcity = scanner.nextInt();
                while (true) { // give the user an opportunity to re-enter values
                    out.print("\nJust double checking, you wanted your store to have " + numberOfDesiredClerks +
                            " clerks, and a maximum line capacity of " + desiredLineCapcity + "\npeople per line. " +
                            "Is that correct? ('y' for yes, 'n' for no): ");
                    try{input = scanner.next();}
                    catch (java.util.InputMismatchException e) {
                        System.err.println(e.getMessage());
                        continue;
                    }

                    if (input.equalsIgnoreCase("y")) break; // if the user doesnt want to re-enter values

                    else if (input.equalsIgnoreCase("n")){ // if the user wanted to re-enter values...
                        out.print("\nGo ahead and re-enter the desired number of clerks: ");
                        try{numberOfDesiredClerks = scanner.nextInt();}
                        catch (java.util.InputMismatchException e){
                            System.err.println(e.getMessage());
                        }
                        out.print("Now re-enter the desired line capacity: ");
                        try{desiredLineCapcity = scanner.nextInt();}
                        catch (java.util.InputMismatchException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                } // END WHILE LOOP

                out.println("\nFantastic! Now let's get some customers in this place!");

                while (true) { // Allow the user the chance to generate the markey
                    out.print("\nType 'e' to generate your market: ");
                    try {input = scanner.next();}
                    catch (java.util.InputMismatchException e) {}
                    if (input.equals("e")) break;
                }
                SupermarketCheckouts market = new SupermarketCheckouts(); // construct market
                out.println("\nBuilding market....");
                market.buildMarket(numberOfDesiredClerks,desiredLineCapcity); // build market
                out.println("\nMarket has been built!");
                out.println("Here is your current Market:\n");
                out.println(market);

                while (true) {// Allow the user to control the market
                    out.print("Type 'a' to add customers to the line, 't' to tick through the checkout, " +
                            "'d' to display the lines, and 'q' to quit: ");
                    try{input = scanner.next();}
                    catch (java.util.InputMismatchException e){continue;}
                    if(input.equalsIgnoreCase("a")){
                        market.addCustomer((rand.nextInt(5)+1)); // add a customer with between 1-5 items
                    }

                    else if (input.equalsIgnoreCase("t")){ // allow the user to tick() through time
                        market.tick();
                    }

                    else if (input.equalsIgnoreCase("d")){ // allow the user to display the market
                        out.println("Here is your current Market:\n");
                        out.println(market);
                    }

                    else if (input.equalsIgnoreCase("q")){ // allow the user to quit
                        break;
                    }

                    else{ // make sure the user enters a valid character
                        out.println("Please enter a valid character!");
                        continue;
                    }


                }

                // when the user is finished controlling the market, display it one more time
                out.println("\nHere is your final market!");
                out.println(market);
                break;
            }

            // if the user does not wish to continue, terminate the program
            else if (input.equalsIgnoreCase("q")) {
                System.out.println("Y'all come back now ya hear!");
                break;
            }

            // if the user enters an invalid character, prompt them for valid input
            else {
                System.out.print("Please enter a valid character ('c' to continue, or 'q' to quit): ");
            }
        }
    }
}
