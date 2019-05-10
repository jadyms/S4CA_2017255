package customers;


import rental.ManageRental;
import rental.CreateRentalView;
import model.db;
import model.Model;
import init.HomeView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
import rental.RentalController;

/**
 *
 * @author JadyMartins
 */
public class ManageCustomerView extends JFrame {

    private String[][] data = new String[10][6];
    static JTable searchCustomer;
    static JTable table;
    private static String card;
        private static String fname;
    private static    String lname;
        private static String subscription;
        private static String loyalty_number;
        private static String hold;
        static JButton[] options = new JButton[3]   ;
      

    HomeView homeView;
   CustomerModel customerModel= new CustomerModel();
   CustomerController customerController = new CustomerController();

    public void populateTable() {
        //###### THIS CODE IN A SEPARATE METHOD #######
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[6];
        columnsName[0] = "First Name";
        columnsName[1] = "Last Name";
        columnsName[2] = "Subscription";
        columnsName[3] = "Card Number";
        columnsName[4] = "Loyalty card";
        columnsName[5] = "Titles hold";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[6];

        for (int i = 0; i < customerModel.getCustomers().size(); i++) {

            rowData[0] = customerModel.getCustomers().get(i).getFirstname();
            rowData[1] = customerModel.getCustomers().get(i).getLastname();
            rowData[2] = customerModel.getCustomers().get(i).getSubscription();
            rowData[3] = customerModel.getCustomers().get(i).getCard();
            rowData[4] = customerModel.getCustomers().get(i).getLoyaltyNumber();
            rowData[5] = customerModel.getCustomers().get(i).getHold();
            model.addRow(rowData);

        }
        
             //When selecting a row, JDialog will print 
        //the options below
        //to trigger action Listener for each one
        //This should be in a inner class as a List =/
        /*options[0] = new JButton("Update Customer");
        options[1] = new JButton("Create Rental from ");
        options[2] = new JButton("Manage Rental");
        
        options[0].setActionCommand("Update Customer");
        options[1].setActionCommand("Create Rental from customer Loyalty Card");
        options[2].setActionCommand("Manage Rental");
        RentalController rentalController = new RentalController();
        
         options[0].addActionListener(rentalController);
        options[1].addActionListener(rentalController);
        options[2].addActionListener(rentalController);
        */
        
        
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(false);
        table.getSelectionModel().addListSelectionListener(customerController);
        //Panel which we add the table to  table 
        JPanel myPanel = new JPanel();
        
        //Add ScrollPane to the panel
        myPanel.add(sp);
        
        //Populating main frame with Panel
        homeView = new HomeView("Select a customer", myPanel, "Logout", "Go back");

        
        
      }
  

             
    
    public String getFirstName(){
        return  (String) table.getValueAt(table.getSelectedRow(), 0);
    }
    
     public String getLastName(){
        return (String) table.getValueAt(table.getSelectedRow(), 1);
    }

     public String getSubscription(){
        return (String) table.getValueAt(table.getSelectedRow(), 2);
    }
     public String getCard(){
        return (String) table.getValueAt(table.getSelectedRow(), 3);
    }
     public String getLoyaltyNumber(){
        return (String) table.getValueAt(table.getSelectedRow(), 4);
    }
     public String getLoyaltyHold(){
        return (String) table.getValueAt(table.getSelectedRow(), 5);
    }
    
     
}