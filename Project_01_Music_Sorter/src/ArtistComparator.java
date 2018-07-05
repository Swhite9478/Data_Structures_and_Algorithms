import java.util.Comparator;

/**
 * Created by Stephen White  on 9/29/2016.
 *
 * A comparator that will sort by artist name alphabetically,
 * album name alphabetically, and track number ascending.
 */
public class ArtistComparator implements Comparator<MusicTrack> {


    @Override
    public int compare(MusicTrack o1, MusicTrack o2) {

        // Obtain all relevant information for comparing
        String artist1Name = o1.getArtistName();
        String artist2Name = o2.getArtistName();
        String album1Name = o1.getAlbumName();
        String album2Name = o2.getAlbumName();
        int track1 = o1.getTrackNumber();
        int track2 = o2.getTrackNumber();

        // Sort by artist name alphabetically, album name alphabetically, and track number ascending.

        //SORT ARTIST NAME ALPHABETICALLY
        if (artist1Name.compareTo(artist2Name) != 0) return artist1Name.compareTo(artist2Name);

        // SORT ALBUM NAME ALPHABETICALLY
        if (album1Name.compareTo(album2Name) != 0) return album1Name.compareTo(album2Name);

        // Compare track number ascending
        if(o2.getTrackNumber() < o1.getTrackNumber()) return 1;
        else if(o2.getTrackNumber() > o1.getTrackNumber()) return  -1;
        else return 0;
    }

}
