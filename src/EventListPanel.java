import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListPanel  extends JPanel {
    private List<Event> events;
    private JPanel controlPanel;
    private JPanel displayPanel;
    private JComboBox sortDropDown;
    private JCheckBox filterDisplay;
    public JButton addEventButton;


    public EventListPanel() {
        events = new ArrayList<>();
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        sortDropDown = new JComboBox<>(new String[]{"Sort by Date", "Sort by Name"});
        sortDropDown.addActionListener(e -> sortEvents((String) sortDropDown.getSelectedItem()));
        controlPanel.add(sortDropDown);

        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> new AddEventModel(this));
        controlPanel.add(addEventButton);
        add(controlPanel, BorderLayout.NORTH);

        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);
    }

    public void addEvent(Event event) {
        events.add(event);
        refreshDisplay();
    }

    private void refreshDisplay() {
        displayPanel.removeAll();
        for (Event event : events) {
            displayPanel.add(new EventPanel(event));
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    private void sortEvents(String criteria) {
        if (criteria.equals("Sort by Date")) {
            events.sort(Event::compareTo);
        } else if (criteria.equals("Sort by Name")) {
            //When sorting by name it prioritizes capitals over lowercase regardless of character
            events.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        }
        refreshDisplay();
    }
}
