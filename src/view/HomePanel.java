package view;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class HomePanel extends JPanel {

  private JLabel dateLabel;


  public HomePanel() {
	  
	setBackground(Color.decode("#34334D"));
	
    dateLabel = new JLabel();
    dateLabel.setForeground(Color.WHITE);
    dateLabel.setFont(new Font("Arial", Font.PLAIN, 24));
    dateLabel.setHorizontalAlignment(JLabel.CENTER);
    updateDate();
  
    
    setLayout(new BorderLayout());
    add(dateLabel, BorderLayout.NORTH);
  }

  public void updateDate() {
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    dateLabel.setText(dateFormat.format(date));
  }

}