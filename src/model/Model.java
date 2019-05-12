package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Model {

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    db newdb; //Connection with the db

    public Model() {

        newdb = new db();
    }

    public ResultSet showTitles() {

        String query = "SELECT * FROM titles;";
        
        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showTitles(String subscriptionQuery) {

        String query = subscriptionQuery;

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showCustomers(String q) {

        String query = q;

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showCustomers() {

        String query = "SELECT * FROM customer;";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showPoints() {

        String query = "SELECT * FROM points;";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showAllRental() {

        String query = "SELECT * FROM rental; ";

        rs = newdb.newQuery(query);

        return rs;

    }

    public ResultSet showRental(String id) {

        String query = "SELECT * FROM rental WHERE loyalty_number = '" + id + "' AND rental_status = 'RT';";

        rs = newdb.newQuery(query);

        return rs;

    }

}
