package view;
import javax.swing.*;

import controller.Auth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
	public JTextField usernameField;
	public JTextField passwordField;
	public JButton loginButton;
	public LoginFrame() {
	    setSize(450, 700);
	    setResizable(false);
        setLocationRelativeTo(null);
        setBackground(Color.decode("#34334D"));
        
        JPanel iconPanel = new JPanel();
        iconPanel.setBackground(this.getBackground());
        iconPanel.setPreferredSize(new Dimension(0, 200));
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.Y_AXIS));
        
        JLabel icon = new JLabel(new ImageIcon("C:\\Users\\Admin\\eclipse-workspace\\DoAn2\\src\\view\\phone-call.png"));
        icon.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        
        iconPanel.add(Box.createVerticalGlue());
        iconPanel.add(icon);
        iconPanel.add(Box.createVerticalGlue());
        

        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        loginButton = new JButton("Đăng Nhập");

        
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(this.getBackground());
        panel.setMaximumSize(new Dimension(100,0));
        panel.setMaximumSize(new Dimension(100, 0));
        
        JPanel loginPanel = new JPanel(new GridLayout(5,2));
        loginPanel.setBackground(this.getBackground());
        
        //Margin panel
        JPanel temp = new JPanel();
        temp.setBackground(this.getBackground());
        //
        
        JLabel usernameTitle = new JLabel("Tài khoản: ");
        usernameTitle.setForeground(Color.white);
        JLabel passwordTitle = new JLabel("Mật khẩu: ");
        passwordTitle.setForeground(Color.white);
        
        loginPanel.add(usernameTitle);
        loginPanel.add(usernameField);
        loginPanel.add(temp);
        loginPanel.add(temp);
        loginPanel.add(passwordTitle);
        loginPanel.add(passwordField);
        loginPanel.add(temp);
        loginPanel.add(temp);
        loginPanel.add(temp);
        loginPanel.add(temp);
        
        panel.add(loginPanel);
       
        JPanel right = new JPanel();
        right.setBackground(this.getBackground());
        right.setPreferredSize(new Dimension(75,0));
        JPanel left = new JPanel();
        left.setBackground(this.getBackground());
        left.setPreferredSize(new Dimension(75,0));
        
        JPanel bottom = new JPanel();
        bottom.setBackground(this.getBackground());
        bottom.setPreferredSize(new Dimension(0,200));
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        loginButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bottom.add(loginButton);
        bottom.add(Box.createVerticalGlue());
        JLabel author = new JLabel("Copyright by CoungDev");
        author.setForeground(Color.white);
        author.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        author.setFont(new Font("Arial", Font.PLAIN, 10));
        bottom.add(author);
        
       
        
        setLayout(new BorderLayout());
        add(iconPanel, BorderLayout.NORTH);
        add(right, BorderLayout.WEST);
        add(left, BorderLayout.EAST);
        add(panel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        
		
	}
	
	private void setupLoginButton() {
	    loginButton.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        String username = usernameField.getText();
	        String password = passwordField.getText();
	        if (Auth.Authenticated(username, password)) {
	          MainFrame mainFrame = new MainFrame();
	          mainFrame.setVisible(true);
	          setVisible(false);
	        }
	      }
	    });
	  }

	  public void setVisi(boolean visible) {
	    this.setVisible(visible);
	    if (visible) {
	      setupLoginButton();
	    }
	  }
}
