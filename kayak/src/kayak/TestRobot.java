package kayak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * A robot lands on Mars, which happens to be a cartesian grid; assuming
 * that we hand the robot these instructions, such as LFFFRFFFRRFFF, where
 * "L" is a "turn 90 degrees left", "R" is a "turn 90 degrees right", and
 * "F" is "go forward one space, please write control code for the robot
 * such that it ends up at the appropriate-and-correct destination, and
 * include unit tests.
 * 
 * Here is an example output with command "FF":
 * 
 * [0, 2]
 */
public class TestRobot {

	private Robot testRobot;
	
	@Before
	public void setup(){
		//Starting position
		Coordinate startPosition = new Coordinate(0, 0);
		testRobot = new Robot(startPosition);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRobotWalkNullInstructions(){
		testRobot.walk(null);
	}
	
	@Test
	public void testRobotWalkEmptyInstructions(){
		testRobot.walk("");
		System.out.println(testRobot.getPosition());
		Assert.assertEquals(0, testRobot.getPosition().getX());
		Assert.assertEquals(0, testRobot.getPosition().getY());
	}
	
	@Test
	public void testRobotWalkInvalidInstructions(){
		testRobot.walk("abcdexyz");
		System.out.println(testRobot.getPosition());
		Assert.assertEquals(0, testRobot.getPosition().getX());
		Assert.assertEquals(0, testRobot.getPosition().getY());
	}
	
	@Test
	public void testRobotMove() {
		String walkingInstructions = "FF";
		
		testRobot.walk(walkingInstructions);	
		System.out.println(testRobot.getPosition());
		Assert.assertEquals(0, testRobot.getPosition().getX());
		Assert.assertEquals(2, testRobot.getPosition().getY());
		
		walkingInstructions = "LFFFRFFFRRFFF";
		testRobot.walk(walkingInstructions);
		System.out.println(testRobot.getPosition());
		Assert.assertEquals(-3, testRobot.getPosition().getX());
		Assert.assertEquals(2, testRobot.getPosition().getY());
		
	}

}
