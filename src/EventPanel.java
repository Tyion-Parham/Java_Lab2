import javax.swing.*;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;
    private JButton incompleteButton;

    public EventPanel(Event e) {
        event = e;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel eventLabel = new JLabel(event.toString());
        add(eventLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener(e1 -> {
                ((Completable) event).complete();
                eventLabel.setText(event.toString());
            });
            buttonPanel.add(completeButton);

            incompleteButton = new JButton("Incomplete");
            incompleteButton.addActionListener(e1 -> {
                ((Completable) event).incomplete();
                eventLabel.setText(event.toString());
            });
            buttonPanel.add(incompleteButton);
            add(buttonPanel);
        }

    }

}
