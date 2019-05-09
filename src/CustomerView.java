
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

/**
 *
 * @author JadyMartins
 */
public class CustomerView extends JFrame {

    private static JTextField tfFname;
    private static JTextField tfLname;
    private static JTextField tfCard;
    private static JComboBox<String> subscriptionType;
    // DELETE private String[] subscription = new String[]{"TV_LOVER", "MUSIC_LOVER", "PREMIUM", "VIDEO_LOVER"};
    JDialog frame;
    HomeView homeView;
    boolean isUpdate;
    JOptionPane j;
    Subscription subs; //Enum Class

    CustomerController customerController;
    public CustomerView(){
        
    }
    
    //create a constructor that receives an user as an object
    
    
    // use getters to get user object info
    
    //Populate JTextField with getters
    
    
    
     
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
        bsubmit.setActionCommand("addCustomerDetails");
        customerController = new CustomerController();
        bsubmit.addActionListener(customerController);
        /*
        bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                //creating a instance of customer class
                Customer newCustomer = new Customer(getFirstName(), getLastName(), getCard(), getSubscriptionType());
                /*CreateCustomerController createCustomerController = new CreateCustomerController();
                createCustomerController.getClass();
                
                //save info on the db
                
                   JOptionPane.showMessageDialog(null, "Form submitted");
               
                   
                          
            
            }
        });

//Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
       // bsubmit.addActionListener(myRegController);
     */
         homeView = new HomeView("New Customer Details ", form, "Logout", "Go back");
    }
   
     /* 
     Map<String, JTextField> map = new HashMap<String, JTextField>();
 
     public void setValues(String fname, String lname, String card){
         map.put(fname, tfFname);
         map.put(lname, tfLname);
         map.put(card, tfCard);
     }
     
    */
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
      
}

