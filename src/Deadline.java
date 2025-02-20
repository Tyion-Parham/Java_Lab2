import java.time.LocalDateTime;

public class Deadline extends Event implements Completable{
    private boolean complete = false;

    public Deadline(String name, LocalDateTime deadline) {
        super.setName(name);
        super.setDateTime(deadline);
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

    @Override
    public String toString() {
        return "Deadline: " + getName() + " (Due: " + getDateTime() + ", Status: " + (complete ? "Complete" : "Incomplete") + ")";
    }
}
