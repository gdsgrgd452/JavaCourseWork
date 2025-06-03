public class YogaSession extends Session {
    String YogaStyle; //Initialises the unique attributes for yoga
    int MeditationTime;
    YogaSession(String SessionName, String RequiredFitnessLevel, String Day, String StartTime, int Duration, int SpacesLeft, String YogaStyle, int MeditationTime) {
        super(SessionName, RequiredFitnessLevel, Day, StartTime, Duration, SpacesLeft);
        this.YogaStyle = YogaStyle;
        this.MeditationTime = MeditationTime;
    }

    @Override //Uses this method instead of the Session class one
    public void showDetails() {
        super.showDetails(); //Calls the Superclass method to print the common attributes
        System.out.printf("%36s", "Style: " + YogaStyle + ", " + "Meditation: " + MeditationTime + " Mins" + "|"); //Prints the unique attributes
    }

    @Override //Uses this method instead of the Session class one
    public void book(int SessionId, String personsName){
        if (Participants.contains(personsName)){ //Checks if the person is already booked in for this session and returns an error message if they are
            System.out.println("Participant " + personsName + " is already booked for this session");
        } else if (SpacesLeft > 0) { //If there is spaces available, book them in
            updateSpaces("Book"); //Updates the spaces left in the session
            Participants.add(personsName); //Adds the name to the participants
            System.out.println("Booked " + personsName + " for Yoga"); //Prints a message for the user
        } else {
            System.out.println("There is no spaces left for this session"); //Error message for if there is no spaces
        }
    }

    @Override //Uses this method instead of the Session class one
    public void cancel(int SessionID, String personsName) {
        if (Participants.contains(personsName)){ //If the person is one of the participants then cancel their booking
            Participants.remove(personsName); //Removes them from the participants
            updateSpaces("Cancel"); //Updates the spaces left in the session
            System.out.println("Participant " + personsName + " has been removed from Yoga"); //Prints a message for the user
        } else {
            System.out.println("Participant " + personsName + " is not registered for Yoga"); //Error message if they are not registered so cant cancel
        }
    }
}
