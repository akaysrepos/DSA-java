package Arrays;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		System.out.println(permut(arr1, arr2));
		System.out.println(dumbPermut(arr1, arr2));

	}
	
	static boolean permut(int[] arr1, int[] arr2){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		boolean isPermut = true;
		for(int i : arr1){
			arr.add(i);
		}
		for(int j : arr2){
			if(!arr.contains(j)){
				isPermut=false;
			}
		}
		return isPermut;
	}
	
	static boolean dumbPermut(int[] arr1, int[] arr2){
		int count1 = 0;
		int count2 = 0;
		int mul1 = 1;
		int mul2 = 1;
		
		for(int i = 0;i<arr1.length;i++){
			count1+=arr1[i];
			mul1*=arr1[i];
		}
		for(int j = 0;j<arr2.length;j++){
			count2+=arr2[j];
			mul2*=arr2[j];
		}
		if(count1==count2 && mul1==mul2){
			return true;
		}
		return false;
	}

}
