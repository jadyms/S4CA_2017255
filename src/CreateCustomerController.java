/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class CreateCustomerController {
    
    private String fname;
    private String subscription;
    
    
    public CreateCustomerController(){
        
    CreateCustomerView createCustomerView = new CreateCustomerView();
   subscription = createCustomerView.getSubscriptionType();
   
        System.out.println(subscription);
    
        
        
    }
    
}
