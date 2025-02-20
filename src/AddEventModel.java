import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class AddEventModel extends JDialog {
    private EventListPanel eventListPanel;

    public AddEventModel(EventListPanel eLP) {
        eventListPanel = eLP;
        setTitle("Add Event");
        setSize(240, 160);
        setLayout(new GridLayout(6,2));

        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField timeField = new JTextField();
        JTextField endTimeField = new JTextField();
        JTextField locationField = new JTextField();
        JButton addButton = new JButton("Add");

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Date (yyyy-MM-dd):")); // ex. 2025-02-18
        add(dateField);
        add(new JLabel("Time (HH:mm):")); // ex. 05:11
        add(timeField);
        /* invalid entries for the date and time field won't prompt anything in the gui,
         but will send an error to the console. */
        add(new JLabel("End Time(HH:mm):"));
        add(endTimeField);
        add(new JLabel("Location:"));
        add(locationField);
        add(addButton);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            LocalDateTime dateTime = LocalDateTime.parse(dateField.getText() + "T" + timeField.getText());
            String location = locationField.getText();
            if(endTimeField.getText().equals("") && locationField.getText().equals("")) {
                Event event = new Deadline(name, dateTime);
                eventListPanel.addEvent(event);
            }
            else {
                LocalDateTime endTime = LocalDateTime.parse(dateField.getText() + "T" + endTimeField.getText());
                if (locationField.getText().equals("")) {
                    location = "Online";
                }
                Event event = new Meeting(name, dateTime, endTime, location);
                eventListPanel.addEvent(event);
            }
            dispose();
        });

        setVisible(true);
    }
}
