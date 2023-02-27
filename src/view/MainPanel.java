package view;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  public MainPanel() {
    // Set the layout manager
    setLayout(new CardLayout());

    // Add the home panel to the main panel
    add(new HomePanel(), "Home");

    // Add the customers panel to the main panel
    add(new CustomersPanel(), "Customers");

    // Add the services panel to the main panel
    add(new ServicesPanel(), "Services");

    // Add the invoices panel to the main panel
    add(new InvoicesPanel(), "Invoices");
    

    // Add the account panel to the main panel
    add(new AccountPanel(), "Account");
    
  }
}



