package titles;

import init.HomeView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//This class populates the table with array of titles

public class ManageTitlesView extends JFrame {

    //atributes 
    static JTable table;
    private String titleID;
    private String title;
    private String titleType;
    private String mediaType;
    private String year;
    private String rate;
    private String additional;
    
    HomeView homeView;
    TitleModel titleModel = new TitleModel();

    //String x and y are used to name the buttons differently
    //boolean z sets the row/column selection
    //none of them worked for what I expected :(
    
    public JPanel populateTable(String x, String y, boolean z) {

        //table definition
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

        //for the size of the array of titles,
        //get every title
        //add to the table
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
        //table definitions
        table.setModel(model);
        JScrollPane sp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(z);
        table.setColumnSelectionAllowed(z);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            //when a row (title) is selected
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //get values from the row
                //assign them to the attributes
                int row = table.getSelectedRow();
                title = (String) table.getValueAt(row, 0);
                titleType = (String) table.getValueAt(row, 1);
                mediaType = (String) table.getValueAt(row, 2);
                titleID = (String) table.getValueAt(row, 3);
                year = (String) table.getValueAt(row, 4);
                rate = (String) table.getValueAt(row, 5);
                additional = (String) table.getValueAt(row, 6);
                String message = (title + " " + titleType + " " + mediaType + " " + titleID + " " + year + " " + rate + " " + additional);

                //Two options - delete or update title
                //should also display - rent or choose another title
                //it is not the best strategy - it did not work as expected
                Object[] options = {x, y};
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
                    System.out.println("If title - Create a method to .remove from array at index.titleID");
                    System.out.println("If rent - add to array");
                //if update    
                } else if (n == 0) {
                    System.out.println("Create a method to .set values to array at index.titleID");
                }

            }
        });

        //Panel for the table
        JPanel myPanel = new JPanel();

        //Add table to the panel
        myPanel.add(sp);
      
        return myPanel;
    }

    //To place the panel onto the main frame
    public void displayTitles() {
        homeView = new HomeView("Search Titles", populateTable("Delete", "Update", true), "Logout", "Go back");

    }
}
