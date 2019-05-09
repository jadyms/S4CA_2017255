
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class TitleController implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Title")) {
            
               //JDialog to determine title type
            String[] possibilities = {"Movies", "Live Concert", "Music", "Box Set"};
            String titleType = (String) JOptionPane.showInputDialog(
                    null, "Select title type", "What title would you like to add?", JOptionPane.PLAIN_MESSAGE, null,
                    possibilities,
                    possibilities[0]);
            
            CreateTitleView createTitle = new CreateTitleView();
           createTitle.addTitle(titleType);
            

        } else if (e.getActionCommand().equals("Manage existing title")) {

              Model myModel = new Model();
               ResultSet rs = myModel.showTitles();
               
           
             ManageTitles manageTitles = new ManageTitles();
           manageTitles.populateTable();
        }
}
    
}
