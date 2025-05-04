import java.util.Date;

public class Song {
    private String name;
    private String singer;
    private String genre;
    private String language;
    private String country;
    private Date releaseDate;

    public Song(String name, String singer, String genre, String language, String country, Date releaseDate) {
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
    public Date getReleaseDate() { return releaseDate; }

    @Override
    public String toString() {
        return String.format("%s by %s [%s | %s | %s | %s]", 
            name, singer, genre, language, country, releaseDate.toString());
    }
}
