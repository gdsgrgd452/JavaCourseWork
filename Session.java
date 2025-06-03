import java.util.ArrayList; //Imports lists

public abstract class Session implements Bookable {
    private static int idCount = 1; //The session id (starting at 1 for the fist instance)
    int SessionId; //Initialises the attributes for a session
    String SessionName;
    String RequiredFitnessLevel;
    String Day;
    String StartTime;
    int Duration;
    int SpacesLeft;
    ArrayList<String> Participants;
    Session(String SessionName, String RequiredFitnessLevel, String Day, String StartTime, int Duration, int SpacesLeft){ //Constructor
        this.SessionId = idCount++;
        this.SessionName = SessionName;
        this.RequiredFitnessLevel = RequiredFitnessLevel;
        this.Day = Day;
        this.StartTime = StartTime;
        this.Duration = Duration;
        this.SpacesLeft = SpacesLeft;
        this.Participants = new ArrayList<>(); //Participants starts as empty
    }
    public void showDetails(){ //Prints the details of the session
        System.out.print("|"); //Prints the divider for the table
        System.out.printf("%12d", SessionId); //Prints the attributes with a space in front for alignment with the table
        System.out.print("|");
        System.out.printf("%15s", SessionName);
        System.out.print("|");
        System.out.printf("%19s", RequiredFitnessLevel);
        System.out.print("|");
        System.out.printf("%18s", Day);
        System.out.print("|");
        System.out.printf("%13s", StartTime);
        System.out.print("|");
        System.out.printf("%11d", Duration);
        System.out.print("|");
        System.out.printf("%19s", SpacesLeft);
        System.out.print("|");
    }
    public void updateSpaces(String toDo){ //Update the spaces left in the session
        if (toDo.equals("Book")){ //If they are booking
            if (SpacesLeft > 0){ //If there is any spaces left then decrease the spaces
                SpacesLeft--;
            } else {
                System.out.println("No spaces left"); //If there is no spaces left then print an error message
            }
        } else if (toDo.equals("Cancel")){ //If they are canceling then increase the spaces
            SpacesLeft++;
        }
    }
    public int getSessionId(){ //Getter for the session id
        return SessionId;
    }
}
