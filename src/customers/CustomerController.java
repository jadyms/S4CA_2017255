package customers;


import static customers.CustomerModel.users;
import init.HomeView;
import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import rental.CreateRentalView;
import rental.ManageRental;
import rental.RentalController;
import rental.RentalModel;

/**
 *
 * @author JadyMartins
 */
public class CustomerController implements ActionListener, ListSelectionListener{
    
    Customer newCustomer;
    AddCustomerView addCustomerView;
    ManageCustomerView manageCustomerView;
    CustomerModel customerModel;
    HomeView homeView;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Customer")) {

            AddCustomerView createCustomer = new AddCustomerView();
            createCustomer.addCustomer("", "", "", "","addCustomerDetails");
            
     
        } else if (e.getActionCommand().equals("Manage existing customer")) {

            
           ManageCustomerView manageCustomer = new ManageCustomerView();
            manageCustomer.populateTable();

        }else if (e.getActionCommand().equals("addCustomerDetails")) {
            
             //PLACE IT IN CUSTOMER MODEL
             //creating a instance of customer class
             addCustomerView = new AddCustomerView(); 
            
            int last =  Integer.parseInt(customerModel.users.get(customerModel.users.size()-1).getLoyaltyNumber())+1;
                     customerModel.users.add(new Customer(
                     
                     addCustomerView.getFirstName(), 
                     addCustomerView.getLastName(), 
                     addCustomerView.getSubscriptionType(),
                     addCustomerView.getCard(), 
                     String.valueOf(last),
                              "0"
                                  ));
                           
                   JOptionPane.showMessageDialog(null, "Customer created. You can manage details in Manage Customer");
      
                    
                  
                     //save info on the db
            }else if (e.getActionCommand().equals("Create Rental")) {

               RentalModel rentalModel = new RentalModel();
             
               
               
               
               if ( rentalModel.getRental(manageCustomerView.getLoyaltyNumber()).size()>=4){
              
              //JDialog to display information below
              System.out.println("You cant rent any more titles");
              
              
          } else{
               
            ManageCustomerView manageCustomer = new ManageCustomerView();
            manageCustomer.populateTable();
            
            }
        
            }
            }

    //When a customer is selected
    //It means when a row is selected from the JTable
    @Override
    public void valueChanged(ListSelectionEvent e) {
       
        Customer customer = new Customer();

        int row = manageCustomerView.table.getSelectedRow();
        String fname = (String) manageCustomerView.table.getValueAt(row, 0);
        String lname = (String) manageCustomerView.table.getValueAt(row, 1);
        String subscription = (String) manageCustomerView.table.getValueAt(row, 2);
        String card = (String) manageCustomerView.table.getValueAt(row, 3);
        String loyalty_number = (String) manageCustomerView.table.getValueAt(row, 4);
        String hold = (String) manageCustomerView.table.getValueAt(row, 5);
        String message = (fname + " " + lname);
     
        Object[] options ={"Update Customer","Create Rental" ,"Manage Rental"};
        int n = JOptionPane.showOptionDialog(null,
                        "Update " + message + " info",         
                         "Select an option for the user",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[2]);    
                
                //if create rental
                if (n == 1) {
                    
                    //MAKE RENTAL AS A CLASS AND CREATE AN ARRAY OF RENTALS
                    
               ManageRental manageRental = new ManageRental();
               manageRental.populateTable(loyalty_number);
                
               
                   RentalModel rentalModel = new RentalModel();
                     if ( rentalModel.getRental((String) manageCustomerView.table.getValueAt(row, 4)).size()>=4){
                  //   if ( rentalModel.allRental((String) manageCustomerView.table.getValueAt(row, 4)).size()>=4){
                         JOptionPane.showMessageDialog (null, 
                                 "Customer have reached 4 titles rented. Select the option - Manage rental - to return titles" , 
                                 "You cannot rent any more titles", 
                                 JOptionPane.ERROR_MESSAGE);
              
                                   }else{
                         
                    manageCustomerView = new ManageCustomerView();
                    
                    CreateRentalView createRental = new CreateRentalView( 
                            manageCustomerView.getFirstName(), 
                            manageCustomerView.getLastName(), 
                            manageCustomerView.getLoyaltyHold(),
                            manageCustomerView.getLoyaltyNumber(),
                            manageCustomerView.getSubscription());
                    
                    
 
                }
                }//if update customer
                else if (n == 0) {
                    
                    customer.FillCustomerForm(fname,lname, subscription,card, loyalty_number);
                    
                    customerModel.users.indexOf(loyalty_number);
                    customerModel.users.set(customerModel.users.indexOf(loyalty_number)+1,new Customer(
                    fname,
                            lname, 
                            subscription,
                            card, 
                            loyalty_number,
                            hold
                            
                                               
                    ));

                                
                         //manageCustomerView.getFirstName(),
                         //manageCustomerView.getLastName(), 
                         //manageCustomerView.getSubscription(),
                         //manageCustomerView.getCard());
                } 



//ig manage rental
                else if (n == 2) {

                    //create a try catch in case person has no 
                    Model myModel = new Model();
                    ResultSet rs = myModel.showRental(manageCustomerView.getLoyaltyNumber());

                    ManageRental manageRental = new ManageRental();
                    manageRental.viewRentals(rs);

                }

    
    }
        
}
