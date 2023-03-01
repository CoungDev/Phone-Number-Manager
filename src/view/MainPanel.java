package view;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  public MainPanel() {
    
    setLayout(new CardLayout());

    
    add(new HomePanel(), "Trang chủ");

   
    add(new CustomersPanel(), "Khách hàng");

    
    add(new ServicesPanel(), "Dịch vụ");

   
    add(new InvoicesPanel(), "Hóa đơn");
    

   
    add(new AccountPanel(), "Tài khoản");
    
  }
}



