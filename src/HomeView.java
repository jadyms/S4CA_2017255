
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


public class HomeView extends JFrame {
    
      JDialog frame;
     String message;
     JPanel panel;
     String logout;
               
      public HomeView(){
         HomePanel();
        
      }
      
      public HomeView(String message, JPanel panel, String logout){
          this.message = message;
          this.panel = panel;
          this.logout = logout;
          mainPanel(message, panel, logout);
      }
         
      
    private void newFrame(int h, int w) {
       
        frame = new JDialog(frame, "Home");
        frame.setSize(h, w);
        frame.setModal(true);
        frame.setTitle("Ultra Vision");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.validate();
        frame.repaint();
    }
    
   
    public void HomePanel(){
      
         JPanel myPanel2 = new JPanel();
         String b1 = "Manage Customer";
         String b2 = "Manage Titles";
         String b3 = "Manage Rental"; 
         String b4 = "Loyalty Card";
        //Panel 2 for buttons
      
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

        //Add Action Listener
        btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Customer options");
               CustomerView customer = new CustomerView();
               customer.AddNewCustomerPanel();
               
           }});
        
        btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Titles Options");
               TitlesView titles = new TitlesView();
               titles.TitlesPanel();
               
           }});
       
        btn3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               
                            
               System.out.println("Manage Rental");
               RentalView rental = new RentalView();
               rental.RentalPanel();
           }});
        
        
        btn4.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               
               Model myModel = new Model();
               ResultSet rs = myModel.showPoints();
               
               System.out.println("Membership Card");
               LoyaltyCardView loyaltyCard = new LoyaltyCardView();
               loyaltyCard.viewPoints(rs);
               
           }});
        
                //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        myPanel2.add(btn3);
        myPanel2.add(btn4);
        
           //Panel 2 layout
        GridLayout mgr = new GridLayout(2,2);
        myPanel2.setLayout(mgr);
        
       mainPanel("Select an option", myPanel2, "Logout");
        
    }
    
     public void mainPanel(String message, JPanel myPanel2, String b5) {
        newFrame(900, 600);
        //Panel 1 for welcome message
        JPanel myPanel1 = new JPanel();
        //message for Panel 1
        JLabel myLabel = new JLabel(message);//according to method calling it
        
        
        
        //Panel 3 for footer buttons
        JPanel myPanel3 = new JPanel();
        
        //Logout button
         JButton btn5 = new JButton(b5);
        
        //Instance of Controller that holds Action Events     
       Logout l = new Logout();
        btn5.addActionListener(l);
        //btn2.addActionListener(cController);

        //Add Welcome message to Panel 1
        myPanel1.add(myLabel);
        
    
          //Add Buttons to Panel 2
       myPanel3.add(btn5);

     
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
