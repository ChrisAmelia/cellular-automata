package gridAutomaton;

/**
 * Rules to match for a live cell to stay alive on to the next generation,
 * otherwise it dies.
 * 
 * @author rhynes
 *
 */
public class DeathRule extends GoldenRule {

	/**
	 * Constructs a new object DeathRule.
	 */
	public DeathRule() {
	}

	@Override
	public boolean isTrue(Cell cell) {
		return ((one) ? (cell.isAlive() && cell.getAliveNeighbors() != 1) : true)
				&& ((two) ? (cell.isAlive() && cell.getAliveNeighbors() != 2) : true)
				&& ((three) ? (cell.isAlive() && cell.getAliveNeighbors() != 3) : true)
				&& ((four) ? (cell.isAlive() && cell.getAliveNeighbors() != 4) : true)
				&& ((five) ? (cell.isAlive() && cell.getAliveNeighbors() != 5) : true)
				&& ((six) ? (cell.isAlive() && cell.getAliveNeighbors() != 6) : true)
				&& ((seven) ? (cell.isAlive() && cell.getAliveNeighbors() != 7) : true)
				&& ((eight) ? (cell.isAlive() && cell.getAliveNeighbors() != 8) : true);
	}

	@Override
	public String toString() {
		return 
				"<html>"
				+((one) ? ("- Any live cell with exactly " + 1 + " live neighbor lives.<br />") : "")
				+ ((two) ? ("\n- Any live cell with exactly " + 2 + " live neighbors lives.<br />")
						: "")
				+ ((three)
						? ("\n- Any live cell with exactly " + 3 + " live neighbors lives.<br />")
						: "")
				+ ((four) ? ("\n- Any live cell with exactly " + 4 + " live neighbors lives.<br />")
						: "")
				+ ((five) ? ("\n- Any live cell with exactly " + 5 + " live neighbors lives.<br />")
						: "")
				+ ((six) ? ("\n- Any live cell with exactly " + 6 + " live neighbors lives.<br />")
						: "")
				+ ((seven)
						? ("\n- Any live cell with exactly " + 7 + " live neighbors lives.<br />")
						: "")
				+ ((eight)
						? ("\n- Any live cell with exactly " + 8 + " live neighbors lives.<br />")
						: "")
				+ "</html>";

	}
}
