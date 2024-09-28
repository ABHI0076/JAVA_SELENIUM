package program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class Count_NumberOfCharacter_In_String {

	@Test(enabled = true, groups= {"JavaTests"})
	public void countChar() {

		String str = "My name is Abhishek Anand";
		char[] charArr = str.toLowerCase().toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character ch : charArr) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		for (Character ch : map.keySet()) {
			System.out.println(ch + " " + map.get(ch));
		}

	}

}
