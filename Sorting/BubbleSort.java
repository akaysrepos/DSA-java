package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		for(int i = 0; i<arr.length;i++){
			for(int j = 0;j<arr.length;j++){
				if(arr[j]>arr[i]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
