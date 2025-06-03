public class ZumbaSession extends Session {
    String DanceStyle; //Initialises the unique attributes for zumba
    int EnergyLevel;
    ZumbaSession( String SessionName, String RequiredFitnessLevel, String Day, String StartTime, int Duration, int SpacesLeft, String DanceStyle, int EnergyLevel) {
        super(SessionName, RequiredFitnessLevel, Day, StartTime, Duration, SpacesLeft);
        this.DanceStyle = DanceStyle;
        this.EnergyLevel = EnergyLevel;
    }
    @Override //Uses this method instead of the Session class one
    public void showDetails() {
        super.showDetails(); //Calls the Superclass method to print the common attributes
        System.out.printf("%36s", "Dance: " + DanceStyle + ", " + "Energy: " + EnergyLevel + " Cal" + "|"); //Prints the unique attributes
    }
    @Override //Uses this method instead of the Session class one
    public void book(int SessionId, String personsName){
        if (Participants.contains(personsName)){ //Checks if the person is already booked in for this session and returns an error message if they are
            System.out.println("Participant " + personsName + " is already booked for this session");
        } else if (SpacesLeft > 0) { //If there is spaces available, book them in
            updateSpaces("Book"); //Updates the spaces left in the session
            Participants.add(personsName); //Adds the name to the participants
            System.out.println("Booked " + personsName + " for Zumba"); //Prints a message for the user
        } else {
            System.out.println("There is no spaces left for this session"); //Error message for if there is no spaces
        }
    }

    @Override //Uses this method instead of the Session class one
    public void cancel(int SessionID, String personsName) {
        if (Participants.contains(personsName)){ //If the person is one of the participants then cancel their booking
            Participants.remove(personsName); //Removes them from the participants
            updateSpaces("Cancel"); //Updates the spaces left in the session
            System.out.println("Participant " + personsName + " has been removed from Zumba"); //Prints a message for the user
        } else {
            System.out.println("Participant " + personsName + " is not registered for Zumba"); //Error message if they are not registered so cant cancel
        }
    }
}
