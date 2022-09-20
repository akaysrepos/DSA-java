package Leets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeNumber_9 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String num = bf.readLine();
		checkValidNumber(num);
	}
	
	public static void checkValidNumber(String num){
		if((""+Integer.parseInt(num)).equals(num)){
			checkPalindrome(num);
		}else{
			System.out.println("Psych! That's a wrong number!");
		}
	}
	
	public static void checkPalindrome(String num){
		for(int i = 0; i<num.length()/2; i++){
			if(num.charAt(i)!=num.charAt(num.length()-1-i)){
				System.out.println("Not a Palindrome!");
				return;
			}
		}
		System.out.println("It's a Palindrome!");
	}
	

}
