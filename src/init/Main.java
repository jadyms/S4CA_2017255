package init;


import customers.CustomerModel;
import customers.ManageCustomerView;
import init.HomeView;
import rental.RentalModel;
import titles.TitleModel;


public class Main {
    
    
    public static void main (String [] args){
        
           //Loading the Db into an arraylist       
           CustomerModel customerModel = new CustomerModel();
           customerModel.getCustomers();
      
           
           TitleModel titlesModel = new TitleModel();
           titlesModel.getTitles();
           
           RentalModel rentalModel = new RentalModel();
           rentalModel.getAllRental();
           
        new HomeView();
        
        
    }
}
