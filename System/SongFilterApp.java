import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

class Song {
    private String name;
    private String singer;
    private String genre;
    private String language;
    private String country;
    private LocalDate releaseDate;

    public Song(String name, String singer, String genre, String language, String country, LocalDate releaseDate) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.language = language;
        this.country = country;
        this.releaseDate = releaseDate;
    }

    public String getName() { return name; }
    public String getSinger() { return singer; }
    public String getGenre() { return genre; }
    public String getLanguage() { return language; }
    public String getCountry() { return country; }
    public LocalDate getReleaseDate() { return releaseDate; }

    @Override
    public String toString() {
        return String.format("Song: %s, Singer: %s, Genre: %s, Language: %s, Country: %s, Release: %s",
                name, singer, genre, language, country, releaseDate);
    }
}

public class SongFilterApp {
    private List<Song> songs;
    private Scanner scanner;

    public SongFilterApp() {
        songs = new ArrayList<>();
        scanner = new Scanner(System.in);
        initializeSongs();
    }

    private void initializeSongs() {
        songs.add(new Song("Bohemian Rhapsody", "Queen", "Rock", "English", "UK", LocalDate.of(1975, 10, 31)));
        songs.add(new Song("Imagine", "John Lennon", "Pop", "English", "UK", LocalDate.of(1971, 9, 9)));
        songs.add(new Song("La Vie en Rose", "Edith Piaf", "Chanson", "French", "France", LocalDate.of(1947, 1, 1)));
        songs.add(new Song("Despacito", "Luis Fonsi", "Pop", "Spanish", "Puerto Rico", LocalDate.of(2017, 1, 13)));
        songs.add(new Song("Smells Like Teen Spirit", "Nirvana", "Grunge", "English", "USA", LocalDate.of(1991, 9, 10)));
    }

    private void displayMenu() {
        System.out.println("\nSong Filter Application");
        System.out.println("1. Add new song");
        System.out.println("2. Filter songs");
        System.out.println("3. Sort songs");
        System.out.println("4. Display all songs");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private void addSong() {
        System.out.println("\nEnter song details:");
        
        System.out.print("Song name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Singer: ");
        String singer = scanner.nextLine().trim();
        
        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        
        System.out.print("Language: ");
        String language = scanner.nextLine().trim();
        
        System.out.print("Country: ");
        String country = scanner.nextLine().trim();
        
        System.out.print("Release date (YYYY-MM-DD): ");
        String dateInput = scanner.nextLine().trim();
        LocalDate releaseDate;
        try {
            releaseDate = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid date format. Using current date.");
            releaseDate = LocalDate.now();
        }

        Song newSong = new Song(name, singer, genre, language, country, releaseDate);
        songs.add(newSong);
        System.out.println("Song added successfully!");
    }

    private List<Song> filterSongs() {
        List<Song> filteredSongs = new ArrayList<>(songs);
        System.out.println("\nFilter options (leave blank to skip):");
        
        System.out.print("Singer: ");
        String singer = scanner.nextLine().trim();
        if (!singer.isEmpty()) {
            List<Song> temp = new ArrayList<>();
            for (Song song : filteredSongs) {
                if (song.getSinger().equalsIgnoreCase(singer)) {
                    temp.add(song);
                }
            }
            filteredSongs = temp;
        }

        System.out.print("Genre: ");
        String genre = scanner.nextLine().trim();
        if (!genre.isEmpty()) {
            List<Song> temp = new ArrayList<>();
            for (Song song : filteredSongs) {
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    temp.add(song);
                }
            }
            filteredSongs = temp;
        }

        System.out.print("Language: ");
        String language = scanner.nextLine().trim();
        if (!language.isEmpty()) {
            List<Song> temp = new ArrayList<>();
            for (Song song : filteredSongs) {
                if (song.getLanguage().equalsIgnoreCase(language)) {
                    temp.add(song);
                }
            }
            filteredSongs = temp;
        }

        System.out.print("Country: ");
        String country = scanner.nextLine().trim();
        if (!country.isEmpty()) {
            List<Song> temp = new ArrayList<>();
            for (Song song : filteredSongs) {
                if (song.getCountry().equalsIgnoreCase(country)) {
                    temp.add(song);
                }
            }
            filteredSongs = temp;
        }

        return filteredSongs;
    }

    private void sortSongs(List<Song> songsToSort) {
        System.out.println("\nSort by:");
        System.out.println("1. Name");
        System.out.println("2. Release Date");
        System.out.println("3. Singer");
        System.out.print("Enter choice: ");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Comparator<Song> comparator = null;
        switch (sortChoice) {
            case 1:
                comparator = new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getName().compareToIgnoreCase(s2.getName());
                    }
                };
                break;
            case 2:
                comparator = new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getReleaseDate().compareTo(s2.getReleaseDate());
                    }
                };
                break;
            case 3:
                comparator = new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getSinger().compareToIgnoreCase(s2.getSinger());
                    }
                };
                break;
            default:
                System.out.println("Invalid choice. Sorting by name.");
                comparator = new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getName().compareToIgnoreCase(s2.getName());
                    }
                };
        }

        Collections.sort(songsToSort, comparator);
    }

    private void displaySongs(List<Song> songsToDisplay) {
        if (songsToDisplay.isEmpty()) {
            System.out.println("No songs match the criteria.");
        } else {
            System.out.println("\nSongs:");
            for (Song song : songsToDisplay) {
                System.out.println(song);
            }
        }
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addSong();
                    break;
                case 2:
                    List<Song> filteredSongs = filterSongs();
                    displaySongs(filteredSongs);
                    break;
                case 3:
                    List<Song> songsToSort = new ArrayList<>(songs);
                    sortSongs(songsToSort);
                    displaySongs(songsToSort);
                    break;
                case 4:
                    displaySongs(songs);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        SongFilterApp app = new SongFilterApp();
        app.run();
    }
}