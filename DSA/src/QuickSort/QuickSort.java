package QuickSort;

public class QuickSort {

	static int [] array = {5,6,1,2,9,8,11,7,3};

	private static int partition(int low, int high) { //  returns one new partition 

		int pivot = array[low];
		int pivotIndex = low;
		
		while (low < high) {
			
			do {

				low++;
			} while (low < array.length && QuickSort.array[low] <= pivot);
			
			do {

				high--;
			} while (QuickSort.array[high] > pivot);
			
			
			if(low < high) {

				int temp = QuickSort.array[low];
				QuickSort.array[low] = QuickSort.array[high];
				QuickSort.array[high] = temp;
				
			}


		}


		QuickSort.array[pivotIndex] = QuickSort.array[high];
		QuickSort.array[high] = pivot;

		
		int sortedElementLocation =  high;
		
		return sortedElementLocation;
	} 
	
	private static void sort(int low, int high) {
		
		if(low < high) {  /* if low is equal to high that means there are only one element*/
			int sortedElementLocation = QuickSort.partition(low, high); 
			
			QuickSort.sort(low, sortedElementLocation);
			QuickSort.sort(sortedElementLocation+1, high);
		} 
		
	} 
	
	public static void main (String a[] ) {
		
		QuickSort.sort(0,array.length);
		
		for(int i = 0; i< array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
}
