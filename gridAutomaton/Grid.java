package gridAutomaton;

/**
 * A grid.
 * 
 * @author rhynes
 */
public interface Grid {

	/**
	 * Returns true if all cells are dead, else false. It is assumed that a
	 * cell's state can be classified as dead.
	 * 
	 * @return true if all cells are dead.
	 */
	public boolean areAllCellsDead();

	/**
	 * Sets all cells to dead.
	 */
	public void clear();

	/**
	 * Returns the number of rows
	 * 
	 * @return the number of rows
	 */
	public int getRows();

	/**
	 * Returns the number of columns
	 * 
	 * @return the number of columns
	 */
	public int getCols();

	/**
	 * Prints the grid.
	 */
	public void showGrid();

	/**
	 * Updates the grid.
	 */
	public void update();
}
