package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalToBinaryClass {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter a number");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		
		System.out.println(DecimalToBinary(num));

	}
	
	static int DecimalToBinary(int n){
		if(n==0){
			return 0;
		}
		return n%2 + 10*DecimalToBinary(n/2);
	}

}
