import java.time.LocalDateTime;

public class Event implements Comparable<Event> {
    private String name;
    private LocalDateTime DateTime;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDateTime(LocalDateTime DateTime) {
        this.DateTime = DateTime;
    }
    public LocalDateTime getDateTime() {
        return DateTime;
    }

    public int compareTo(Event e) {
        if (this.DateTime.isAfter(e.DateTime))
            return 1;
        else if (this.DateTime.isBefore(e.DateTime))
            return -1;
        else if (this.DateTime.isEqual(e.DateTime))
            return 0;

        return 0;
    }
}
