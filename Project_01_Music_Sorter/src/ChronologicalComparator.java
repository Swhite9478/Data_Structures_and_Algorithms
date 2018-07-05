import java.util.Comparator;

/**
 * Created by Stephen White on 9/29/2016.
 *
 * A comparator that will sort by year ascending, album name alphabetically, and track number ascending.
 */
public class ChronologicalComparator  implements Comparator<MusicTrack>{

    @Override
    public int compare(MusicTrack o1, MusicTrack o2) {

        // Obtain all relevant information for comparing
        int year1 = o1.getYear();
        int year2 = o2.getYear();
        int trackNumber1 = o1.getTrackNumber();
        int trackNumber2 = o2.getTrackNumber();
        String album1Name = o1.getAlbumName();
        String album2Name = o2.getAlbumName();

        // Compare year ascending, album name alphabetically, and track number ascending.

        // Compare year ascending
        if (year1 > year2) return 1; // if track 1 # > rack 2 #, return 1
        else if (year1 < year2) return -1; // otherwise return -1 ( track 1 # < track 2 #)

        // Compare album name alphabetically
        if (album1Name.compareTo(album2Name) == 1) return 1;
        else if (album1Name.compareTo(album2Name) == -1) return -1;

        // Compare track number ascending
        if (trackNumber1 > trackNumber2) return 1;
        else if (trackNumber1 < trackNumber2) return -1;
        else return 0;

        }
    }
