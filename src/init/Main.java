package init;


import customers.CustomerModel;

import rental.RentalModel;
import titles.TitleModel;


public class Main {
    
    
    public static void main (String [] args){
        
           //Loading all the Db into arraylists 
           //Then dealing only with the arrays
           
           //customers
           CustomerModel customerModel = new CustomerModel();
           customerModel.getCustomers();
           //titles           
           TitleModel titlesModel = new TitleModel();
           titlesModel.getTitles();
           //rentals
           RentalModel rentalModel = new RentalModel();
           rentalModel.getAllRental();
           
        new HomeView();
        
        
    }
}
