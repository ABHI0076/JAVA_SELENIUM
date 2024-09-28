package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class String_Program {

	@Test(enabled = true, groups = { "JavaTests" })
	public void stringProgram() {

		// WAP to segregate the digits of string into two different List.
		// List1 : 0-5
		// List2 : 6-10

		String str = "232043874834578435";

		List<Integer> lst1 = new ArrayList<Integer>();
		List<Integer> lst2 = new ArrayList<Integer>();

		// Method 1:

		for (int i = 0; i < str.length(); i++) {
			if (Integer.parseInt(String.valueOf(str.charAt(i))) <= 5) {
				lst1.add(Integer.parseInt(String.valueOf(str.charAt(i))));
			} else {
				lst2.add(Integer.parseInt(String.valueOf(str.charAt(i))));
			}

		}

		// Method 2:

//		for (int i = 0; i < str.length(); i++) {
//			if (Character.getNumericValue(str.charAt(i)) <= 5) {
//				lst1.add(Character.getNumericValue(str.charAt(i)));
//			} else {
//				lst2.add(Character.getNumericValue(str.charAt(i)));
//			}
//
//		}

		System.out.println(lst1);
		System.out.println(lst2);

	}

}
