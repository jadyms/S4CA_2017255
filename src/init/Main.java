package init;


import customers.CustomerModel;
import customers.ManageCustomerView;
import init.HomeView;


public class Main {
    
    
    public static void main (String [] args){
        
           //ManageCustomerView manageCustomer = new ManageCustomerView();
           //manageCustomer.populateTable();
           
           CustomerModel customerModel = new CustomerModel();
           customerModel.getCustomers();
           
        new HomeView();
        
        
    }
}
