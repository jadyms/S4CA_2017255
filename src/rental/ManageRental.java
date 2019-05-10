package rental;



import init.HomeView;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class ManageRental {
    
     JDialog frame;
    HomeView homeView;
    private String[][] data = new String[4][5];
    static JTable searchRentals;
    
    public ManageRental(){
    }
    
    public void viewRentals( ResultSet rs){
        
        
        String[] columnName = {"Transaction", "Title", "Rent Date", "Rent return", "Rent status"};
        try {
            int i = 0;
            while (rs.next()) {

                data[i][0] = rs.getString("rental_id");
                data[i][1] = rs.getString("title");
                data[i][2] = rs.getString("rental_date");
                data[i][3] = rs.getString("rental_return");
                data[i][4] = rs.getString("rental_status");
           
                i++;
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

        }


        DefaultTableModel model = new DefaultTableModel(data, columnName);
        searchRentals = new JTable(model);
       // searchRentals.getSelectionModel().addListSelectionListener(cController);

        JScrollPane sp = new JScrollPane(searchRentals, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchRentals.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchRentals.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

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
       homeView = new HomeView("Search titles", myPanel, "Logout", "Go back");
        
        
        
    }
    
}
