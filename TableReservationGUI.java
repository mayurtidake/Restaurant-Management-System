package cp;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableReservationGUI extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nameLabel, phoneLabel, partySizeLabel, dateLabel, timeLabel;
    private JTextField nameField, phoneField, partySizeField, dateField, timeField;
    private JButton reserveButton, clearButton;
    private JTable table;
    private DefaultTableModel tableModel;

    @SuppressWarnings("null")
	public TableReservationGUI() {
        // Set frame properties
//        getContentPane.setBackground(Color.YELLOW);
        setTitle("Table Reservation");
        setSize(800, 500);
        setLocationRelativeTo(null);
        //getContentPane().setBackground(Color.YELLOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel for form fields
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setBackground(Color.YELLOW);

        // Add form fields to panel
        nameLabel = new JLabel("Name:");
        formPanel.add(nameLabel);
        nameField = new JTextField();
        formPanel.add(nameField);

        phoneLabel = new JLabel("Phone Number:");
        formPanel.add(phoneLabel);
        phoneField = new JTextField();
        formPanel.add(phoneField);

        partySizeLabel = new JLabel("Party Size:");
        formPanel.add(partySizeLabel);
        partySizeField = new JTextField();
        formPanel.add(partySizeField);

        dateLabel = new JLabel("Date:");
        formPanel.add(dateLabel);
        dateField = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        formPanel.add(dateField);

        timeLabel = new JLabel("Time:");
        formPanel.add(timeLabel);
        timeField = new JTextField(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a")));
        formPanel.add(timeField);

        // Add form panel to frame
        add(formPanel, BorderLayout.WEST);

        // Create panel for buttons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        buttonPanel.setBackground(Color.CYAN);

        // Add buttons to panel
        reserveButton = new JButton("Reserve");
        reserveButton.addActionListener(this);
        buttonPanel.add(reserveButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        // Add button panel to frame
        add(buttonPanel, BorderLayout.SOUTH);

        // Create table panel
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 20));
        tablePanel.setBackground(Color.YELLOW);

        // Create table and table model
        String[] columnNames = {"Name", "Phone Number", "Party Size", "Date", "Time"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setReorderingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // Add table header to panel
        JLabel tableLabel = new JLabel("Reservation Details");
        tableLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
        tableLabel.setForeground(Color.BLACK);
        tableLabel.setBorder(BorderFactory.createEmptyBorder(0, 170, 0, 0));
        tablePanel.add(tableLabel, BorderLayout.NORTH);

        // Add table panel to frame
        add(tablePanel, BorderLayout.CENTER);

        // Set frame background color
        getContentPane().setBackground(Color.CYAN);

        // Display frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reserveButton) {
            // Get form field values
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String partySize = partySizeField.getText().trim();
            String date = dateField.getText().trim();
            String time = timeField.getText().trim();

            // Validate form field values
            if (name.isEmpty() || phone.isEmpty() || partySize.isEmpty() || date.isEmpty() || time.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int partySizeInt = Integer.parseInt(partySize);
                if (partySizeInt < 1 || partySizeInt > 20) {
                    JOptionPane.showMessageDialog(this, "Party size must be between 1 and 20.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid party size.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid date (MM/dd/yyyy).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                LocalTime.parse(time, DateTimeFormatter.ofPattern("hh:mm a"));
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid time (hh:mm AM/PM).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Add row to table
            String[] rowData = {name, phone, partySize, date, time};
            tableModel.addRow(rowData);

            // Clear form fields
            nameField.setText("");
            phoneField.setText("");
            partySizeField.setText("");
            dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            timeField.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a")));

            JOptionPane.showMessageDialog(this, "Table reserved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == clearButton) {
            // Clear form fields
            nameField.setText("");
            phoneField.setText("");
            partySizeField.setText("");
            dateField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            timeField.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a")));
        }
    }

    public static void main(String[] args) {
        new TableReservationGUI();
    }
}

