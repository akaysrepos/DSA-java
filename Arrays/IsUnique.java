package Arrays;

import java.util.HashMap;

public class IsUnique {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,50};
		IsUniqueOrNot(arr);
	}
	
	static void IsUniqueOrNot(int[] arr){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i = 0; i<arr.length;i++){
			if(!hm.containsKey(arr[i])){
				hm.put(arr[i], i);
			}
			else{
				System.out.println("Not Unique!");
				return;
			}
		}
		
		System.out.println("Unique!");
		
	}

}
