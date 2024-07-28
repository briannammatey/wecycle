import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Diary {
    private DiaryEntry head;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public Diary() {
        head = null;
    }

    public void addEntry(String content) {
        Date date = new Date(); // Get the current date
        DiaryEntry newEntry = new DiaryEntry(date, content);
        newEntry.setNext(head);
        head = newEntry;
        System.out.println("Entry added: " + newEntry);
    }

    public void deleteEntry(String dateStr) {
        try {
            Date date = dateFormat.parse(dateStr);
            if (head == null) {
                System.out.println("Diary is empty.");
                return;
            }

            if (head.getDate().equals(date)) {
                System.out.println("Entry deleted: " + head);
                head = head.getNext();
                return;
            }

            DiaryEntry current = head;
            while (current.getNext() != null && !current.getNext().getDate().equals(date)) {
                current = current.getNext();
            }

            if (current.getNext() == null) {
                System.out.println("No entry found with the given date.");
            } else {
                System.out.println("Entry deleted: " + current.getNext());
                current.setNext(current.getNext().getNext());
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
        }
    }

    public void printAllEntries() {
        DiaryEntry current = head;
        if (current == null) {
            System.out.println("Diary is empty.");
            return;
        }

        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }
}
