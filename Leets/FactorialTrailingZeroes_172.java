package Leets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialTrailingZeroes_172 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		findZeroes(num);
	}
	
	public static void findZeroes(int num){
		int count = 0;   // The Trick is
		while(num>0){    // The number of zeroes in a factorial is
			num /=5;     // the number of 5s in its expanded form
			count += num;// i.e. 10-> 2*5  
		}
		System.out.println(count);
	}

}
