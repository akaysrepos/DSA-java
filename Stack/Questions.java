package Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Questions {

	public void implement(){
//		ThreeInOne tio = new ThreeInOne(3);
//		tio.push(0, 1);
//		tio.push(1, 4);
//		tio.push(2, 7);
//		System.out.println(tio.peek(0));
//		System.out.println(tio.peek(1));
//		System.out.println(tio.peek(2));
//		tio.push(0, 2);
//		tio.push(1, 5);
//		tio.push(2, 8);
//		System.out.println(tio.peek(0));
//		System.out.println(tio.peek(1));
//		System.out.println(tio.peek(2));
//		tio.push(0, 3);
//		tio.push(1, 6);
//		tio.push(2, 9);
//		System.out.println(tio.peek(0));
//		System.out.println(tio.peek(1));
//		System.out.println(tio.peek(2));
//		System.out.println(tio.pop(0));
//		System.out.println(tio.pop(1));
//		System.out.println(tio.pop(2));
//		System.out.println(tio.peek(0));
//		System.out.println(tio.peek(1));
//		System.out.println(tio.peek(2));
		
//		MinStack m = new MinStack();
//		m.push(3);
//		System.out.println(m.minimum());
//		m.push(2);
//		System.out.println(m.minimum());
//		m.push(1);
//		System.out.println(m.minimum());
//		m.pop();
//		System.out.println(m.minimum());
		
		SetOfStacks sos = new SetOfStacks(3);
		sos.push(1);
		sos.push(2);
		sos.push(3);
		sos.push(4);
		SetOfStacks.Stack s1 = sos.getLastStack();
		System.out.println(sos.pop());
		SetOfStacks.Stack s2 = sos.getLastStack();
		System.out.println(s1==s2);
		System.out.println(sos.pop());
		SetOfStacks.Stack s3 = sos.getLastStack();
		System.out.println(s2==s3);
		System.out.println(sos.pop());
		SetOfStacks.Stack s4 = sos.getLastStack();
		System.out.println(s4==s3);
		
	}
	public static void main(String[] args) {
		Questions q = new Questions();
		q.implement();
	}
	
	//Question 1: Three in One
	//implement three stacks with a single array
	public class ThreeInOne{
		private int numberOfStacks=3;
		private int stackCapacity;
		private int[] sizes;
		private int[] values;
		
		public ThreeInOne(int size){
			stackCapacity=size;
			values = new int[stackCapacity*numberOfStacks];
			sizes = new int[numberOfStacks];
		}
		
		public boolean isFull(int stackNum){
			if(sizes[stackNum]==stackCapacity){
				return true;
			}else{
				return false;
			}
		}
		
		public boolean isEmpty(int stackNum){
			if(sizes[stackNum]==0){
				return true;
			}else{
				return false;
			}
		}
		
		private int topOfStack(int stackNum){
			int offset = stackNum * stackCapacity;
			int size = sizes[stackNum];
			return offset + size -1;
		}
		
		public void push(int stackNum, int value){
			if(isFull(stackNum)){
				System.out.println("The Stack is Full!");
			}else{
				sizes[stackNum]++;
				values[topOfStack(stackNum)]=value;
			}
		}
		
		public int pop(int stackNum){
			if(isEmpty(stackNum)){
				System.out.println("The Stack is Empty!");
				return -1;
			}else{
				int pop = values[topOfStack(stackNum)];
				values[topOfStack(stackNum)]=0;
				sizes[stackNum]--;
				return pop;
			}
		}
		
		public int peek(int stackNum){
			if(isEmpty(stackNum)){
				System.out.println("The Stack is Empty!");
				return -1;
			}else{
				return values[topOfStack(stackNum)];
			}
		}
	}

	//Question 2:Minimum in Stack
	//return the minimum value in the stack
	public class MinStack{
		private int min;
		private int secMin;
		private Node head;
		public class Node{
			private int value;
			private Node next;
		}
		
		public boolean isEmpty(){
			if(head==null){
				return true;
			}else{
				return false;
			}
		}
		
		public void push(int nodeValue){
			Node node = new Node();
			node.value = nodeValue;
			if(isEmpty()){
				head = node;
				
				min =  nodeValue;
			}else{
				if(nodeValue<min){
					secMin = min;
					min = nodeValue;
				}
				node.next = head;
				head = node;
			}
		}
		
		public int pop(){
			if(isEmpty()){
				System.out.println("The Stack is Empty!");
				return -1;
			}else{
				int result = head.value;
				head = head.next;
				if(result==min){
					min = secMin;
				}
				return result;
			}
		}
		
		public int peek(){
			if(isEmpty()){
				System.out.println("The Stack is Empty!");
				return -1;
			}else{
				return head.value;
			}
		}
		
		public int minimum(){
			return min;
		}
	}
	
	//Question 3:Set of Stacks
	//implement a new Stack if crossed capacity and treat the set as a single Stack
	public class SetOfStacks{
		public ArrayList<Stack> stacks = new ArrayList<Stack>();
		public int capacity;
		
		public SetOfStacks(int capacity){
			this.capacity = capacity;
		}
		
		public Stack getLastStack(){
			if(stacks.size()==0){
				return null;
			}else{
				return stacks.get(stacks.size()-1);
			}
		}
		
		public void push(int v){
			Stack last = getLastStack();
			if(last!=null && !last.isFull()){
				last.push(v);
			}else{
				Stack stack = new Stack(capacity);
				stack.push(v);
				stacks.add(stack);
			}
		}
		
		public int pop(){
			Stack last = getLastStack();
			if(last == null) throw new EmptyStackException();
			int result = last.pop();
			stacks.remove(stacks.size() - 1);
			return result;
		}
		
		
		public class Stack{
			public int capacity;
			public StackNode top;
			public StackNode bottom;
			public int size =0;
			
			public Stack(int capacity){
				this.capacity = capacity;
			}
			
			public class StackNode{
				public int value;
				public StackNode above;
				public StackNode below;
				
				public StackNode(int value){
					this.value = value;
				}
			}
			
			public boolean isFull(){
				return capacity == size;
			}
			
			public void join(StackNode above, StackNode below){
				if(below!=null) below.above = above;
				if(above!=null) above.below = below;
			}
			
			public boolean push(int v){
				if(size>=capacity){
					return false;
				}else{
					size++;
					StackNode newNode = new StackNode(v);
					if(size==1) bottom = newNode;
					join(newNode, top);
					top = newNode;
					return true;
				}
			}
			
			public int pop(){
				if(top==null) throw new EmptyStackException();
				int result = top.value;
				top = top.below;
				size--;
				return result;
			}
		}
	}
}
	
