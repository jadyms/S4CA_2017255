package rental;

import init.HomeView;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JadyMartins
 */
//This class populates the table with array of rental
public class ManageRental {

    
    static JTable table;
    static List<Rental> list;
    RentalModel rentalModel = new RentalModel();
    RentalController rentalController = new RentalController();
    HomeView homeView;
    
    public ManageRental() {
    }

    public JPanel populateTable(String id) {

        //table settings
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
        String iD = id;

        list = new ArrayList<Rental>();

        //something is worng here
        //tried to get all rentals and add into an array
        //then create a list of rentals for specific user (loyaltynumber)
        for (int i = 0; i < rentalModel.allRental.size(); i++) {

            if (rentalModel.allRental.get(i).getLoyaltyNumber().equals(iD)) {

                list.add(new Rental(
                        rentalModel.allRental.get(i).getLoyaltyNumber(),
                        rentalModel.allRental.get(i).getRentalID(),
                        rentalModel.allRental.get(i).getTitle(),
                        rentalModel.allRental.get(i).getTitleType(),
                        rentalModel.allRental.get(i).getRentalStatus(),
                        rentalModel.allRental.get(i).getRentalDate(),
                        rentalModel.allRental.get(i).getRentalReturn(),
                        rentalModel.allRental.get(i).getReturnDate()
                )
                );
                for (int j = 0; j < list.size(); j++) {

                    rowData[0] = list.get(j).getLoyaltyNumber();
                    rowData[1] = list.get(j).getRentalID();
                    rowData[2] = list.get(j).getTitle();
                    rowData[3] = list.get(j).getTitleType();
                    rowData[4] = list.get(j).getRentalStatus();
                    rowData[5] = list.get(j).getRentalDate();
                    rowData[6] = list.get(j).getRentalReturn();
                    rowData[7] = list.get(j).getReturnDate();
                    model.addRow(rowData);
                }
            }

        }
   
        //table settings
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

         return myPanel;
    }

  
}
