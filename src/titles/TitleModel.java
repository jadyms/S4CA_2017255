/**
 *
 * @author JadyMartins
 */

package titles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.db;

public class TitleModel {
    
    //Declaring array of titles to hold all the titles in the DB
    static   ArrayList<Titles> titles;
 
     public static ArrayList<Titles> getTitles(){
               
                titles = new ArrayList<Titles>();
                Titles t;
              
               try{
                   //Connect with the db and get all the titles
               Model myModel = new Model();
               ResultSet rs = myModel.showTitles();
               
                   while(rs.next()){
                       //Create a new title t for every row
                       //until it reaches the last row
                       t = new Titles(
                       rs.getString("titleID"),
                       rs.getString("title"),
                       rs.getString("titleType"),
                       rs.getString("mediaType"),
                       rs.getString("year"),
                       rs.getString("rate"),
                       rs.getString("additional")
                               
                    );
                       //add the titles to the array
                       titles.add(t);
                   }
                   
               }catch(SQLException ex){
                   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
                                 
               }
               
               return titles;
             
           }
}
