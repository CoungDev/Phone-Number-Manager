package modal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
  private static final String URL = "jdbc:mysql://localhost/phone_number_manager";
  private static final String USERNAME = "CUONG";
  private static final String PASSWORD = "Dc@25072004";

  
  public static  List<Customer> getCustomers() {
    List<Customer> customers = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
      while (resultSet.next()) {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String birthday = resultSet.getString("birthday");
        String gender = resultSet.getString("gender");
        String address = resultSet.getString("address");
        String phoneNumber = resultSet.getString("phone_number");
        customers.add(new Customer(id, name, birthday, gender, address, phoneNumber));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customers;
  }
  
  public static List<Service> getServices() {
	  List<Service> services = new ArrayList<>();
	  try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
	  Statement statement = connection.createStatement();
	  ResultSet resultSet = statement.executeQuery("SELECT * FROM services");
	  
	  while (resultSet.next()) {
	    String id = resultSet.getString("id");
	    String name = resultSet.getString("name");
	    String duration = resultSet.getString("duration");
	    double price = resultSet.getDouble("price");
	    services.add(new Service(id, name, duration, price));
	  }
	  
	  } catch (Exception e) {
		  e.printStackTrace();
	}
	  return services;
  }
  
  public static List<Invoice> getInvoices(){
	  List<Invoice> invoices = new ArrayList<>();
	  try(Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD)) {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT c.id, c.name, c.phone_number, SUM(s.price) AS total_payment FROM customers c JOIN invoices i ON c.id = i.customer_id JOIN services s ON i.service_id = s.id GROUP BY c.id");
		while(resultSet.next()) {
			String id = resultSet.getString("c.id");
			String name = resultSet.getString("c.name");
			String phoneNumber = resultSet.getString("c.phone_number");
			double total = resultSet.getDouble("total_payment");
			invoices.add(new Invoice(id, name, phoneNumber, total));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	  return invoices;
  }
  
  
}