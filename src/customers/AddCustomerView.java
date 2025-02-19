package customers;


import init.HomeView;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import loyaltycard.Subscription;

/**
 *
 * @author JadyMartins
 */

//Form to get user details
public class AddCustomerView extends JFrame {

    private static JTextField tfFname;
    private static JTextField tfLname;
    private static JTextField tfCard;
    private static JComboBox<String> subscriptionType;
    HomeView homeView;
    boolean isUpdate;
    JOptionPane j;
    Subscription subs; //Enum Class

    CustomerController customerController;
    public AddCustomerView(){
        
    }
    
    
    //Getters
    public String getSubscriptionType() {
        return String.valueOf(subscriptionType.getSelectedItem());
    }

      public String getFirstName() {
        return tfFname.getText();
    }
   
      public String getLastName() {
        return tfLname.getText();
    }
      
      public String getCard() {
        return tfCard.getText();
    }
    
     
    //Form to get Customer details
    //JTextField set as "" when adding a new customer
    //JTextField set with user details when Updating Customer
    public void addCustomer(String setfname, String setlname, String setsubscription, String setcard ){
            
        //Panel for form 
        JPanel form = new JPanel(new GridBagLayout());
      
        //Setting Layout
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;

        //Form Labels
        JLabel fname = new JLabel("First Name: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 1; //1 cell
        form.add(fname, fgbc);

        JLabel lname = new JLabel("Last Name: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 1; //1 cell
        form.add(lname, fgbc);

        JLabel lcardNumber = new JLabel("Card Number: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 1; //1 cell
        form.add(lcardNumber, fgbc);
        
        JLabel lsubscription = new JLabel("Subscription: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(lsubscription, fgbc);

        //Form textfield       
        tfFname = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfFname, fgbc);
        tfFname.setText(setfname);

        tfLname = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLname, fgbc);
         tfLname.setText(setlname);

        tfCard = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfCard, fgbc);
        tfCard.setText(setcard);

        subscriptionType = new JComboBox(subs.values());
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(subscriptionType, fgbc);
  
        //Button
        JButton bsubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        
        //ActionEvents
          bsubmit.setActionCommand("Submit");
        //bsubmit.setActionCommand("addCustomerDetails");
        customerController = new CustomerController();
        bsubmit.addActionListener(customerController);
       
        //Passing panel into frame
        homeView = new HomeView("New Customer Details ", form, "Logout", "Go back");
    }
   
     /* instead of setText
     Map<String, JTextField> map = new HashMap<String, JTextField>();
 
     public void setValues(String fname, String lname, String card){
         map.put(fname, tfFname);
         map.put(lname, tfLname);
         map.put(card, tfCard);
     }
     
    */
     
      
}

