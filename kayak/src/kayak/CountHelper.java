package kayak;

/**
 * Created by lisandro on 3/3/16.
 */
public class CountHelper {

	/**
	 * Counts up by one from start to end. 
	 * 
	 * Preconditions : assumes that start & end are positive ints, assumes that start is less than end.
	 * Postconditions : start <= end
	 * 
	 * @param start
	 * @param end
	 * @throws StackOverflowError may occur if the number of recursive calls is large
	 */
	public void countUp(int start, int end) {
		if (start <= end) {
			System.out.println(start);
			countUp(start + 1, end);
		}
	}

	/**
	 * Counts up by one from start to end and then counts down to start.
	 * 
	 * Preconditions : assumes that start & end are positive ints, assumes that start is less than end.
	 * Postconditions : start <= end
	 * 
	 * @param start
	 * @param end
	 * @throws StackOverflowError may occur if the number of recursive calls is large
	 */
	public void countUpAndDown(int start, int end) {
		if (start <= end) {
			System.out.println(start);
			countUpAndDown(start + 1, end);
			if (start != end) {
				System.out.println(start);
			}
		}
	}
}
