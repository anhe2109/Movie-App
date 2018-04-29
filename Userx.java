import java.util.*;


public class Userx{

   private String name;
   private int birthDate;
   private String password;
   private ArrayList<String> watchHistory = new ArrayList<String>();
   
   
   public Userx (String name, int birthDate, String password, ArrayList<String> watchHistory){
      this.name = name;
      this.birthDate = birthDate;
      this.password = password;
      this.watchHistory = watchHistory;
   }

   public Userx(){}

   public void setName (String name){
      this.name = name;
      
   }
   public String getName(){
      return name;
   }
      
   public void setBirthDate (int birthDate){
      this.birthDate = birthDate;
      
   }
   public int getBirthDate(){
      return birthDate;
   }
   public void setPassword (String password){
      this.password = password;
      
   }
   public String getPassword(){
      return password;
   }

}