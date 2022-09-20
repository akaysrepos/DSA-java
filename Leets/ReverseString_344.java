package Leets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString_344 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		reverse(str, 0);
	}
	
	public static void reverse(String s, int index){
		if(index>=s.length()/2){
			return;
		}
		System.out.print(s.charAt(s.length()-1-index));
		reverse(s, index+1);
		System.out.print(s.charAt(index));
		
	}

}
