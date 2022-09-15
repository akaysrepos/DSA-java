package Arrays;

import java.util.HashMap;

public class TwoSum {
	
	//According to the problem
	//We're given an array of integers, and a sum value
	//And there exists exactly one solution for a pair of values
	//in the array summing up to that sum value
	//I'll try to write it for as many pairs as there can be
	
	public static void main(String[] args){
		int[] array = {9,8,5,6,7,2,1,10};
		int sum = 10;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		System.out.println("Solutions:");
		for(int i =0;i<array.length; i++){
			if(!hm.containsKey(sum-array[i])){
				hm.put(array[i], i);
			}
			else{
				System.out.println("("+hm.get(sum-array[i])+", "+i+")");
			}
		}
	}
}
