package Experiments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpFreq {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine();
		char[] c = s.toCharArray();
		int[] arr = new int[10];
		System.out.println();
		for(char a: c){
			if((int) a >= 48 && (int) a < 58){
				arr[Integer.parseInt(""+a)]++;
			}
		}
		for(int i = 0;i<arr.length; i++){
			System.out.println("Freq. of "+i+" is "+arr[i]);
		}
	}

}
