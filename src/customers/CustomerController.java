package customers;


import model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
    
    Customer newCustomer;
    CustomerView customerView;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Customer")) {

            CustomerView createCustomer = new CustomerView();
            createCustomer.addCustomer("", "", "", "");

        } else if (e.getActionCommand().equals("Manage existing customer")) {

            Model myModel = new Model();
            ResultSet rs = myModel.showCustomers();

            ManageCustomer viewCustomer = new ManageCustomer();
            viewCustomer.populateTable();

        }else if (e.getActionCommand().equals("addCustomerDetails")) {

             //creating a instance of customer class
             customerView = new CustomerView(); 
             newCustomer = new Customer(
                     customerView.getFirstName(), 
                     customerView.getLastName(), 
                     customerView.getCard(), 
                     customerView.getSubscriptionType());
                
                   JOptionPane.showMessageDialog(null, "Form submitted");
               
                     //save info on the db
            }
        
    }
        
}
