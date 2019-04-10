
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JadyMartins
 */
public class CreateCustomeView {
    
    JDialog form;
    private JTextField tfFname;
    private JTextField tfLname;
    private JTextField tfCard;
    private JTextField tfEmail;   
    private JComboBox<String> subscriptionType;
    private String[] subscription = new String[]{ "TV Lover", "Music Lover", "Premium", "Movie Lover"};
    public CreateCustomeView(){
        
    }
    
    public void addCustomer(){
        //Panel for form 
         form = new JDialog();
         
        //Setting Layout
        GridBagLayout gbl = new GridBagLayout();
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

        
        JLabel email = new JLabel("E-mail: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(email, fgbc);

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

        tfEmail = new JTextField();
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 4
        fgbc.gridwidth = 3; //3 cell
        form.add(tfEmail, fgbc);

        //Button
        JButton bsubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 6; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        //Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
       // bsubmit.addActionListener(myRegController);

        //Frame Layout 
        BorderLayout bl = new BorderLayout();
        form.setLayout(gbl);
    }
}
