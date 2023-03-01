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

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    setBackground(Color.decode("#87CEEB"));

    setPreferredSize(new Dimension(150, 0));

    add(createButton("Trang chủ", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\home.png"));
    add(createButton("Khách hàng", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\customer.png"));
    add(createButton("Dịch vụ", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\cart.png"));
    add(createButton("Hóa đơn", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\bill.png"));
    add(createButton("Tài khoản", "C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\user.png"));
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
	  
	    	 // Reset the background color 
	    	  if (selectedButton != null && !selectedButton.getText().equals("Tài khoản")) {
	    	    selectedButton.setBackground(Color.decode("#6495ED"));
	    	  }
	    	  // TK
	    	  if (!button.getText().equals("Tài khoản")) {
	    	    button.setBackground(Color.decode("#90EE90"));
	    	  }
	    	  selectedButton = button;

	      // Show card
	      CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
	      cardLayout.show(mainPanel, text);
	    }
	  });
	  if (text.equals("Tài khoản")) {
	        button.setBackground(getBackground());
	        button.setBorder(null);
	        add(Box.createVerticalGlue());
	      }
	  return button;
	}



}
