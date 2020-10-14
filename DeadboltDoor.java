import java.util.InputMismatchException;

/**
 * Door with deadbolt locks
 */
public class DeadboltDoor implements Door {
	/**
	 * Bolts on door. True if bolt is attached, false if removed.
	 */
	boolean bolt1, bolt2;

	/**
	 * Constructs a door with 1 bolt removed and another attached
	 */
	public DeadboltDoor() {
		bolt1 = false;
		bolt2 = true;
	}

	/**
	 * Returns a string description of the door
	 * 
	 * @return string description of the door
	 */
	@Override
	public String examine() {
		return "A door with two deadbolts. Both need to be unlocked for the door to open, but you can’t tell if they are locked or unlocked";
	}

	/**
	 * Returns list of options user can do to unlock the door
	 * 
	 * @return list of options user can do to unlock the door
	 */
	@Override
	public String menu() {
		return "1. Toggle Bolt 1\n" + "2. Toggle Bolt 2";
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
		try {
			if (choice == 1) {
				bolt1 = !bolt1; // invert status of bolt 1
				if (bolt1) {
					return "You toggled the bolt, but now it is as sealed as your fate";
				} else {
					return "One of the bolts is unlocked.";
				}
			}

			else if (choice == 2) {
				bolt2 = !bolt2; // invert status of bolt 2
				if (bolt1) {
					return "You toggled the bolt, but now it is as sealed as your fate";
				} else {
					return "One of the bolts is unlocked.";
				}
			}

			else {
				return "Not a valid menu selection.";
			}
		} catch (InputMismatchException e) {
			return "Invalid Input";
		}
	}

	/**
	 * Tests to see if door has been unlocked
	 * 
	 * @return true if unlocked. False otherwise
	 */
	@Override
	public boolean open() {
		if (bolt1 == bolt2 == true) {
			return true;
		}

		return false;
	}

	/**
	 * Returns a clue to help user unlock the door
	 * 
	 * @return clue to help user unlock the door
	 */
	@Override
	public String clue() {
		return "One is in the correct position";
	}

	/**
	 * Returns success message for the door
	 * 
	 * @return success message for the door
	 */
	@Override
	public String success() {
		return "You unlocked both deadbolts and opened the door";
	}

}
