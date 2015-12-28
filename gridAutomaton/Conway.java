package gridAutomaton;

/**
 * The two states of a cell in Conway's game are : dead or alive which can be
 * represented by a boolean.
 * 
 * @author rhynes
 */
public class Conway implements State, Cloneable {
	private Boolean alive = false;

	/**
	 * Constructs a new object Conway.
	 */
	public Conway() {
		this.alive = false;
	}

	/**
	 * Constructs a new object Conway.
	 * 
	 * @param alive
	 *            true for alive, false for dead.
	 */
	public Conway(Boolean alive) {
		super();
		this.alive = alive;
	}

	@Override
	public void change() {
		if (alive == false)
			alive = true;
		else
			alive = false;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public Boolean isAlive() {
		return alive;
	}

}
