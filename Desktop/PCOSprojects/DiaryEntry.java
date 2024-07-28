import java.util.Date;
public class DiaryEntry {
    private Date date;
    private String content;
    private DiaryEntry next;

    public DiaryEntry(Date date, String content) {
        this.date = date;
        this.content = content;
        this.next = null;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public DiaryEntry getNext() {
        return next;
    }

    public void setNext(DiaryEntry next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Content: " + content;
    }
}


