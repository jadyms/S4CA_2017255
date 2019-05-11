package init;


import customers.ManageCustomerView;
import init.HomeView;


public class Main {
    
    
    public static void main (String [] args){
        
          ManageCustomerView manageCustomer = new ManageCustomerView();
           manageCustomer.populateTable();
           
        new HomeView();
        
        
    }
}
