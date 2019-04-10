
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author JadyMartins
 * Use of Anonymous Action Listener
 */
public class CustomerView extends JFrame{
    
    HomeView homeView;
         
        
    public CustomerView(){
        

  
        
    }
    public void AddNewCustomerPanel(){
      
        JPanel myPanel2 = new JPanel();
         String b1 = "Add Customer";
         String b2 = "Manage Existing Customer";
        // String b3 = "Manage Rental"; 
         //String b4 = "Loyalty Card";
        //Panel 2 for buttons
      
        //Buttons for Panel 2
        JButton btn1 = new JButton(b1);
        JButton btn2 = new JButton(b2);
      //  JButton btn3 = new JButton(b3);
       // JButton btn4 = new JButton(b4);
        
        //Set Action command
        btn1.setActionCommand(b1);
        btn2.setActionCommand(b2);
       // btn3.setActionCommand(b3);
        //btn4.setActionCommand(b4);
        
       //Add Action Listener as Anonymous Class
       btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Add customer Class");
               CreateCustomerView createCustomer = new CreateCustomerView();
               createCustomer.addCustomer();
               
           }});
       
       btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Manage Customer Class");
           }});
       
       
       

                //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        //myPanel2.add(btn3);
        //myPanel2.add(btn4);
        
           //Panel 2 layout
        GridLayout mgr = new GridLayout(1,2);
        myPanel2.setLayout(mgr);
    
        homeView = new HomeView("Select an option", myPanel2, "Logout");
     
      // homeView.mainPanel("Select an option", myPanel2, "Logout");
               //homeView.HomePanel("Select an option", myPanel2, "Logout");

             
        
    }
    
}
