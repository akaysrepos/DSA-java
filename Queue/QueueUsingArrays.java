package Queue;

public class QueueUsingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class Queue{
		public int[] arr;
		public int beginningOfQueue;
		public int topOfQueue;
		
		public Queue(int size){
			arr = new int[size];
			beginningOfQueue = -1;
			topOfQueue = -1;
			System.out.println("The Queue is created with size: "+size);
		}
		
		public boolean isFull(){
			if(topOfQueue== arr.length-1){
				return true;
			}else{
				return false;
			}
		}
		
		public boolean isEmpty(){
			if(beginningOfQueue==-1 || (beginningOfQueue== arr.length)){
				return true;
			}else{
				return false;
			}
		}
		
		public void enQueue(int value){
			if(isFull()){
				System.out.println("The Queue is Full!");
			}else if(isEmpty()){
				beginningOfQueue = 0;
				topOfQueue++;
				arr[topOfQueue] = value;
				System.out.println("Successfully inserted!");
			}else{
				topOfQueue++;
				arr[topOfQueue]= value;
				System.out.println("Successfully inserted!");
			}
		}
		
		public int deQueue(){
			if(isEmpty()){
				System.out.println("The Queue is Empty!");
				return - 1;
			}else{
				int result = arr[beginningOfQueue];
				beginningOfQueue++;
				if(beginningOfQueue>topOfQueue){
					beginningOfQueue = topOfQueue = -1;
				}
				return result;
			}
		}
		
		public int peek(){
			if(isEmpty()){
				System.out.println("The Queue is Empty!");
				return - 1;
			}else{
				return arr[beginningOfQueue];
			}
		}
		
		public void delete(){
			arr = null;
			System.out.println("Queue deleted!");
		}
	}

}
