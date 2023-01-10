package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import modal.Customer;
import modal.Database;


public class CustomersPanel extends JPanel {
  public CustomersPanel() {
    setBackground(Color.decode("#34334D"));

    // Set the layout manager
    setLayout(new GridLayout(2, 1));

    // Create the top and bottom panels
    JPanel topPanel = new JPanel();
    topPanel.setBackground(Color.decode("#34334D"));
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.decode("#34334D"));

    // Create the form panel
    JPanel formPanel = new JPanel();
    formPanel.setMinimumSize(new Dimension(250, 0));
    formPanel.setMaximumSize(new Dimension(350, 0));
    formPanel.setBackground(Color.WHITE);
    formPanel.setLayout(new BorderLayout());
    
    
    JPanel rightPanel = new JPanel();
    rightPanel.setBackground(Color.decode("#34334D"));
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
    rightPanel.setBorder(BorderFactory.createTitledBorder(
    	    BorderFactory.createLineBorder(Color.WHITE), "Action", 
    	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
    
    rightPanel.setLayout(null); // disable layout manager
    rightPanel.setBackground(Color.decode("#34334D"));

    rightPanel.setBorder(BorderFactory.createTitledBorder(
    	    BorderFactory.createLineBorder(Color.WHITE), "Action", 
    	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));

    // create the buttons
    JButton addButton = new JButton("ADD");
    JButton deleteButton = new JButton("DELETE");
    JButton editButton = new JButton("EDIT");
    JButton clearButton = new JButton("CLEAR");
    addButton.setBounds(70, 20, 100, 40);
    deleteButton.setBounds(250, 20, 100, 40);
    editButton.setBounds(70, 130, 100, 40);
    clearButton.setBounds(250, 130, 100, 40);
    
    addButton.setBackground(Color.decode("#f58f0a"));
    deleteButton.setBackground(Color.decode("#f58f0a"));
    editButton.setBackground(Color.decode("#f58f0a"));
    clearButton.setBackground(Color.decode("#f58f0a"));
    clearButton.setBackground(Color.decode("#f58f0a"));


    rightPanel.add(addButton);
    rightPanel.add(deleteButton);
    rightPanel.add(editButton);
    rightPanel.add(clearButton);

    
    topPanel.setLayout(new GridLayout(1,2));
    topPanel.add(formPanel);
    topPanel.add(rightPanel);


    // Create the form labels and text fields
    JLabel idLabel = new JLabel("ID:");
    idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JTextField idField = new JTextField();
    idField.setColumns(10);
    idField.setEditable(false);
    
    JLabel nameLabel = new JLabel("Name:");
    nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JTextField nameField = new JTextField();
    nameField.setColumns(10);
    
    JLabel birthdayLabel = new JLabel("Birthday:");
    final JTextField birthdayField = new JTextField("mm/dd/yyyy", 10);

    
    JLabel genderLabel = new JLabel("Gender:");
    genderLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JRadioButton maleRadioButton = new JRadioButton("Male");
    final JRadioButton femaleRadioButton = new JRadioButton("Female");
    ButtonGroup genderGroup = new ButtonGroup();
    genderGroup.add(maleRadioButton);
    genderGroup.add(femaleRadioButton);

    maleRadioButton.setBackground(Color.decode("#34334D"));
    femaleRadioButton.setBackground(Color.decode("#34334D"));
    maleRadioButton.setForeground(Color.WHITE);
    femaleRadioButton.setForeground(Color.WHITE);
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(maleRadioButton);
    buttonGroup.add(femaleRadioButton);
    JPanel genderPanel = new JPanel();
    genderPanel.setBackground(Color.decode("#34334D"));
    genderPanel.add(maleRadioButton);
    genderPanel.add(femaleRadioButton);
    
    JLabel addressLabel = new JLabel("Address:");
    addressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JTextField addressField = new JTextField();
    addressField.setColumns(10);
    
    JLabel phoneNumberLabel = new JLabel("Phone number:");
    phoneNumberLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JTextField phoneNumberField = new JTextField();
    phoneNumberField.setColumns(10);
    
 // Set the color of the labels
    idLabel.setForeground(Color.WHITE);
    nameLabel.setForeground(Color.WHITE);
    birthdayLabel.setForeground(Color.WHITE);
    genderLabel.setForeground(Color.WHITE);
    addressLabel.setForeground(Color.WHITE);
    phoneNumberLabel.setForeground(Color.WHITE);

    // Create the form panel with the labels and text fields
    JPanel formFieldsPanel = new JPanel();
    formFieldsPanel.setBackground(Color.decode("#34334D"));
 // Set the layout of the form fields panel to a GridLayout
    formFieldsPanel.setLayout(new GridLayout(7, 2));

    // Add the form fields to the form fields panel
    formFieldsPanel.add(idLabel);
    formFieldsPanel.add(idField);
    formFieldsPanel.add(nameLabel);
    formFieldsPanel.add(nameField);
    formFieldsPanel.add(birthdayLabel);
    formFieldsPanel.add(birthdayField);
    formFieldsPanel.add(genderLabel);
    formFieldsPanel.add(genderPanel);
    formFieldsPanel.add(addressLabel);
    formFieldsPanel.add(addressField);
    formFieldsPanel.add(phoneNumberLabel);
    formFieldsPanel.add(phoneNumberField);

    // Create a border for the form panel
    formFieldsPanel.setBorder(BorderFactory.createTitledBorder(
    BorderFactory.createLineBorder(Color.WHITE), "Customer Infomation", 
    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));

    // Add the form fields panel to the form panel
    formPanel.add(formFieldsPanel, BorderLayout.CENTER);
  
    
    bottomPanel.setLayout(new BorderLayout());
    String[] columnNames = {"ID", "Name", "Birthday", "Gender", "Address", "Phone number"};
    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    final JTable table = new JTable(tableModel);
    table.getTableHeader().setReorderingAllowed(false);
    table.getTableHeader().setResizingAllowed(false);
    
    List<Customer> customers = Database.getCustomers();
    for (Customer customer : customers) {
      String id = customer.getId();
      String name = customer.getName();
      String birthday = customer.getBirthday();
      String gender = customer.getGender();
      String address = customer.getAddress();
      String phoneNumber = customer.getPhoneNumber();
      tableModel.addRow(new String[] {id, name, birthday, gender, address, phoneNumber});
    }
    
    table.addMouseListener(new MouseAdapter() {
    	  public void mouseClicked(MouseEvent e) {
    	    // Get the selected row and column
    	    int row = table.getSelectedRow();
    	    int col = table.getSelectedColumn();
    	    // Get the value at the selected cell
    	    Object value = table.getValueAt(row, col);
    	    // Update the form with the selected value
    	    // You will need to adjust this code based on the specific form fields you have
    	    idField.setText((String) table.getValueAt(row, 0));
    	    nameField.setText((String) table.getValueAt(row, 1));
    	    birthdayField.setText((String) table.getValueAt(row, 2));
    	    // You will need to handle the gender field separately since it is a radio button
    	    String gender = (String) table.getValueAt(row, 3);
    	    if (gender.equals("Male")) {
    	      maleRadioButton.setSelected(true);
    	    } else {
    	      femaleRadioButton.setSelected(true);
    	    }
    	    addressField.setText((String) table.getValueAt(row, 4));
    	    phoneNumberField.setText((String) table.getValueAt(row, 5));
    	  }
    	});

    
    JScrollPane scrollPane = new JScrollPane(table);

	bottomPanel.add(scrollPane,BorderLayout.CENTER);
	bottomPanel.setPreferredSize(scrollPane.getPreferredSize());

    
    add(topPanel);
    add(bottomPanel);

  }
}


