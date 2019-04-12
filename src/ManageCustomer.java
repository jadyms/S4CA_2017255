
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
/**
 *
 * @author JadyMartins
 */
public class ManageCustomer extends JFrame{
    
    private String[][] data = new String[10][6];
    static JTable searchCustomer;
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


        //############# USING OG ANONYMOUS CLASS #############
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        searchCustomer = new JTable(model);
       searchCustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = searchCustomer.getSelectedRow();
                String fname = (String) searchCustomer.getValueAt(row, 0);
                String lname = (String) searchCustomer.getValueAt(row, 1);
                String subscription = (String) searchCustomer.getValueAt(row, 2);
                String card = (String) searchCustomer.getValueAt(row, 3);
                String loyalty_number = (String) searchCustomer.getValueAt(row, 4);
                String hold = (String) searchCustomer.getValueAt(row, 5);
                // String message = ("Location: "+loc + "\r\n Provider: " + provider+ "\r\n Provider Email: " +pEmail+ " \r\nDate: " +fdate+ " \r\nTime: " +ftime);
                String message = ( fname + " " + lname);
               
         
               Object[] options = {"Update Customer ", "Create Rental", " Return Rental"};
int n = JOptionPane.showOptionDialog(null,
    "Update " + message + " info",
    "Select an option for the user",
    JOptionPane.YES_NO_CANCEL_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[2]);

if (n == 1){
    
    CreateRentalView createRental = new CreateRentalView();
    createRental.createRental(loyalty_number);
    
    }
else if (n==0){
    
    UpdateCustomerInfo updatecustomer = new UpdateCustomerInfo();
    updatecustomer.getClass();
}
else if (n==2){
    
    
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

        JScrollPane sp = new JScrollPane(searchCustomer, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        searchCustomer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchCustomer.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

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
