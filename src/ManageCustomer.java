
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
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
public class ManageCustomer extends JFrame{
    
    private String[][] data = new String[10][6];
    static JTable searchTitles;
       HomeView homeView;
    
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
       homeView = new HomeView("Search customer", myPanel, "Logout");

    }
    
    
    
}
