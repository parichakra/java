import java.util.*;

public class SongProcessor {
    private List<Song> songs;

    public SongProcessor(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> filterByAttribute(String attribute, String value) {
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            switch (attribute.toLowerCase()) {
                case "singer":
                    if (song.getSinger().equalsIgnoreCase(value)) result.add(song);
                    break;
                case "genre":
                    if (song.getGenre().equalsIgnoreCase(value)) result.add(song);
                    break;
                case "language":
                    if (song.getLanguage().equalsIgnoreCase(value)) result.add(song);
                    break;
                case "country":
                    if (song.getCountry().equalsIgnoreCase(value)) result.add(song);
                    break;
            }
        }
        return result;
    }

    public void sortByName() {
        Collections.sort(songs, new Comparator<Song>() {
            public int compare(Song s1, Song s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });
    }

    public void sortByReleaseDate() {
        Collections.sort(songs, new Comparator<Song>() {
            public int compare(Song s1, Song s2) {
                return s1.getReleaseDate().compareTo(s2.getReleaseDate());
            }
        });
    }

    public List<Song> getSongs() {
        return songs;
    }
}
