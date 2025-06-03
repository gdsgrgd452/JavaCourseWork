public class PilatesSession extends Session {
    String EquipmentNeeded; //Initialises the unique attributes for pilates
    String CoreFocusLevel;
    PilatesSession(String SessionName, String RequiredFitnessLevel, String Day, String StartTime, int Duration, int SpacesLeft, String EquipmentNeeded, String CoreFocusLevel) {
        super(SessionName, RequiredFitnessLevel, Day, StartTime, Duration, SpacesLeft); //Sets the common session attributes to the input values
        this.EquipmentNeeded = EquipmentNeeded; //Sets the unique attributes to the input values
        this.CoreFocusLevel = CoreFocusLevel;
    }

    @Override //Uses this method instead of the Session class one
    public void showDetails() {
        super.showDetails(); //Calls the Superclass method to print the common attributes
        System.out.printf("%36s", "Equipment: " + EquipmentNeeded + ", " + "Focus: " + CoreFocusLevel + "|"); //Prints the unique attributes
    }

    @Override //Uses this method instead of the Session class one
    public void book(int SessionId, String personsName){
        if (Participants.contains(personsName)){ //Checks if the person is already booked in for this session and returns an error message if they are
            System.out.println("Participant " + personsName + " is already booked for this session");
        } else if (SpacesLeft > 0) { //If there is spaces available, book them in
            updateSpaces("Book"); //Updates the spaces left in the session
            Participants.add(personsName); //Adds the name to the participants
            System.out.println("Booked " + personsName + " for Pilates"); //Prints a message for the user
        } else {
            System.out.println("There is no spaces left for this session"); //Error message for if there is no spaces
        }
    }

    @Override //Uses this method instead of the Session class one
    public void cancel(int SessionID, String personsName) {
        if (Participants.contains(personsName)){ //If the person is one of the participants then cancel their booking
            Participants.remove(personsName); //Removes them from the participants
            updateSpaces("Cancel"); //Updates the spaces left in the session
            System.out.println("Participant " + personsName + " has been removed from Pilates"); //Prints a message for the user
        } else {
            System.out.println("Participant " + personsName + " is not registered for Pilates"); //Error message if they are not registered so cant cancel
        }
    }
}
