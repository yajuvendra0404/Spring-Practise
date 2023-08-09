package HeapOps;

public class HeapOps {

	/*
	 * Root element is a '0' zero
	 * Left child of i-th node is at (2*i + 1)th index.
	 * Right child of i-th node is at (2*i + 2)th index.
	 * Parent of i-th node is at (i-1)/2 index.
	 */
	private static int[] array = {30,40,10,90,20,50,80,60};
	
	public static void createMaxHeap() {
		for(int i= HeapOps.array.length/2 -1 ; i >= 0; i--) {
			
			int largestElementIndex = i ;
			int leftElementIndex = i*2+1;
			int rightElementIndex = i*2+2;
			
			System.out.println("\n ----------------- ");
			System.out.println("\n- largestElementIndex - "+ largestElementIndex);
			System.out.println("- leftElementIndex - "+ leftElementIndex);
			System.out.println("- rightElementIndex - "+ rightElementIndex);

			if( HeapOps.array[largestElementIndex] <  HeapOps.array[leftElementIndex] ) {
				largestElementIndex = leftElementIndex;
			}
			if( HeapOps.array[largestElementIndex] <  HeapOps.array[rightElementIndex] ) {
				largestElementIndex =rightElementIndex;
			}
			
			int temp = HeapOps.array[largestElementIndex];
				HeapOps.array[largestElementIndex] =HeapOps.array[i];
				HeapOps.array[i] = temp;
		
				for(int j=1; j<HeapOps.array.length ; j++) {
					System.out.print( HeapOps.array [j]+ ",");
				}
				System.out.println("\n");
		}
				

	}
	
	public static void createMinHeap() {
		
	}
	
	public static void main(String Args[]) {
		HeapOps.createMaxHeap();
	}
	
}
