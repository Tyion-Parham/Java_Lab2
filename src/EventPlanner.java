import javax.swing.*;
import java.time.LocalDateTime;

public class EventPlanner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Event Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        EventListPanel eventListPanel = new EventListPanel();
        addDefaultEvents(eventListPanel);

        frame.add(eventListPanel);
        frame.setVisible(true);
    }

    private static void addDefaultEvents(EventListPanel eventListPanel) {
        eventListPanel.addEvent(new Deadline("Submit Report", LocalDateTime.now().plusDays(1)));
        eventListPanel.addEvent(new Meeting("Team Meeting", LocalDateTime.now().plusHours(2),
                LocalDateTime.now().plusHours(3), "Conference Room"));
    }
}
