package Queue;

public class CircularQueueUsingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class CircularQueue{
		public int[] arr;
		public int topOfQueue;
		public int beginningOfQueue;
		public int size;
		
		public CircularQueue(int size){
			arr = new int[size];
			this.size = size;
			this.topOfQueue = -1;
			this.beginningOfQueue = -1;
			System.out.println("Circular Queue created of size: "+size);
		}
		
		public boolean isEmpty(){
			if(topOfQueue==-1){
				return true;
			}else{
				return false;
			}
		}
		
		public boolean isFull(){
			if(topOfQueue+1==beginningOfQueue){
				return true;
			}else if(beginningOfQueue==0 && topOfQueue+1==size){
				return true;
			}else{
				return false;
			}
		}
		
		public void enQueue(int value){
			if(isFull()){
				System.out.println("The Circular Queue is Full!");
			}else if(isEmpty()){
				beginningOfQueue =0;
				topOfQueue++;
				arr[topOfQueue] = value;
				System.out.println("Successfully inserted!");
			}else{
				//if topOfQueue points at the front
				if(topOfQueue+1==size){
					topOfQueue = 0;
				}
				//else it points after the front
				else{
					topOfQueue++;
				}
				arr[topOfQueue] = value;
				System.out.println("Successfully inserted!");
			}
		}
		
		public int deQueue(){
			if(isEmpty()){
				System.out.println("Circular Queue is Empty!");
				return -1;
			}else{
				int result = arr[beginningOfQueue];
				arr[beginningOfQueue] = 0;
				if(topOfQueue == beginningOfQueue){
					beginningOfQueue = topOfQueue = -1;
				}else if(beginningOfQueue+1==size){
					beginningOfQueue=0;
				}else{
					beginningOfQueue++;
				}
				return result;
			}
		}
		
		public int peek(){
			if(isEmpty()){
				System.out.println("The Circular Queue is Empty!");
				return -1;
			}
			else{
				return arr[beginningOfQueue];
			}
		}
		
		public void delete(){
			arr=null;
			System.out.println("Queue deleted!");
		}
		
	}

}
