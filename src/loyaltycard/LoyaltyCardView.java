package loyaltycard;


import init.HomeView;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JadyMartins
 */

//#####CLASS NOT DEVELOPED########
public class LoyaltyCardView extends JFrame {
    
     private String[][] data = new String[10][4];
    static JTable searchTitles;
       HomeView homeView;
    
    public void viewPoints(ResultSet rs) {
        String[] columnName = {"Loyalty Card", "Points acc", "Free Rental", "Used Rental"};
        try {
            int i = 0;
            while (rs.next()) {

                data[i][0] = rs.getString("loyalty_card");
                data[i][1] = rs.getString("acc_points");
                data[i][2] = rs.getString("free_rental");
               data[i][3] = rs.getString("used_rental");
              //  data[i][4] = rs.getString("loyalty_number");
               //data[i][5] = rs.getString("hold");
                i++;
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

        }


        DefaultTableModel model = new DefaultTableModel(data, columnName);
        searchTitles = new JTable(model);
       // searchTitles.getSelectionModel().addListSelectionListener(cController);

        JScrollPane sp = new JScrollPane(searchTitles, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchTitles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchTitles.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

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
