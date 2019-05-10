/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author JadyMartins
 */
public class RentalController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Create Rental")) {
           System.out.println("Create Rental");
       }
       else if (e.getActionCommand().equals(  "Return Rental")) {
           System.out.println("Return Rental");
       } 
    
    
    }
    
}
