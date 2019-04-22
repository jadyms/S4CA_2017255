
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
    CreateCustomerView updateCustomer; 
   
     public Customer(){
         
     }
    
    public Customer (String fname, String lname, String card, String subscription){
        this.fname = fname;
        this.lname = lname;
        this.card = card;
        this.subscription = subscription;
        
        System.out.println(fname + lname+ card+ subscription);
        setSubscription(Subscription.valueOf(subscription.toUpperCase()));
    }
    
    public String setSubscription(Subscription s){
   
        
        
       if(null != s) switch (s) {
            case MUSIC_LOVER:
                System.out.println(" \"Music Lover :-)\"");
            case PREMIUM:
                 System.out.println(" \"Premium :-)\"");
            case TV_LOVER:
                System.out.println(" \"TV Lover :-)\"");
            case VIDEO_LOVER:
               System.out.println(" \"Video Lover :-)\"");
            default:
                break;
        }
        return null;
    }
    
       
       
       /*

        Subscription s  ;
  
    if(subscription.equals(Subscription.MUSIC_LOVER.toString())){
        System.out.println("This user can rent Concerts and Music");
        
}else if (subscription.equals(Subscription.PREMIUM.toString())){
        System.out.println("This user can rent anything");
        
    
}else if (subscription.equals(Subscription.TV_LOVER.toString())){
        System.out.println("This user can rent Box Sets ");
        
    
}else if (subscription == Subscription.VIDEO_LOVER.toString()){
        System.out.println("This user can rent Movies");
        
    
}
        return null;
    */
   
            
     
    
       
    
    
         
    
       
    
    
    
    public void FillCustomerForm(String fname, String lname, String subscription, String card ){
        
        //get user info from the db
        
        //call this method passing an user as an object
      updateCustomer = new CreateCustomerView();
        updateCustomer.addCustomer(fname, lname, subscription, card);
      
        
        
    }
    
    

    
}
