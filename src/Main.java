import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //polymorphism: runtime method behavior is different for different objects. depends on run-time type of object
        //runtime type might be different from declared type in code. Declared type has to havee a relationship to
        //runtime type. Inheritance is one way to accomplish this.

        Movie theMovie = new Movie ("star wars");
        theMovie.watchMovie(); // will retrieve star wars as a 'movie' film

       Movie anotherMovie = new Adventure ("lord of the rings"); // assigning an adventure object to a movie variable
        anotherMovie.watchMovie();

        Movie funnyMovie = new Comedy("Zoolander");
        funnyMovie.watchMovie();

        Movie spaceMovie = new SciFi("Interstellar");
        spaceMovie.watchMovie();

        System.out.println("=================");
        /////////////////////////////////////////

        Movie factoryMovie = Movie.getMovie("Adventure", "Journey to the West");
        //compile time is movie, but runtime is adventure
        //even if new subclasses are created like 'fantasy', how we write code in main method doesn't change
        factoryMovie.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("enter type (A for adventure, C for comedy, S for scifi, Q for quit");
            String type = s.nextLine();
            if ("Qq".contains(type)){ //this checks if the type variable was assigned a value of Q or q. if so, quit.
                break;
            }
            System.out.println("enter movie title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type,title);
            movie.watchMovie();

        }
    }
}