public class Book {
    int id;
    String name;
    String author;
    int releaseYear;
    String genre;
    boolean isAvaliable;

    public Book (int id, String name, String author, int releaseYear, String genre) {
        isAvaliable = true;
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

}
