package Experiments;

import java.io.*;
import java.util.HashMap;

public class ExpTCS {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String a = bf.readLine();
		String b = bf.readLine();
		
		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c1:bb){
			map.put(c1, 1);
		}
		for(char a1: aa){
			if(!map.containsKey(a1)){
				System.out.print(a1);
			}
		}
	}

}
