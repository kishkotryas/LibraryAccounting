package util;
import object.*;
import java.util.HashMap;
import java.util.Scanner;

public class Library {
    Scanner scanner = new Scanner(System.in);
    private HashMap <Integer, Book> catalogOfBooks;
    private HashMap <Integer, Reader> catalogOfReaders;

    public Library () {
        catalogOfBooks = new HashMap<>();
        catalogOfReaders = new HashMap<>();
    }

    public void createBook () {
        System.out.println("Введите ID для добавления книги: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите название книги: ");
        String bookName = scanner.nextLine();
        System.out.println("Введите автора книги: ");
        String bookAuthor = scanner.nextLine();
        System.out.println("Введите год выпуска книги: ");
        int bookYear = scanner.nextInt();
        scanner.nextLine();
        printGenreBookMenu();
        System.out.println("Выберите жанр книги:");
        String bookGenre = scanner.nextLine();
        Book newBook = new Book(bookID, bookName, bookAuthor, bookYear, bookGenre);

        catalogOfBooks.put(newBook.id, newBook);

        if (catalogOfBooks.containsValue(newBook)) {
            System.out.println("Книга успешно добавлена в каталог!");
        } else {
            System.out.println("Произошла ошибка при добавлении книги.");
        }
    }

    public void createReader () {
        System.out.println("Введите ID читателя: ");
        int readerID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите имя и фамилию читателя: ");
        String readerName = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthDate = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
        String phoneNum = scanner.nextLine();
        Reader newReader = new Reader(readerID, readerName, birthDate, phoneNum);

        catalogOfReaders.put(newReader.id, newReader);

        if (catalogOfReaders.containsValue(newReader)) {
            System.out.println("Читатель успешно добавлен!");
        } else {
            System.out.println("Произошла ошибка при добавлении читателя.");
        }
    }

    private static void printGenreBookMenu () {
        System.out.println( "1 - Боевик, 2 - Ужасы,\n" +
                "3 - Фантастика, 4 - Детектив");
    }

    public boolean giveBookToReader (int bookID, int readerID) {
        Book book = catalogOfBooks.get(bookID);
        Reader reader = catalogOfReaders.get(readerID);
        if (book == null) {
            System.out.println("Книги с ID " + readerID + " не существует!");
            return false;
        }
        if (reader == null) {
            System.out.println("Читателя с ID " + readerID + " не существует!");
            return false;
        }
        if (!book.isAvaliable) {
            System.out.println("Эта книга недоступна для выдачи!");
            return false;
        }
        if (reader.books.size() > reader.booksLimit) {
            System.out.println("Выдача книги невозможна. Лимит книг читателя " + readerID + " превышен!");
            return false;
        }
        book.isAvaliable = false;
        reader.books.add(bookID);
        reader.booksLimit -= 1;
        System.out.println("Книга " + book.name + "(ID:" + bookID + ") была выдана читателю " + reader.nameAndSurname + "(ID:" + readerID + ").");
        return true;
    }

    public void displayBooks () {
        if (catalogOfBooks.isEmpty()) {
            System.out.println("Нет добавленных книг.");
        } else {
            for (Book book : catalogOfBooks.values()) {
                var element = catalogOfBooks.get(book.id);
                System.out.println("ID Книги: " + element.id + ", Автор: " + element.author + ", Год выпуска: " +
                        element.releaseYear + ", Жанр:" + element.genre + ", Книга доступна? " + element.isAvaliable);
            }
        }
    }
    public void displayReaders() {
        if (catalogOfReaders.isEmpty()) {
            System.out.println("Нет добавленных читателей.");
        } else {
            for (Reader reader : catalogOfReaders.values()) {
                var element = catalogOfReaders.get(reader.id);
                System.out.println("ID читателя: " + element.id + ", Имя и Фамилия: " + element.nameAndSurname +
                        ", Дата рождения: " + element.dateOfBirthday + ", Номер телефона: " + element.phoneNum +
                        " Кол-во книг, которые может взять: " + element.booksLimit);
            }
        }
    }

}
