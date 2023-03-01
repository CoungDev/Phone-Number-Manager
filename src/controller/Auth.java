package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.*;

public class Auth {
	private static final String URL = "jdbc:mysql://localhost/authentication";
    private static final String USERNAME = "CUONG";
    private static final String PASSWORD = "Dc@25072004";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
    public static boolean Authenticated(String username, String password) {
    	try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
    		  PreparedStatement statement = connection.prepareStatement("SELECT * FROM admins WHERE admins = ? AND password = ?");
    		  statement.setString(1, username);
    		  statement.setString(2, password);
    		  ResultSet resultSet = statement.executeQuery();
    		  
    		  if (resultSet.next()) {
    			  return true;
    		  } else {
    		    JOptionPane.showMessageDialog(null, "Tài khoản hoặc mật khẩu không chính xác", "EROR", JOptionPane.ERROR_MESSAGE);
    		    return false;
    		  }
    		} catch (SQLException e) {
    		  e.printStackTrace();
    		}
		return false;
    }
}
