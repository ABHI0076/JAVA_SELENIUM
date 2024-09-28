package program;

import java.util.Arrays;

import org.testng.annotations.Test;

public class Sorting_Array {
	
	@Test(enabled=true,groups= {"JavaTests"})
	public void sortArray() {
		
		//Sort array in ascending order
		int[] intArray = {21,11,10,30,20,25,15,85, 20, 15};
		for(int i=0;i<intArray.length;i++) {
			for(int j=i+1;j<intArray.length;j++) {
				if(intArray[i]>intArray[j]) {
					int temp = intArray[i];
					intArray[i]=intArray[j];
					intArray[j]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(intArray));
		
		for(int i : intArray) {
			System.out.print(i+" ");
		}
		
	}

}
