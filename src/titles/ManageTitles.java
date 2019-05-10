package titles;


import rental.CreateRentalView;
import rental.ManageRental;
import model.db;
import model.Model;
import customers.Customer;
import init.HomeView;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import static titles.CreateTitleView.searchTitles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class ManageTitles extends JFrame{
    
    private String[][] data = new String[10][6];
    static JTable searchTitle;
    static JTable table;
    String titleID;
    String title;
    String titleType ;
    String mediaType;
    String year;
    String rate;
    String additional;
    HomeView homeView;
    
        
           
           public static ArrayList<Titles> getTitles(){
               
                ArrayList<Titles> titles = new ArrayList<Titles>();
        
             
               
               Titles t;
              
               try{
                    Model myModel = new Model();
               ResultSet rs = myModel.showTitles();
               
                   while(rs.next()){
                       t = new Titles(
                       rs.getString("titleID"),
                       rs.getString("title"),
                       rs.getString("titleType"),
                       rs.getString("mediaType"),
                       rs.getString("year"),
                       rs.getString("rate"),
                       rs.getString("additional")
                               
                    );
                       titles.add(t);
                   }
                   
               }catch(SQLException ex){
                   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
                                 
               }
               
               return titles;
             
           }
           
           public JPanel populateTable(){
               //###### THIS CODE IN A SEPARATE METHOD #######
               table = new JTable();
               DefaultTableModel model = new DefaultTableModel();
               Object[] columnsName = new Object[7];
               columnsName[0] = "ID";
               columnsName[1] = "Title Name";
               columnsName[2] = "Type";
               columnsName[3] = "Media";  
               columnsName[4] = "Year";
               columnsName[5] = "Rate";
               columnsName[6] = "Info";
               
               model.setColumnIdentifiers(columnsName);
               Object[] rowData = new Object[7];
               System.out.println(getTitles().get(2).getTitleType());
               
               
               for(int i = 0; i < getTitles().size(); i++){
               
                          
                   rowData[0] = getTitles().get(i).getTitleID();
                   rowData[1] = getTitles().get(i).getTitle();
                   rowData[2] = getTitles().get(i).getTitleType(); 
                   rowData[3] = getTitles().get(i).getMediaType();
                   rowData[4] = getTitles().get(i).getYear();
                   rowData[5] = getTitles().get(i).getRate(); 
                   rowData[6] = getTitles().get(i).getAdditional();    
                   model.addRow(rowData);
               }
                   
               table.setModel(model);
               JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
               table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
               table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
               table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                   private Frame owner;

                   @Override
                   public void valueChanged(ListSelectionEvent e) {
                       int row = table.getSelectedRow();
                       title = (String) table.getValueAt(row, 0);
                       titleType = (String) table.getValueAt(row, 1);
                       mediaType = (String) table.getValueAt(row, 2);
                       titleID = (String) table.getValueAt(row, 3);
                       year = (String) table.getValueAt(row, 4);
                       rate = (String) table.getValueAt(row, 5);
                       additional = (String) table.getValueAt(row, 6);
                       // String message = ("Location: "+loc + "\r\n Provider: " + provider+ "\r\n Provider Email: " +pEmail+ " \r\nDate: " +fdate+ " \r\nTime: " +ftime);

                       String message = (title + " " + titleType+ " " + mediaType + " " + titleID+ " " + year + " " + rate + " " + additional);
                          
                       
                       
                Object[] options = { "Rent", "Choose another title"};
int n = JOptionPane.showOptionDialog(null,
    "Rent " + message ,
    "Confirm your rental",
    JOptionPane.OK_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);


//if create rental
if (n == 0){
     // Create an arrayList with initial capacity 2 
 //       ArrayList<Titles> arrL = new ArrayList<Titles>(4); 
                ArrayList<Titles> arrL = new ArrayList<Titles>(4);
                
    // Add elements to ArrayList 
    arrL.add(new Titles(titleID, title, titleType, mediaType, year, rate, additional));
    arrL.add(new Titles(titleID, title, titleType, mediaType, year, rate, additional));
    arrL.add(new Titles(titleID, title, titleType, mediaType, year, rate, additional));
    arrL.add(new Titles(titleID, title, titleType, mediaType, year, rate, additional));
   
    
    // Access elements of ArrayList 
    System.out.println(arrL.get(0).toString());
    System.out.println(arrL.size());

 
    }
/*
//if update customer
else if (n==0){
        
    Customer updatecustomer = new Customer();
    updatecustomer.FillCustomerForm(title, titleType, mediaType, titleID );
}
//ig manage rental
else if (n==2){
    
    //create a try catch in case person has no 
    Model myModel = new Model();
    ResultSet rs = myModel.showRental(year);

    ManageRental manageRental = new ManageRental();
    manageRental.viewRentals(rs);
    
}
               
             
   */    
           }   });
                
        //Panel with appointmnets information
        JPanel myPanel = new JPanel();
        //To be displayed on the Top Panel
        String message = "View bookings";
        //Label of Button 1 and Button 2
        String b1 = ("Cancel Appointment");
        String b2 = ("Logout");
        //Add elements to the panel
        myPanel.add(sp);
        //Populating main Panel with appointment data
     
        //homeView = new HomeView("Search customer", myPanel, "Logout");
                
                return myPanel;
               }
    
    public void viewCustomers(ResultSet rs) {
        String[] columnName = {"First Name", "Last Name", "Subscription", "Card Number", "Loyalty card", "Titles hold"};
        try {
            int i = 0;
            while (rs.next()) {

                data[i][0] = rs.getString("fname");
                data[i][1] = rs.getString("lname");
                data[i][2] = rs.getString("subscription");
               data[i][3] = rs.getString("card");
                data[i][4] = rs.getString("loyalty_number");
               data[i][5] = rs.getString("hold");
                i++;
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

        }


        //############# USING ANONYMOUS CLASS #############
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        searchTitle = new JTable(model);
       searchTitle.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = searchTitle.getSelectedRow();
               title = (String) searchTitle.getValueAt(row, 0);
                 titleType = (String) searchTitle.getValueAt(row, 1);
            mediaType = (String) searchTitle.getValueAt(row, 2);
                 titleID = (String) searchTitle.getValueAt(row, 3);
               year = (String) searchTitle.getValueAt(row, 4);
              rate = (String) searchTitle.getValueAt(row, 5);
                // String message = ("Location: "+loc + "\r\n Provider: " + provider+ "\r\n Provider Email: " +pEmail+ " \r\nDate: " +fdate+ " \r\nTime: " +ftime);
                String message = ( title + " " + titleType);
               
         
               Object[] options = {"Update Customer ", "Create Rental", "Manage Rental"};
int n = JOptionPane.showOptionDialog(null,
    "Update " + message + " info",
    "Select an option for the user",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2]);
//if create rental
if (n == 1){
    
    CreateRentalView createRental = new CreateRentalView();
    createRental.createRental(title, titleType, rate, year, mediaType);
    
    }

//if update customer
else if (n==0){
    
   // Customer updatecustomer = new Customer();
    //updatecustomer.FillCustomerForm(title, titleType, mediaType, titleID );
}
//ig manage rental
else if (n==2){
    
    //create a try catch in case person has no 
    Model myModel = new Model();
    ResultSet rs = myModel.showRental(year);

    ManageRental manageRental = new ManageRental();
    manageRental.viewRentals(rs);
    
}
            
                 // int q = JOptionPane.showConfirmDialog(null, message, "Confirm your information ", JOptionPane.YES_NO_OPTION);
                /*
                if (q==0){
                myModel.bookingApt(fdate, ftime, pEmail, loginView.getEmail());
                JOptionPane.showMessageDialog(null, "Your booking has been placed.\r\n You can view it on your upcoming appointments", "Bookings", JOptionPane.DEFAULT_OPTION);
                
                System.out.println(message);
                }
                
                */
            }
        });

        JScrollPane sp = new JScrollPane(searchTitle, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchTitle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchTitle.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
   searchTitle.setPreferredScrollableViewportSize(   searchTitle.getPreferredSize());
        searchTitle.setFillsViewportHeight(true);
        //Panel with appointmnets information
        JPanel myPanel = new JPanel();
        //To be displayed on the Top Panel
        String message = "View bookings";
        //Label of Button 1 and Button 2
        String b1 = ("Cancel Appointment");
        String b2 = ("Logout");
        //Add elements to the panel
        myPanel.add(sp);
        //Populating main Panel with appointment data
       homeView = new HomeView("Search customer", myPanel, "Logout", "Go back");

    
    
               }

    
    
    
}
