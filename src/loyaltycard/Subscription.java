package loyaltycard;

//previsouly created to determine
//user types of titles allowed to rent
//not complete
public enum Subscription {
    MUSIC_LOVER("select * from titles where titleType = \"MUSIC\" OR titleType = \"LIVE_CONCERT\";"),
    TV_LOVER("select * from titles where titleType = \"BOX_SET\" ;"),
    VIDEO_LOVER("select * from titles where titleType = \"MOVIE\" ;"),
    PREMIUM("SELECT * FROM titles;");
    
    private String subscriptonQuery;
    
    Subscription(final String subscriptionQuery){
        this.subscriptonQuery = subscriptionQuery;
           
    }
    public String getSubscriptonQuery(){
        return subscriptonQuery;
        
    }
  }
