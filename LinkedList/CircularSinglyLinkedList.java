package LinkedList;

public class CircularSinglyLinkedList {

	public void makeCircularSLL(){
		CircularSLL csll = new CircularSLL();
		csll.createCircularSLL(5);
		System.out.println(csll.head.value);
		System.out.println(csll.head.next.value);
		csll.insertCSLL(7, 1);
		csll.insertCSLL(17, 5);
		csll.display();
	}
	
	public static void main(String[] args) {
	CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
	csll.makeCircularSLL();

	}
	
	public class Node{
		public int value;
		public Node next;
	}
	
	public class CircularSLL{
		public Node head;
		public Node tail;
		public int size;
		
		public Node createCircularSLL(int nodeValue){
			head = new Node();
			Node node = new Node();
			node.value = nodeValue;
			node.next = node; //CircularSLL Node points to itself, in SLL it points to null
			head = node;
			tail = node;
			size=1;
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
			if(head==null){
				System.out.println("Circular LL does not exists!");
			}else if(location==0){
				head = head.next;
				tail.next = head;
				size--;
				if(size==0){
					head=null;
					head.next = null;
					tail=null;
				}
			}else if(location>=size){
				Node temp = head;
				for(int i =0;i<size-1;i++){
					temp = temp.next;
				}
				if(temp==head){
					temp = null;
					head = null;
					tail = null;
					size--;
					return;
				}
				temp.next = head;
				tail = temp;
				size--;
			}else{
				Node temp = head;
				for(int i = 0;i<location-1;i++){
					temp = temp.next;
				}
				temp.next = temp.next.next;
				size--;
			}
		}
		
		public void insertCSLL(int nodeValue, int location){
			Node node = new Node();
			node.value = nodeValue;
			if(head==null){
				this.createCircularSLL(nodeValue);
				return;
			}
			else if(location==0){
				node.next = head;
				head = node;
				tail.next = node;
			}
			else if(location>=size){
				tail.next = node;
				tail = node;
				node.next = head;
			}
			else{
				int index =0;
				Node temp = head;
				while(index<location-1){
					temp = temp.next;
					index++;
				}
				node.next = temp.next;
				temp.next = node;
			}
			size++;
			
		}
	}

}
