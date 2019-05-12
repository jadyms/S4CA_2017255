package rental;

/**
 *
 * @author JadyMartins
 */
//Create an object rental
public class Rental {
    //attributes
    private String loyalty_number;
    private String rental_id;
    private String title;
    private String titleType;
    private String rentalStatus;
    private String rentalDate;
    private String rentalReturn;
    private String returnDate;
                
    
    public Rental(String loyalty_number, String rental_id, String title, String titleType, String rentalStatus, String RentalDate,
            String RentalReturn, String ReturnDate) {

        this.loyalty_number = loyalty_number;
        this.rental_id = rental_id;
        this.title = title;
        this.titleType = titleType;
        this.rentalStatus = rentalStatus;
        this.rentalDate = rentalDate;
        this.rentalReturn = rentalReturn;
        this.returnDate = returnDate;
      
    }
    //getters
    public String getLoyaltyNumber(){
        return this.loyalty_number;
    }
    public String getRentalID(){
        return this.rental_id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getTitleType(){
        return this.titleType;
    }
    public String getRentalStatus(){
        return this.rentalStatus;
    }
    public String getRentalDate(){
        return this.rentalDate;
    }
    public String getRentalReturn(){
        return this.rentalReturn;
    }
    public String getReturnDate(){
        return this.returnDate;
    }
    
}
