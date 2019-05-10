package rental;


import model.Model;
import titles.ManageTitles;
import init.HomeView;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import loyaltycard.Subscription;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class CreateRentalView extends JFrame {
    
     private JLabel tfFname;
    private JLabel tfLname;
    private JLabel tfHold;
       private JLabel tfLoyaltyCard;
        private JTextField tfTitle;
         private JTextField tfCard;
          private JLabel type;
          
          
   // private JComboBox<String> type;
    private String[] subscription = new String[]{ "TV Lover", "Music Lover", "Premium", "Movie Lover"};
    //String titleType;
    JDialog frame;
    HomeView homeView;
    
    
    public CreateRentalView(){
        
        
    }
    
    //Receives a customer selected from JTable
    public void createRental(String setfname, String setlname, String sethold, String setloyalty_number, String setsubscription){

        
         JPanel parent = new JPanel();
      
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
       // subscriptionType.setVisible(isCustomer);
       
       
        ltype = new JLabel(setloyalty_number);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(ltype, fgbc);
       // subscriptionType.setVisible(isCustomer);
   

        //Button
        JButton bsubmit = new JButton("Rent");
        //fgbc.gridx = 1; //middle column
        //fgbc.gridy = 6; // row 6
        //fgbc.gridwidth = 3; //3 cell
   
        //Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
       
       
        Model myModel = new Model();
        Subscription subscription = Subscription.valueOf(setsubscription);
        // ResultSet rs = myModel.showTitles(subscription.getSubscriptonQuery());

       RentalController rentalController = new RentalController();
      
         RentalModel rentalModel = new RentalModel();
          if ( rentalModel.getRental().size()>=4){
              
              //JDialog to display information below
              System.out.println("You cant rent any more titles");
              
              
          } else{
           
           ManageRental manageRental = new ManageRental();
           JPanel rentTable = manageRental.populateTable();
         
           
          
        ManageTitles manageTitles = new ManageTitles();
        JPanel table = manageTitles.populateTable();
       // table.add(bsubmit);
        parent.add(form);
        parent.add(rentTable);
        parent.add(table);

        bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

              
         
           
           //display filme escolhido [
          //button para criar rental
          //add points to membership card
                   
       
              
            }
        }
        );
     

      //   homeView = new HomeView("Rent Title ", myPanel, "Logout");
                  
         homeView = new HomeView("Rent Title ", parent, "Logout","Go back"); 
         
    }
        
        
        
        
        
        
        
    }
}
    

    

