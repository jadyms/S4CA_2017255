/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package titles;

/**
 *
 * @author JadyMartins
 */
public enum Media {
    
    MUSIC ("CD"),
    LIVE_CONCERT ("DVD"),
    MOVIE ("BLU_RAY"),
    BOX_SET ("DVD");
   
    
    
    private String media;
    
    Media(final String media){
        this.media = media;
           
    }
    
    public String getMedia(){
        return media;
        
    }
    
}
