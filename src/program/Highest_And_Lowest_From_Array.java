package program;

import org.testng.annotations.Test;

public class Highest_And_Lowest_From_Array {

	@Test(enabled = true,groups= {"JavaTests"})
	public void findHighestAndLowest() {

		int[] intArray = { 10, 30, 100, 100, 20, 25, 25, 15, 85 };
		int highest = intArray[0];
		int lowest = intArray[0];
		for (int i = 1; i < intArray.length; i++) {
			if (intArray[i] > highest) {
				highest = intArray[i];
			} else if (intArray[i] < lowest) {
				lowest = intArray[i];
			}
		}
		System.out.println("Highest value is: " + highest);
		System.out.println("Lowest value is: " + lowest);

	}

}
