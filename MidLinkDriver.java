import java.util.Random;
import java.util.Scanner;

/**
 * Driver for MidLinkedList
 * @author Austin Fillipi
 * @version 11/02/17
 */
public class MidLinkDriver {
	public static void main(String []args) {
		MidLinkedList<Integer> listTest = new MidLinkedList<Integer>();
		Scanner userIn = new Scanner(System.in);
		System.out.println("Input the number of operations to perform.");
		int numOps = userIn.nextInt();
		System.out.println("Input the size of the list.");
		int listSize = userIn.nextInt();
		
		for(int i=0; i<listSize; i++) {
			listTest.add(0,0);
		}
		StopWatch timer1 = new StopWatch();
		timer1.start();
		for(int o=0;o<numOps;o++) {
			listTest.get(new Random().nextInt(listTest.numStored));
		}
		timer1.stop();
		System.out.print(timer1.getElapsedTime());
	}
}
