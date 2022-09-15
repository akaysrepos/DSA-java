package BinaryTree;

public class BinaryTreeUsingArrays {
	
	public BinaryTreeUsingArrays(){
		implement();
	}

	public static void main(String[] args) {
		new BinaryTreeUsingArrays();
	}
	
	public void implement(){
		BinaryTree bt = new BinaryTree(5);
		bt.insert("N1");
		bt.insert("N2");
		bt.insert("N3");
		bt.insert("N4");
		bt.insert("N5");
		bt.insert("N6");
		bt.preOrder(1);
		System.out.println();
		bt.inOrder(1);
		System.out.println();
		bt.levelOrder();
		System.out.println();
		bt.search("N3");
	}
	
	public class BinaryTree{
		public String[] array;
		public int lastUsedIndex;
		
		public BinaryTree(int size){
			array = new String[size+1];
			lastUsedIndex = 0;
		}
		
		public boolean isFull(){
			if(array.length-1 == lastUsedIndex){
				return true;
			}
			return false;
		}
		
		public void insert(String value){
			if(!isFull()){
				array[lastUsedIndex+1]=value;
				lastUsedIndex++;
				return;
			}
			System.out.println("Binary Tree is Full!");
		}
		
		public void preOrder(int index){
			if(index>lastUsedIndex){
				return;
			}
			System.out.print(array[index] + " ");
			preOrder(index*2);
			preOrder(index*2 + 1);
		}
		
		public void inOrder(int index){
			if(index>lastUsedIndex){
				return;
			}
			inOrder(index*2);
			System.out.print(array[index] + " ");
			inOrder(index*2 + 1);
		}
		
		public void postOrder(int index){
			if(index>lastUsedIndex){
				return;
			}
			postOrder(index*2);
			postOrder(index*2 + 1);
			System.out.print(array[index] + " ");
		}
		
		public void levelOrder(){
			for(int i=1; i<=lastUsedIndex;i++){
				System.out.print(array[i] + " ");
			}
		}
		
		public int search(String value){
			for(int i=0;i<=lastUsedIndex;i++){
				if(array[i]==value){
					System.out.println("Found at "+ i);
					return i;
				}
			}
			System.out.println("Not Found!");
			return -1;
		}
		
		public void deleteNode(String value){
			int index = search(value);
			if(index==-1){
				return;
			}
			array[index]=array[lastUsedIndex];
			lastUsedIndex--;
			System.out.println("Node deleted!");
			return;
		}
	}

}
