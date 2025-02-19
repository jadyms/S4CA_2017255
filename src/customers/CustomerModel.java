package customers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.db;

public class CustomerModel {
    
      static ArrayList<Customer> users;
      
    public CustomerModel(){
        
    }
    
 
    public static ArrayList<Customer> getCustomers() {

        users = new ArrayList<Customer>();
        Customer c;

        try {
            Model myModel = new Model();
           ResultSet rs = myModel.showCustomers("SELECT * FROM customer;");
            

            while (rs.next()) {
                c = new Customer(
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("subscription"),
                        rs.getString("card"),
                        rs.getString("loyalty_number"),
                        rs.getString("hold")
                );
                users.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

        }
    
        
       
       
        
  
        

        return users;

    }
    
    public String getLastLoyaltyNumber(){
         
         int last =  Integer.parseInt(users.get(users.size()-1).getLoyaltyNumber())+1;
        System.out.println(String.valueOf(last));
         return String.valueOf(last);
    }
}
