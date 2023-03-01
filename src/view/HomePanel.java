package view;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

import modal.Customer;
import modal.Database;

import java.util.Date;
import java.text.SimpleDateFormat;

public class HomePanel extends JPanel {

  private JLabel dateLabel;
  private JPanel left = new JPanel();
  private JPanel right = new JPanel();
  private JPanel centerPanel = new JPanel();
  private JLabel lblNumberOfCustomers = new JLabel();
  private JLabel lblTotalRevenue = new JLabel();
 
  public HomePanel() {
	  
	setBackground(Color.decode("#34334D"));
	
	
    dateLabel = new JLabel();
    dateLabel.setForeground(Color.WHITE);
    dateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
    dateLabel.setHorizontalAlignment(JLabel.CENTER);
    updateDate();
    	
    JLabel numTitle = new JLabel("Số lượng khách hàng:");
    numTitle.setForeground(Color.white);
    numTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    JLabel reveTitle = new JLabel("Tổng doanh thu:");
    reveTitle.setForeground(Color.white);
    reveTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    
    lblNumberOfCustomers.setFont(new Font("Arial", Font.PLAIN, 20));
    lblNumberOfCustomers.setForeground(Color.white);
    lblTotalRevenue.setFont(new Font("Arial", Font.PLAIN, 20));
    lblTotalRevenue.setForeground(Color.white);
    
    centerPanel.setBackground(Color.decode("#34334D"));
    right.setBackground(Color.decode("#34334D"));
    left.setBackground(Color.decode("#34334D"));
    
    centerPanel.setLayout(new GridLayout(2,1));
    centerPanel.add(numTitle);
    centerPanel.add(lblNumberOfCustomers);
    centerPanel.add(reveTitle);
    centerPanel.add(lblTotalRevenue);
    
    updateData();
    
    right.setPreferredSize(new Dimension(100, 0));
    left.setPreferredSize(new Dimension(100, 0));
    setLayout(new BorderLayout());
    add(dateLabel, BorderLayout.NORTH);
    add(right, BorderLayout.WEST);
    add(left, BorderLayout.EAST);
    add(centerPanel, BorderLayout.CENTER);
    
  }

  public void updateDate() {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    dateLabel.setText(dateFormat.format(date));
  }
  
  public void updateData() {
      try (Connection connection = Database.getConnection()) {
          Statement statement1 = connection.createStatement();
          ResultSet resultSet1 = statement1.executeQuery("SELECT COUNT(*) FROM customers");
          if (resultSet1.next()) {
              int numberOfCustomers = resultSet1.getInt(1);
              lblNumberOfCustomers.setText(String.valueOf(numberOfCustomers));
          }

          
          
          Statement statement2 = connection.createStatement();
          ResultSet resultSet2 = statement2.executeQuery("SELECT SUM(s.price) FROM invoices i JOIN services s ON i.service_id = s.id");
          if (resultSet2.next()) {
              double totalRevenue = resultSet2.getDouble(1);
              lblTotalRevenue.setText(String.format("%.0f", totalRevenue) + " vnđ");
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  
}