package HeapOps;

import java.util.Arrays;

public class HeapInsertion {

	
	/*
	 * Root element is a '0' zero
	 * Left child of i-th node is at (2*i + 1)th index.
	 * Right child of i-th node is at (2*i + 2)th index.
	 * Parent of i-th node is at (i-1)/2 index.
	 */
	private static int[] array = {90,60,80,40,20,10,50,30};
	private static int num = 70;
	
	
	public static void heapInsertion() {
		HeapInsertion.array = Arrays.copyOf(HeapInsertion.array, HeapInsertion.array.length+1);
	
		int i = HeapInsertion.array.length-1; // increase the length of Array.
		HeapInsertion.array[i] = num;
		
		

		
		while( i > 0) {
			
			int parent = (i-1)/2;
			
			if(HeapInsertion.array[parent] < num) {
				int temp = HeapInsertion.array[parent];
				HeapInsertion.array[parent] = HeapInsertion.array[i];
				HeapInsertion.array[i] = temp;
				
				i = parent;
			} else { 
				/* If parent node is greater then you don't 
				 * need to swap the values in case of Max-heap*/
				break;
			}
		}
			

		System.out.println("\n\n\n");
		
		for (int x = 0 ; x < HeapInsertion.array.length ; x++) {
			System.out.println("-----"+ HeapInsertion.array[x]);
		}
	}
	
	public static void main(String a[]) {	
		HeapInsertion.heapInsertion();
	}
	
	
	
}
