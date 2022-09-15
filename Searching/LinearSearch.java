package Searching;

public class LinearSearch {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		int value = 3;
		search(arr, value);
	}
	
	public static int search(int[] arr, int value){
		int index=-1;
		for(int i =0;i<arr.length-1;i++){
			if(arr[i]==value){
				index=i;
				System.out.println("Found at "+ i);
				break;
			}
		}
		if(index==-1){
			System.out.println("Not Found!");
		}
		return index;
	}

}
