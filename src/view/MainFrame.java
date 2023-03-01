package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
	public MainFrame() {
		setTitle("Quản lý số điện thoại và thuê bao khách hàng");

	    setSize(new Dimension(1000, 500));

	    setLayout(new BorderLayout());
	   
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	   
	    MainPanel mainpanel = new MainPanel();
	    Sidebar sidebar = new Sidebar(mainpanel);
	    

	    
	    add(sidebar, BorderLayout.WEST);
	    add(mainpanel,BorderLayout.CENTER);
	    

	}
	
}
