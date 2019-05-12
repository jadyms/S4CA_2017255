package customers;

import loyaltycard.Subscription;

//creates a customer as an object Customer
public class Customer {
//attrubutes
    private String fname;
    private String lname;
    private String card;
    private String subscription;
    private String loyalty_number;
    private String hold;
    AddCustomerView updateCustomer;

    public Customer(String fname, String lname, String subscription, String card, String loyalty_number, String hold) {
        this.fname = fname;
        this.lname = lname;
        this.subscription = subscription;
        this.card = card;
        this.loyalty_number = loyalty_number;
        this.hold = hold;

    }

    public Customer(String fname, String lname, String card, String subscription) {
        this.fname = fname;
        this.lname = lname;
        this.card = card;
        this.subscription = subscription;

     
        
    }

    Customer() {
    }
    
    //getters

    public String getFirstname() {
        return this.fname;
    }

    public String getLastname() {
        return this.lname;
    }

    public String getCard() {
        return this.card;
    }

    public String getSubscription() {
        return this.subscription;
    }

    public String getLoyaltyNumber() {
        return this.loyalty_number;
    }

    public String getHold() {
        return this.hold;
    }
        
    public void FillCustomerForm(String fname, String lname, String subscription, String card, String loyalty_card) {

        //get user info from the db
        //call this method passing an user as an object
        updateCustomer = new AddCustomerView();
        updateCustomer.addCustomer(fname, lname, subscription, card)
                ;
    

    }

}
