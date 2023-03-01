package view;

import view.MainFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AccountPanel extends JPanel {

  public AccountPanel() {
	  setBackground(Color.decode("#34334D"));
	  setLayout(new GridLayout(2, 1));
	  JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\user4.png"));
	  
	  JButton logout = new JButton("Đăng xuất");
	  logout.setForeground(Color.white);
	  logout.setBackground(this.getBackground());
	  logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	  logout.setAlignmentX(JButton.CENTER);
	  logout.setBorder(null);
	  
	  JPanel bottomPanel = new JPanel();
	  bottomPanel.setBackground(this.getBackground());
	  bottomPanel.add(logout);
	  
	  add(icon);
	  add(bottomPanel);
	  
	  logout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame mainFrame = (MainFrame) getParent().getParent().getParent().getParent().getParent();
			mainFrame.setVisible(false);
			LoginFrame loginFrame = new LoginFrame();
			loginFrame.setVisi(true);
			
		}
	});
  }
}
