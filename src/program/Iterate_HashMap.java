package program;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

public class Iterate_HashMap {
	
	@Test(enabled=true, groups= {"JavaTests"})
	public void iterateMap() {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("India", 2);
		hm.put("France", 4);
		hm.put("UK", 1);
		hm.put("Germany", 3);
		
		//Method 1
		for(String str : hm.keySet()) {
			System.out.println(str+":"+hm.get(str));
		}
		//Method 2
		for(Entry<String, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
