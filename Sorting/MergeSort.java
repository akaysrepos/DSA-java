package Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {1,5,6,7,4,2};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void merge(int[] a, int left, int mid, int right){
		int[] leftTemp = new int[mid-left+2];
		int[] rightTemp = new int[right-mid+1];
		for(int i = 0;i<=mid-left;i++){
			leftTemp[i] = a[left+i];
		}
		for(int i = 0;i<right-mid;i++){
			rightTemp[i] = a[mid+1+i];
		}
		
		leftTemp[mid-left+1] = Integer.MAX_VALUE;
		rightTemp[right-mid] = Integer.MAX_VALUE;
		
		int i = 0, j=0;
		for(int k= left; k<=right; k++){
			if(leftTemp[i]<rightTemp[j]){
				a[k] = leftTemp[i];
				i++;
			}else{
				a[k] = rightTemp[j];
				j++;
			}
		}
	}
	
	public static void sort(int[] a,int left, int right ){
		if(right>left){
			int m = (left+right)/2;
			sort(a, left, m);
			sort(a, m+1, right);
			merge(a, left, m, right);
		}
	}

}
