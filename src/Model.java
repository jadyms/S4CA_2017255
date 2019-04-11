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

         
        String query = "SELECT * FROM movies;";
            
        rs = newdb.newQuery(query);
        
 
		return rs;	
             
    }
/*
    //get email and password from login session
    public boolean customerLogin(String email, String password) {

        
        String query = "SELECT * FROM customers WHERE cEmail = '" + email + "' AND password = '" + password + "';";
        System.out.println("query customer login" + query);
          
        boolean r = newdb.executeQuery(query);
        
        return r;
    }

    public boolean servicePLogin(String email, String password) {

        String query = "SELECT * FROM providers WHERE pEmail = '" + email + "' AND password = '" + password + "';";

        boolean r = newdb.executeQuery(query);

        return r;
    }

    public boolean adminLogin(String email, String password) {

        String query = "SELECT * FROM admin WHERE email = '" + email + "' AND password = '" + password + "';";

        boolean r = newdb.executeQuery(query);
        System.out.println("admin login query "+ query);
        return r;
    }

    public ResultSet selectProvider() {

        String query = "SELECT * FROM providers;";
        rs = newdb.newQuery(query);
        return rs;
    }
    
    public void searchByLoc(String location) {

        String query = "SELECT\n"
                + "p.location AS 'Location',\n"
                + "p. fName AS 'Provider',\n"
                + "p.pEmail as 'Provider E-mail',\n"
                + "CONCAT (b.fdate, \" at \",  b.ftime)  AS 'Free Slot'\n"
                + "FROM bookings AS b\n"
                + "\n"
                + "JOIN providers AS  p ON p.pEmail = b.pEmail\n"
                + "WHERE slotStatus = 'A'\n"
                + "AND location = '" + location + "'\n"
                + "\n"
                + ";";
     //   boolean r = newdb.showTable();
//        System.out.println(r);

       // return r;

    }
    
     
    
       public ResultSet setStatus(String email) {

         
        String query = "SELECT * FROM bookings WHERE pEmail = '" + email + "';";
        
        rs = newdb.newQuery(query);

		return rs;	
             
    }
    
     public ResultSet showCustBookings(String email) {

         
        String query = "SELECT * FROM bookings WHERE cEmail = '" + email + "';";
        
        rs = newdb.newQuery(query);

		return rs;	
             
    }
     
      public ResultSet showProvBookings(String email) {

         
        String query = "SELECT * FROM bookings WHERE pEmail = '" + email + "' AND cEmail IS NOT NULL;";
        
        rs = newdb.newQuery(query);
        
  		return rs;	
             
    }
     
    public void createCustomer(String fname, String lname, String mobile, String cEmail, String password) {
            System.out.println(fname + " " + lname + " " + mobile + " " + cEmail + " " + password);

        String query = "INSERT INTO customers "
                + "VALUES ('" + fname + "',"
                + " '" + lname + "',"
                + " '" + mobile + "',"
                + " '" + cEmail + "',"
                + " '" + password + "');";
        
        
                 newdb.executeInsert(query);
        
    }
    
    public void createProvider(String fname, String lname, String mobile, String pmail, String password, String location, String regStatus, String admResp) {
            System.out.println(fname + " " + lname + " " + mobile + " " + pmail + " " + password + " " + location);

        String query = "INSERT INTO providers "
                + "VALUES ('" + fname + "',"
                + " '" + lname + "',"
                + " '" + mobile + "',"
                + " '" + pmail + "',"
                + " '" + password + "',"
                + " '" + location + "',"
                + " '" + regStatus + "',"
                + " '" + admResp + "');";
        
         newdb.executeInsert(query);
        
    }
    
    
    public void createAdmin(String email, String password) {
            System.out.println(email + " " + password);

        String query = "INSERT INTO admin "
                + "VALUES ( '" + email +"',"
                + password +"');";
        
         newdb.executeInsert(query);
        
    }
    
    public void setComplaint(String pEmail, String cEmail, String complaint) {
       
        String query = "INSERT INTO providers (cEmail, p_email, complaint, admResp)"
                + "VALUES ('" + cEmail + "'," + " '" + pEmail + "', "+ " '" + complaint + "',"+ " 'admin@admin.com');";
     
    newdb.executeInsert(query);
        
    }
    
     public void bookingApt(String fdate, String ftime, String pEmail, String cEmail) {
            System.out.println(fdate + " " + ftime + " " + pEmail + " " + cEmail + " " + "B");

        String query = "UPDATE bookings SET slotStatus='B', cEmail = '"+ cEmail +"' WHERE  fdate='"+fdate+"' AND ftime ='"+ftime+"' AND pEmail='"+pEmail+"';";
        
        
                 newdb.executeInsert(query);
                 System.out.println("Saved on the db" + query);
                 
        
    }
    
     public void cancelApt(String fdate, String ftime, String pEmail, String cEmail) {
   

        String query =  "UPDATE bookings SET aptStatus='Cancelled' WHERE  fdate='"+fdate+"' AND ftime ='"+ftime+"' AND pEmail='"+pEmail+"'AND cEmail='"+cEmail+"';";
       
                 newdb.executeInsert(query);
         System.out.println(query);   
    }
     public void noShowApt(String fdate, String ftime, String pEmail, String cEmail) {
   

        String query =  "UPDATE bookings SET aptStatus='No-Show' WHERE  fdate='"+fdate+"' AND ftime ='"+ftime+"' AND pEmail='"+pEmail+"';";
       
                 newdb.executeInsert(query);
        
    }
    public void CompletedApt(String fdate, String ftime, String pEmail, String cEmail) {
   

        String query =  "UPDATE bookings SET aptStatus='Completed' WHERE  fdate='"+fdate+"' AND ftime ='"+ftime+"' AND pEmail='"+pEmail+"';";
       
                 newdb.executeInsert(query);
        
    }



   public void confirmApt(String fdate, String ftime, String pEmail, String cEmail) {
   

        String query =  "UPDATE bookings SET aptStatus='Confirmed' WHERE  fdate='"+fdate+"' AND ftime ='"+ftime+"' AND pEmail='"+pEmail+"';";
       
                 newdb.executeInsert(query);
        
    }
    public void setSlotAs(String fdate, String ftime, String pEmail, String slotStatus) {
   

        String query = "INSERT INTO bookings VALUES ('"+pEmail+"','"+fdate+"','"+ftime+"','"+slotStatus+"',NULL,'Pending',NULL);";
                 newdb.executeInsert(query);
        
    }

*/
}

