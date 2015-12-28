package gridAutomaton;

/**
 * The number of states of a cell is not limited, meaning, it's not necessary
 * that a cell could be alive or dead. There could be a transitional state.
 * 
 * @author rhynes
 */
public interface State extends Cloneable {

	/**
	 * Changes the state of the cell.
	 */
	public void change();

	/**
	 * Returns true if it's alive else false.
	 * 
	 * @return true if it's alive.
	 */
	public Boolean isAlive();

	/**
	 * Creates and returns a copy of this object.
	 * 
	 * @return a copy of this
	 * @throws CloneNotSupportedException
	 *             if it's null
	 */
	public Object clone() throws CloneNotSupportedException;

}
