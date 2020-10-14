
/**
 * Door with a combination lock
 */
import java.util.Random;

public class ComboDoor implements Door {
	/**
	 * Combination value to unlock door and user's guess
	 */
	int comboValue, guess;

	/**
	 * Constructs a combination door with a random value to unlock, and sets user's
	 * guess to 0
	 */
	public ComboDoor() {
		comboValue = (int) (Math.random() * ((10 - 1) + 1));
		guess = 0;
	}

	/**
	 * Returns a string description of the door
	 * 
	 * @return string description of the door
	 */
	@Override
	public String examine() {
		return "A door with a combination lock. You can spin the dial to a number 1-10.";
	}

	/**
	 * Returns list of options user can do to unlock the door
	 * 
	 * @return list of options user can do to unlock the door
	 */
	@Override
	public String menu() {
		return "Enter # 1-10:";
	}

	/**
	 * passes in the user’s menu selection, checks that it is in the bounds of the
	 * menu choices, and then performs the action associated with that choice in the
	 * attempt to open the door
	 * 
	 * @return text related to user action
	 */
	@Override
	public String unlock(int choice) {
		guess = choice;

		if (guess == comboValue) {
			return success();
		}

		return "The combination is turning, but your number will not unlock this door.";

	}

	/**
	 * Tests to see if door has been unlocked
	 * 
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

	/**
	 * Returns a clue to help user unlock the door
	 * 
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

	/**
	 * Returns success message for the door
	 * 
	 * @return success message for the door
	 */
	@Override
	public String success() {
		return "You found the right value and opened the door";
	}

}
