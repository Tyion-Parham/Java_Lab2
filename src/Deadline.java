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
    public boolean isComplete() {
        return complete;
    }
}
