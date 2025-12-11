package object;

import java.util.ArrayList;

public class Reader {
    public int id;
    public String nameAndSurname;
    public String dateOfBirthday;
    public ArrayList <Integer> books;
    public String phoneNum;
    public int booksLimit = 5;

    public Reader (int id, String name, String dateOfBirthday, String phoneNum) {
        books = new ArrayList<>();
        this.id = id;
        this.nameAndSurname = name;
        this. dateOfBirthday = dateOfBirthday;
        this.phoneNum = phoneNum;
    }
}
