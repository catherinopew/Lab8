import java.util.Random;

/** Door with a combination lock */
public class ComboDoor implements Door {
	/** Combination value to unlock door and user's guess */
	private int comboValue, guess;

	/** Constructs a combination door with a random value to unlock, 
     * and sets user's guess to 0
	 */
	public ComboDoor() {
		Random rand = new Random();
		comboValue = rand.nextInt(10) + 1;
		guess = 0;
	}

	/** Returns a string description of the door
	 * @return string description of the door
	 */
	@Override
	public String examine() {
		return "A door with a combination lock. You can spin the dial to a number 1-10.";
	}

	/** Returns list of options user can do to unlock the door
	 * @return list of options user can do to unlock the door
	 */
	@Override
	public String menu() {
		return "Enter # 1-10: ";
	}

	/** Checks if the option is within the range 
     * and sets guess to become the option
	 * @return String related to user action
	 */
	@Override
	public String unlock(int option) {
        if (option >= 1 && option <= 10) {
            guess = option;
            return "You turn the dial...";
        }
        return "Invalid input.";
	}

	/** Tests to see if door has been unlocked
	 * @return true if unlocked. False otherwise
	 */
	@Override
	public boolean open() {
		if (guess == comboValue) {
			return true;
		} else {
			return false;
		}
	}

	/** Returns a clue to help user unlock the door
	 * @return clue to help user unlock the door
	 */
	@Override
	public String clue() {
		if (guess < comboValue) {
			return "Too Low";
		} else {
			return "Too High";
		}
	}

	/** Returns success message for the door
	 * @return success message for the door
	 */
	@Override
	public String success() {
		return "You found the right value and opened the door.";
	}
}
