import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Song> songList = new ArrayList<>();
        songList.add(new Song("Shape of You", "Ed Sheeran", "Pop", "English", "UK", sdf.parse("2017-01-06")));
        songList.add(new Song("Despacito", "Luis Fonsi", "Reggaeton", "Spanish", "Puerto Rico", sdf.parse("2017-01-13")));
        songList.add(new Song("Tum Hi Ho", "Arijit Singh", "Romantic", "Hindi", "India", sdf.parse("2013-04-08")));
        songList.add(new Song("Blinding Lights", "The Weeknd", "Synthpop", "English", "Canada", sdf.parse("2019-11-29")));
        songList.add(new Song("Perfect", "Ed Sheeran", "Pop", "English", "UK", sdf.parse("2017-03-03")));
        songList.add(new Song("Believer", "Imagine Dragons", "Rock", "English", "USA", sdf.parse("2017-02-01")));

        SongProcessor processor = new SongProcessor(songList);

        while (true) {
            System.out.println("\n1. Filter\n2. Sort by Name\n3. Sort by Release Date\n4. Show All Songs\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter attribute (singer/genre/language/country): ");
                    String attr = sc.nextLine();
                    System.out.print("Enter value: ");
                    String value = sc.nextLine();
                    List<Song> filtered = processor.filterByAttribute(attr, value);
                    for (Song song : filtered) System.out.println(song);
                    break;
                case 2:
                    processor.sortByName();
                    System.out.println("Sorted by name.");
                    break;
                case 3:
                    processor.sortByReleaseDate();
                    System.out.println("Sorted by release date.");
                    break;
                case 4:
                    for (Song song : processor.getSongs()) System.out.println(song);
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
