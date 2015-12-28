package gridAutomaton;

/**
 * This rule is effective when a cell has exactly two states.
 * 
 * @author rhynes
 *
 */
public abstract class GoldenRule implements Rule {
	protected boolean one = false;
	protected boolean two = false;
	protected boolean three = false;
	protected boolean four = false;
	protected boolean five = false;
	protected boolean six = false;
	protected boolean seven = false;
	protected boolean eight = false;

	/**
	 * Returns true if the rule for the given number of live neighbors is true,
	 * else false.
	 * 
	 * @param number
	 *            the number of live cells needed, at least one, max eight.
	 * @return true if the rule for the given number of alive neighbors is true.
	 */
	public boolean getLiveCell(int number) {
		if (number <= 0 || number > 8)
			return false;
		else {
			switch (number) {
			case 1:
				return one;
			case 2:
				return two;
			case 3:
				return three;
			case 4:
				return four;
			case 5:
				return five;
			case 6:
				return six;
			case 7:
				return seven;
			case 8:
				return eight;
			}
			return false;
		}
	}

	/**
	 * Sets the number of alive neighbors needed to zero.
	 */
	public void reset() {
		one = two = three = four = five = six = seven = eight = false;
	}

	/**
	 * Sets the number of live neighbors for a cell to match the rule.
	 * 
	 * @param number
	 *            the number of live neighbors for a cell to match the rule
	 * @return the number of live neighbors for a cell to match the rule.
	 */
	public boolean add(int number) {
		if (number <= 0 || number > 8)
			return false;
		else {
			switch (number) {
			case 1:
				one = true;
				break;
			case 2:
				two = true;
				break;
			case 3:
				three = true;
				break;
			case 4:
				four = true;
				break;
			case 5:
				five = true;
				break;
			case 6:
				six = true;
				break;
			case 7:
				seven = true;
				break;
			case 8:
				eight = true;
				break;
			}
			return true;
		}
	}

}
