package init;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Logout extends JFrame implements ActionListener{
    

/*
Class to be called when logout is hit
Displays a JOptionPane with Yes or No option
 */


//    Controller mcontroller;
    //Constructor
    public Logout() {
        
    }
    

    //Return 0 if user choose to logout and 1 if user hits No
    public int logout() {
        //yes = 0  //no = 1
        int r = JOptionPane.showConfirmDialog(null,
                "Would you like to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

        return r;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Logout")) {
         
          int r = logout();
            //Would you like to logout? YES
            if (r == 0) {
                System.exit(r);
                /*
                try {
                    myModel.newdb.stmt.close();
                    myModel.newdb.rs.close();
                    myModel.newdb.conn.close();
                    //Would you like to logout? NO
                } catch (SQLException ex) {
                    Logger.getLogger(ProviderController.class.getName()).log(Level.SEVERE, null, ex);
                }
*/
            } else if (r == 1) {
                //DO NOTHINHG, JUST CLOSE THE DIALOG BOX
            }
}
    }
       }
