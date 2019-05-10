package init;


import loyaltycard.LoyaltyCardView;
import model.Model;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

//This is the home
//of the application
public class HomeView extends JFrame {

    JDialog frame;
    JPanel panel;
    String message;
    String logout;
    String goback;

    //first panel when system is initialized
    public HomeView() {
        HomePanel();
    }

    //constructor that receives panel
    //and place it onto the frame
    public HomeView(String message, JPanel panel, String logout, String goback) {
        this.message = message;
        this.panel = panel;
        this.logout = logout;
        this.goback = goback;
        mainPanel(message, panel, logout, goback);
    }

    //creating and setting the frame
    private void newFrame(int h, int w) {
        frame = new JDialog(frame, "Home");
        frame.setSize(h, w);
        frame.setModal(true);
        frame.setTitle("Ultra Vision");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }

    public void HomePanel() {
        //Creating Panel 2
        JPanel myPanel2 = new JPanel();
        String b1 = "Manage Customer";
        String b2 = "Manage Titles";
        String b3 = "Manage Rental";
        String b4 = "Loyalty Card";
        //Buttons for Panel 2
        JButton btn1 = new JButton(b1);
        JButton btn2 = new JButton(b2);
        JButton btn3 = new JButton(b3);
        JButton btn4 = new JButton(b4);

        //Add Action command
        btn1.setActionCommand(b1);
        btn2.setActionCommand(b2);
        btn3.setActionCommand(b3);
        btn4.setActionCommand(b4);

        //Add Action Listeners
 
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage a Customer - add a customer or manage an existing customer
                //Create a rent for selected customer
                //Update customer information
                //Manage an existing customer rental
                DefaultPanel customer = new DefaultPanel();
                customer.TwoButtonPanel("Customer","Add Customer", "Manage existing customer");
            }
        });

        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage titles options
                DefaultPanel customer = new DefaultPanel();
                customer.TwoButtonPanel("Titles","Add Title", "Manage existing title");
                //TitlesView titles = new TitlesView();
                //titles.TitlesPanel();
            }
        });

        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage rental options
                DefaultPanel customer = new DefaultPanel();
                customer.TwoButtonPanel("Rental","Create Rental", "Return Rental");
              
              //  RentalView rental = new RentalView();
              //  rental.RentalPanel();
            }
        });

        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //To manage Loyalty Card
                Model myModel = new Model();
                ResultSet rs = myModel.showPoints();

                LoyaltyCardView loyaltyCard = new LoyaltyCardView();
                loyaltyCard.viewPoints(rs);

            }
        });

        //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        myPanel2.add(btn3);
        myPanel2.add(btn4);

        //Panel 2 Grid layout
        GridLayout mgr = new GridLayout(2, 2);
        myPanel2.setLayout(mgr);

        //Placing panel into the frame
        mainPanel("Select an option", myPanel2, "Logout", "Go back");

    }

    public void mainPanel(String message, JPanel myPanel2, String b5, String b6) {
       //Frame size
        newFrame(800, 600);
        //Panel 1 for welcome message
        JPanel myPanel1 = new JPanel();
        //message for Panel 1
        JLabel myLabel = new JLabel(message);//according to method calling it

        //Panel 3 for footer buttons
        JPanel myPanel3 = new JPanel();

        //Logout and Go Back buttons
        JButton btn5 = new JButton(b5);
        JButton btn6 = new JButton(b6);
        
        //Instance of Logout Class that terminate the program     
        Logout l = new Logout();
        btn5.addActionListener(l);
 
        //Add Welcome message to Panel 1
        myPanel1.add(myLabel);

        //Add Buttons to Panel 2
        myPanel3.add(btn5);
        myPanel3.add(btn6);
        
        //Frame Layout
        BorderLayout manager = new BorderLayout();
        frame.setLayout(manager);
        
        //Adding Panels to the frame
        frame.add(myPanel1, BorderLayout.NORTH);
        frame.add(myPanel2, BorderLayout.CENTER);
        frame.add(myPanel3, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}
