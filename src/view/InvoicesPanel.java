package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modal.Database;
import modal.Invoice;
import modal.Service;

public class InvoicesPanel extends JPanel {
private JTable table;

public InvoicesPanel() {
setLayout(new BorderLayout());
setBackground(Color.decode("#34334D"));

// Add the "Invoices" label to the top of the panel
JLabel invoicesLabel = new JLabel("Invoices");
invoicesLabel.setForeground(Color.white);
invoicesLabel.setFont(new Font("Arial", Font.PLAIN, 24));
invoicesLabel.setHorizontalAlignment(JLabel.CENTER);
add(invoicesLabel, BorderLayout.NORTH);

// Create the table and add it to the center of the panel
String[] columnNames = {"ID", "Name", "Phone number", "Total payment"};
DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
table = new JTable(tableModel);
table.getTableHeader().setReorderingAllowed(false);
table.getTableHeader().setResizingAllowed(false);
List<Invoice> invoices = Database.getInvoices();
for (Invoice invoice : invoices) {
  String id = invoice.getId();
  String name = invoice.getName();
  String phoneNumber = invoice.getPhoneNumber();
  double total = invoice.getTotalPayment();
 
  tableModel.addRow(new Object[] {id, name, phoneNumber, total});
}

JScrollPane scrollPane = new JScrollPane(table);
add(scrollPane, BorderLayout.CENTER);
}
}