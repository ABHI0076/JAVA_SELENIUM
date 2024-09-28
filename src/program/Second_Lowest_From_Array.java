package program;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Second_Lowest_From_Array {
	
	@Test(enabled=true,groups= {"JavaTests"})
	public void FindsecondLowest() {
		
		//Note: If duplicates are available in the array then remove the duplicate first.
		int[] intArray = { 10, 10,15,30, 100, 20, 25, 15, 85 };
		System.out.println("Actual Array is: "+Arrays.toString(intArray));
		Set<Integer> set = new HashSet<Integer>();
		for(int val : intArray) {
			set.add(val);
		}
		int[] newIntArray = new int[set.size()];
		int k =0;
		for(int val :set) {
			newIntArray[k++]=val;
		}
		System.out.println("After removing duplicate elements: "+Arrays.toString(newIntArray));
		for(int i =0;i<newIntArray.length;i++) {
			for(int j=i+1;j<newIntArray.length;j++) {
				if(newIntArray[i]>newIntArray[j]) {
					int temp = newIntArray[i];
					newIntArray[i]=newIntArray[j];
					newIntArray[j]=temp;
				}
			}
			if(i==1)
				break;
		}
		System.out.println("Second lowest number is: "+newIntArray[1]);
	}

}
