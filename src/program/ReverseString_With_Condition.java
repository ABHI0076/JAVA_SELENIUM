package program;

import org.testng.annotations.Test;

public class ReverseString_With_Condition {

	@Test(enabled = true,groups= {"JavaTests"})
	public void reverseString() {
		String str = "Rama 123 Krishna 456 Anand 789 Abhishek";
		String[] strArr = str.split(" ");
		String revString = "";
		for (int i = 0; i < strArr.length; i++) {
			String word = strArr[i];
			String revWord = "";
			if (i % 2 != 0) {
				revWord = word;
			} else {
				for (int j = word.length() - 1; j >= 0; j--) {
					revWord = revWord + word.charAt(j);
				}
			}
			revString = revString + revWord + " ";
		}
		System.out.println(revString);
	}

}
