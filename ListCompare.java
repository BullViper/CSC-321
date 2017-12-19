import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Class that tests efficiency of algorithms
 * @author Austin Fillipi
 * @version 10/6/17
 */
public class ListCompare {
	private int numOps;
	private int listSize;
	
	/**
	 * Constructs basic tester
	 */
	public ListCompare() {
		this.numOps = getOps();
		this.listSize = listSize();
	}
	
	/**
	 * Prompts user for list size
	 */
	public int listSize() {
		Scanner userIn = new Scanner(System.in);
		System.out.println("Input the size of the list.");
		int size = userIn.nextInt(); 
		return size;
	}
	
	/**
	 * Prompts user for number of operations to perform
	 */
	public int getOps() {
		Scanner userIn = new Scanner(System.in);
		System.out.println("Input the number of operations to perform.");
		int numOps = userIn.nextInt();
		return numOps;
	}
	
	/**
	 * Tests how long a set of operations takes with a list of a certain size
	 * @param numOps
	 * @param listSize
	 */
	public void tester() {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for(int i=0; i<listSize; i++) {
			aList.add(0);
		}
		LinkedList<Integer> lList = new LinkedList<Integer>();
		for(int q=0; q<listSize; q++) {
			lList.add(0);
		}
		StopWatch timer1 = new StopWatch();
		StopWatch timer2 = new StopWatch();
		
		int iterator1 = 0; 
		
		timer1.start();
		while(iterator1<numOps){	
			aListHelper(aList,numOps);
			iterator1++;
		}
		timer1.stop();
		
		timer2.start();
		int iterator2 = 0;
		while(iterator2<numOps){	
			lListHelper(lList,numOps);
			iterator2++;
		}
		timer2.stop();
		System.out.print(numOps+ " " + timer1.getElapsedTime() +" "+ timer2.getElapsedTime());
	}
	
	/**
	 * Aids in performing the operations on the ArrayList
	 * @param aList
	 * @param numOps
	 */
	private void aListHelper(ArrayList<Integer> aList, int numOps) {
		aList.get(aList.size()/2);
	}
	
	/**
	 *Aids in performing the operations on the LinkedList 
	 * @param lList
	 * @param numOps
	 */
	private void lListHelper(LinkedList<Integer> lList, int numOps) {
		lList.get(lList.size()/2);
	}
}
