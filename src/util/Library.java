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
        if (reader.booksLimit >= reader.maxBooksLimit) {
            System.out.println("Выдача книги невозможна. Лимит книг читателя " + readerID + " превышен!");
            return false;
        }
        book.isAvaliable = false;
        reader.books.add(bookID);
        reader.booksLimit += 1;
        System.out.println("Книга " + book.name + "(ID:" + bookID + ") была выдана читателю " + reader.nameAndSurname + "(ID:" + readerID + ").");
        return true;
    }

    public boolean getBookBack (int readerID, int bookID) {
        Book book = catalogOfBooks.get(bookID);
        Reader reader = catalogOfReaders.get(readerID);

        if (book == null) {
            System.out.println("Книги с ID " + bookID + " не существует!");
            return false;
        }
        if (reader == null) {
            System.out.println("Читателя с ID " + readerID + " не существует!");
            return false;
        }
        if (!(reader.books.contains(bookID))) {
            System.out.println("Эта книга не находится у данного читателя!");
            return false;
        }
        book.isAvaliable = true;
        reader.books.remove(reader.books.indexOf(bookID));
        reader.booksLimit -= 1;
        System.out.println("Книга " + book.name + "(ID:" + bookID + ") была принята у читателя " + reader.nameAndSurname + "(ID:" + readerID + ").");
        return true;
    }

    public void displayBooksOfReader (int readerID) {
        Reader reader = catalogOfReaders.get(readerID);
        int i = 1;
        if (reader == null) {
            System.out.println("Читателя с ID " + readerID + " не существует!");
        } else {
            if (reader.books.isEmpty()) {
                System.out.println("У читателя " + reader.nameAndSurname + " (ID:" + readerID + ") нет книг на руках.");
            }
            for (Integer bookID : reader.books) {
                Book book = catalogOfBooks.get(bookID);
                System.out.println("На данный момент на руках у читателя " + reader.nameAndSurname + "(ID:" + readerID + "):");
                System.out.println(i + ". Книга " + book.name + "(ID:" + book.id + "), Автор: " + book.author + ", Год выпуска: " + book.releaseYear);
                ++i;
            }
            if (reader.booksLimit == reader.maxBooksLimit) {
                System.out.println("У читателя закончился лимит. Нужно сдать книгу, чтобы получить новую.");
            } else {
                System.out.println("Читателю разрешено взять еще книг: " + reader.getLimitDifference() + ".");
            }
        }
    }

    public void displayAllBooks () {
        int i = 1;
        if (catalogOfBooks.isEmpty()) {
            System.out.println("Нет добавленных книг.");
        } else {
            for (Book book : catalogOfBooks.values()) {
                var element = catalogOfBooks.get(book.id);
                System.out.println(i + "." + " Книга: " + element.name + "(ID:" + element.id + "), Автор: " + element.author + ", Год выпуска: " +
                        element.releaseYear + ", Жанр: " + getGenre(element.genre) + ", Книга доступна? " + element.isAvaliable);
                ++i;
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
                        ", Максимальное кол-во книг для выдачи: " + element.maxBooksLimit);
            }
        }
    }

    public void findBook () {
        int i = 1;
        System.out.println("Введите ID книги для поиска:");
        int intOfID = scanner.nextInt();
        if (catalogOfBooks.containsKey(intOfID)) {
            for (Book book : catalogOfBooks.values()) {
                var element = catalogOfBooks.get(intOfID);
                System.out.println(i + "." + " Книга: " + element.name + "(ID:" + element.id + "), Автор: " + element.author + ", Год выпуска: " +
                        element.releaseYear + ", Жанр: " + getGenre(element.genre) + ", Книга доступна? " + element.isAvaliable);
                ++i;
            }
        } else {
            System.out.println("Ошибка! В каталоге нет ни одной подобной книги");
        }
    }

    public String getGenre (String genre) {
        switch (genre) {
            case "1":
                return "Боевик";
            case "2":
                return "Ужасы";
            case "3":
                return "Фантастика";
            case "4":
                return "Детектив";
            default:
                return "Роман";    // роман - по умолчанию
        }
    }
}
