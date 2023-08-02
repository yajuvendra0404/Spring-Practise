package QuickSort;

public class QuickSort {

	static int [] array = {5,6,1,2,9,8,11,7,3};

	private static int partition(int low, int high) { //  returns one new partition 

		int pivot = array[low];
		int pivotIndex = low;
		while (low < high) {
			
			do {
//				System.out.println("low ++");
				low++;
			} while (QuickSort.array[low] <= pivot);
			
			do {
//				System.out.println("high --");
				high--;
			} while (QuickSort.array[high] > pivot);
			
			
			if(low < high) {
//				System.out.println("partition swapping the numbers --");
				int temp = QuickSort.array[low];
				QuickSort.array[low] = QuickSort.array[high];
				QuickSort.array[high] = temp;
				
				
				for(int i = 0; i< array.length; i++) {
					System.out.println(array[i]);
				}
				System.out.println("--- go --- ");
			}

		}
		
		QuickSort.array[pivotIndex] = QuickSort.array[high];
		QuickSort.array[high] = pivot;

		
		int sortedElementLocation =  high;
		
		return sortedElementLocation;
	} 
	
	private static void sort(int low, int high) {
		
		if(low < high) {
			int sortedElementLocation = QuickSort.partition(low, high);
			QuickSort.sort(low, sortedElementLocation);
			QuickSort.sort(sortedElementLocation+1, high);
		} 
		
	} 
	
	public static void main (String a[] ) {
		QuickSort.sort(0,array.length);
	}
	
}
