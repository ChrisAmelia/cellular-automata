package gridAutomaton;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * A cell basically contains two informations : its state (e.g. dead or alive)
 * and its neighbors.
 * 
 * @author rhynes
 */
public class Cell implements Cloneable {
	protected Integer id;
	protected State state;
	protected Neighbor[] neighbors = new Neighbor[8];

	/**
	 * Constructs a new object Cell.
	 * 
	 * @param id
	 *            id
	 */
	public Cell(Integer id) {
		this.id = id;
		this.state = new Conway();
	}

	/**
	 * Constructs a new object Cell.
	 * 
	 * @param id
	 *            id
	 * @param state
	 *            state of the current cell
	 */
	public Cell(Integer id, State state) {
		this.id = id;
		this.state = state;
	}

	/**
	 * Constructs a new object Cell.
	 * 
	 * @param id
	 *            id
	 * @param state
	 *            state of the current cell
	 * @param cells
	 *            list of its neighbors
	 */
	public Cell(Integer id, State state, Cell[] cells) {
		this.id = id;
		this.state = state;
		for (int i = 0; i < cells.length; i++)
			if (cells[i] != null)
				setNeighbor(i, cells[i]);
	}

	/**
	 * Returns the id of the current cell.
	 * 
	 * @return the id of the current cell
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Returns the state of the current cell.
	 * 
	 * @return the state of the current cell
	 */
	public State getState() {
		return state;
	}

	/**
	 * Returns true if this cell has the neighbor given by orientation.
	 * 
	 * @param orientation
	 *            north-west, north, north-east, east, south-east, south,
	 *            south-west west
	 * @return true if this cell has the given neighbor
	 */
	public Boolean hasNeighbor(int orientation) {
		return (neighbors[orientation].getCell() != null);
	}

	/**
	 * Returns the neighbors.
	 * 
	 * @return the list of its neighbors
	 */
	public Neighbor[] getNeighbors() {
		return neighbors;
	}

	/**
	 * Returns the neighbor given by orientation.
	 * 
	 * @param orientation
	 *            north-west, north, north-east, east, south-east, south,
	 *            south-west west
	 * @return the neighbor given by orientation
	 */
	public Neighbor getNeighbor(int orientation) {
		return neighbors[orientation];
	}

	/**
	 * Returns the numbers of alive neighbors.
	 * 
	 * @return the number of alive neighbors.
	 */
	public int getAliveNeighbors() {
		int neighborsAlive = 0;
		for (int i = 0; i < neighbors.length; i++)
			if (neighbors[i].isAlive())
				neighborsAlive++;
		return neighborsAlive;
	}

	/**
	 * Sets the state.
	 * 
	 * @param state
	 *            state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	/**
	 * Sets the neighbors.
	 * 
	 * @param neighbors
	 *            lists of neighbors to set
	 */
	public void setNeighbor(Neighbor[] neighbors) {
		this.neighbors = neighbors;
	}

	/**
	 * Sets the neighbor given by the orientation and the given cell.
	 * 
	 * @param orientation
	 *            north-west, north, north-east, east, south-east, south,
	 *            south-west west
	 * @param cell
	 *            the cell of the neighbor
	 */
	public void setNeighbor(int orientation, Cell cell) {
		neighbors[orientation] = new Neighbor(cell);
	}

	/**
	 * Returns true if it's is alive, else false. Notice that if the current
	 * cell has more than two states, e.g : live, zombie or dead, this method
	 * will return false whether or not the state is zombie or dead.
	 * 
	 * @return true if the cell is alive
	 */
	public boolean isAlive() {
		if (state != null)
			return state.isAlive();
		return false;
	}

	/**
	 * Returns true if the neighbor given by orientation is alive, else false.
	 * 
	 * @param orientation
	 *            north-west, north, north-east, east, south-east, south,
	 *            south-west west
	 * @return true if the neighbor is alive
	 */
	public boolean isNeighborAlive(int orientation) {
		return neighbors[orientation].isAlive();
	}

	/**
	 * Changes the state of the cell.
	 */
	public void change() {
		if (state != null)
			state.change();
	}

	/**
	 * Creates and returns a copy of this cell. More exactly, the cloned cell's
	 * modification of state won't affect the original's.
	 * 
	 * @return a copy of this
	 * @throws CloneNotSupportedException
	 *             if the state of this is null
	 * 
	 */
	public Cell deepCopy() throws CloneNotSupportedException {
		return deepCopy(this, new IdentityHashMap<Cell, Cell>());
	}

	/**
	 * Creates and returns a copy of the given cell.
	 * 
	 * @param original
	 *            the cell to copy
	 * @param map
	 *            to spot when a previously encountered cell is discovered to
	 *            avoid computing its copy more than once
	 * @return a copy of this
	 * @throws CloneNotSupportedException
	 *             if the state of this is null
	 */
	private static Cell deepCopy(Cell original, Map<Cell, Cell> map) throws CloneNotSupportedException {
		if (original == null)
			return null;

		Cell copy = map.get(original);
		if (copy != null)
			return copy;

		State state = (State) original.getState().clone();
		copy = new Cell(original.id, state);

		map.put(original, copy);

		for (int i = 0; i < copy.neighbors.length; i++)
			copy.neighbors[i] = new Neighbor(deepCopy(original.neighbors[i].cell, map));

		return copy;
	}

}
