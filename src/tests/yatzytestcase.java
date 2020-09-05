package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import game.*;

class yatzytestcase {

	@Test
	public void testScoreOnes() {

		int[] dices = new int[] { 2, 2, 2, 4, 5 };
		int result;
		int expected = 6;
		try {

			Score obj = new Score();

			obj.setScore(2, dices);

			result = obj.getScore(2);

			assertEquals(expected, result);

		} catch (Exception e) {

			fail("Test fail");

		}
	}

	@Test
	public void testDice() {
		Dice obj = new Dice();

		int dice = 0;
		int max = 0;
		int min = 0;

		for (int i = 0; i < 1000; i++) {

			obj.roll();
			dice = obj.getResult();

			if (dice > max) {
				System.out.println("Value is more than 6");
			} else if (dice < min) {
				System.out.println("Value is less than 1");
			}
		}
	}

	@Test
	public void testWrongNameOfPlayer() throws Exception {

		Player obj = new Player("Johan");
		String expected = "JPS";
		String name = obj.getName();
		Assert.assertNotEquals(name, expected);
		System.out.println("Wrong name of player tested sucessfully");

	}

}
