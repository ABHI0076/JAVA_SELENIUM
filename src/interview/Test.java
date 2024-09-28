package interview;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		String str = "AAABBCCDDD";
		char[] charArr = str.toCharArray();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(Character ch : charArr) {
			
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1); 
			}
 
		}
		for(Character ch :map.keySet()) {
			System.out.print(ch +""+map.get(ch));
		}

	}

}
