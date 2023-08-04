package MergeSort;

import java.util.Arrays;

public class MergeSort {

	static int[] array = {11,4,7,9,3,1,2,5,6}; 
	
	public static void sort(int low, int high) {
		
		if(low < high) { 
			int mid  = ( low + high )/ 2;
//			System.out.println("mid - "+ mid);
//			System.out.println("low - "+ low);
//			System.out.println("high - "+ high);
			MergeSort.sort(low, mid);
			MergeSort.sort(mid+1, high);

			MergeSort.merge(low, mid, high);
		}
	}
	
	
	public static void merge(int low, int mid, int high) {
		int[] listA= Arrays.copyOfRange(array, low, mid+1);
		int[] listB= Arrays.copyOfRange(array, mid+1, high+1);

		
		int i=0,j=0,k=low;
		

		while (i < listA.length && j < listB.length) {
			if(listA[i] < listB[j]) {
				MergeSort.array[k] = listA[i];
				i++;
			} else {
				MergeSort.array[k] = listB[j];
				j++;
			}
			k++;
		}
		

			for(  ; j<listB.length; j++) {
				MergeSort.array[k] = listB[j];
				k++;
			}
			for(  ; i<listA.length; i++) {
				MergeSort.array[k] = listA[i];
				k++;
			}

	}



	
	public static void main(String[] args) {
		MergeSort.sort(0, MergeSort.array.length-1);
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]+ " , ");
		}
	}

}
