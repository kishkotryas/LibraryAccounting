import java.util.ArrayList;

public class Reader {
    int id;
    String nameAndSurname;
    String dateOfBirthday;
    ArrayList <Integer> books;
    String phoneNum;
    int booksLimit = 5;

    public Reader (int id, String name, String dateOfBirthday, String phoneNum) {
        books = new ArrayList<>();
        this.id = id;
        this.nameAndSurname = name;
        this. dateOfBirthday = dateOfBirthday;
        this.phoneNum = phoneNum;
    }
}
