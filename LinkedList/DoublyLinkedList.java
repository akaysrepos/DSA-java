package LinkedList;

public class DoublyLinkedList {
	
	public void makeDoublyLL(){
		DoublyLL dll = new DoublyLL();
		dll.createDoublyLL(7);
		System.out.println(dll.head.value);
		dll.insertDLL(5, 0);
		dll.insertDLL(9, 1);
		dll.insertDLL(10, 5);
		dll.display();
	}

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.makeDoublyLL();
	}
	
	public class DoublyNode{
		public int value;
		public DoublyNode next;
		public DoublyNode prev;
	}
	
	public class DoublyLL{
		public DoublyNode head;
		public DoublyNode tail;
		public int size;
		
		public DoublyNode createDoublyLL(int nodeValue){
			head = new DoublyNode();
			DoublyNode node = new DoublyNode();
			node.value = nodeValue;
			node.next = null;
			node.prev = null;
			head = node;
			tail = node;
			size = 1;
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
				System.out.println("Doubly LL does not exists");
			}else if(location==0){
				head = head.next;
				head.prev = null;
				size--;
				if(size==0){
					head = null;
					tail = null;
					return;
				}
				
			}else if(location>=size){
				DoublyNode temp = head;
				for(int i = 0; i<size-1;i++){
					temp = temp.next;
				}
				temp.next.prev = null;
				temp.next = null;
				size--;
			}else{
				DoublyNode temp = head;
				for(int i = 0;i<location-1;i++){
					temp = temp.next;
				}
				temp.next = temp.next.next;
				temp.next.prev = temp;
				size--;
			}
		}
		
		public void insertDLL(int nodeValue, int location){
			DoublyNode node = new DoublyNode();
			node.value = nodeValue;
			if(head==null){
				this.createDoublyLL(nodeValue);
				return;
			}
			else if(location==0){
				node.prev = null;
				node.next = head;
				tail = head;
				head = node;
				
			}else if(location>size){
				node.prev = tail;
				node.next = null;
				tail.next = node;
				tail = node;
				
			}else{
				DoublyNode temp = head;
				int index =0;
				while(index<location-1){
					temp = temp.next;
					index++;
				}
				node.prev = temp;
				node.next = temp.next;
				temp.next = node;
				node.next.prev = node;
				
			}
			size++;
		}
	}

}
