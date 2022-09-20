package Leets;

public class FizzBuzz_412 {

	public static void main(String[] args) {
		String[] arr = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
		fizzBuzz(arr);
		for(String s : arr){
			System.out.println(s);
		}
	}
	
	public static void fizzBuzz(String[] arr){
		for(int i = 0; i<arr.length;i++){
			if(Integer.parseInt(arr[i])%3==0 && Integer.parseInt(arr[i])%5==0){
				arr[i] = "FizzBuzz";
			}else if(Integer.parseInt(arr[i])%5==0){
				arr[i] = "Buzz";
			}else if(Integer.parseInt(arr[i])%3==0){
				arr[i] = "Fizz";
			}
		}
	}

}
