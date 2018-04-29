import java.util.*;

public class Actors{

ArrayList<String> actorArray = new ArrayList<String>();

   private String actorName;
   private String role;
   
   this.name = actorName;
   this.role = role;
   
   public Actors (String actorName, String role);
   
   
    public void setActorName (String actorName){
      this.actorName = actorName;
      
   }
   public String getRole(){
      return role;
   }
   public void setRole (String role){
      this.role = role;
      
   }

   

}