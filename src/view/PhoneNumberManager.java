package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PhoneNumberManager {
  public static void main(String[] args) {
    // Create the JFrame and set its title
    JFrame frame = new JFrame("Phone Number and Subscriptions Manager");

    // Set the size of the JFrame
    frame.setSize(new Dimension(1000, 500));

    
    frame.setLayout(new BorderLayout());
    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the sidebar
    MainPanel mainpanel = new MainPanel();
    Sidebar sidebar = new Sidebar(mainpanel);
    

    // Add the sidebar to the JFrame using a BorderLayout
    frame.add(sidebar, BorderLayout.WEST);
    frame.add(mainpanel,BorderLayout.CENTER);
    
    

    // Set the JFrame to be visible
    frame.setVisible(true);
    
  }
}
