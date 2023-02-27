package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.CustomerController;
import modal.Customer;
import modal.Database;


public class CustomersPanel extends JPanel {
	final JTable table;
  public CustomersPanel() {
    setBackground(Color.decode("#34334D"));

    setLayout(new GridLayout(2, 1));

    JPanel topPanel = new JPanel();
    topPanel.setBackground(Color.decode("#34334D"));
    JPanel bottomPanel = new JPanel();
    bottomPanel.setBackground(Color.decode("#34334D"));

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
    
    rightPanel.setBackground(Color.decode("#34334D"));

    rightPanel.setBorder(BorderFactory.createTitledBorder(
    	    BorderFactory.createLineBorder(Color.WHITE), "Action", 
    	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));

    JButton addButton = new JButton("ADD");
    addButton.setBackground(Color.ORANGE);
    addButton.setMaximumSize(new Dimension(100, 50));
    addButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

    JButton deleteButton = new JButton("DELETE");
    deleteButton.setBackground(Color.ORANGE);
    deleteButton.setMaximumSize(new Dimension(100, 50));
    deleteButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

    JButton editButton = new JButton("EDIT");
    editButton.setBackground(Color.ORANGE);
    editButton.setMaximumSize(new Dimension(100, 50));
    editButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

    JButton clearButton = new JButton("CLEAR");
    clearButton.setBackground(Color.ORANGE);
    clearButton.setMaximumSize(new Dimension(100, 50));
    clearButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
    
    JButton searchButton = new JButton("SEARCH");
    searchButton.setBackground(Color.ORANGE);
    searchButton.setMaximumSize(new Dimension(100, 50));
    searchButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
    
    rightPanel.add(addButton);
    rightPanel.add(Box.createVerticalGlue());
    rightPanel.add(deleteButton);
    rightPanel.add(Box.createVerticalGlue());
    rightPanel.add(editButton);
    rightPanel.add(Box.createVerticalGlue());
    rightPanel.add(clearButton);
    rightPanel.add(Box.createVerticalGlue());
    rightPanel.add(searchButton);
    rightPanel.add(Box.createVerticalGlue());

    
    topPanel.setLayout(new GridLayout(1,2));
    topPanel.add(formPanel);
    topPanel.add(rightPanel);
    


    JLabel idLabel = new JLabel("ID:");
    idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
    final JTextField idField = new JTextField();
    idField.setColumns(10);
  
    
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
    
    idLabel.setForeground(Color.WHITE);
    nameLabel.setForeground(Color.WHITE);
    birthdayLabel.setForeground(Color.WHITE);
    genderLabel.setForeground(Color.WHITE);
    addressLabel.setForeground(Color.WHITE);
    phoneNumberLabel.setForeground(Color.WHITE);

    JPanel formFieldsPanel = new JPanel();
    formFieldsPanel.setBackground(Color.decode("#34334D"));
    formFieldsPanel.setLayout(new GridLayout(7, 2));

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

    formFieldsPanel.setBorder(BorderFactory.createTitledBorder(
    BorderFactory.createLineBorder(Color.WHITE), "Customer Infomation", 
    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));

    formPanel.add(formFieldsPanel, BorderLayout.CENTER);
  
    
    bottomPanel.setLayout(new BorderLayout());
    String[] columnNames = {"ID", "Name", "Birthday", "Gender", "Address", "Phone number"};
    final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    table = new JTable(tableModel);
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
    	    int row = table.getSelectedRow();
    	    int col = table.getSelectedColumn();
    	    Object value = table.getValueAt(row, col);

    	    idField.setText((String) table.getValueAt(row, 0));
    	    nameField.setText((String) table.getValueAt(row, 1));
    	    birthdayField.setText((String) table.getValueAt(row, 2));

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
    
    clearButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	idField.setText("");
            nameField.setText("");
            phoneNumberField.setText("");
            birthdayField.setText("");
            maleRadioButton.setSelected(false);
            femaleRadioButton.setSelected(false);
            addressField.setText("");
            table.clearSelection();

        }
    });

  //action
    addButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 // Get data from form
			String id = idField.getText();
		    String name = nameField.getText();
		    String phoneNumber = phoneNumberField.getText();
		    String address = addressField.getText();
		    String birthday = birthdayField.getText();
		    String gender = null;
		    if(maleRadioButton.isSelected()) {
		    	gender = "Male";
		    } else if (femaleRadioButton.isSelected()) {
		    	gender = "Female";
		    }

		    Customer customer = new Customer(id, name, birthday, gender, address, phoneNumber);

		    CustomerController db = new CustomerController();
		    db.insertCustomer(customer, tableModel);
		    refreshTable();
		}
	});
    
    deleteButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			 int selectedRow = table.getSelectedRow();
			  if (selectedRow == -1) {
			    JOptionPane.showMessageDialog(null, "Please select a row to delete", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			  }
			  String customerId = (String) table.getValueAt(selectedRow, 0);
			  
			  CustomerController db = new CustomerController();
			  db.deleteCustomer(customerId);
			  refreshTable();
			  idField.setText("");
	          nameField.setText("");
	          phoneNumberField.setText("");
	          birthdayField.setText("");
	          maleRadioButton.setSelected(false);
	          femaleRadioButton.setSelected(false);
	          addressField.setText("");
		}
	});
    
    editButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int selectedRow = table.getSelectedRow();
			if (selectedRow == -1) {
			    JOptionPane.showMessageDialog(null, "Please select a row to edit", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			  }
			String customerId = (String) table.getValueAt(selectedRow, 0);
			String name = nameField.getText();
			String birthday = birthdayField.getText();
			String gender = null;
			  if(maleRadioButton.isSelected()) {
			    	gender = "Male";
			    } else if (femaleRadioButton.isSelected()) {
			    	gender = "Female";
			    }
			String address = addressField.getText();
			String phonenumber = phoneNumberField.getText();
			CustomerController db = new CustomerController();
			db.updateCustomer(customerId, name, birthday, gender, address, phonenumber);
			refreshTable();
		}
	});


    searchButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String searchQuery = nameField.getText();
			int rowCount = table.getRowCount();
			int resultRow = -1;
			for(int i = 0; i < rowCount; i++) {
				String compareRs = (String) table.getValueAt(i, 1);
				if(compareRs.equals(searchQuery)) {
					resultRow = i;
					break;
				}
			}
			if(resultRow != -1) {
				idField.setText((String) table.getValueAt(resultRow, 0));
				nameField.setText((String) table.getValueAt(resultRow, 1));
				birthdayField.setText((String) table.getValueAt(resultRow, 2));
				if((boolean) table.getValueAt(resultRow, 3).equals("Male")) {
					maleRadioButton.setSelected(true);
				} else if ((boolean) table.getValueAt(resultRow, 3).equals("Female")) {
					femaleRadioButton.setSelected(true);
				}
				addressField.setText((String) table.getValueAt(resultRow, 4));
				phoneNumberField.setText((String) table.getValueAt(resultRow, 5));
			}
			
			table.addRowSelectionInterval(resultRow, resultRow);
		}
	});
    
    JScrollPane scrollPane = new JScrollPane(table);

	bottomPanel.add(scrollPane,BorderLayout.CENTER);
	bottomPanel.setPreferredSize(scrollPane.getPreferredSize());

    
    add(topPanel);
    add(bottomPanel);
    
    

  }
  private void refreshTable() {
	  List<Customer> updatedCustomers = Database.getCustomers();
	  DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	  tableModel.setRowCount(0); // clear the existing data
	  for (Customer customer : updatedCustomers) {
	    Object[] rowData = { customer.getId(), customer.getName(), customer.getBirthday(),
	        customer.getGender(), customer.getAddress(), customer.getPhoneNumber() };
	    tableModel.addRow(rowData);
	  }
	}


}


