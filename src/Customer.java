public class Customer {
    
    String fname;
    String lname;
    String card;
    String subscription;
    String loyalty_number;
  String hold;
    CustomerView updateCustomer; 
   
     public Customer(String fname, String lname , String subscription, String card, String loyalty_number, String hold ){
        this.fname = fname;
        this.lname = lname;
        this.subscription = subscription;
         this.card = card;
         this.loyalty_number = loyalty_number;
         this.hold = hold;
         
         
     }
    
    public Customer (String fname, String lname, String card, String subscription){
        this.fname = fname;
        this.lname = lname;
        this.card = card;
        this.subscription = subscription;
        
        System.out.println(fname + lname+ card+ subscription);
        setSubscription(Subscription.valueOf(subscription.toUpperCase()));
    }

    Customer() {
        }
    
    public String getFirstname(){
        return this.fname;
    }
    
    public String getLastname(){
        return this.lname;
    }
    public String getCard(){
        return this.card;
    }
       public String getSubscription(){
        return this.subscription;
    }
       
     public String getLoyaltyNumber(){
        return this.loyalty_number;
    }  
    
      public String getHold(){
        return this.hold;
    }  
    
    public String setSubscription(Subscription s){
          if(null != s) switch (s) {
            case MUSIC_LOVER:
                System.out.println(("This user can rent Concerts and Music"));
            case PREMIUM:
                 System.out.println("This user can rent anything");
            case TV_LOVER:
                System.out.println("This user can rent Box Sets ");
            case VIDEO_LOVER:
               System.out.println("This user can rent Movies");
            default:
                break;
        }
        return null;
    }
    
    
    
       public void FillCustomerForm(String fname, String lname, String subscription, String card ){
         
           
        //get user info from the db
        
        //call this method passing an user as an object
      updateCustomer = new CustomerView();
      
        updateCustomer.addCustomer(fname, lname, subscription, card);
    //  updateCustomer.setValues(fname, lname, card);
        
        
    }
    
    

    
}
