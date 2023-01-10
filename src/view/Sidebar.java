package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Sidebar extends JPanel {
  private JButton selectedButton;
  private JPanel mainPanel;

  public Sidebar(JPanel mainPanel) {
    this.mainPanel = mainPanel;

    // Set the layout manager
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    // Set the background color
    setBackground(Color.decode("#87CEEB"));

    // Set the preferred size of the sidebar
    setPreferredSize(new Dimension(150, 0));

    // Add some buttons to the sidebar
    add(createButton("Home", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\home.png"));
    add(createButton("Customers", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\customer.png"));
    add(createButton("Services", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\cart.png"));
    add(createButton("Invoices", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\bill.png"));
    add(createButton("Account", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\user.png"));
  }
  
  private JButton createButton(final String text, String iconName) {
	  final JButton button = new JButton(text);
	  button.setAlignmentX(Component.LEFT_ALIGNMENT);
	  button.setMaximumSize(new Dimension(150, 50));
	  button.setBackground(Color.decode("#6495ED"));
	  button.setIcon(new ImageIcon(iconName));
	  button.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	  
	    	 // Reset the background color of the previously selected button, if it is not the "Account" button
	    	  if (selectedButton != null && !selectedButton.getText().equals("Account")) {
	    	    selectedButton.setBackground(Color.decode("#6495ED"));
	    	  }
	    	  // Set the background color of the currently selected button, if it is not the "Account" button
	    	  if (!button.getText().equals("Account")) {
	    	    button.setBackground(Color.decode("#90EE90"));
	    	  }
	    	  selectedButton = button;

	      // Show the corresponding panel in the main panel
	      CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
	      cardLayout.show(mainPanel, text);
	    }
	  });
	  if (text.equals("Account")) {
	        button.setBackground(getBackground());
	        button.setBorder(null);
	        add(Box.createVerticalGlue());
	      }
	  return button;
	}



}
