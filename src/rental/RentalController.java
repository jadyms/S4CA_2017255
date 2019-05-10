/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author JadyMartins
 */
public class RentalController implements ActionListener, ListSelectionListener{
   

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Create Rental")) {
           System.out.println("Create Rental");
           
     ManageRental manageRental = new ManageRental();
            manageRental.populateTable();
       }
       else if (e.getActionCommand().equals(  "Return Rental")) {
           System.out.println("Return Rental");
       } 
    
    
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
