import java.util.Comparator;

/**
 * Created by Stephen White on 9/29/2016.
 *
 * A comparator that will sort by song rating descending, year descending,
 * artist name alphabetically, album name alphabetically, and track ascending
 */
public class HotAndNewComparator implements Comparator<MusicTrack>{

    @Override
    public int compare(MusicTrack o1, MusicTrack o2) { // coompare music tracks

        // Obtain all relevant information for comparing
        int track1Number = o1.getTrackNumber();
        int track2Number = o2.getTrackNumber();
        int year1 = o1.getYear();
        int year2 = o2.getYear();
        int songRating1 = o1.getRating();
        int songRating2 = o2.getRating();
        String artist1Name = o1.getArtistName();
        String artist2Name = o2.getArtistName();
        String album1Name = o1.getAlbumName();
        String album2Name = o2.getAlbumName();

        // Compare song rating descending, year descending,
        // artist name alphabetically, album name alphabetically, and track ascending

        // SONG RATING DESCENDING
        if (songRating1 < songRating2) return 1;
        else if (songRating1 > songRating2) return -1;

        // YEAR DESCENDING
        if (year1 > year2) return -1; // if track 1 # > rack 2 #, return 1
        else if (year1 < year2) return 1; // otherwise return -1 ( track 1 # < track 2 #)

        //SORT ARTIST NAME ALPHABETICALLY
        if (artist1Name.compareTo(artist2Name) != 0) return artist1Name.compareTo(artist2Name);

            // SORT ALBUM NAME ALPHABETICALLY
        else if (album1Name.compareTo(album2Name) != 0) return album1Name.compareTo(album2Name);

        // TRACK NUMBER ASCENDING
        if (track1Number < track2Number) return -1;
        else if (track1Number > track2Number) return 1;
        else return 0;
    }
}
