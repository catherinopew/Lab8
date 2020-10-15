/** Door interface with public abstract functions */
public interface Door {
	/** Examines a door
	 * @return emaine result
	 */
	public String examine();

	/** Lists user options
	 * @return user selection
	 */
	public String menu();

	/** Unlocks a door
	 * @param option user selects
	 * @return unlock result
	 */
	public String unlock(int option);

	/** Opens door
	 * @return return true if open. False otherwise
	 */
	public boolean open();

	/** Give user clue if necessary
	 * @return clue
	 */
	public String clue();

	/** Return success message from door
	 * @return success message from door
	 */
	public String success();
}
