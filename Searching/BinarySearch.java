package Searching;

public class BinarySearch {

	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		int value = 7;
		System.out.println(searchIteratively(arr, value));
		System.out.println(searchRecursively(arr, value, 0, arr.length-1));
	}
	
	public static int searchIteratively(int[] arr, int value){
		int start = 0;
		int end = arr.length-1;
		int middle = (start+end)/2;
		while(arr[middle]!=value && start<=end){
			if(value>arr[middle]){
				start=middle+1;
			}else{
				end=middle-1;
			}
			middle= (start+end)/2;
		}
		if(arr[middle]!=value){
			return -1;
		}
		return middle;
	}
	
	public static int searchRecursively(int[] arr ,int value, int start, int end){
		int middle = (start+end)/2;
		if(value>arr[middle] && start<=end){
			middle = searchRecursively(arr, value, middle+1, end);
		}else if(value<arr[middle] && start<=end){
			middle = searchRecursively(arr, value, start, middle-1);
		}else if(start>end){
			return -1;
		}
		return middle;
	}

}
