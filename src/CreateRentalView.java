
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
    
     private JLabel tfID;
    private JTextField tfMedia;
    private JTextField tfYear;
       private JTextField tfRent;
        private JTextField tfTitle;
         private JTextField tfCard;
          private JLabel type;
          
          String name = "Jady";
   // private JComboBox<String> type;
    private String[] subscription = new String[]{ "TV Lover", "Music Lover", "Premium", "Movie Lover"};
    //String titleType;
    JDialog frame;
    HomeView homeView;
    
    
    public CreateRentalView(){
        
        
    }
    
    //Create a rental
    public void createRental(String loyalty_number){
        System.out.println("User " + loyalty_number + "wants to rent");
        
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
        tfID = new JLabel(name);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfID, fgbc);

        tfMedia = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfMedia, fgbc);

        tfYear = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfYear, fgbc);

         tfRent = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfRent, fgbc);
       // subscriptionType.setVisible(isCustomer);
       
       type = new JLabel("type");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(type, fgbc);
       // subscriptionType.setVisible(isCustomer);
       
       
        ltype = new JLabel(loyalty_number);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(ltype, fgbc);
       // subscriptionType.setVisible(isCustomer);
       
       

        //Button
        JButton bsubmit = new JButton("Show available titles for selected type");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 6; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        //Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
        bsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                Model myModel = new Model();
               ResultSet rs = myModel.showTitles("movies");
               
            CreateTitleView createTitle = new CreateTitleView();
           createTitle.showMovies(rs);
             
             
            }
        });
     
       
       homeView = new HomeView("Rent Title ", form, "Logout");
      //   homeView = new HomeView("Rent Title ", myPanel, "Logout");
         
         
         
         
   
         
         
         
         
    }
        
        
        
        
        
        
        
    }
    

    

