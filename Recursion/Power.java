package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter a number");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int exp = Integer.parseInt(bf.readLine());
		
		System.out.println(power(num, exp));
	}
	
	static int power(int n, int exp){
		if(exp==0||exp==1){
			return 1;
		}
		else if(n<0){
			return -1;
		}
		return n*power(n, exp-1);
	}

}
