
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DefaultPanel extends JFrame{
    //Declaring Home View class 
    //to use the Main Panel method 
    //that cointains the main frame of the application
      HomeView homeView; 
      CustomerController customerController;
        
    public DefaultPanel(){
              
    }
    
    public void TwoButtonPanel(String action, String b1, String b2){
      
        //Add new customer or manage existing one
        JPanel myPanel2 = new JPanel();
 
        //Buttons for Panel 2
        JButton btn1 = new JButton(b1);
        JButton btn2 = new JButton(b2);
        
        //Set Action command
        btn1.setActionCommand(b1);
        btn2.setActionCommand(b2);
        
        //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        
        //Panel 2 layout
        GridLayout mgr = new GridLayout(1,2);
        myPanel2.setLayout(mgr);
    
        
        //Directing to Customer or Titles Controller
        //according to action 
        //specified in the homeview
        if (action.equals("Customer")) {
           //Instance of Customer Controller to access ActionEvents
           customerController = new CustomerController();
            btn1.addActionListener(customerController);
            btn2.addActionListener(customerController);
   
        } else if(action.equals("Titles")) {
            //Instance of Titles Controller to access ActionEvents
           // pController = new ProviderController();
            //btn1.addActionListener(pController);
            //btn2.addActionListener(pController);
        
        }
           //Passing panel onto the Frame         
           homeView = new HomeView("Select an option", myPanel2, "Logout", "Go back");
        
  
   
/*

       //Add Action Listener as Anonymous Class
       btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
            //  if (btn1.equals)
       
               
               CreateCustomerView createCustomer = new CreateCustomerView();
               createCustomer.addCustomer("", "", "", "");
               
           }});
       
       btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Manage Customer Class");
               
       
               Model myModel = new Model();
               ResultSet rs = myModel.showCustomers();
               
           
             ManageCustomer viewCustomer = new ManageCustomer();
           viewCustomer.populateTable();
             //viewCustomer.viewCustomers(rs);
               
           }});
       
       
  */     

        
    }
    
    
     public void AddOrManageCustomer(){
      
        //Add new customer or manage existing one
        JPanel myPanel2 = new JPanel();
        String b1 = "Add Customer";
        String b2 = "Manage Existing Customer";

        //Buttons for Panel 2
        JButton btn1 = new JButton(b1);
        JButton btn2 = new JButton(b2);
  
        //Set Action command
        btn1.setActionCommand(b1);
        btn2.setActionCommand(b2);


       //Add Action Listener as Anonymous Class
       btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Add customer Class");
               CreateCustomerView createCustomer = new CreateCustomerView();
               createCustomer.addCustomer("", "", "", "");
               
           }});
       
       btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Manage Customer Class");
               
       
               Model myModel = new Model();
               ResultSet rs = myModel.showCustomers();
               
           
             ManageCustomer viewCustomer = new ManageCustomer();
           viewCustomer.populateTable();
             //viewCustomer.viewCustomers(rs);
               
           }});
       
       
       

                //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        //myPanel2.add(btn3);
        //myPanel2.add(btn4);
        
           //Panel 2 layout
        GridLayout mgr = new GridLayout(1,2);
        myPanel2.setLayout(mgr);
    
        homeView = new HomeView("Select an option", myPanel2, "Logout", "Go back");
     
      // homeView.mainPanel("Select an option", myPanel2, "Logout");
               //homeView.HomePanel("Select an option", myPanel2, "Logout");

             
        
    }
    
    
}
