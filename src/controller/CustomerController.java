package controller;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modal.Customer;
import view.CustomersPanel;
import modal.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomerController {
    private static final String URL = "jdbc:mysql://localhost/phone_number_manager";
    private static final String USERNAME = "CUONG";
    private static final String PASSWORD = "Dc@25072004";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    //other methods
    public void insertCustomer(Customer customer, DefaultTableModel customerTableModal) {
    	// Insert the customer into the database
    	try (Connection connection = CustomerController.getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (id, name, birthday, gender, address, phone_number) VALUES (?, ?, ?, ?, ?, ?)")) {
    		
    		preparedStatement.setString(1, customer.getId());
    		preparedStatement.setString(2, customer.getName());
    		preparedStatement.setString(3, customer.getBirthday());
    		preparedStatement.setString(4, customer.getGender());
    		preparedStatement.setString(5, customer.getAddress());
    		preparedStatement.setString(6, customer.getPhoneNumber());
    		preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    public void deleteCustomer(String id) {
    	  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this customer?", "Confirm", JOptionPane.YES_NO_OPTION);
    	  if (confirm == JOptionPane.YES_OPTION) {
    		  try {
    		      Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    		      PreparedStatement statement = connection.prepareStatement("DELETE FROM customers WHERE id = ?");
    		      statement.setString(1, id);
    		      statement.executeUpdate();
    		      JOptionPane.showMessageDialog(null, "Customer deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
    		      connection.close();
    		    } catch (SQLException e) {
    		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    		    }
    	  }
    }
    
   
    	  public void updateCustomer(String id, String name, String birthday, String gender, String address, String phoneNumber) {
    	    try(Connection connection = CustomerController.getConnection();
    	    		PreparedStatement statement = connection.prepareStatement("UPDATE customers SET name = ?, birthday = ?, gender = ?, address = ?, phone_number = ? WHERE id = ?");) {
    	      
    	      statement.setString(1, name);
    	      statement.setString(2, birthday);
    	      statement.setString(3, gender);
    	      statement.setString(4, address);
    	      statement.setString(5, phoneNumber);
    	      statement.setString(6, id);
    	      statement.executeUpdate();
    	      statement.close();
    	      connection.close();
    	      JOptionPane.showMessageDialog(null, "UPDATED");
    	    } catch (SQLException e) {
    	      e.printStackTrace();
    	    }
    	  }
    	
}

	
	
	    
