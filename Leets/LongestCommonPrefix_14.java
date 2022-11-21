package Leets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LongestCommonPrefix_14 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strings = new ArrayList<String>();
		System.out.println("Enter Strings");
		String s = bf.readLine();
		while(!s.equals("0")){
			strings.add(s);
			s = bf.readLine();
		}
		String prefix = "";
		if(!strings.isEmpty()){
			prefix = strings.get(0);
			prefix = findLCP(strings, 0, prefix);
		}
		
		System.out.println(prefix);
	}
	
	public static String findLCP(ArrayList<String> strings, int index, String prefix){
		if(index>=strings.size()){
			return prefix;
		}
		if(prefix==""||strings.get(index)==""){
			return "";
		}
		if(strings.get(index).length()>prefix.length()){
			int i = 0;
			for(char c : prefix.toCharArray()){
				if(c==strings.get(index).charAt(i)){
					i++;
				}
			}
			prefix = findLCP(strings, index+1, prefix.substring(0, i));
			
		}else{
			int i = 0;
			for(char c : strings.get(index).toCharArray()){
				if(c==prefix.charAt(i)){
					i++;
				}
			}
			prefix = findLCP(strings, index+1, prefix.substring(0, i));
		}
		return prefix;
	}

}
