package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class PhoneNumberManager {
	public static JFrame frame;
	public static LoginFrame login;
  public static void main(String[] args) {
//	  login = new LoginFrame();
	  frame = new JFrame("Phone Number and Subscriptions Manager");

	    frame.setSize(new Dimension(1000, 500));

	    frame.setLayout(new BorderLayout());
	   
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   
	    MainPanel mainpanel = new MainPanel();
	    Sidebar sidebar = new Sidebar(mainpanel);
	    

	    
	    frame.add(sidebar, BorderLayout.WEST);
	    frame.add(mainpanel,BorderLayout.CENTER);
	    
	    frame.setVisible(true);  

  }
  
//  public void showManagerApp() {
//	  frame = new JFrame("Phone Number and Subscriptions Manager");
//
//	    frame.setSize(new Dimension(1000, 500));
//
//	    frame.setLayout(new BorderLayout());
//	   
//	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	   
//	    MainPanel mainpanel = new MainPanel();
//	    Sidebar sidebar = new Sidebar(mainpanel);
//	    
//
//	    
//	    frame.add(sidebar, BorderLayout.WEST);
//	    frame.add(mainpanel,BorderLayout.CENTER);
//	    
//	    frame.setVisible(true);  
//  }
}
