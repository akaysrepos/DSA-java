package Recursion;
import java.io.*;

public class SumOfDigits {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter a number");
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		
		System.out.println(Sum(num));
		
	}
	
	static int Sum(int n){
		if(n==0){
			return 0;
		}
		else if(n<0){
			return -1;
		}
		return n%10 + Sum(n/10);
	}

}
