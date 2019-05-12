package titles;

//Class for the object Title
//Use of encapsulation with modifiers, getters and setters


public class Titles {
    //all the attributes of a title
    private String titleID;
    private String titleType;
    private String mediaType;
    private String year;
    private String rate;
    private String title;
    private String additional;
    
    //AddTitleView createTitle; 
    
    public Titles(){
        
    }
    //Method used to create a new title
 public Titles(String titleID, String title, String titleType , String mediaType, String year, String rate, String additional){
        this.titleID = titleID;
        this.title = title;
        this.titleType = titleType;
        this.mediaType = mediaType;
         this.year = year;
         this.rate = rate;
         this.additional = additional;
                  
     }

     //Getters
    public String getTitleID() {
        return this.titleID;
    }

    public String getTitleType() {
        return this.titleType;
    }

    public String getMediaType() {
        return this.mediaType;
    }

    public String getYear() {
        return this.year;
    }

    public String getRate() {
        return this.rate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAdditional() {
        return this.additional;
    }

}
