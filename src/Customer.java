
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class Customer {
    
    String fname;
    String lname;
    String card;
    String subscription;
    ArrayList<Customer> customers;
     CreateCustomerView updateCustomer; 
   
     public Customer(){
         
     }
    
    public Customer (String fname, String lname, String card, String subscription){
        this.fname = fname;
        this.lname = lname;
        this.card = card;
        this.subscription = subscription;
    }
    /*
    
    public Customer(){
         updateCustomer = new CreateCustomerView();
        this.fname = updateCustomer.getFirstName();
        this.lname = updateCustomer.getLastName();
        this.card = updateCustomer.getCard();
        this.subscription = updateCustomer.getSubscriptionType();
    }
    */
    public ArrayList<Customer> customerList(){
        
        //customers.add(fname, lname, card, subscription);
        return customers;
    }
    public void FillCustomerForm(String fname, String lname, String subscription, String card ){
        
        //get user info from the db
        
        //call this method passing an user as an object
      updateCustomer = new CreateCustomerView();
        updateCustomer.addCustomer(fname, lname, subscription, card);
      
        
        
    }
    
    
    
    
    
}
