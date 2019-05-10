/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
           System.out.println("Create Rental from Main menu");
           //JDialog to insert customer id
           
           RentalModel rentalModel = new RentalModel();
          if ( rentalModel.getRental().size()>=4){
              
              //JDialog to display information below
              System.out.println("You cant rent any more titles");
              
              
          } else{
           
              
     ManageRental manageRental = new ManageRental();
     homeView = new HomeView("Select a customer",  manageRental.populateTable(), "Logout", "Go back");
  
          }
     
       }
       else if (e.getActionCommand().equals("Return Rental")) {
           System.out.println("Return Rental");
           
           
       }   else if (e.getActionCommand().equals("Create Rental")) {
           System.out.println("Return Rental");
       } 
    
    
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
