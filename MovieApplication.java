import java.util.*;

public class MovieApplication{

   public static void main (String[] args){
   
      ArrayList<Userx> users = new ArrayList<Userx>();
      ArrayList<String> watchHistory = new ArrayList<String>(); 
      Userx user2 = new Userx("Emil Hansen", 1995, "hej", watchHistory);
      users.add(user2);
      int antalUsers = 0;
      
      ArrayList<Movie> movieArray = new ArrayList<Movie>();
      ArrayList<favoList> favoArray = new ArrayList<favoList>();
      
      Movie pulpfiction = new Movie ("Pulp Fiction", "John Travolta, Amanda Plummer, Samuel Jackson", 1994, 1.21);
      Movie batmanbegins = new Movie ("Batman Begins", "Christian Bale, Katie Holmes, Liam Neeson", 2005, 2.20);
      Movie forrestgump = new Movie ("Forrest Gump", "Tom Hanks, Sally Field, Rebecca Williams", 1994, 2.22);
      movieArray.add(pulpfiction);
      movieArray.add(batmanbegins);
      movieArray.add(forrestgump);
      
      Scanner scanner = new Scanner(System.in);
   
      System.out.println("Welcome to movie application\n");
   
      boolean loop1running = true;
      while (loop1running){
         try{
         
            System.out.println("\tMENU");
            System.out.println("0. Exit");
            System.out.println("1. Create user");
            System.out.println("2. Log in");
            System.out.println("3. Alter Library");
            
         
            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
         
            switch(option){
               case 0 :
                  System.out.println("Exiting");
                  loop1running = false;
                  break;
               case 1 :
                  System.out.println("Full name: ");
                  Scanner scan1 = new Scanner(System.in);
                  String scanName = scan1.nextLine();
                  Userx user1 = new Userx();
                  user1.setName(scanName);
                  System.out.println("Choose password: ");
                  Scanner scan2 = new Scanner(System.in);
                  String scanPassword = scan2.next();            
                  user1.setPassword(scanPassword);
                  users.add(user1);
                  System.out.println("Welcome " + scanName + " to MovieApplication");
                  antalUsers++;
                  break;
               case 2 :
                  Userx currentUser = null;
                  boolean found = false;
                  while (!found) {
                     System.out.println("Type in username \n(Type 'exit' to get back to main menu)");
                     Scanner scan3 = new Scanner(System.in);
                     String userName = scanner.nextLine();
                     if (userName.trim().equals("exit")) {
                        break;
                     }
                     
                     for (Userx user : users) {
                        if (user.getName().equals(userName)) {
                           currentUser = user;
                           found = true;
                        }
                     }
                     if (currentUser == null) {
                        System.out.println("No users with that username found");
                        continue;      
                     }                  
                  }
                  if (!found) {
                     continue;
                  }
                  
                  System.out.println("Type Password");
                   
                  String scan4input = scanner.nextLine();
               
                  if (!scan4input.equals(currentUser.getPassword())){
                     System.out.println("wrong password " + currentUser.getName());
                  }else{
                     System.out.println("welcome " + currentUser.getName());
                     boolean loop3running = true;
                  
                     while (loop3running){
                        System.out.println("\tMENU");
                        System.out.println("0. Log ud");
                        System.out.println("1. Movies");            
                        System.out.println("2. Search for movies");
                        System.out.println("3. Add to favourite list");
                        System.out.println("4. Statistics");
                        System.out.println("5. Watch movie");
                        System.out.println("");
                        Scanner scan5 = new Scanner(System.in);
                        int loop3Input = scan5.nextInt();
                        switch (loop3Input){
                           case 0:
                              System.out.println("Log ud");
                              loop3running = false;
                              break;
                           case 1:
                              System.out.println("List of movies:\n");
                              for (Movie ob : movieArray){
                                 System.out.println(ob.getTitle());
                                 System.out.println(ob.getActors());
                                 System.out.println(ob.getYear());
                                 System.out.println(ob.getMovieLength() + "\n");
                              }
                              break;
                           case 2:
                              System.out.println("Search for movies");
                              Scanner scan6 = new Scanner(System.in);
                              String searchInput = scan6.nextLine();
                              //int indexOfInput = movieArray.indexOf(searchInput);
                              for (Movie movie : movieArray){
                                 if (movie.getTitle()  != null && movie.getTitle().toLowerCase().contains(searchInput.toLowerCase()) || 
                                     movie.getActors() != null && movie.getActors().toLowerCase().contains(searchInput.toLowerCase())){
                                     
                                    System.out.println(movie.getTitle());
                                    System.out.println(movie.getActors());
                                    System.out.println(movie.getYear());
                                    break;
                                 }else{
                                    System.out.println("No match. Search again :-)");
                                 
                                 }
                              }
                              
                              //System.out.println(indexOfInput);
                              break;
                           case 3:
                              System.out.println("Add movie to favourite list");
                              Scanner favScan = new Scanner (System.in);
                              String favoriteMovie = favScan.nextLine();
                              
                              boolean favoriteFound = false;
                              for (Movie movie : movieArray){
                                 if (movie.getTitle()  != null && movie.getTitle().toLowerCase().contains(favoriteMovie.toLowerCase())){ 
                                    favoList favUser = new favoList();
                                    favUser.setUserName(currentUser.getName());
                                    favoList favMovie = new favoList();
                                    favMovie.setMovieName(favoriteMovie);
                                    
                                    favoList favusrmovie = new favoList (favUser.getUserName(), favMovie.getMovieName());
                                    favoArray.add(favusrmovie);
                                       
                                    System.out.println("Movie: " + movie.getTitle() + " added to User: " + favUser.getUserName());
                                    
                                    for (favoList ob : favoArray){
                                       if (ob.getUserName().contains(currentUser.getName())){
                                          System.out.println(ob.getMovieName());
                                       }else{
                                          //System.out.println("No movie in favolist");
                                       
                                       }
                                    }
                                    favoriteFound = true;
                                    break;
                                 }
                              }
                              
                              if (!favoriteFound){
                                    System.out.println("No match. try again :-)");
                              }
                              break;
                           case 4:
                              System.out.println(watchHistory);                           
                              break;
                           case 5: 
                              System.out.println("What movie do you want to watch? ");
                              Scanner watchScan = new Scanner (System.in);
                              String scanWatch = watchScan.nextLine();
                              for (Movie ob : movieArray){
                                 if (ob.getTitle() != null && ob.getTitle().contains(scanWatch) || ob.getActors() != null && ob.getActors().contains(scanWatch)){
                                    System.out.println("You are watching the movie " + ob.getTitle() + " with the actors " + ob.getActors() + ". Good luck! :-)");
                                    Date currentDate = new Date();
                                    System.out.println(currentDate.toString());
                                    String builder = new StringBuilder().append(scanWatch + ": ").append(currentDate.toString()).toString();
                                    String wh1 = new String (builder);
                                    watchHistory.add(wh1);
                                    System.out.println(builder);
                                    //watchHistory.add(builder);
                                     
                                    
                                    break;
                                 }
                              }      
                                 
                              System.out.println("Search for the exact title");     
                              break;
                           default:
                              continue;

                        }
                     }
                  
                  }
               case 3:
                  boolean loop4running = true;
                  while (loop4running){
                     System.out.println("\tMENU");
                     System.out.println("0. Add movie");
                     System.out.println("1. Update movie");
                     System.out.println("2. Delete movie");
                     System.out.println("3. Go back");
                     Scanner scan7 = new Scanner(System.in);
                     int loop4Input = scan7.nextInt();            
                     switch (loop4Input){
                     
                        case 0:
                           Movie moviex = new Movie();
                           
                           System.out.println("Title: ");
                           Scanner scan8 = new Scanner (System.in);
                           String scanTitle = scan8.nextLine();
                           moviex.setTitle(scanTitle);
                           
                           System.out.println("Choose actors: ");
                           Scanner scan9 = new Scanner (System.in); 
                           String scanActors = scan9.nextLine();
                           moviex.setActors(scanActors);
                           
                           System.out.println("Year: ");
                           Scanner scan10 = new Scanner (System.in);
                           int scanYear = scan10.nextInt();
                           moviex.setYear(scanYear);
                           
                           System.out.println("Length of the movie: ");
                           Scanner scan11 = new Scanner (System.in);
                           double scanMovieLength = scan11.nextDouble();
                           moviex.setMovieLength(scanMovieLength);
                           movieArray.add(moviex);
                           break;
                        case 1:
                           System.out.println("List of movies:\n");
                           for (Movie ob : movieArray){
                              System.out.println(ob.getTitle());
                              System.out.println(ob.getActors());
                              System.out.println(ob.getYear());
                              System.out.println(ob.getMovieLength() + "\n");
                                 
                           }
                           System.out.println("");
                           System.out.println("What do you want to update?\n");
                              
                           break;
                        case 2:
                           System.out.println("List of movies:\n");
                           for (Movie ob : movieArray){
                              System.out.println(ob.getTitle());
                              System.out.println(ob.getActors());
                              System.out.println(ob.getYear());
                              System.out.println(ob.getMovieLength() + "\n");
                                 
                           }
                           System.out.println("");
                           System.out.println("What do you want to delete?\n");
                           Scanner scan12 = new Scanner (System.in);
                           int deleteScan = scan12.nextInt();
                           movieArray.remove(deleteScan);
                              
                         
                           break;
                        case 3:
                           loop4running = false;
                           break;
                     
                     } 
                  
                  
                  
                  }   
            }
         }   
         catch (Exception e){
            System.out.println("You got an error");
         
         }
      }
      
   }
   
}