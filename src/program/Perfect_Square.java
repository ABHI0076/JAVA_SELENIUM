package program;

import org.testng.annotations.Test;

public class Perfect_Square {

	@Test(enabled = true, groups = { "JavaTests" })
	public void perfectSquare() {

		// Find the element which are perfect Square from Array
		int[] intArray = { 21, 11, 10, 16, 20, 25, 15, 85, 4, 225, 400 };
		for (int num : intArray) {

			int ele = (int) Math.sqrt(num);

			if (ele * ele == num) {

				System.out.println(num + " is a perfect Square.");

			}

		}

	}

}
