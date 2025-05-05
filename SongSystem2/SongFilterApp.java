import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SongFilterApp {
    private static List<Song> songs = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSampleData();
        
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    filterSongs();
                    break;
                case 2:
                    sortSongs();
                    break;
                case 3:
                    displayAllSongs();
                    break;
                case 4:
                    addNewSong();
                    break;
                case 5:
                    System.out.println("Exiting application...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private static void printMenu() {
        System.out.println("\n=== Song Filter Application ===");
        System.out.println("1. Filter songs");
        System.out.println("2. Sort songs");
        System.out.println("3. Display all songs");
        System.out.println("4. Add new song");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void filterSongs() {
        System.out.println("\n=== Filter Songs ===");
        System.out.println("Filter by:");
        System.out.println("1. Singer");
        System.out.println("2. Genre");
        System.out.println("3. Language");
        System.out.println("4. Country");
        System.out.println("5. Release Year");
        System.out.print("Enter your choice: ");
        
        int filterChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter filter value: ");
        String filterValue = scanner.nextLine();
        
        List<Song> filteredSongs = new ArrayList<>();
        
        switch (filterChoice) {
            case 1:
                for (Song song : songs) {
                    if (song.getSinger().equalsIgnoreCase(filterValue)) {
                        filteredSongs.add(song);
                    }
                }
                break;
            case 2:
                for (Song song : songs) {
                    if (song.getGenre().equalsIgnoreCase(filterValue)) {
                        filteredSongs.add(song);
                    }
                }
                break;
            case 3:
                for (Song song : songs) {
                    if (song.getLanguage().equalsIgnoreCase(filterValue)) {
                        filteredSongs.add(song);
                    }
                }
                break;
            case 4:
                for (Song song : songs) {
                    if (song.getCountry().equalsIgnoreCase(filterValue)) {
                        filteredSongs.add(song);
                    }
                }
                break;
            case 5:
                for (Song song : songs) {
                    if (String.valueOf(song.getReleaseYear()).equals(filterValue)) {
                        filteredSongs.add(song);
                    }
                }
                break;
            default:
                System.out.println("Invalid filter choice.");
                return;
        }
        
        if (filteredSongs.isEmpty()) {
            System.out.println("No songs found matching the criteria.");
        } else {
            System.out.println("\nFiltered Songs:");
            displaySongList(filteredSongs);
        }
    }
    
    private static void sortSongs() {
        System.out.println("\n=== Sort Songs ===");
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Singer");
        System.out.println("3. Release Date");
        System.out.println("4. Duration");
        System.out.print("Enter your choice: ");
        
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        List<Song> sortedSongs = new ArrayList<>(songs);
        
        switch (sortChoice) {
            case 1:
                Collections.sort(sortedSongs, new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getTitle().compareToIgnoreCase(s2.getTitle());
                    }
                });
                break;
            case 2:
                Collections.sort(sortedSongs, new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getSinger().compareToIgnoreCase(s2.getSinger());
                    }
                });
                break;
            case 3:
                Collections.sort(sortedSongs, new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return s1.getReleaseDate().compareTo(s2.getReleaseDate());
                    }
                });
                break;
            case 4:
                Collections.sort(sortedSongs, new Comparator<Song>() {
                    @Override
                    public int compare(Song s1, Song s2) {
                        return Double.compare(s1.getDuration(), s2.getDuration());
                    }
                });
                break;
            default:
                System.out.println("Invalid sort choice.");
                return;
        }
        
        System.out.println("\nSorted Songs:");
        displaySongList(sortedSongs);
    }
    
    private static void displayAllSongs() {
        System.out.println("\nAll Songs:");
        displaySongList(songs);
    }
    
    private static void displaySongList(List<Song> songList) {
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-15s %-10s %-10s %-10s %-10s\n", 
                "Title", "Singer", "Genre", "Language", "Country", "Year", "Duration");
        System.out.println("--------------------------------------------------------------------------------------------------");
        
        for (Song song : songList) {
            System.out.printf("%-20s %-20s %-15s %-10s %-10s %-10d %.2f\n", 
                    song.getTitle(), 
                    song.getSinger(), 
                    song.getGenre(), 
                    song.getLanguage(), 
                    song.getCountry(), 
                    song.getReleaseYear(),
                    song.getDuration());
        }
    }
    
    private static void addNewSong() {
        System.out.println("\n=== Add New Song ===");
        
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter singer: ");
        String singer = scanner.nextLine();
        
        System.out.print("Enter genre: ");
        String genre = scanner.nextLine();
        
        System.out.print("Enter language: ");
        String language = scanner.nextLine();
        
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        
        System.out.print("Enter release year: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        System.out.print("Enter duration (minutes): ");
        double duration = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        Song newSong = new Song(title, singer, genre, language, country, releaseYear, duration);
        songs.add(newSong);
        
        System.out.println("Song added successfully!");
    }
    
    private static void initializeSampleData() {
        songs.add(new Song("Bohemian Rhapsody", "Queen", "Rock", "English", "UK", 1975, 5.92));
        songs.add(new Song("Hotel California", "Eagles", "Rock", "English", "USA", 1976, 6.30));
        songs.add(new Song("Despacito", "Luis Fonsi", "Pop", "Spanish", "Puerto Rico", 2017, 3.47));
        songs.add(new Song("Gangnam Style", "PSY", "K-pop", "Korean", "South Korea", 2012, 3.39));
        songs.add(new Song("Shape of You", "Ed Sheeran", "Pop", "English", "UK", 2017, 3.53));
        songs.add(new Song("La Bamba", "Ritchie Valens", "Rock", "Spanish", "USA", 1958, 2.06));
    }
}

class Song {
    private String title;
    private String singer;
    private String genre;
    private String language;
    private String country;
    private int releaseYear;
    private double duration; // in minutes
    
    public Song(String title, String singer, String genre, String language, 
                String country, int releaseYear, double duration) {
        this.title = title;
        this.singer = singer;
        this.genre = genre;
        this.language = language;
        this.country = country;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getSinger() { return singer; }
    public String getGenre() { return genre; }
    public String getLanguage() { return language; }
    public String getCountry() { return country; }
    public int getReleaseYear() { return releaseYear; }
    public double getDuration() { return duration; }
    public Date getReleaseDate() {
        try {
            // Using first day of year for comparison
            return new SimpleDateFormat("yyyy").parse(String.valueOf(releaseYear));
        } catch (ParseException e) {
            return new Date(0); // should never happen
        }
    }
}