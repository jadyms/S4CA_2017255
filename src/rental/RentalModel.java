package rental;

import customers.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.db;

/**
 *
 * @author JadyMartins
 */
public class RentalModel {

    static ArrayList<Rental> rental;//not in use
    static ArrayList<Rental> allRental;//rental from the db

    
    //create an array of rentals from the db
    public static ArrayList<Rental> getAllRental() {

        allRental = new ArrayList<Rental>(4);
        Rental r;

        try {
            Model myModel = new Model();
            ResultSet rs = myModel.showAllRental();

            while (rs.next()) {
                r = new Rental(
                        rs.getString("loyalty_number"),
                        rs.getString("rental_id"),
                        rs.getString("title"),
                        rs.getString("title_type"),
                        rs.getString("rental_status"),
                        rs.getString("rental_date"),
                        rs.getString("rental_return"),
                        rs.getString("returned_date")
                );
                allRental.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

        }

        return allRental;

    }
    
    //first attempt to hold rentals - not in use
    public static ArrayList<Rental> getRental(String id) {

        rental = new ArrayList<Rental>(4);
        Rental r;

        try {
            Model myModel = new Model();
            ResultSet rs = myModel.showRental(id);

            while (rs.next()) {
                r = new Rental(
                        rs.getString("loyalty_number"),
                        rs.getString("rental_id"),
                        rs.getString("title"),
                        rs.getString("title_type"),
                        rs.getString("rental_status"),
                        rs.getString("rental_date"),
                        rs.getString("rental_return"),
                        rs.getString("returned_date")
                );
                rental.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);

        }

        return rental;

    }


    public void addRental(Rental rent) {
        rental.add(rent);
    }

}
