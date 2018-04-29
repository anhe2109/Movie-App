public class favoList{

   private String userName;
   private String movieName;
   
   
   public favoList(String userName, String movieName){
   
   this.userName = userName;
   this.movieName = movieName;
   }
  
   public favoList(){}
   
   public void setUserName (String userName){
      this.userName = userName;
      
   }
   public String getUserName(){
      return userName;
   }

   public void setMovieName (String movieName){
      this.movieName = movieName;
      
   }
   public String getMovieName(){
      return movieName;
   }

}