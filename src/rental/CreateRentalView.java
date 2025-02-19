package rental;

import titles.ManageTitlesView;
import init.HomeView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JadyMartins
 */
//Class to Display a panel with
//customer details
//rent for that customer
//titles to be rented 
//Class in progress - more encapsulations required
public class CreateRentalView extends JFrame {

    //to be used with getters
    //user details
    private JLabel tfFname;
    private JLabel tfLname;
    private JLabel tfHold;
    private JLabel tfLoyaltyCard;
    private JTextField tfTitle;
    private JTextField tfCard;
    private JLabel type;
    
    //atributes from selected row
    // displayed at firts panel
    static String setfname;
    static String setlname;
    static String sethold;
    static String setloyalty_number;
    static String setsubscription;
    
    HomeView homeView;

    public CreateRentalView() {

    }

    //customer details from the selected row - manage customer
    public CreateRentalView(String setfname, String setlname, String sethold, String setloyalty_number, String setsubscription) {

        this.setfname = setfname;
        this.setlname = setlname;
        this.setloyalty_number = setloyalty_number;
        this.setsubscription = setsubscription;
        createRental(); // form with customer details

    }

    
    public void createRental() {
        //  JPanel parent = new JPanel();
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

        JLabel titlesHeld = new JLabel("Titles Held: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 1; //1 cell
        form.add(titlesHeld, fgbc);

        JLabel titlesToRent = new JLabel("Titles to Rent: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(titlesToRent, fgbc);

        JLabel ltype = new JLabel("Title Type: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(ltype, fgbc);

        JLabel lnumber = new JLabel("Loyalty card: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 5; // row 6
        fgbc.gridwidth = 1; //1 cell
        form.add(lnumber, fgbc);

        //Form textfield       
        tfFname = new JLabel(setfname);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfFname, fgbc);

        tfLname = new JLabel(setlname);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLname, fgbc);

        tfHold = new JLabel(sethold);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfHold, fgbc);

        //should be calculated from the array of rental
        //and subtract from 4
        tfLoyaltyCard = new JLabel("Add how many titles user can rent");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfLoyaltyCard, fgbc);
        // subscriptionType.setVisible(isCustomer);

        type = new JLabel(setsubscription);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(type, fgbc);
  
        ltype = new JLabel(setloyalty_number);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(ltype, fgbc);
        
       //send panel to method parent
       //that holds all the panels for rental
       //should be in the controller!!!!
               parent(form);

    }
    //the rental panel altogether
    //should be in the controller!!!!
    public void parent(JPanel form) {
        //Main Panel
        JPanel parent = new JPanel();
 
        //Customer details
        JPanel f = form;
        
        //Customer rental
        ManageRental manageRental = new ManageRental();
        JPanel rentTable = manageRental.populateTable(setloyalty_number);

        //Titles
        ManageTitlesView manageTitles = new ManageTitlesView();
        JPanel table = manageTitles.populateTable("Create Rent", "Choose another title", false);
      
        //add elements to panel
        parent.add(form);
        parent.add(new JLabel("Rented titles for user"));
        parent.add(rentTable);
        parent.add(new JLabel("Select a title to rent"));
        parent.add(table);

        //set layout
        parent.setLayout(new BoxLayout(parent, BoxLayout.Y_AXIS));

        //place it on the main frame
        homeView = new HomeView("Rent Title ", parent, "Logout", "Go back");
      
    }

}
