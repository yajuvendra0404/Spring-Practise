package HeapOps;

import java.util.Arrays;

public class HeapDeletion {
	/*
	 * if you are using '0' as first index
	 * Root element is a '0' zero
	 * Left child of i-th node is at (2*i + 1)th index.
	 * Right child of i-th node is at (2*i + 2)th index.
	 * Parent of i-th node is at (i-1)/2 index.
	 */
	private static int[] array = {90,60,80,40,20,10,50,30};
	
	public static void heapDeletion () {
		
		int arrLength = HeapDeletion.array.length;		
		/*
		 * Swaps the first element with the last element in the Array.
		 */
		int temp =  HeapDeletion.array[0];
			 HeapDeletion.array[0] =  HeapDeletion.array[arrLength - 1];
			 HeapDeletion.array[arrLength - 1] = temp;
			/*
			 * Removes the Last element from the array.
			 */ 
			 HeapDeletion.array = Arrays.copyOf(array, arrLength-1);
			 arrLength = HeapDeletion.array.length;
					 
		int i = 0;
		while ( i < arrLength-1 ) {
			
			int leftChild = 2*i+1; 
			int rightChild = 2*i+2;
			
			if( HeapDeletion.array[i] > HeapDeletion.array[ leftChild ] && 
				HeapDeletion.array[i] > HeapDeletion.array[ rightChild ] ) break;
			
			/* terminates the loop when no child is bigger than the non-leaf node 
			 * or when it reaches the end of the Array length. */
			
			if(HeapDeletion.array[ leftChild ] >  HeapDeletion.array[ rightChild ]) {
				temp = HeapDeletion.array[ leftChild ];
				HeapDeletion.array[ leftChild ] = HeapDeletion.array[ i ];
				HeapDeletion.array[ i ] = temp;
				
				i = leftChild;
			} else {
				temp = HeapDeletion.array[ rightChild ];
				HeapDeletion.array[ rightChild ] = HeapDeletion.array[ i ];
				HeapDeletion.array[ i ] = temp;
				
				i = rightChild;
			}
			
		} 
		
		for(int j=0; j< arrLength; j++) {
			System.out.print("-"+ HeapDeletion.array[j]);
		}
		
		
	}
	public static void main (String a []) {
		HeapDeletion.heapDeletion();
		
	}
}
