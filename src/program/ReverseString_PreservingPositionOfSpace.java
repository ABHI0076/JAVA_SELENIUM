package program;

import org.testng.annotations.Test;

public class ReverseString_PreservingPositionOfSpace {

	@Test(enabled = true, groups= {"JavaTests"})
	public void rev_String() {
		String str = "My Name is Khan but I am not a terrorist.";
		char[] strArr = str.toCharArray();
		char[] strArrNew = new char[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == ' ') {
				strArrNew[i] = ' ';
			}
		}
		int lastIndex = strArrNew.length - 1;
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] != ' ') {
				if (strArrNew[lastIndex] == ' ') {
					lastIndex--;
				}
				strArrNew[lastIndex] = strArr[i];
				lastIndex--;
			}
		}
		System.out.println(strArr);
		System.out.println(strArrNew);
		
		System.out.println(String.valueOf(strArr));
		System.out.println(String.valueOf(strArrNew));
	}

}
