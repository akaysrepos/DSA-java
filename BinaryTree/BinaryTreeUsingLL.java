package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUsingLL {

	public BinaryTreeUsingLL() {
		implement();
	}

	public static void main(String[] args) {
		new BinaryTreeUsingLL();
	}
	
	public void implement(){
		BinaryTree bt = new BinaryTree();
		bt.insert("N1");
		bt.insert("N2");
		bt.insert("N3");
		bt.insert("N4");
		bt.insert("N5");
		bt.insert("N6");
		bt.insert("N7");
		bt.insert("N8");
		bt.insert("N9");
		bt.levelOrder();
		bt.deleteNode("N7");
		System.out.println();
		bt.levelOrder();
	}
	
	public class BinaryTree{
		public BinaryNode root;
		
		public BinaryTree(){
			this.root = null;
		}
		
		public class BinaryNode{
			public String value;
			public BinaryNode left;
			public BinaryNode right;
			public int height;
			
		}
		
		public void preOrder(BinaryNode node){
			if(node == null){
				return;
			}
			System.out.print(node.value + "->");
			preOrder(node.left);
			preOrder(node.right);
		}
		
		public void inOrder(BinaryNode node){
			if(node == null){
				return;
			}
			inOrder(node.left);
			System.out.print(node.value + "->");
			inOrder(node.right);
		}
		
		public void postOrder(BinaryNode node){
			if(node == null){
				return;
			}
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value + "->");
		}
		
		public void levelOrder(){
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				BinaryNode presentNode = queue.remove();
				System.out.print(presentNode.value + "->");
				if(presentNode.left!=null){
					queue.add(presentNode.left);
				}
				if(presentNode.right!=null){
					queue.add(presentNode.right);
				}
			}
		}
		
		public void search(String value){
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				BinaryNode presentNode = queue.remove();
				if(presentNode.value==value){
					System.out.println("Found!");
					return;
				}
				else{
					if(presentNode.left!=null){
						queue.add(presentNode.left);
					}
					if(presentNode.right!=null){
						queue.add(presentNode.right);
					}
				}
			}
		}
		
		public void insert(String value){
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			if(root==null){
				root= newNode;
				System.out.println("Inserted at Root!");
				return;
			}
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()){
				BinaryNode presentNode = queue.remove();
				if(presentNode.left==null){
					presentNode.left=newNode;
					System.out.println("Inserted!");
					break;
				}else if(presentNode.right==null){
					presentNode.right=newNode;
					System.out.println("Inserted!");
					break;
				}else{
					queue.add(presentNode.left);
					queue.add(presentNode.right);
				}
			}
		}
		
		public BinaryNode getDeepestNode(){
			Queue<BinaryNode> queue = new LinkedList<>();
			queue.add(root);
			BinaryNode presentNode = null;
			while(!queue.isEmpty()){
				presentNode = queue.remove();
				if(presentNode.left!=null){
					queue.add(presentNode.left);
				}
				if(presentNode.left!=null){
					queue.add(presentNode.right);
				}
			}
			return presentNode;
		}
		
		public void deleteDeepestNode(){
			Queue<BinaryNode> queue = new LinkedList<>();
			queue.add(root);
			BinaryNode previousNode, presentNode = null;
			while(!queue.isEmpty()){
				previousNode = presentNode;
				presentNode = queue.remove();
				if(presentNode.left==null){
					previousNode.right = null;
					return;
				}
				if(presentNode.right==null){
					presentNode.left=null;
					return;
				}
				queue.add(presentNode.left);
				queue.add(presentNode.right);
			}
		}
		
		public void deleteNode(String value){
			Queue<BinaryNode> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				BinaryNode presentNode = queue.remove();
				if(presentNode.value==value){
					presentNode.value = getDeepestNode().value;
					deleteDeepestNode();
					System.out.println("Deleted!");
					return;
				}else{
					if(presentNode.left!=null){
						queue.add(presentNode.left);
					}
					if(presentNode.right!=null){
						queue.add(presentNode.right);
					}
				}
			}
			System.out.println("Node not found!");
		}
		
		public void deleteTree(){
			root = null;
			System.out.println("Binary Tree Deleted!");
		}

	}

}
