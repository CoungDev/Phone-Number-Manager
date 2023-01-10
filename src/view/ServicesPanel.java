package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import modal.Customer;
import modal.Database;
import modal.Service;

public class ServicesPanel extends JPanel {
private JPanel topPanel;
private JPanel bottomPanel;
private JPanel formPanel;
private JPanel rightPanel;
private JButton addButton;
private JButton deleteButton;

public ServicesPanel() {
setLayout(new GridLayout(2,1));
setBackground(Color.decode("#34334D"));

topPanel = new JPanel();
topPanel.setLayout(new BorderLayout());
topPanel.setBackground(Color.decode("#34334D"));

bottomPanel = new JPanel();
bottomPanel.setLayout(new BorderLayout());
bottomPanel.setBackground(Color.decode("#34334D"));

formPanel = new JPanel();
formPanel.setLayout(new BorderLayout());
formPanel.setPreferredSize(new Dimension(500, 0));
formPanel.setBackground(Color.decode("#34334D"));

 formPanel = new JPanel();
formPanel.setLayout(new GridLayout(6, 2));
formPanel.setBorder(BorderFactory.createTitledBorder(
	    BorderFactory.createLineBorder(Color.WHITE), "Service Infomation", 
	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));;
formPanel.setBackground(Color.decode("#34334D"));

JLabel idLabel = new JLabel("ID: ");
idLabel.setForeground(Color.WHITE);
formPanel.add(idLabel);
final JTextField idField = new JTextField(20);
formPanel.add(idField);

JLabel nameLabel = new JLabel("Name: ");
nameLabel.setForeground(Color.WHITE);
formPanel.add(nameLabel);
final JTextField nameField = new JTextField(20);
formPanel.add(nameField);

JLabel durationLabel = new JLabel("Duration: ");
durationLabel.setForeground(Color.WHITE);
formPanel.add(durationLabel);
final JTextField durationField = new JTextField("mm/dd/yyyy",10);
formPanel.add(durationField);

JLabel priceLabel = new JLabel("Price: ");
priceLabel.setForeground(Color.WHITE);
formPanel.add(priceLabel);
final JTextField priceField = new JTextField("$",20);
formPanel.add(priceField);



topPanel.add(formPanel, BorderLayout.WEST);

rightPanel = new JPanel();
rightPanel.setPreferredSize(new Dimension(350, 0));
rightPanel.setBackground(Color.decode("#34334D"));
rightPanel.setBorder(BorderFactory.createTitledBorder(
	    BorderFactory.createLineBorder(Color.WHITE), "Action", 
	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

JButton addButton = new JButton("ADD");
addButton.setBackground(Color.ORANGE);
addButton.setMaximumSize(new Dimension(100, 50));
addButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

JButton deleteButton = new JButton("DELETE");
deleteButton.setBackground(Color.ORANGE);
deleteButton.setMaximumSize(new Dimension(100, 50));
deleteButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

rightPanel.add(Box.createVerticalGlue());
rightPanel.add(addButton);
rightPanel.add(Box.createVerticalGlue());
rightPanel.add(deleteButton);
rightPanel.add(Box.createVerticalGlue());


topPanel.add(formPanel, BorderLayout.WEST);
topPanel.add(rightPanel, BorderLayout.EAST);

bottomPanel = new JPanel();
bottomPanel.setLayout(new BorderLayout());
String[] columnNames = {"ID", "Name", "Duration", "Price"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
final JTable table = new JTable(tableModel);
table.getTableHeader().setReorderingAllowed(false);
table.getTableHeader().setResizingAllowed(false);

List<Service> services = Database.getServices();
for (Service service : services) {
  String id = service.getId();
  String name = service.getName();
  String duration = service.getDuration();
  double price = service.getPrice();
 
  tableModel.addRow(new Object[] {id, name, duration, price});
}

table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	  public void valueChanged(ListSelectionEvent event) {
	    int row = table.getSelectedRow();
	    
	    String id = table.getValueAt(row, 0).toString();
	    String name = table.getValueAt(row, 1).toString();
	    String duration = table.getValueAt(row, 2).toString();
	    String price = table.getValueAt(row, 3).toString();

	    idField.setText(id);
	    nameField.setText(name);
	    durationField.setText(duration);
	    priceField.setText(price);
	  }
	});


JScrollPane scrollPane = new JScrollPane(table);
bottomPanel.add(scrollPane, BorderLayout.CENTER);



add(topPanel);
add(bottomPanel);
}
}
