
public class Titles {
    String titleID;
    String titleType;
    String mediaType;
    String year;
    String rate;
    String title;
    String additional;
    CreateTitleView createTitle; 
    
    public Titles(){
        
    }
    
 public Titles(String titleID, String title, String titleType , String mediaType, String year, String rate, String additional){
        this.titleID = titleID;
        this.title = title;
        this.titleType = titleType;
        this.mediaType = mediaType;
         this.year = year;
         this.rate = rate;
         this.additional = additional;
                  
     }

 public String getTitleID(){
        return this.titleID;
    }
    
    public String getTitleType(){
        return this.titleType;
    }
    public String getMediaType(){
        return this.mediaType;
    }
       public String getYear(){
        return this.year;
    }
       
     public String getRate(){
        return this.rate;
    }  
    
      public String getTitle(){
        return this.title;
    }  

 public String getAdditional(){
        return this.additional;
    }  

}