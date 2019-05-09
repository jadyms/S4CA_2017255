
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class CustomerController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Add Customer")) {
        
     CreateCustomerView createCustomer = new CreateCustomerView();
               createCustomer.addCustomer("", "", "", "");
    
            }else if(e.getActionCommand().equals("Manage existing customer")) {
                
                Model myModel = new Model();
               ResultSet rs = myModel.showCustomers();
               
           
             ManageCustomer viewCustomer = new ManageCustomer();
           viewCustomer.populateTable();
                
            }
    
    }
    
}
