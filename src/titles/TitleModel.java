/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model;
import model.db;

/**
 *
 * @author JadyMartins
 */
public class TitleModel {
 
     public static ArrayList<Titles> getTitles(){
               
                ArrayList<Titles> titles = new ArrayList<Titles>();
                
               
               Titles t;
              
               try{
                    Model myModel = new Model();
               ResultSet rs = myModel.showTitles();
               
                   while(rs.next()){
                       t = new Titles(
                       rs.getString("titleID"),
                       rs.getString("title"),
                       rs.getString("titleType"),
                       rs.getString("mediaType"),
                       rs.getString("year"),
                       rs.getString("rate"),
                       rs.getString("additional")
                               
                    );
                       titles.add(t);
                   }
                   
               }catch(SQLException ex){
                   Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
                                 
               }
               
               return titles;
             
           }
}
