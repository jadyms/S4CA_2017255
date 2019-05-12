
package rental;

import init.HomeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


/**
 *
 * @author JadyMartins
 */
public class RentalController implements ActionListener, ListSelectionListener{
    
    HomeView homeView;
   

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Create Rental from customer Loyalty Card")) {
           
           //To be developed
         
//           RentalModel rentalModel = new RentalModel();
//          if ( rentalModel.getRental("101").size()>=4){
//              
//              //JDialog to display information below
//              System.out.println("You cant rent any more titles");
//              
//              
//          } else{
//               
//            ManageCustomerView manageCustomer = new ManageCustomerView();
//            manageCustomer.populateTable();
//            
     //ManageRental manageRental = new ManageRental();
     //homeView = new HomeView("Select a customer",  manageRental.populateTable(), "Logout", "Go back");
  
          }
     
       
       else if (e.getActionCommand().equals("Return Rental")) {
       
           //to be deleloped
           
           
       }   else if (e.getActionCommand().equals("Create Rental")) {
          
           //create rental is being manipulated in customer controller
       } 
    
    
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        //when row is selected, you can change de status of rental from RT rented to RN - returned
        
    
    }
    
}
