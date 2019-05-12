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
import java.util.Date;
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
import rental.Rental;
import rental.RentalModel;
import static titles.AddTitleView.searchTitles;

public class ManageTitlesView extends JFrame {

    private String[][] data = new String[10][6];
    static JTable searchTitle;
    static JTable table;
    String titleID;
    String title;
    String titleType;
    String mediaType;
    String year;
    String rate;
    String additional;
    HomeView homeView;
    TitleModel titleModel = new TitleModel();

    public JPanel populateTable() {
       
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
        
           for (int i = 0; i < titleModel.titles.size(); i++) {

            rowData[0] = titleModel.titles.get(i).getTitleID();
            rowData[1] = titleModel.titles.get(i).getTitle();
            rowData[2] = titleModel.titles.get(i).getTitleType();
            rowData[3] = titleModel.titles.get(i).getMediaType();
            rowData[4] = titleModel.titles.get(i).getYear();
            rowData[5] = titleModel.titles.get(i).getRate();
            rowData[6] = titleModel.titles.get(i).getAdditional();
            model.addRow(rowData);
        }

        table.setModel(model);
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

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

                String message = (title + " " + titleType + " " + mediaType + " " + titleID + " " + year + " " + rate + " " + additional);

                Object[] options = {"Delete", "Update"};
                int n = JOptionPane.showOptionDialog(null,
                        "Title " + message,
                        "Select an option",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[1]);

//if delete
                if (n == 0) {
                    System.out.println("Create a method to .remove from array at index.titleID");
                }
                else if (n==0){
                     System.out.println("Create a method to .set values to array at index.titleID");
                }
                
            }
        });

        //Panel with appointmnets information
        JPanel myPanel = new JPanel();
        
        //Add elements to the panel
        myPanel.add(sp);
        //Populating main Panel with appointment data

        //homeView = new HomeView("Search Titles", myPanel, "Logout", "Go back");
        return myPanel;
    }

    public void displayTitles(){
        homeView = new HomeView("Search Titles", populateTable(), "Logout", "Go back");
        
    }
}
