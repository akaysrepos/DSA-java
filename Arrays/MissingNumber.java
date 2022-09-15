package Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1 to get the missing element in an array\nEnter 2 to get the missing element in two arrays");
		int choice = Integer.parseInt(bf.readLine());
		switch(choice){
		case 1:
			System.out.println("Enter the upper limit of the series");
			int upper = Integer.parseInt(bf.readLine());
			System.out.println("Enter elements of array separated by spaces");
			String s1 = bf.readLine();
			String[] arr1 = s1.split(" ");
			System.out.println(MissingNumberInSeries(upper, arr1));
			break;
		case 2:
			System.out.println("Enter elements of 1st array separated by spaces");
			String s = bf.readLine();
			String[] ar1 = s.split(" ");
			System.out.println("Enter elements of 2nd array separated by spaces");
			String s2 = bf.readLine();
			String[] ar2 = s2.split(" ");
			System.out.println(Compare(ar1, ar2));
			break;
			
		default:
			System.out.println("You have seem to be chosen an invalid option");
		};
		
	}
	
	static int Compare(String[] arr1, String[] arr2){
		int count1 = 0;
		for(int i = 0; i<arr1.length;i++){
			count1+=Integer.parseInt(arr1[i]);
		}
		int count2 = 0;
		for(int j = 0; j<arr2.length;j++){
			count2+=Integer.parseInt(arr2[j]);
		}
		return count1-count2;
	}
	
	static int MissingNumberInSeries(int count, String[] arr){
		int count1 = 0;
		int count2 = count*(count+1)/2;
		for(int i = 0; i<arr.length;i++){
			count1+=Integer.parseInt(arr[i]);
		}
		return count2-count1;
	}

}
