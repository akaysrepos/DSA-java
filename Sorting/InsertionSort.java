package Sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr){
		for(int i=0; i<arr.length;i++){
			int temp = arr[i], j=i; //temp is the current element
			while(j>0 && arr[j-1]>temp){ //arr[j-1] is the previous element in the Array or last in the sorted part
				arr[j]=arr[j-1]; //we keep moving the elements ahead until we get the index
				j--; //we keep going back till the current element or temp is smaller than the sorted elements
			} // we terminate the loop once we get the right index to fit the element in
			arr[j]=temp; // we set the element at that index
		}
	}

}
