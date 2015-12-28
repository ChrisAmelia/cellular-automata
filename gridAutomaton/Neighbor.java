package gridAutomaton;

/**
 * A neighbor is basically a cell.
 * 
 * @author rhynes
 */
public class Neighbor {
	Cell cell;

	/**
	 * Constructs a new object Cell.
	 * 
	 * @param cell
	 *            cell to set
	 */
	public Neighbor(Cell cell) {
		super();
		this.cell = cell;
	}

	/**
	 * Returns the cell.
	 * 
	 * @return the cell
	 */
	public Cell getCell() {
		return cell;
	}

	/**
	 * Sets the cell.
	 * 
	 * @param cell
	 *            cell to set
	 */
	public void setCell(Cell cell) {
		this.cell = cell;
	}

	/**
	 * Returns true if the cell is alive, else false.
	 * 
	 * @return true if the cell is alive
	 */
	public boolean isAlive() {
		return cell.isAlive();
	}

}
