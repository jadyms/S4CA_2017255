
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JadyMartins
 */
public class CreateCustomerView extends JFrame{
    
    //JDialog form;
    private JTextField tfFname;
    private JTextField tfLname;
    private JTextField tfCard;
    private JComboBox<String> subscriptionType;
    private String[] subscription = new String[]{ "TV Lover", "Music Lover", "Premium", "Movie Lover"};
    JDialog frame;
       HomeView homeView;
       boolean isUpdate;
       
    public CreateCustomerView(){
        
    }
    
    //create a constructor that receives an user as an object
    
    
    // use getters to get user object info
    
    //Populate JTextField with getters
    
    public void addCustomer(){
            
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

        tfLname = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLname, fgbc);

        tfCard = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfCard, fgbc);

        subscriptionType = new JComboBox<String>(subscription);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(subscriptionType, fgbc);
       // subscriptionType.setVisible(isCustomer);


        //Button
        JButton bsubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        //Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
       // bsubmit.addActionListener(myRegController);
     
         homeView = new HomeView("New Customer Details ", form, "Logout");
    }
    
    
    
    
    
}
