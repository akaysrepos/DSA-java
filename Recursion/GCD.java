package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCD {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter 2 numbers to find GCD");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int num2 = Integer.parseInt(bf.readLine());
		
		System.out.println(gcd(num, num2));

	}
	
	static int gcd(int a, int b){
		if(b==0){
			return a;
		}
		return gcd(b, a%b);
	}

}
