package rental;



import init.HomeView;
import java.awt.Dimension;
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
        static JTable table;
        RentalModel rentalModel = new RentalModel(); 
        RentalController rentalController = new RentalController();
        
    public ManageRental(){
    }
    
    public JPanel populateTable() {
        //###### THIS CODE IN A SEPARATE METHOD #######
        table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] columnsName = new Object[8];
        columnsName[0] = "Loyalty Number";
        columnsName[1] = "Rental ID";
        columnsName[2] = "Title";
        columnsName[3] = "Title Type";
        columnsName[4] = "Rental Status";
        columnsName[5] = "Rental Date";
           columnsName[6] = "Return Date";
              columnsName[7] = "Returned?";

        model.setColumnIdentifiers(columnsName);
        Object[] rowData = new Object[8];

        for (int i = 0; i < rentalModel.getRental().size(); i++) {

            rowData[0] = rentalModel.getRental().get(i).getLoyaltyNumber();
            rowData[1] = rentalModel.getRental().get(i).getRentalID();
            rowData[2] = rentalModel.getRental().get(i).getTitle();
            rowData[3] = rentalModel.getRental().get(i).getTitleType();
            rowData[4] = rentalModel.getRental().get(i).getRentalStatus();
            rowData[5] = rentalModel.getRental().get(i).getRentalDate();
            rowData[6] = rentalModel.getRental().get(i).getRentalReturn();
            rowData[7] = rentalModel.getRental().get(i).getReturnDate();
            model.addRow(rowData);

        }

        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        table.setModel(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(rentalController);
        //Panel which we add the table to  table 
        JPanel myPanel = new JPanel();
        
        //Add ScrollPane to the panel
        myPanel.add(sp);
        
        //Populating main frame with Panel
        //homeView = new HomeView("Select a customer", myPanel, "Logout", "Go back");

        
        return myPanel;
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
