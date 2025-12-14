package object;

public class Book {
    public int id;
    public String name;
    public String author;
    public int releaseYear;
    public String genre;
    public boolean isAvaliable;

    public Book (int id, String name, String author, int releaseYear, String genre) {
        isAvaliable = true;
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    // Были проведены тесты

}
