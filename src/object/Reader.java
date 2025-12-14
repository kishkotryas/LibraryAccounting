package object;

import java.util.ArrayList;

public class Reader {
    public int id;
    public String nameAndSurname;
    public String dateOfBirthday;
    public ArrayList <Integer> books;
    public String phoneNum;
    public int booksLimit;
    public int maxBooksLimit = 5;

    public Reader (int id, String name, String dateOfBirthday, String phoneNum) {
        books = new ArrayList<>();
        this.id = id;
        this.nameAndSurname = name;
        this. dateOfBirthday = dateOfBirthday;
        this.phoneNum = phoneNum;
        booksLimit = 0;
    }

    public int getLimitDifference () {
        int result = maxBooksLimit - booksLimit;
        return result;
    }

    // Были проведены тесты
}
