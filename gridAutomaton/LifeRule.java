package gridAutomaton;

/**
 * Rule to match to make a dead cell becoming a live cell either way, it stays
 * dead on to the next generation. A dead cell can't become a live cell if there
 * is not at least one alive neighbor.
 * 
 * @author rhynes
 *
 */
public class LifeRule extends GoldenRule {

	/**
	 * Constructs a new object LifeRule.
	 */
	public LifeRule() {
	}

	@Override
	public boolean isTrue(Cell cell) {
		return ((one) ? (!cell.isAlive() && cell.getAliveNeighbors() == 1) : false)
				|| ((two) ? (!cell.isAlive() && cell.getAliveNeighbors() == 2) : false)
				|| ((three) ? (!cell.isAlive() && cell.getAliveNeighbors() == 3) : false)
				|| ((four) ? (!cell.isAlive() && cell.getAliveNeighbors() == 4) : false)
				|| ((five) ? (!cell.isAlive() && cell.getAliveNeighbors() == 5) : false)
				|| ((six) ? (!cell.isAlive() && cell.getAliveNeighbors() == 6) : false)
				|| ((seven) ? (!cell.isAlive() && cell.getAliveNeighbors() == 7) : false)
				|| ((eight) ? (!cell.isAlive() && cell.getAliveNeighbors() == 8) : false);
	}

	@Override
	public String toString() {
		return "<html>"
				+ ((one) ? ("- Any dead cell with exactly " + 1 + " live neighbor becomes a live cell.<br />") : "")
				+ ((two) ? ("\n- Any dead cell with exactly " + 2 + " live neighbors becomes a live cell.<br />") : "")
				+ ((three) ? ("\n- Any dead cell with exactly " + 3 + " live neighbors becomes a live cell.<br />")
						: "")
				+ ((four) ? ("\n- Any dead cell with exactly " + 4 + " live neighbors becomes a live cell.<br />") : "")
				+ ((five) ? ("\n- Any dead cell with exactly " + 5 + " live neighbors becomes a live cell.<br />") : "")
				+ ((six) ? ("\n- Any dead cell with exactly " + 6 + " live neighbors becomes a live cell.<br />") : "")
				+ ((seven) ? ("\n- Any dead cell with exactly " + 7 + " live neighbors becomes a live cell.<br />")
						: "")
				+ ((eight) ? ("\n- Any dead cell with exactly " + 8 + " live neighbors becomes a live cell.<br />")
						: "")
				+ "</html>";
	}
}
