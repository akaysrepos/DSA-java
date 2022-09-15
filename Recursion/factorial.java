package Recursion;

import java.io.*;

public class factorial {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter a number");
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num  = Integer.parseInt(bf.readLine());
		int fact = factorialOf(num);
		System.out.println(fact);
		
	}
	
	static int factorialOf(int n){
		if(n==0){
			return 1;
		}
		else if(n<0){
			return -1;
		}
		return n*factorialOf(n-1);
	}

}
