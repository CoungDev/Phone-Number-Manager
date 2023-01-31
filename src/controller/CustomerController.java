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
    public void insertCustomer(Customer customer, DefaultTableModel tableModel) {
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
    		tableModel.addRow(new String[] { customer.getId(), customer.getName(), customer.getBirthday(),  customer.getGender(), customer.getAddress(), customer.getPhoneNumber()});
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    public void updateCustomer() {
    	
    }
}

	
	
	    
