package titles;

import init.HomeView;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author JadyMartins
 */

//Form used to add a new title
public class AddTitleView extends JFrame {

    //attributes
    private static JLabel tfID;
    private static JLabel mediaType;
    private static JTextField tfYear;
    private static JTextField tfPrice;
    private static JTextField tfTitle;
    private static JTextField tfAdditional;
    private static JLabel type;
    private static JComboBox<String> titleType;
    static JPanel myPanel;
    static JPanel myPanel2;
  
    HomeView homeView; //main frame
    Media media; //enum 
    TitleController titleController;

    public AddTitleView() {

    }

    //Display the form for a new title
    //already sets the title ID - in the title controller
    public void addTitle(String titleID) {

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

        JLabel ltype = new JLabel("Title Type: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 1; //1 cell
        form.add(ltype, fgbc);

        JLabel ltitle = new JLabel("Title name: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 2; // row 3
        fgbc.gridwidth = 1; //1 cell
        form.add(ltitle, fgbc);

        JLabel lyear = new JLabel("Year: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 3; // row 4
        fgbc.gridwidth = 1; //1 cell
        form.add(lyear, fgbc);

        JLabel lRent = new JLabel("Price: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 4; // row 5
        fgbc.gridwidth = 1; //1 cell
        form.add(lRent, fgbc);

        JLabel lmedia = new JLabel("Media Type: ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 5; // row 6
        fgbc.gridwidth = 1; //1 cell
        form.add(lmedia, fgbc);

        JLabel ladditional = new JLabel("Additional Information(artist, band): ");
        fgbc.gridx = 0; //leftmost column
        fgbc.gridy = 6; // row 7
        fgbc.gridwidth = 1; //1 cell
        form.add(ladditional, fgbc);

        //Form textfield       
        tfID = new JLabel(titleID);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 0; //top row
        fgbc.gridwidth = 3; //3 cell
        form.add(tfID, fgbc);

        titleType = new JComboBox(media.values());
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 1; // row 1
        fgbc.gridwidth = 3; //3 cell
        form.add(titleType, fgbc);

        tfTitle = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 2; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfTitle, fgbc);

        tfYear = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 3; // row 2
        fgbc.gridwidth = 3; //3 cell
        form.add(tfYear, fgbc);

        tfPrice = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 4; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfPrice, fgbc);
       

        //media = (Media) titleType.getSelectedItem();
        //mediaType = new JComboBox(media.getMedia());
        //Improvement = could be better if it was a dynamic JComboBox
        mediaType = new JLabel("Music = CD / Box Set and Live Concert = DVD / Movie = BluRay");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 5; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(mediaType, fgbc);
      
        tfAdditional = new JTextField(25);
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 6; // row 3
        fgbc.gridwidth = 3; //3 cell
        form.add(tfAdditional, fgbc);

        //Button
        JButton bsubmit = new JButton("Submit");
        fgbc.gridx = 1; //middle column
        fgbc.gridy = 7; // row 6
        fgbc.gridwidth = 3; //3 cell
        form.add(bsubmit, fgbc);
        
        //Action events in the controller
        titleController = new TitleController();
        bsubmit.addActionListener(titleController);

        //place panel in the main frame
        homeView = new HomeView("New Title Details ", form, "Logout", "Go back");
    }

    //Getters
    public String getTitleId() {
        return tfID.getText();
    }

    public String getTitleName() {
        return tfTitle.getText();
    }

    public String getTitleType() {
        return String.valueOf(titleType.getSelectedItem());
    }

    public String getMediaType() {
        media = (Media) titleType.getSelectedItem();
        return media.getMedia();
    }

    public String getYear() {
        return tfYear.getText();
    }

    public String getRate() {
        return tfPrice.getText();
    }

    public String getAdditonal() {
        return tfAdditional.getText();
    }

}
