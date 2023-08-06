package InsertionSort;

public class InsertionSort {

	static int array[] = {2,8,1,3,7,9,4};
	
	public static void sort() {
		
		for(int i=1 ; i<InsertionSort.array.length; i++ ) { /* This loop runs the passes. */
			
			int j = i-1;
			int x = i;
			
			/*Logic for comparing and shifting*/
			while (j > -1 && InsertionSort.array[j] > InsertionSort.array[x]) {
				
				int temp = InsertionSort.array[j];
				InsertionSort.array[j]= InsertionSort.array[x];
				InsertionSort.array[x] = temp;

				x--;
				j--;
				
			}

		}
		
	}
	
	public static void main (String a[]) {
		InsertionSort.sort();
		for(int u=0;u<InsertionSort.array.length; u++) {
			System.out.println(array[u]);
		}
	}
}
