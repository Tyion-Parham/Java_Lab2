import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Meeting extends Event implements Completable{
    private LocalDateTime endDateTime;
    private String location;
    Boolean complete = false;

    public Meeting(String meetingOrintation, LocalDateTime start, LocalDateTime end, String location) {
        setName(meetingOrintation);
        endDateTime = end;
        this.location = location;
        setDateTime(start);
    }

    @Override
    public void complete() {
        complete = true;
    }

    @Override
    public void incomplete() {
        complete = false;
    }

    @Override
    public boolean isComplete() {
        return complete;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Duration getDuration() {
        Duration duration;
        duration = Duration.ofHours(ChronoUnit.HOURS.between(getDateTime(), endDateTime));
        return duration;
    }

    @Override
    public String toString() {
        return "Meeting: " + getName() + " (Start: " + getDateTime() + ", End: " + endDateTime +
                ", Location: " + location + ", Status: " + (complete ? "Complete" : "Incomplete") + ")";
    }
}
