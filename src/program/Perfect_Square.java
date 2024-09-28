package program;

import org.testng.annotations.Test;

public class Perfect_Square {

	@Test(enabled = true, groups = { "JavaTests" })
	public void perfectSquare() {

		// Find the element which are perfect Square from Array
		int[] intArray = { 21, 11, 10, 16, 20, 25, 15, 85, 4, 225, 400};
		for (int i = 0; i < intArray.length; i++) {

			int ele = (int) Math.sqrt(intArray[i]);
			
			if(ele*ele==intArray[i]) {
				
				System.out.println(intArray[i] + " is a perfect Square.");
				
			}

			

		}

	}

}
