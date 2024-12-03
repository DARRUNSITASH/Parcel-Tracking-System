import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

class Parcel {
    private String parcelId;
    private String senderName;
    private String receiverName;
    private String location;
    private String status;

    public Parcel(String parcelId, String senderName, String receiverName, String location, String status) {
        this.parcelId = parcelId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.location = location;
        this.status = status;
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "<html><b>Parcel ID:</b> " + parcelId +
                "<br><b>Sender:</b> " + senderName +
                "<br><b>Receiver:</b> " + receiverName +
                "<br><b>Location:</b> " + location +
                "<br><b>Status:</b> " + status + "</html>";
    }
}

public class PTS {
    private static HashMap<String, Parcel> parcelDatabase = new HashMap<>();

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Parcel Tracking System");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Create Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel for Adding a Parcel
        JPanel addParcelPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        JTextField tfParcelId = new JTextField();
        JTextField tfSenderName = new JTextField();
        JTextField tfReceiverName = new JTextField();
        JTextField tfLocation = new JTextField();
        JTextField tfStatus = new JTextField();
        JButton btnAddParcel = new JButton("Add Parcel");

        addParcelPanel.add(new JLabel("Parcel ID:"));
        addParcelPanel.add(tfParcelId);
        addParcelPanel.add(new JLabel("Sender Name:"));
        addParcelPanel.add(tfSenderName);
        addParcelPanel.add(new JLabel("Receiver Name:"));
        addParcelPanel.add(tfReceiverName);
        addParcelPanel.add(new JLabel("Location:"));
        addParcelPanel.add(tfLocation);
        addParcelPanel.add(new JLabel("Status:"));
        addParcelPanel.add(tfStatus);
        addParcelPanel.add(new JLabel());
        addParcelPanel.add(btnAddParcel);

        btnAddParcel.addActionListener(e -> {
            String parcelId = tfParcelId.getText();
            String senderName = tfSenderName.getText();
            String receiverName = tfReceiverName.getText();
            String location = tfLocation.getText();
            String status = tfStatus.getText();

            if (!parcelId.isEmpty() && !senderName.isEmpty() && !receiverName.isEmpty() &&
                    !location.isEmpty() && !status.isEmpty()) {
                Parcel parcel = new Parcel(parcelId, senderName, receiverName, location, status);
                parcelDatabase.put(parcelId, parcel);
                JOptionPane.showMessageDialog(frame, "Parcel added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Panel for Updating a Parcel
        JPanel updateParcelPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField tfUpdateParcelId = new JTextField();
        JTextField tfNewLocation = new JTextField();
        JTextField tfNewStatus = new JTextField();
        JButton btnUpdateParcel = new JButton("Update Parcel");

        updateParcelPanel.add(new JLabel("Parcel ID:"));
        updateParcelPanel.add(tfUpdateParcelId);
        updateParcelPanel.add(new JLabel("New Location:"));
        updateParcelPanel.add(tfNewLocation);
        updateParcelPanel.add(new JLabel("New Status:"));
        updateParcelPanel.add(tfNewStatus);
        updateParcelPanel.add(new JLabel());
        updateParcelPanel.add(btnUpdateParcel);

        btnUpdateParcel.addActionListener(e -> {
            String parcelId = tfUpdateParcelId.getText();
            String location = tfNewLocation.getText();
            String status = tfNewStatus.getText();

            Parcel parcel = parcelDatabase.get(parcelId);
            if (parcel != null) {
                parcel.updateLocation(location);
                parcel.updateStatus(status);
                JOptionPane.showMessageDialog(frame, "Parcel updated successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Parcel ID not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Panel for Viewing a Parcel
        JPanel viewParcelPanel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JTextField tfViewParcelId = new JTextField();
        JButton btnViewParcel = new JButton("View Parcel");
        JLabel lblParcelDetails = new JLabel("", SwingConstants.CENTER);

        inputPanel.add(new JLabel("Parcel ID:"));
        inputPanel.add(tfViewParcelId);
        viewParcelPanel.add(inputPanel, BorderLayout.NORTH);
        viewParcelPanel.add(btnViewParcel, BorderLayout.CENTER);
        viewParcelPanel.add(lblParcelDetails, BorderLayout.SOUTH);

        btnViewParcel.addActionListener(e -> {
            String parcelId = tfViewParcelId.getText();
            Parcel parcel = parcelDatabase.get(parcelId);

            if (parcel != null) {
                lblParcelDetails.setText(parcel.toString());
            } else {
                lblParcelDetails.setText("<html><b>Parcel ID not found!</b></html>");
            }
        });

        // Add Panels to Tabbed Pane
        tabbedPane.addTab("Add Parcel", addParcelPanel);
        tabbedPane.addTab("Update Parcel", updateParcelPanel);
        tabbedPane.addTab("View Parcel", viewParcelPanel);

        // Add Tabbed Pane to Frame
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Make Frame Visible
        frame.setVisible(true);
    }
}