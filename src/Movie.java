public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        //.getClass is a java.lang.object method that returns class type at runtime instance. then get the name of the
        //class using getSimpleName method
        System.out.println(title + " is a " + instanceType + " film");
    }

    public static Movie getMovie(String type, String title){
        return switch (type.toUpperCase().charAt(0)){ //parameter 'type' calls upperCase method to format index 0 for
            //use in switch statement
            case 'A' -> new Adventure (title);
            case 'C' -> new Comedy (title);
            case 'S' -> new SciFi(title);
            default -> new Movie (title);
        }; //this is an example of a 'factory method'. Calling code doesn't need to know anything about movies subclasses
        //it passes in the type and gets a different kind of movie subclass. No direct/manual creation of instances of
        // adventure, comedy, scifi objects. factory methods return a new instance object. factory methods give us an
        // object without having to know the details of how to create a new one or specify the exact class we want
    }
}


class Adventure extends Movie{
    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(3), // %s replaces a string
                "pleasant scene",
                "scary music",
                "something bad happens");
    }
}

class Comedy extends Movie{
    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(2), // %s replaces a string
                "funny stuff",
                "more funny stuff");
    }
}

class SciFi extends Movie{
    public SciFi(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s%n".repeat(1), // %s replaces a string
                "doing space stuff");
    }
}

