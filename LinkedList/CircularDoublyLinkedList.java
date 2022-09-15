package LinkedList;

public class CircularDoublyLinkedList {

	public void makeCDLL(){
		CircularDLL cdll = new CircularDLL();
		cdll.createCDLL(7);
//		cdll.display();
		cdll.insertCDLL(8, 0);
//		cdll.display();
		cdll.insertCDLL(9, 1);
		cdll.display();
		cdll.insertCDLL(5, 5);
		cdll.display();
	}
	public static void main(String[] args) {
		CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
		cdll.makeCDLL();
	}
	
	public class DoublyNode{
		public int value;
		public DoublyNode prev;
		public DoublyNode next;
	}
	
	public class CircularDLL{
		public DoublyNode head;
		public DoublyNode tail;
		public int size;
		
		public DoublyNode createCDLL(int nodeValue){
			DoublyNode node = new DoublyNode();
			node.value = nodeValue;
			head = new DoublyNode();
			node.prev = node;
			node.next = node;
			head = node;
			tail = node;
			size=1;
			return head;
		}
		
		public void display(){
			DoublyNode temp = head;
			int index = 0;
			while(index<size){
				System.out.println(temp.value);
				temp = temp.next;
				index++;
			}
		}
		
		public void delete(int location){
			if(head==null){
				System.out.println("Circular Doubly LL doe not exists");
				return;
			}if(location==0){
				if(size==1){
					head.prev = null;
					head.next = null;
					head = tail = null;
					size--;
				}else{
					head = head.next;
					head.prev = tail;
					tail.next = head;
					size--;
				}
			}else if(location>=size){
				if(size==1){
					head.prev = null;
					head.next = null;
					head = tail = null;
					size--;
				}else{
					tail = tail.prev;
					tail.next = head;
					head.prev = tail;
					size--;
				}
			}else{
				DoublyNode temp = head;
				for(int i= 0; i<location-1;i++){
					temp = temp.next;
				}
				temp.next = temp.next.next;
				temp.next.prev = temp;
				size--;
			}
		}
		
		public void insertCDLL(int nodeValue, int location){
			DoublyNode node = new DoublyNode();
			node.value = nodeValue;
			if(head==null){
				createCDLL(nodeValue);
				return;
			}
			else if(location == 0){
				node.prev = tail;
				node.next = head;
				head.prev = node;
				tail.next = node;
				head = node;
			}
			else if(location>=size){
				node.next = head;
				node.prev = tail;
				head.prev = node;
				tail.next = node;
				tail = node;
				
			}else{
				DoublyNode temp = head;
				for(int i = 0;i<location-1;i++){
					temp = temp.next;
				}
				node.prev = temp;
				node.next = temp.next;
				temp.next = node;
				temp.next.prev = node;
			}
			size++;
		}
	}

}
