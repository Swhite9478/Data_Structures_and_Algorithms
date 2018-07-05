import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Stephen White  on 9/29/2016.
 *
 * A class to see if I can sort every list in every way
 */
public class MusicSortMain {
    public static  void main(String[] args) {
        ISorter sorter = new InsertionSorter(); // change to whatever sorter you want to use
        Comparator<MusicTrack> comp = new HotAndNewComparator(); // change to whatever comparator you want
        List<MusicTrack> library = MusicTrack.generateMusicLibrary(); // generate the music

        // See what the music looks like unsorted
        for (int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i));
        }
        // Sort the music
        sorter.sort(library, comp);
        // see what the music looks like after sorting it
        System.out.println("\n\n\n");
        for (int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i));
        }



    }
}

//LOOK AT SELECTION SORT ALGORITHM, IT MAY BE BROKEN
