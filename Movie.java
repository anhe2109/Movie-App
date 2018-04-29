import java.util.*;

public class Movie{

//ArrayList<String> movieArray = new ArrayList<String>();

   private String title;
   private String actors;
   private int year;
   private double movieLength;
   
   public Movie (String title, String actors, int year, double movieLength){
   
      this.title = title;
      this.actors = actors;
      this.year = year;
      this.movieLength = movieLength;
   }
   
   public Movie(){}
   
   public void setTitle (String title){
      this.title = title;
      
   }
   public String getTitle(){
      return title;
   }
   public void setActors (String actors){
      this.actors = actors;
      
   }
   public String getActors(){
      return actors;
   }
   public void setYear (int year){
      this.year = year;
      
   }
   public int getYear(){
      return year;
   }
   public void setMovieLength (double movieLength){
      this.movieLength = movieLength;
      
   }
   public double getMovieLength(){
      return movieLength;
   }

 

}