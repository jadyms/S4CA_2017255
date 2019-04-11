
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
public class CreateTitleView extends JFrame {
       
    //WORK WITH ENUMS
    
    private JTextField tfID;
    private JTextField tfMedia;
    private JTextField tfYear;
       private JTextField tfRent;
        private JTextField tfTitle;
         private JTextField tfCard;
          private JLabel type;
   // private JComboBox<String> type;
    private String[] subscription = new String[]{ "TV Lover", "Music Lover", "Premium", "Movie Lover"};
    //String titleType;
    JDialog frame;
    HomeView homeView;
    private String[][] data = new String[50][3];
    static JTable searchTitles;
       
    public CreateTitleView(){
      
    }
    
    
    public void addTitle(String titleType){
            
        //Panel for form 
        JPanel form = new JPanel(new GridBagLayout());
      
         
        //Setting Layout
        GridBagConstraints fgbc = new GridBagConstraints();
        fgbc.fill = GridBagConstraints.HORIZONTAL;

        //Form Labels
        JLabel id = new JLabel("ID: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 1; //1 cell
        form.add(id, fgbc);

        JLabel lmedia = new JLabel("Media Type: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 1; //1 cell
        form.add(lmedia, fgbc);

        JLabel lyear = new JLabel("Year: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 1; //1 cell
        form.add(lyear, fgbc);

        
        JLabel lrent = new JLabel("Rent: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(lrent, fgbc);
        
        
        JLabel ltype = new JLabel("Title Type: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(ltype, fgbc);
        
        JLabel lcard = new JLabel("Credit Card: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 5; // row 6
        fgbc.gridwidth = 1; //1 cell
        form.add(lcard, fgbc);

        //Form textfield       
        tfID = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfID, fgbc);

        tfMedia = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(tfMedia, fgbc);

        tfYear = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfYear, fgbc);

         tfRent = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfRent, fgbc);
       // subscriptionType.setVisible(isCustomer);
       
        type = new JLabel(titleType);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(type, fgbc);
       // subscriptionType.setVisible(isCustomer);
       
        tfCard = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfCard, fgbc);
       // subscriptionType.setVisible(isCustomer);


        //Button
        JButton bsubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 6; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        //Setting button ActionCommand - true if Customer/false if Service Provider
       // bsubmit.setActionCommand(String.valueOf(isCustomer));
       // bsubmit.addActionListener(myRegController);
     
         homeView = new HomeView("New Title Details ", form, "Logout");
    }

   
     public void showMovies(ResultSet rs) {
        String[] columnName = {"ID", "Language", "Year"};
        try {
            int i = 0;
            while (rs.next()) {

                data[i][0] = rs.getString("mov_id");
                data[i][1] = rs.getString("mov_lang");
                data[i][2] = rs.getString("mov_year");
               // data[i][3] = rs.getString("aptStatus");
               // data[i][4] = rs.getString("cEmail");
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
       homeView = new HomeView("Search titles", myPanel, "Logout");

    }
    
}
