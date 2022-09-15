package LinkedList;

public class LinkedListImplementation{

	public static void main(String[] args) {
		LinkedListImplementation ll = new LinkedListImplementation();
		ll.implement();
		
	}
	
	public void implement(){
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createSinglyLinkedList(5);
//		System.out.println(sll.head.value);
		sll.insertNodeInLL(4, 0);
		
		sll.insertNodeInLL(1, 1);
		
		sll.insertNodeInLL(2, 3);
		
		sll.display();
		sll.delete(1);
		sll.display();
//		for(int i = 0; i<sll.size; i++){
//			System.out.println(sll.head.value);
//			sll.head = sll.head.next;
//		}
		
		
	}
	
	
	public class Node{
		public int value;
		public Node next;
	}
	
	public class SinglyLinkedList{
		
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

