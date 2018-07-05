/**
 * Created by Stephen White on 10/20/2016.
 *
 * A player that will be utilized in the Elimination game
 *
 */
public class Player {
    private String name;

    public Player(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name =name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name;
    }
}

