package Sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int partition(int[] arr, int start, int end){
		int pivot = end;
		int i = start - 1;
		for(int j = start; j<=end; j++){
			if(arr[j]<=arr[pivot]){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		return i;
	}
	
	public static void sort(int[] arr, int start, int end){
		if(start<end){
			int pivot = partition(arr, start, end);
			sort(arr, start, pivot-1);
			sort(arr, pivot+1, end);
		}
	}

}
