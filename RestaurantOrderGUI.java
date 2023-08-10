package cp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantOrderGUI extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel mainPanel, orderPanel, buttonPanel, titlePanel;
    private JLabel foodLabel, drinkLabel, dessertLabel, totalLabel, titleLabel;
    private JComboBox<String> foodComboBox, drinkComboBox, dessertComboBox;
    private JButton placeOrderButton, clearOrderButton;
    private JTextArea orderDetailsTextArea;

    public RestaurantOrderGUI() {
        // Set up the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        // Set up the title panel
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(titlePanel, BorderLayout.NORTH);

        // Add the title label
        titleLabel = new JLabel("Welcome to Our Restaurant");
        titleLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Set up the order panel
        orderPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        orderPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        orderPanel.setBackground(Color.GREEN);
        mainPanel.add(orderPanel, BorderLayout.CENTER);

        // Add the food combo box
        foodLabel = new JLabel("Food:");
        foodLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(foodLabel);
        foodComboBox = new JComboBox<>(new String[]{"Select an option", "Burger", "Pizza", "Pasta","kebab","sandwich","soup","noodles","fried rice","paratha","biryani","pav bhaji","Bread-toast"});
        foodComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(foodComboBox);

        // Add the drink combo box
        drinkLabel = new JLabel("Beverages:");
        drinkLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(drinkLabel);
        drinkComboBox = new JComboBox<>(new String[]{"Select an option", "Coke", "Pepsi","Cold coffee","Iced Tea","Mirinda","Thumbs-up","Sprite","Mountain-dew","Monster","RedBull","Sting","Fanta","7-Up","Dr.Pepper"});
        drinkComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(drinkComboBox);

        // Add the dessert combo box
        dessertLabel = new JLabel("Dessert:");
        dessertLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(dessertLabel);
        dessertComboBox = new JComboBox<>(new String[]{"Select an option","Pastries","Muffin","Gulab Jamun","Rasgulla","Jalebi","ShriKhand", "Aamras", "Cake", "Pie", "Ice Cream", "Fruit"});
        dessertComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(dessertComboBox);

        // Add the total label
        totalLabel = new JLabel("Total:");
        totalLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        orderPanel.add(totalLabel);
        orderDetailsTextArea = new JTextArea(4, 20);
        orderDetailsTextArea.setFont(new Font("Arial", Font.PLAIN, 16));
        orderDetailsTextArea.setEditable(false);
        orderDetailsTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(orderDetailsTextArea);
        orderPanel.add(scrollPane);

        // Set up the button panel
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the place order button
        placeOrderButton = new JButton("Place Order");
        placeOrderButton.addActionListener(this);
        placeOrderButton.setFont(new Font("Arial", Font.BOLD, 16));
        placeOrderButton.setBackground(new Color(46, 204, 113));
        placeOrderButton.setForeground(Color.WHITE);
        buttonPanel.add(placeOrderButton);

        // Add the clear order button
        clearOrderButton = new JButton("Clear Order");
        clearOrderButton.addActionListener(this);
        clearOrderButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearOrderButton.setBackground(new Color(231, 76, 60));
        clearOrderButton.setForeground(Color.WHITE);
        buttonPanel.add(clearOrderButton);
    
        // Set up the frame
        setTitle("Restaurant Order");
        setSize(800, 500);
        getContentPane().setBackground(Color.YELLOW);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == placeOrderButton) {
            String food = (String) foodComboBox.getSelectedItem();
            String drink = (String) drinkComboBox.getSelectedItem();
            String dessert = (String) dessertComboBox.getSelectedItem();
            double totalCost = 0;
    
            if (food.equals("Burger")) {
                totalCost += 129;
            } else if (food.equals("Pizza")) {
                totalCost += 249;
            } else if (food.equals("Pasta")) {
                totalCost += 159;
            } else {
                // Do nothing if no food selected
            }
    
            if (drink.equals("Coke")) {
                totalCost += 20;
            } else if (drink.equals("Pepsi")) {
                totalCost += 20;
            } else if (drink.equals("Iced Tea")) {
                totalCost += 35;
            } else {
                // Do nothing if no drink selected
            }
    
            if (dessert.equals("Cake")) {
                totalCost += 349;
            } else if (dessert.equals("Pie")) {
                totalCost += 99;
            } else if (dessert.equals("Ice Cream")) {
                totalCost += 50;
            } else if (dessert.equals("Fruit")) {
                totalCost += 50;
            }
    
            // Display the order details
            orderDetailsTextArea.setText("Food: " + food + "\n" +
                    "Beverages: " + drink + "\n" +
                    "Dessert: " + dessert + "\n" +
                    "Total Cost: ₹" + String.format("%.2f", totalCost));
        } else if (e.getSource() == clearOrderButton) {
            // Clear the order details
            foodComboBox.setSelectedIndex(0);
            drinkComboBox.setSelectedIndex(0);
            dessertComboBox.setSelectedIndex(0);
            orderDetailsTextArea.setText("");
        }
    }
    
    public static void main(String[] args) {
        new RestaurantOrderGUI();
    }
}    

