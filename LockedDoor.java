import java.util.Random;

/** A basic type of door that can be opened 
 * if the key is found.
 */
public class LockedDoor implements Door{
    /** An integer variable that determines if the key is found at a certain location */
    private int keyLocation;
    /** An integer that determines where you decided to look */
    private int keyChoice;

    /** Constructs a locked door
     * Randomizes a key location
     */
    public LockedDoor() {
        Random rand = new Random();
        keyLocation = rand.nextInt(3) + 1;
    }

    /** Examines the door to read the description
     * @return the door description
     */
    @Override
    public String examine() {
        return "A door that can be opened with a key. " +
        "Look around to see if you can find it.";
    }

    /** Displays the option menu 
     * @return String the menu options
     */
    @Override 
    public String menu() {
        return "1. Look Under Mat\n2. Look Under Flower Pot\n" +
        "3. Look Under Fake Rock";
    }

    /** Determines the action based on the user's selection
     * @return String the user's chosen action
     */
    @Override
    public String unlock(int option) {
        if (option >= 1 && option <= 3) {
            keyChoice = option;
            if (keyChoice == 1) {
                return "You looked under the mat.";
            }
            else if (keyChoice == 2) {
                return "You looked under the flower pot.";
            }
            else {
                return "You looked under the fake rock.";
            }
        }
        return "Invalid input.";
    }

    /** Returns true if the door is able to be unlocked 
     * @return true if the door is opened, false otherwise
     */
    @Override
    public boolean open() {
        if (keyLocation == keyChoice) {
            return true;
        }
        else {
            return false;
        }
    }

    /** Gives the user a clue if the door can't be opened 
     * @return String a clue
     */
    @Override 
    public String clue() {
        return "Look somewhere else.";
    }
    
    /** Congratulates the user if the door is successfully opened 
     * @return String congratulating the user
     */
    @Override 
    public String success() {
        return "Congratulations, you opened the door.";
    }
}
