package Stack;

public class Stack {

	public int[] arr;
	public int topOfStack;
	
	public Stack(int size){
		this.arr = new int[size];
		this.topOfStack= -1;
		System.out.println("Stack is created of size: "+size+"\n");
	}
	
	public boolean isEmpty(){
		if(this.topOfStack ==-1){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isFull(){
		if(this.topOfStack==this.arr.length-1){
			return true;
		}else{
			return false;
		}
	}
	
	//Push
	public void push(int value)
	{
		if(isFull()){
			System.out.println("Stack is full!");
		}else{
			arr[topOfStack+1]=value;
			topOfStack++;
			System.out.println("The value is pushed into the Stack");
		}
	}
	//pop
	public int pop(){
		if(isEmpty()){
			System.out.println("The Stack is empty");
			return -1;
		}else{
			int top = arr[this.topOfStack];
			this.topOfStack--;
			return top;
		}
	}
	
	//peek
	public int peek(){
		if(isEmpty()){
			System.out.println("The Stack is Empty");
			return -1;
		}else{
			return arr[topOfStack];
		}
	}
	
	//delete
	public void delete(){
		arr = null;
		System.out.println("Stack deleted!");
	}
	
	public static void main(String[] args) {
		Stack newStack = new Stack(5);
		newStack.push(1);
		newStack.push(2);
		newStack.push(3);
		newStack.push(4);
		newStack.push(5);
		newStack.push(5);
		int pop = newStack.pop();
		System.out.println(pop);
		int peek = newStack.peek();
		System.out.println(peek);
		newStack.delete();
		
	}

}
