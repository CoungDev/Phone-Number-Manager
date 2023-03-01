package controller;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modal.Customer;
import view.CustomersPanel;
import modal.Database;
import modal.Service;

import java.util.ArrayList;
import java.util.Vector;

public class ServiceController {
    private static final String URL = "jdbc:mysql://localhost/phone_number_manager";
    private static final String USERNAME = "CUONG";
    private static final String PASSWORD = "Dc@25072004";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public void insertService(Service service, DefaultTableModel serviceTableModel) {
    	
    	try (Connection connection = ServiceController.getConnection();
    			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO services (id, name, duration, price) VALUES (?, ?, ?, ?)")) {
    		
    		preparedStatement.setString(1, service.getId());
    		preparedStatement.setString(2, service.getName());
    		preparedStatement.setString(3, service.getDuration());
    		preparedStatement.setDouble(4, service.getPrice());
    		preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    public void deleteService(String id) {
  	  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this service?", "Confirm", JOptionPane.YES_NO_OPTION);
  	  if (confirm == JOptionPane.YES_OPTION) {
  		  try {
  		      Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
  		      PreparedStatement statement = connection.prepareStatement("DELETE FROM services WHERE id = ?");
  		      statement.setString(1, id);
  		      statement.executeUpdate();
  		      JOptionPane.showMessageDialog(null, "Service deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
  		      connection.close();
  		    } catch (SQLException e) {
  		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
  		    }
  	  }
  }
    
    public void updateService(String id, String name, String duration, double price) {
	    try(Connection connection = ServiceController.getConnection();
	    		PreparedStatement statement = connection.prepareStatement("UPDATE services SET name = ?, duration = ?, price = ? WHERE id = ?");) {
	      
	      statement.setString(1, name);
	      statement.setString(2, duration);
	      statement.setDouble(3, price);
	      statement.setString(4, id);
	      statement.executeUpdate();
	      statement.close();
	      connection.close();
	      JOptionPane.showMessageDialog(null, "UPDATED");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	  }
}

	
	
	    
