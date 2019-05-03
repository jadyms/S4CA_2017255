
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JadyMartins
 * 
 */
public class TitlesView extends JFrame{
    
    HomeView homeView;
     String titleType;
         
        
    public TitlesView(){
               
    }
    public void TitlesPanel(){
      
        JPanel myPanel2 = new JPanel();
         String b1 = "Add Title";
         String b2 = "Manage Existing Titles";
        // String b3 = "Manage Rental"; 
         //String b4 = "Loyalty Card";
        //Panel 2 for buttons
      
        //Buttons for Panel 2
        JButton btn1 = new JButton(b1);
        JButton btn2 = new JButton(b2);
      //  JButton btn3 = new JButton(b3);
       // JButton btn4 = new JButton(b4);
        
        //Set Action command
        btn1.setActionCommand(b1);
        btn2.setActionCommand(b2);
       // btn3.setActionCommand(b3);
        //btn4.setActionCommand(b4); 
        
       //Add Action Listener as Anonymous Class
       btn1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
       
               System.out.println("Call Create Title Class");
               
               //JDialog to determine title type
            String[] possibilities = {"Movies", "Live Concert", "Music", "Box Set"};
            titleType = (String) JOptionPane.showInputDialog(
                    null, "Select title type", "What title would you like to add?", JOptionPane.PLAIN_MESSAGE, null,
                    possibilities,
                    possibilities[0]);
            
            CreateTitleView createTitle = new CreateTitleView();
           createTitle.addTitle(titleType);
            
            
                                             
               //CreateTitleView createTitle = new CreateTitleView();
               //createTitle.addTitle();
           }});
       
       btn2.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               
                 Model myModel = new Model();
               ResultSet rs = myModel.showTitles();
               
           
             ManageTitles manageTitles = new ManageTitles();
           manageTitles.populateTable();
       /*
               System.out.println("Call Manage Titles Class");
               
               String[] possibilities = {"movies", "Live Concert", "Music", "Box Set"};
            titleType = (String) JOptionPane.showInputDialog(
                    null, "Select title type", "What title would you like to add?", JOptionPane.PLAIN_MESSAGE, null,
                    possibilities,
                    possibilities[0]);
            
               Model myModel = new Model();
               ResultSet rs = myModel.showTitles(titleType);
               
            //customerView.setComplaint(rs);
            
              CreateTitleView createTitle = new CreateTitleView();
           createTitle.showMovies(rs);
         */      
               
           }});
       
       
       

                //Add Buttons to Panel 2
        myPanel2.add(btn1);
        myPanel2.add(btn2);
        //myPanel2.add(btn3);
        //myPanel2.add(btn4);
        
           //Panel 2 layout
        GridLayout mgr = new GridLayout(1,2);
        myPanel2.setLayout(mgr);
    
        homeView = new HomeView("Select an option", myPanel2, "Logout");
     
      // homeView.mainPanel("Select an option", myPanel2, "Logout");
               //homeView.HomePanel("Select an option", myPanel2, "Logout");

             
        
    }
    
}
