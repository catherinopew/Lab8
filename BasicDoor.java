import java.util.Random;

/** A basic type of door that can be opened if it is pushed or pulled */
public class BasicDoor implements Door {
    /** A boolean variable that determines whether push will unlock the door */
    private boolean push;
    /** A boolean variable that determines if the user input will unlock the door */
    private boolean input;

    /** Constructs a basic door
     * Whether push is true or false is randomized
     */
    public BasicDoor() {
        Random rand = new Random();
        int randomNum = rand.nextInt(2) + 1;
        if (randomNum == 1) {
            push = true;
        }
        else {
            push = false;
        }
        input = false;
    }

    /** Examines the door to read the description
     * @String the door description
     */
    @Override
    public String examine() {
        return "A door that can be pushed or pulled.";
    }

    /** Displays the option menu 
     * @return the menu options
     */
    @Override 
    public String menu() {
        return "1. Push\n2. Pull";
    }

    /** Determines the action based on the user's selection
     * @return String a message of the user's chosen action
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 2) {
            if (option == 1 && push == true) {
                input = true;
                return "You push the door.";
            }
            else if (option == 1 && push == false) {
                return "You push the door.";
            }
            else if (option == 2 && push == false) {
                input = true;
                return "You pulled the door.";
            }
            else {
                return "You pulled the door.";
            }
        } 
        return "Invalid input.";
    }

    /** Returns true if the door is able to be unlocked 
     * @return true if the door is opened, false otherwise
     */
    @Override
    public boolean open() {
        return input;
    }

    /** Gives the user a clue if the door can't be opened 
     * @return String a clue
     */
    @Override 
    public String clue() {
        return "Try the other direction.";
    }
    
    /** Congratulates the user if the door is successfully opened 
     * @return String congratulating the user
     */
    @Override 
    public String success() {
        return "Congratulations, you opened the door.";
    }
}
