package object;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || this.getClass() != obj.getClass()) return false;
        Book otherBook = (Book) obj;
        return Objects.equals(id, otherBook.id) &&
                Objects.equals(name, otherBook.name) &&
                Objects.equals(author, otherBook.author) &&
                Objects.equals(genre, otherBook.genre) &&
                (releaseYear == otherBook.releaseYear);
    }

    // Были проведены тесты

}
