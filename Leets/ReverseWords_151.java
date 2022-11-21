package Leets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWords_151 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		reverse(s, s.length()-1);
	}
	
	public static void reverse(String s, int index){
		if(index<0){
			return;
		}
		int i = index;
		while(s.charAt(i)!= ' ' && i>0){ // stops at the index of space
			i--;
			
		}
		if(i>0){ // starting index will be after the _space_ so i+1 and end_index is element number not index
			System.out.print(s.substring(i+1, index+1));
			System.out.print(" ");
		}else{ // if the pointer reaches the start of first word
			System.out.print(s.substring(i, index+1));
		}
		
		reverse(s, i-1);
	}

}
