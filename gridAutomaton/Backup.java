package gridAutomaton;
/**
 * 
 * @author rhynes
 * @deprecated
 * 
 * 			Used as a local copy of a grid, contained informations such as
 *             the state of a cell, the numbers of alive neighbors.
 */
public class Backup {
	int i, j;
	int aliveNeighbors;
	boolean alive;

	public Backup(int i, int j, int aliveNeighbors, boolean alive) {
		super();
		this.i = i;
		this.j = j;
		this.aliveNeighbors = aliveNeighbors;
		this.alive = alive;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

	public int getAliveNeighbors() {
		return aliveNeighbors;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void setAliveNeighbors(int aliveNeighbors) {
		this.aliveNeighbors = aliveNeighbors;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String toString() {
		return "[" + i + "," + j + "] = " + "[" + ((alive) ? "*" : " ") + "," + aliveNeighbors + "]";
	}
}
