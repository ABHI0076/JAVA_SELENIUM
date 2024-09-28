package interview;

public class MissingElement {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6};
		
		int[] arr2 = new int[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			arr2[i]=arr[i];
		}
		
		
		for(int j=0;j<arr.length;j++) {
			for(int k=0;k<arr2.length;k++) {
				if(arr[j]!=arr2[k]) {
					System.out.println(arr[j]);
				}
			}
		}
		
		

	}

}
