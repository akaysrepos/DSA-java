package Experiments;

public class ExpCall {
	
	String what;
	
	public ExpCall(String what){
		this.what = what;
	}
	
	public void CallByReference(String what){
		what = "Reference"; //local variable is only changed
	}
	
	public void CallByValue(ExpCall e){
		e.what = "Value"; // Change here reflects in the change in the object passed
	}
	

	public static void main(String[] args) {
		ExpCall exp = new ExpCall("VALUE");
		exp.CallByReference("Reference");
		System.out.println(exp.what);
		exp.CallByValue(exp);// Passed Object
		System.out.println(exp.what); // change reflects in our object as well as if it were a pointer passed
	}
	

}
