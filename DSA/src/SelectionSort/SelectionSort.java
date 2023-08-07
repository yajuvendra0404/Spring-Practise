package SelectionSort;

public class SelectionSort {

	
	static int[] array= {4,2,5,8,1,9,3,7};
	
	public static void sort () {
		for(int i=0 ; i < SelectionSort.array.length; i++) {
			
			int  k = i; /* pointing the smallest element in the array */
			
			for (int j=i; j < SelectionSort.array.length; j++) {
				if(SelectionSort.array[j] < SelectionSort.array[k] ) {
					 k = j; /*  when find another smaller element assign its index
					 		    to the index of previous small element */
				}
			}
			
			int temp = SelectionSort.array[k];
			SelectionSort.array[k] = SelectionSort.array[i];
			SelectionSort.array[i] = temp;
		}
	}
	
	public static void main( String a[] ) {
		
		SelectionSort.sort();
		
		for(int c = 0; c < SelectionSort.array.length ; c++) {
			System.out.println(SelectionSort.array[c]);
		}
	}
}
