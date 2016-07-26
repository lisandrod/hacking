package kayak;

/**
 *
 * A robot object that can be instantiated on a cartesian grid. The robot can do
 * many things such as receive instructions to walk.
 *
 * Created by lisandro on 3/2/16.
 */
public class Robot {

	private enum FaceDirection {
		North, South, West, East
	}

	private Coordinate position;
	private FaceDirection currentDirection;

	public Robot(Coordinate startingPosition) {
		this.position = startingPosition;
		this.currentDirection = FaceDirection.North;
	}

	public Coordinate getPosition() {
		return position;
	}
	
	public void reset(){
		this.position = new Coordinate(0, 0);
		this.currentDirection = FaceDirection.North;
	}

	/**
	 * 
	 * @param instructions
	 * @throws IllegalArgumentException
	 */
	public void walk(String instructions) throws IllegalArgumentException {
		// check instructions for only capital L,R,F

		if (instructions == null) {
			throw new IllegalArgumentException("empty instructions received");
		}

		char[] moves = instructions.toUpperCase().toCharArray();

		for (char command : moves) {

			switch (command) {
			case 'F':
				moveForward();
				break;
			case 'L':
				moveLeft();
				break;
			case 'R':
				moveRight();
				break;
			default:
				break;
			}
		}
	}

	private void moveForward() {
		switch (currentDirection) {
			case North:
				position.setY(position.getY() + 1);
				break;
			case South:
				position.setY(position.getY() - 1);
				break;
			case West:
				position.setX(position.getX() - 1);
				break;
			case East:
				position.setX(position.getX() + 1);
				break;
			}
	}

	private void moveLeft() {
		switch (currentDirection) {
			case North:
				position.setX(position.getX() - 1);
				currentDirection = FaceDirection.West;
				break;
			case South:
				position.setX(position.getX() + 1);
				currentDirection = FaceDirection.East;
				break;
			case West:
				position.setY(position.getY() - 1);
				currentDirection = FaceDirection.South;
				break;
			case East:
				position.setY(position.getY() + 1);
				currentDirection = FaceDirection.North;
				break;
			}
	}

	private void moveRight() {
		switch (currentDirection) {
			case North:
				position.setX(position.getX() + 1);
				currentDirection = FaceDirection.East;
				break;
			case South:
				position.setX(position.getX() - 1);
				currentDirection = FaceDirection.West;
				break;
			case West:
				position.setY(position.getY() + 1);
				currentDirection = FaceDirection.North;
				break;
			case East:
				position.setY(position.getY() - 1);
				currentDirection = FaceDirection.South;
				break;
			}
	}
}
