/**
 *
 * @author JadyMartins
 */
package titles;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

//Interaction between Frames and Model
public class TitleController implements ActionListener {

    TitleModel titleModel = new TitleModel();
    AddTitleView createTitle = new AddTitleView();

    @Override
    public void actionPerformed(ActionEvent e) {
        //Create a new title
        if (e.getActionCommand().equals("Add Title")) {

            //Creating an ID for this new title
            //get the ID of last added title and add 1
            int titleID = Integer.parseInt(titleModel.titles.get(titleModel.titles.size() - 1).getTitleID()) + 1;

            //method to add the title, setting the title ID
            createTitle.addTitle(String.valueOf(titleID));

        } else if (e.getActionCommand().equals("Submit")) {
            //Add title as an object Title to ArrayList of titles
            titleModel.titles.add(new Titles(
                    createTitle.getTitleId(),
                    createTitle.getTitleName(),
                    createTitle.getTitleType(),
                    createTitle.getMediaType(),
                    createTitle.getYear(),
                    createTitle.getRate(),
                    createTitle.getAdditonal()
            ));
            //Display message to inform title was added 
            JOptionPane.showMessageDialog(null, "Title created. You can manage details in Manage Titles");

        } else if (e.getActionCommand().equals("Manage existing title")) {
            //To display all the titles in the array of Titles
            ManageTitlesView manageTitles = new ManageTitlesView();
            manageTitles.displayTitles();
        }
    }

}
