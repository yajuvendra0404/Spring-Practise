package BubbleSort;

public class BubbleSort {

	public static void main (String a[]) {
		
		
		/* 
		 * In case of bubble sort if there are 6 elements there will be 5 comparisons
		 * if there are "n" elements, then  at most there will be (n-1) in bubble sort.
		 */
		
		/*
		 * If there are "n" elements then there will be "n-1" comparisons in case of bubble sort. 
		 */
		
		int array[] = {8,3,6,7,9,1};
		
		for(int i = 0; i < array.length-1; i++) { 
			// This for loop is for passes which is (array.length-1)

			for( int j=0; j< array.length-1-i;j++) {
				// This for loop is for comparisons.
				
				/* ""array.length-1-i"" ... here reason for subtracting "i". 
				 * as we go along sorting the number, the number of elements 
				 * which need to be sorted will be decreased with each pass.
				 */
			
				if(array[j] > array[j+1]) {
					// Swapping logic
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			
				
			}
			
		}
		for(int x = 0; x < array.length; x++) { 
			System.out.print(array[x]);
		}
		
	}
	

}
