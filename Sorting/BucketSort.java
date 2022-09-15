package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	@SuppressWarnings("unchecked")
	public static void sort(int[] arr){
		int numberOfBuckets = (int) Math.ceil( Math.sqrt(arr.length));
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<arr.length;i++){
			if(max>arr[i]){
				max = arr[i]; // we take the max value
			}
		}
		ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
		for(int i = 0; i<buckets.length; i++){
			buckets[i] = new ArrayList<Integer>(); // Array of buckets
		}
		
		for(int value: arr){
			int bucketNumber = (int) Math.ceil(((float) value*numberOfBuckets)/(float)max);
			if(bucketNumber==0){
				buckets[bucketNumber].add(value); // add the values to buckets
			}
			else{
				buckets[bucketNumber-1].add(value);
			}
		}
		
		for(ArrayList<Integer> bucket: buckets){
			Collections.sort(bucket); // sort the buckets individually
		}
		
		for(int i = 0;i<buckets.length; i++){
			for(int j = 0;j<buckets[i].size(); j++){
				arr[i+j] = buckets[i].get(j); // change the array elements
			}
		}
	}

}
