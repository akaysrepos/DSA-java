package Leets;

public class Pow_50 {

	public static void main(String[] args) {
		System.out.println(pow(4, 4));
	}
	
	public static int pow(int x, int n){
		if(n==1){
			return x;
		}
		if(n%2==0){ // this part breaks the calculation into
			x *=x;  // 4^4 into 16^2
			n /=2;
			return pow(x, n);
		}else{		// if the exponent isn't even it breaks it like
			return x*pow(x, n-1); // 4^3 -> 4*(4^2)
		}
	}

}
