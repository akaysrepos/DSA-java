package LinkedList;

import java.util.HashSet;

public class Questions {

	public void makeLL(){
		LinkedList l1 = new LinkedList();
		l1.createLL(1);
		l1.insertNode(2);
		l1.insertNode(3);
//		l1.insertNode(4);
//		l1.insertNode(5);
//		l1.insertNode(1);
//		l1.insertNode(7);
//		l1.traverseLL();
//		
//		this.deleteDups(l1);
//		l1.traverseLL();
//		System.out.println(this.NthFromLast(l1, 2).value);
//		LinkedList l = this.partition(l1, 3);
//		l.traverseLL();
		LinkedList l2 = new LinkedList();
		l2.createLL(4);
		l2.insertNode(5);
		l2.insertNode(6);
		LinkedList ll = this.SumLists(l1, l2);
		ll.traverseLL();
	}
	public static void main(String[] args) {
		Questions que = new Questions();
		que.makeLL();
	}
	
	//Question 1: Delete the Duplicates
	//*Hashing*
	public void deleteDups(LinkedList ll){
		Node curr = ll.head;
		Node prev = null;
		HashSet<Integer> hs = new HashSet<Integer>();
		while(curr!=null){
			if(hs.contains(curr.value)){
				prev.next = curr.next;
				ll.size--;
			}else{
				hs.add(curr.value);
				prev = curr;
			}
			curr = curr.next;
		}
	}
	
	//Question 2: Return the Nth element from the last
	//*Double pointer with difference of n b/w them*
	//*p2 points to last, p1 points to Nth from last*
	public Node NthFromLast(LinkedList ll, int n){
		Node p1 = ll.head;
		Node p2 = ll.head;
		for(int i =0;i<n;i++){
			if(p2==null) return null;
			p2 = p2.next;
		}
		while(p2!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	//Question 3: Make partition in a LinkedList around x,
	//such that all elements < come before all >= x
	//*if < x add the node to the beginning otherwise to the end*
	public LinkedList partition(LinkedList ll, int x){
		Node curr = ll.head;
		ll.tail = ll.head;
		while(curr!=null){
			Node next = curr.next;
			if(curr.value<x){
				curr.next = ll.head;
				ll.head = curr;
			}else{
				ll.tail.next = curr;
				ll.tail = curr;
			}
			curr = next;
		}
		ll.tail.next = null;
		return ll;
	}
	
	//Question 4: Return a LinkedList which is the sum of
	//the numbers represented by the LinkedLists in reverse order
  	public LinkedList SumLists(LinkedList l1, LinkedList l2){
		int count1 = 0;
		int count2 = 0;
		Node temp = l1.head;
		for(int i =0;i<l1.size;i++){
			count1+=Math.pow(10,i)*temp.value;
			temp = temp.next;
		}
		temp = l2.head;
		for(int j =0;j<l2.size;j++){
			count2+=Math.pow(10,j)*temp.value;
			temp = temp.next;
		}
		int count = count1+count2;
		LinkedList ll = new LinkedList();
		ll.createLL(count%10);
		while(count%10!=0){
			count = count/10;
			ll.insertNode(count%10);
		}
		return ll;
	}
  	
  	//Question 5: Intersection of two LinkedList
  	//return the Node is there is where the LinkedLists
  	//make an intersection
  	
  	//returns the Kth Node i.e. the Node to start from
  	public Node getKthNode(Node head, int k){
  		Node curr = head;
  		while(k>0 && curr!=null){
  			curr = curr.next;
  			k--;
  		}
  		return curr;
  	}
  	
  	//returns the intersecting Node
  	public Node findIntersection(LinkedList list1, LinkedList list2){
  		if(list1.head == null || list2.head == null) return null;
  		if(list1.tail != list2.tail){
  			return null;
  		}
  		Node shorter = new Node();
  		Node longer = new Node();
  		if(list1.size > list2.size){
  			longer = list1.head;
  			shorter = list2.head;
  		}else{
  			longer = list2.head;
  			shorter = list1.head;
  		}
  		longer = this.getKthNode(longer, Math.abs(list1.size-list2.size));
  		while(shorter!=longer){
  			shorter = shorter.next;
  			longer = longer.next;
  		}
  		return longer;
  	}
  	
  	//adds the same Nodes to both the LinkedLists
  	public void addSameNode(LinkedList llA, LinkedList llB, int nodeValue){
  		Node newNode = new Node();
  		newNode.value = nodeValue;
  		llA.tail.next = newNode;
  		llA.tail = newNode;
  		llB.tail.next = newNode;
  		llB.tail = newNode;
  		
  	}
  	
	
	public class Node{
		public int value;
		public Node prev;
		public Node next;
	}
	
	public class LinkedList{
		public Node head;
		public Node tail;
		public int size;
		
		public Node createLL(int nodeValue){
			Node node = new Node();
			head = new Node();
			node.value = nodeValue;
			node.next = null;
			head = node;
			tail = node;
			size=1;
			return head;
		}
		
		public void traverseLL(){
			Node temp = head;
			for(int i=0; i<size;i++){
				System.out.print(temp.value);
				if(i!=size-1){
					System.out.print(" -> ");
				}
				temp = temp.next;
			}
			System.out.println("\n");
		}
		
		public void insertNode(int nodeValue){
			Node node = new Node();
			node.value = nodeValue;
			node.next = null;
			tail.next = node;
			tail = node;
			size++;
		}
	}

}
