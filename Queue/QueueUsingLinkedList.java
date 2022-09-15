package Queue;

public class QueueUsingLinkedList {

	public void implement(){
		Queue q = new Queue();
		System.out.println(q.isEmpty());
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		System.out.println(q.isEmpty());
		System.out.println(q.peek());
		q.deQueue();
		System.out.println(q.peek());
		q.delete();
	}
	
	public static void main(String[] args) {
		QueueUsingLinkedList qll = new QueueUsingLinkedList();
		qll.implement();
	}
	
	public class Node{
		public int value;
		public Node next;
	}
	
	public class Queue{
		public Node head;
		public Node tail;
		
		public Queue() {
			System.out.println("Queue is created!");
		}

		public boolean isEmpty(){
			if(head==null)
				return true;
			else
				return false;
		}
		
		public void enQueue(int value){
			Node node = new Node();
			node.value = value;
			if(head==null){
				head = new Node();
				head = node;
			}
			tail.next = node;
			tail = node;
			System.out.println("EnQueued!");
		}
		
		public int peek(){
			if(isEmpty()){
				System.out.println("The Queue is Empty!");
				return -1;
			}else{
				return this.head.value;
			}
		}
		
		public int deQueue(){
			if(isEmpty()){
				System.out.println("The Queue is Empty!");
				return -1;
			}
			int deQueue = this.head.value;
			head = head.next;
			System.out.println(deQueue+" DeQueued!");
			return deQueue;
		}
		
		public void delete(){
			head=null;
			tail=null;
			System.out.println("Queue deleted!");
		}
	}

}
