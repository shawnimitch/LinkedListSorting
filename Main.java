package MergeSort;
import java.util.Scanner;

/* Main Class */
/* Programmed by A-Shawni Mitchell */
/* Last Modified December 24,2016 */

public class Main {

	private static Scanner in;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		in = new Scanner(System.in);
		int choice;
		
		System.out.println("***** WELCOME TO SORTING LINKED LIST ******");
		System.out.println();
		
		LinkedList list1 = new LinkedList();
		
		
		while(true) {
			
			System.out.println("Please enter the method you would like to use \n");
    		System.out.println("1. Bubble Sort");
    		System.out.println("2. Merge Sort");
    		System.out.println("3. Quit");
    		
    		System.out.println();
    		System.out.println("Enter your choice: \n");
    		choice = in.nextInt();
    		
    		if(choice==3)
    			break;
			
			switch(choice) {
			
			case 1:
				list1.createList();
				System.out.println("List Before Bubble Sort:");
				list1.display();
				System.out.println();
				
				System.out.println("Our list after Bubble Sort is:");
				list1.bubbleSort();
				
				list1.display();
				list1.deleteList();
				System.out.println("\n");
				break;
				
			case 2:
				list1.createList();
				System.out.println("List Before Merge Sort:");
				list1.display();
				System.out.println();
				
				System.out.println("Our list after Merge Sort is:");
				list1.mergeSort();
				
				list1.display();
				list1.deleteList();
				System.out.println("\n");
				break;
				
			default:
				System.out.println("No such choice");
				break;
			
			}
		}
	}

}
