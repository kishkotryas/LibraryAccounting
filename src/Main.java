import util.Library;

import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = 0;

        while (userInput != 9) {
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    library.createBook();
                    printMenu();
                    break;
                case 2:
                    library.createReader();
                    printMenu();
                    break;
                case 3:
                    System.out.println("Введите ID читателя, которому будет выдана книга:");
                    int readerID = scanner.nextInt();
                    System.out.println("Введите ID выдаваемой книги:");
                    int bookID = scanner.nextInt();
                    library.giveBookToReader(bookID, readerID);
                    printMenu();
                    break;
                case 5:
                    library.displayBooks();
                    printMenu();
                    break;
                case 6:
                    library.displayReaders();
                    printMenu();
                    break;
                case 9:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Выберите корректную опцию из меню...");
                    printMenu();
            }
        }
    }

    private static void printMenu () {
        System.out.println( "1. Добавить книгу\n" +
                            "2. Добавить читателя\n" +
                            "3. Выдать книгу\n" +
                            "4. Принять книгу\n" +
                            "5. Показать все книги\n" +
                            "6. Показать всех читателей\n" +
                            "7. Поиск книги\n" +
                            "8. Показать книги на руках у читателя\n" +
                            "9. Выход" );
    }

}