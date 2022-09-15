package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	public BinaryNode root;

	public BinarySearchTree() {
		root = null;
	}
	

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(70);
		bst.insert(50);
		bst.insert(90);
		bst.insert(30);
		bst.insert(60);
		bst.insert(80);
		bst.insert(100);
		bst.insert(20);
		bst.insert(40);
		bst.preOrder(bst.root);
		System.out.println();
		bst.inOrder(bst.root);
		System.out.println();
		bst.postOrder(bst.root);
		System.out.println();
		bst.levelOrder();
		System.out.println();
		System.out.println(bst.search(40));
		System.out.println();
		bst.deleteNode(bst.root, 90);
		System.out.println();
		bst.levelOrder();
		
	}
	
	public class BinaryNode{
		public int value;
		public int height;
		public BinaryNode left;
		public BinaryNode right;
	}
	
	public BinaryNode insert(BinaryNode currentNode, int value){
		if(root==null){
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			this.root = newNode;
			return root;
		}
		if(currentNode == null){
			BinaryNode newNode = new BinaryNode();
			newNode.value = value;
			System.out.println("Inserted!");
			return newNode;
		}
		else if(value<=currentNode.value){
			currentNode.left = insert(currentNode.left, value);
			return currentNode;
		}
		else{
			currentNode.right = insert(currentNode.right, value);
			return currentNode;
		}
	}
	
	public void preOrder(BinaryNode node){
		if(node==null){
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(BinaryNode node){
		if(node==null){
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}
	
	public void postOrder(BinaryNode node){
		if(node==null){
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}
	
	public void levelOrder(){
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode node = queue.remove();
			System.out.print(node.value + " ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	
	public BinaryNode search(int value){
		Queue<BinaryNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryNode node = queue.remove();
			if(node.value==value){
				System.out.println("Found!");
				return node;
			}
			if(value<node.value){
				queue.add(node.left);
			}
			if(value>node.value){
				queue.add(node.right);
			}
		}
		System.out.println("Not Found!");
		return null;
	}
	
	public BinaryNode minimumNode(BinaryNode root){
		if(root.left==null){
			return root;
		}
		else{
			return minimumNode(root.left);
		}
	}
	
	public BinaryNode deleteNode(BinaryNode root, int value){
		if(root == null){
			System.out.println("Not Found!");
			return null;
		}
		else if(value< root.value){ //traversing
			root.left = deleteNode(root.left, value);
		}
		else if(value> root.value){ //traversing
			root.right = deleteNode(root.right, value);
		}
		else{ //FOUND!
			if(root.left!=null && root.right !=null){ //has two children
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumNode(temp.right);
				root.value = minNodeForRight.value;
				root.right = deleteNode(root.right, minNodeForRight.value); //delete the minimum element (in the right subtree)
			}else if(root.left!=null){ //has a left child                                     //or the successor of the node to be deleted
				root = root.left;
			} else {
				root = root.right;
			}
			
		}
		return root;
	}
	
	public void insert(int value){
		insert(root, value);
	}

}
