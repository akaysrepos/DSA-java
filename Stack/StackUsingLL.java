package Stack;

public class StackUsingLL {

	public void implement(){
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		int pop = stack.pop();
		System.out.println(pop);
		int peek = stack.peek();
		System.out.println(peek);
		stack.delete();
	}
	
	public static void main(String[] args) {
		StackUsingLL sll = new StackUsingLL();
		sll.implement();
	}
	
	public class Stack{
		LinkedList ll;
		
		public Stack(){
			ll = new LinkedList();
		}
		
		//push
		public void push(int value){
			ll.insertNodeInLL(value, 0);
		}
		
		public boolean isEmpty(){
			if(ll.head==null){
				return true;
			}else{
				return false;
			}
		}
		
		//pop
		public int pop(){
			int result = -1;
			if(isEmpty()){
				System.out.println("The Stack is Empty!");
			}else{
				result = ll.head.value;
				ll.delete(0);
			}
			return result;
		}
		
		//peek
		public int peek(){
			if(isEmpty()){
				System.out.println("The Stack is Empty!");
				return -1;
			}else{
				return ll.head.value;
			}
		}
		
		//delete
		public void delete(){
			ll.head = null;
			System.out.println("The Stack is deleted!");
		}
	}
	
	public class Node{
		public int value;
		public Node next;
	}
	
	public class LinkedList{
		
		public Node head;
		public Node tail;
		public int size;
		
		public Node createSinglyLinkedList(int nodeValue){
			head = new Node();
			Node node = new Node();
			node.next = null;
			node.value = nodeValue;
			head = node;
			tail = node;
			size = 1;
			return head;
			
		}
		
		public void display(){
			Node temp = head;
			int index = 0;
			while(index<size){
				System.out.println(temp.value);
				temp = temp.next;
				index++;
			}
		}
		
		public void delete(int location){
			if(head==null)return;
			Node temp = head;
			if(location==0){
				head = head.next;
				size--;
			}
			int index =0;
			if(location>=size){
				while(index<size-1){
					temp = temp.next;
					index++;
				}
				temp.next = null;
				tail = temp;
				size--;
			}
			else{
				index=0;
				temp = head;
				while(index<location-1){
					temp = temp.next;
					index++;
				}
				Node node = temp.next;
				temp.next = node.next;
				size--;
				}
		}
		
		public void insertNodeInLL(int nodeValue, int location){
			Node node = new Node();
			node.next = null;
			node.value = nodeValue;
			
			if(head==null){
				createSinglyLinkedList(nodeValue);
				return;
			}else if(location==0){
				node.next = head;
				head = node;
				//tail still points to previous head so tail=head; is redundant
				
			}else if(location>=size){
				node.next = null;
				tail.next = node;
				tail = node;
			}else{
				Node temp = head;
				int index=0;
				while(index<location-1){
					temp = temp.next;
					index++;
				}
				Node nextNode = temp.next;
				node.next = nextNode;
				temp.next = node;
			}
			size++;
		}
	}


}
