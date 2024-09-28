package program;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class FindDuplicates_From_Array {

	@Test(enabled = true, groups = { "JavaTests" })
	public void findDuplicates_UsingSet() {
		int[] arr = { 1, 2, 3, 2, 4, 5, 4, 6 };

		Set<Integer> set = new HashSet<Integer>();

		for (int num : arr) {
			boolean bool = set.add(num);
			if (bool == false) {
				System.out.println(num);
			}
		}

	}

	@Test(enabled = true, groups = { "JavaTests" })
	public void findDuplicates_UsingLoop() {

		int[] arr = { 1, 2, 3, 2, 4, 5, 4, 6 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(arr[i]);
				}
			}
		}

	}
	
	@Test(enabled = true, groups = { "JavaTests" })
	public void findDuplicates_UsingMap() {

		int[] arr = { 1, 2, 3, 2, 4, 5, 4, 6};
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : arr) {
		if(map.containsKey(num)) {
			System.out.println(num);
		}else {
			map.put(num, 1);
		}
		}

	}

}
