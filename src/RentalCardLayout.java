
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JadyMartins
 */
public class RentalCardLayout extends JFrame implements ActionListener{
    
               

         CardLayout cd;
                   JDialog frame;
  
    JPanel parent;
    
    public RentalCardLayout(){};
    public void showRental(){
    
        
         frame = new JDialog(frame, "Home");
        frame.setSize(500, 500);
        frame.setModal(true);
        frame.setTitle("Ultra Vision");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    
 parent= new JPanel();
    
    
                Model myModel = new Model();
               ResultSet rs = myModel.showTitles("movies");
               ResultSet rs2 = myModel.showTitles("movies");
     
               
            CreateTitleView createTitle = new CreateTitleView();
                   
          JPanel movies =  createTitle.showTitles(rs);
          JPanel music =  createTitle.showTitles(rs2);

          
          cd = new CardLayout();

         parent.setLayout(cd);
         
             JButton mv = new JButton("movies");
                mv.setActionCommand("movies");
                
             JButton ms = new JButton("music");
               ms.setActionCommand("music");
         
         frame.add(mv);    
         frame.add(ms);
         parent.add(movies, "movies");
         parent.add(music, "music");
   
        frame.add(parent);
        
   
                frame.validate();
        frame.repaint();
        
   
}

    @Override
    public void actionPerformed(ActionEvent e) {
          
         if(e.equals("movies")){
             cd.show(parent, "movies");
             
             
         }if(e.equals("music")){
              cd.show(parent, "music");
             
             
         }
   
    }
}
