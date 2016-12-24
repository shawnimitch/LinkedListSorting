package MergeSort;
import java.util.Random;
import java.util.Scanner;

/* Linked List Class */
/* Programmed by A-Shawni Mitchell */
/* Last Modified December 24,2016 */

public class LinkedList {
	
	private Node start;
	private Scanner in;
	
	public LinkedList() {
		start = null;
	}
	
	/* Delete Linked List */
	public void deleteList() {
		start = null;
	}
	/*Display Linked List */
	public void display(){
		
		Node p;
		
		if(start==null) {
			System.out.println("The list is empty.");
			return;
		}
		//System.out.print("The list is :");
		p=start;
		
		while(p!=null) {
			System.out.print(p.info + "  ");
			p=p.next;
		}
		System.out.println();
	}
	
	/* Insert Method */
	public void insert(int data) {
		
		Node temp = new Node(data);
		temp.next = start;
		start = temp;
		
	}
	
	/* Insert At End of List */
	public void insertEnd(int data) {
		
		Node p;
		Node temp = new Node(data);
		
		if(start==null){
			start=temp;
			return;
		}
		
		p=start;
		
		while(p.next!=null)
			p=p.next;
		
		p.next=temp;
	}
	
	/* Create Linked List */
	public void createList(){
		
		int i,n,data;
		Random rand = new Random();
		
		in = new Scanner(System.in);
		System.out.println("Please enter the number of nodes");
		n = in.nextInt();
		
		if(n==0)
			return;
		
		for(i=0;i<n;i++){
			data = rand.nextInt(500)+0;
			insertEnd(data);
		}
		System.out.println();
		
	}
	
	/* Bubble Sort: Exchanging data */
	public void bubbleSort(){
		
		Node end,p,q;
		
		for(end=null;end!=start.next;end=p) {
			for(p=start;p.next!=end;p=p.next) {
				q=p.next;
				if(p.info > q.info) { //make swap
					int temp = p.info;
					p.info = q.info;
					q.info = temp;
				}
			}
			
		}
	}
	
	/* Merge Sort Method */
	public void mergeSort(){
		
		start = mergeSortRec(start);
	}
	
	/* Recursive Merge Sort */
	private Node mergeSortRec(Node lstart) {
		
		if(lstart==null || lstart.next==null) //If list has one or no elements return list
			return lstart;
		
		/* if more than one element */
		Node start1 = lstart;
		Node start2 = divideList(lstart);
		start1 = mergeSortRec(start1);
		start2 = mergeSortRec(start2);
		Node startM = merge2(start1,start2);
		return startM;
	}
	
	/* Divide List Method */
	private Node divideList(Node p) {
		
		Node q = p.next.next;
		while(q!=null && q.next!=null) {
			p=p.next;
			q=q.next.next;
		}
		Node start2 = p.next;
		p.next = null;
		return start2;
	}
	
	/* Merge 2 Method */
	private Node merge2(Node p1, Node p2) {
		
		Node startM;
		
		if(p1.info <= p2.info) {
			startM=p1;
			p1=p1.next;
		}
		else {
			startM = p2;
			p2=p2.next;
		}
		
		Node pM = startM;
		
		while(p1!=null && p2!=null) {
			if(p1.info<=p2.info) {
				pM.next=p1;
				pM=pM.next;
				p1=p1.next;
			}
			else {
				pM.next=p2;
				pM=pM.next;
				p2=p2.next;
			}
		}
		
		if(p1==null)
			pM.next=p2;
		else
			pM.next=p1;
		return startM;
		
	}

}
