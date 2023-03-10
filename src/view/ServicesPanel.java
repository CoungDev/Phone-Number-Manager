package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import controller.ServiceController;
import modal.Service;
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
final JTable table;

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
	    BorderFactory.createLineBorder(Color.WHITE), "Thông tin dịch vụ", 
	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));;
formPanel.setBackground(Color.decode("#34334D"));

JLabel idLabel = new JLabel("ID: ");
idLabel.setForeground(Color.WHITE);
formPanel.add(idLabel);
final JTextField idField = new JTextField(20);
formPanel.add(idField);

JLabel nameLabel = new JLabel("Tên dịch vụ: ");
nameLabel.setForeground(Color.WHITE);
formPanel.add(nameLabel);
final JTextField nameField = new JTextField(20);
formPanel.add(nameField);

JLabel durationLabel = new JLabel("Thời hạn: ");
durationLabel.setForeground(Color.WHITE);
formPanel.add(durationLabel);
final JTextField durationField = new JTextField(10);
formPanel.add(durationField);

JLabel priceLabel = new JLabel("Giá: ");
priceLabel.setForeground(Color.WHITE);
formPanel.add(priceLabel);
final JTextField priceField = new JTextField(20);
formPanel.add(priceField);



topPanel.add(formPanel, BorderLayout.WEST);

rightPanel = new JPanel();
rightPanel.setPreferredSize(new Dimension(350, 0));
rightPanel.setBackground(Color.decode("#34334D"));
rightPanel.setBorder(BorderFactory.createTitledBorder(
	    BorderFactory.createLineBorder(Color.WHITE), "Điều khiển", 
	    TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial", Font.PLAIN, 18), Color.WHITE));
rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

JButton addButton = new JButton("Thêm");
addButton.setBackground(Color.ORANGE);
addButton.setMaximumSize(new Dimension(100, 50));
addButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

JButton deleteButton = new JButton("Xóa");
deleteButton.setBackground(Color.ORANGE);
deleteButton.setMaximumSize(new Dimension(100, 50));
deleteButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

JButton editButton = new JButton("Sửa");
editButton.setBackground(Color.ORANGE);
editButton.setMaximumSize(new Dimension(100, 50));
editButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

JButton clearButton = new JButton("Hủy");
clearButton.setBackground(Color.ORANGE);
clearButton.setMaximumSize(new Dimension(100, 50));
clearButton.setAlignmentX(JButton.CENTER_ALIGNMENT);

rightPanel.add(Box.createVerticalGlue());
rightPanel.add(addButton);
rightPanel.add(Box.createVerticalGlue());
rightPanel.add(deleteButton);
rightPanel.add(Box.createVerticalGlue());
rightPanel.add(editButton);
rightPanel.add(Box.createVerticalGlue());
rightPanel.add(clearButton);
rightPanel.add(Box.createVerticalGlue());



topPanel.add(formPanel, BorderLayout.WEST);
topPanel.add(rightPanel, BorderLayout.EAST);

bottomPanel = new JPanel();
bottomPanel.setLayout(new BorderLayout());
String[] columnNames = {"ID", "Tên dịch vụ", "Thời hạn", "Giá"};
final DefaultTableModel serviceTableModel = new DefaultTableModel(columnNames, 0);
table = new JTable(serviceTableModel);
table.getTableHeader().setReorderingAllowed(false);
table.getTableHeader().setResizingAllowed(false);

List<Service> services = Database.getServices();
for (Service service : services) {
  String id = service.getId();
  String name = service.getName();
  String duration = service.getDuration();
  double price = service.getPrice();
 
  serviceTableModel.addRow(new Object[] {id, name, duration, price});
}

table.addMouseListener(new MouseAdapter() {
	  public void mouseClicked(MouseEvent e) {
	    int row = table.getSelectedRow();
	    int col = table.getSelectedColumn();
	    Object value = table.getValueAt(row, col);

	    idField.setText((String) table.getValueAt(row, 0));
	    nameField.setText((String) table.getValueAt(row, 1));
	    durationField.setText((String) table.getValueAt(row, 2));
	   priceField.setText(Double.toString((double) table.getValueAt(row, 3)));
	  }
	});

clearButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    	idField.setText("");
        nameField.setText("");
       durationField.setText("");
       priceField.setText("");
       table.clearSelection();
    }
});

//action
addButton.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = idField.getText();
	    String name = nameField.getText();
	    String duration = durationField.getText();
	    double price = Double.parseDouble(priceField.getText());

	    Service service = new Service(id, name, duration, price);

	    ServiceController db = new ServiceController();
	    db.insertService(service, serviceTableModel);
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
		  String serviceId = (String) table.getValueAt(selectedRow, 0);
		  ServiceController db = new ServiceController();
		  db.deleteService(serviceId);
		  refreshTable();
		  idField.setText("");
	      nameField.setText("");
	      durationField.setText("");
	      priceField.setText("");
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
		String serviceId = (String) table.getValueAt(selectedRow, 0);
	    String name = nameField.getText();
	    String duration = durationField.getText();
	    double price = Double.parseDouble(priceField.getText());
	    
	    ServiceController db = new ServiceController();
	    db.updateService(serviceId, name, duration, price);
	    refreshTable();
	}
});

JScrollPane scrollPane = new JScrollPane(table);
bottomPanel.add(scrollPane, BorderLayout.CENTER);



add(topPanel);
add(bottomPanel);
	}
private void refreshTable() {
	  List<Service> updatedServices = Database.getServices();
	  DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
	  tableModel.setRowCount(0); // clear the existing data
	  for (Service service : updatedServices) {
	    Object[] rowData = { service.getId(), service.getName(), service.getDuration(), service.getPrice()};
	    tableModel.addRow(rowData);
	  }
	}
}
