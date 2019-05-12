package titles;


import customers.Customer;
import model.Model;
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

       TitleModel titleModel = new TitleModel();
         AddTitleView createTitle = new AddTitleView();
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Title")) {
         
            
            //get the Id of last added title and add 1
             int titleID =  Integer.parseInt(titleModel.titles.get(titleModel.titles.size()-1).getTitleID())+1;
         
          createTitle = new AddTitleView();
           createTitle.addTitle(String.valueOf(titleID));
           
            } else if (e.getActionCommand().equals("Submit")) {

           //Add title to ArrayList of titles
           
            titleModel.titles.add(new Titles(
                       createTitle.getTitleId(),
                    createTitle.getTitleName(),
                    createTitle.getTitleType(), 
                    createTitle.getMediaType(),
                    createTitle.getYear(),
                    createTitle.getRate(),
                    createTitle.getAdditonal()
    
                           ));
             JOptionPane.showMessageDialog(null, "Title created. You can manage details in Manage Titles");
      
                                 
                           
                  
            

        } else if (e.getActionCommand().equals("Manage existing title")) {

           
           ManageTitlesView manageTitles = new ManageTitlesView();
           manageTitles.displayTitles();
        }
}
    
}
