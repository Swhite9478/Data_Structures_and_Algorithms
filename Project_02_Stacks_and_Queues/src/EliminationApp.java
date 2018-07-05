import static java.lang.System.out;
import java.util.Random;

/**
 * Created by Stephen White on 10/20/2016.
 *
 * Goal: To simulate an elimination game similar to Duck, Duck, Goose, without the chasing
 *
 */
public class EliminationApp implements Elimination {
    // create a circular linked list of type Player so we can play this game
    CircularLinkedList<Player> circle = new CircularLinkedList<Player>();
    private int numPlayers; // an integer representation of the number of players in the game
    private Player[] losers; // an array to store the losers of the game
    private int eliminationNumber; // elimination number from constructor is stored here

    @Override
    public void init(int numPlayers, int elimNumber) { // Initialize a game with a # of players and elimination #
        this.eliminationNumber = elimNumber; // set the elimination number
        this.numPlayers = numPlayers; // set the max # players
        circle.setMaxNodes(numPlayers); // set the max # nodes in the linked list
        // set up player names for the # players present
        for (int i=1; i <= numPlayers; i++){
            String playerName = "player" + (Integer.toString(i));
            circle.addNode(new Node(new Player(playerName)));
        }
    }

    @Override
    public boolean currentIsWinner() {
        return circle.isWinner();
    } // determine if their is one player left

    @Override
    public int getEliminationNumber() {
        return this.eliminationNumber;
    } // retrieve elimination number for tick()

    @Override
    public String getCurrentPlayerName() { // cycle through the list and find a the current node
        Node<Player> playerNode  = circle.getNode(eliminationNumber); // will find node @ "index" 25
        Player player = playerNode.element; // obtain the element
        String playerName = player.getName(); // get the name  of the person
        return playerName; // return that name
    }

    @Override
    public String tick() { // remove the player at the specified elimination number
        int eliminationNumber = getEliminationNumber(); // get the elimination number for this tick
        Node<Player> eliminatedPlayer = circle.removeNode(eliminationNumber); // aquire the node
        Player eliminated = eliminatedPlayer.element; // obtain its element
        if (eliminated == null) return null; // if it does not exist, exit the tick() by returning null.
        String player_name = eliminated.getName(); // aquire the player's name
        //out.println("REMOVED: " + player_name);
        return player_name; // return the name of the loser
    }

    public String toString(){ // What does it mean to print out an elimination game?
        String s = "";
        s += circle;
        return  s; // print out the Linked List!
    }

    // Main method for testing
    public static void main(String[] args){
        EliminationApp game = new EliminationApp();
        game.init(10,25);
        out.println("ELIMINATION NUMBER: " + game.getEliminationNumber());
        //out.println(game);
        for(int i=0;i<10;i++){
            out.println(game);
            game.tick();
        }
        //out.println("Winner: " + game);
        String winner = game.tick();
        out.println("Winner was: " + winner);
        //out.println(game.currentIsWinner());

    }
}


