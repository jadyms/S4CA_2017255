package titles;

/**
 *
 * @author JadyMartins
 */

//Enum for media type 
//Used when  creating a new title
//User select the title type and Media value is attached to it
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
