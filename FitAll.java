import java.util.Scanner; //Imports the scanner
import java.util.ArrayList; //Imports lists

public class FitAll {
    public static void main(String[] args) {
        ArrayList<Session> sessions = new ArrayList<>(); //Array that contains the sessions
        Scanner sc = new Scanner(System.in); //Scanner to take inputs from the user
        int option = -1; //The variable that holds which option the user selected from the menu
        boolean running = true; //Checks whether the program is running
        sessions.add(new YogaSession("Yoga", "Low", "Wednesday", "10.00 AM", 45, 15, "Hatha", 20)); //Adds the hardcoded sessions to the sessions array with their information
        sessions.add(new PilatesSession("Pilates", "High", "Monday", "15.00 PM", 60, 5, "None", "High"));
        sessions.add(new ZumbaSession("Zumba", "Medium", "Sunday", "17.00 PM", 15, 11, "Salsa", 500));
        System.out.println("Welcome to FitAll"); //Prints a welcome message
        while (running) {
            System.out.println("1. Show all sessions\n2. Book a session\n3. Cancel a booking\n4. Exit"); //Prints the menu
            System.out.println("Choose an option: ");

            while (true) { //Loop to keep taking inputs until 1 is valid
                try {
                    option = Integer.parseInt(sc.nextLine().trim()); //Takes an input from the user and converts it to an integer
                    if (option < 1 || option > 4) { //Checks the input matches an available option
                        System.out.print("Please make sure your input is between 1 and 4: "); //Prints an error message
                    } else {
                        break; //Exits the loop when a valid input is given
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Please enter a valid integer: "); //Prints an error message
                }
            }


            if (option == 1) { //To print out available sessions as a table
                System.out.println("Available sessions");
                System.out.println("|------------|---------------|-------------------|------------------|-------------|-----------|-------------------|-----------------------------------| ");
                System.out.println("|Session ID  |Session Name   |Level of fitness   |Day of the week   |Start time   |Duration   |Available spaces   |Additional Info                    |"); //The header for the table of sessions
                for (Session session : sessions) { //Loops through the array of sessions and prints them with dividers in between
                    System.out.println("|------------|---------------|-------------------|------------------|-------------|-----------|-------------------|-----------------------------------| ");
                    session.showDetails();
                    System.out.println(" ");
                }
                System.out.println("|------------|---------------|-------------------|------------------|-------------|-----------|-------------------|-----------------------------------| ");


            } else if (option == 2) { //Booking a sessions
                boolean sessionFound = false; //Checks if the session has been found in the array of sessions
                System.out.println("Enter a session ID: ");
                int inputID = 0;
                while (true) { //Loops until a valid input is given
                    try {
                        inputID = Integer.parseInt(sc.nextLine().trim()); //Takes the input from the user and converts it to an integer
                        if (inputID < 1 || inputID > sessions.size()) { //Checks if the input session id is a valid session id (in the sessions array)
                            System.out.print("This session does not exist, Try again: "); //Error message
                        } else {
                            break; //Exits the loop when a valid input is given
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Please enter a valid integer: "); //Error message
                    }
                }
                System.out.print("Enter your name: ");
                String name = sc.nextLine(); //Takes the users name as an input
                for (Session session : sessions) {
                    if (session.getSessionId() == inputID) { //Finds the session with the inputted id
                        sessionFound = true;
                        session.book(inputID, name); //Calls the method to book the user into the session
                    }
                }
                if (!sessionFound) {
                    System.out.println("Session not found"); //If the session is not found, Print an error message
                }


            } else if (option == 3) { //Cancelling a booking for a session
                boolean sessionFound = false; //Checks if the session has been found in the array of sessions
                System.out.println("Enter a session ID: ");
                int inputID = 0;
                while (true) { //Loops until a valid input is given
                    try {
                        inputID = Integer.parseInt(sc.nextLine().trim()); //Takes the input from the user and converts it to an integer
                        if (inputID < 1 || inputID > sessions.size()) { //Checks if the input session id is a valid session id (in the sessions array)
                            System.out.print("This session does not exist, Try again: "); //Error message
                        } else {
                            break; //Exits the loop when a valid input is given
                        }
                    } catch (NumberFormatException e) {
                        System.out.print("Please enter a valid integer: "); //Error message
                    }
                }
                System.out.print("Enter your name: ");
                String name = sc.nextLine(); //Takes the users name as an input
                for (Session session : sessions) {
                    if (session.getSessionId() == inputID) { //Finds the session with the inputted id
                        sessionFound = true;
                        session.cancel(inputID, name); //Calls the method to remove the user from the session
                    }
                }
                if (!sessionFound) {
                    System.out.println("Session not found"); //If the session is not found, Print an error message
                }
            } else if (option == 4) {
                System.out.println("Thank you for using FitAll, Have a nice day!"); //Prints a goodbye message
                running = false; //Stops the program from running if exit is selected
            }
        }
    }
}
