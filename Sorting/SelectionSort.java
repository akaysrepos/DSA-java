package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int minimumIndex = i;
			for(int j=i+1;j<arr.length; j++){
				if(arr[j]<arr[minimumIndex]){
					minimumIndex = j;
				}
			}
			if(minimumIndex!=i){
				int temp = arr[minimumIndex];
				arr[minimumIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}

}
