package gridAutomaton;

/**
 * A rule is either true or false.
 * 
 * @author rhynes
 */
public interface Rule {


	/**
	 * Returns true if the given cell matches the rule, else false.
	 * 
	 * @param cell
	 *            the cell to test.
	 * @return boolean true if the given cell matches the rule.
	 */
	public boolean isTrue(Cell cell);

}
