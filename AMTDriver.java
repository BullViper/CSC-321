import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AMTDriver {


	public static void main(String[] args) {
		int paramX =0;
		int paramY =0;
		ArrayList<Integer> values = new ArrayList<Integer>();
		String filename ="robo1.txt";
		try {
			Scanner infile = new Scanner(new File(filename));
			while (infile.hasNext()) {
				int nextInt = infile.nextInt();
				System.out.println(nextInt);
				values.add(nextInt);
				}
		}
		catch(java.io.FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
		}
		int[][] mapValues = new int[paramX][paramY]; 
		String[][] map = new String[8][12];
		//infile.close();
		System.out.println(values);
		paramX = values.get(0);
		paramY = values.get(1);
		values.remove(1);
		values.remove(0);
		System.out.println(values);
		System.out.println(paramX);
		System.out.println(paramY);
		int rangeX;
		int rangeY;
		while(values.size()!=0) {
			rangeX = values.get(2);
			rangeY = values.get(3);
			while(rangeX!=values.get(0) || rangeY!=values.get(1)) {
				System.out.println(rangeX);
				System.out.println(rangeY);
				mapValues[rangeX][rangeY] = 1;
				
				if(rangeX!=values.get(0)) {
					rangeX--;
				}
				if(rangeY!=values.get(1)) {
					rangeY--;
				}
			}
			values.remove(3);
			values.remove(2);
			values.remove(1);
			values.remove(0);
		}
		//for(int i=0; i<=2; i++) {
			//if(i==0) {
			//	paramX = infile.nextInt();
			//}
			//if(i==1) {
			//	paramY = infile.nextInt();
			//}
		//}
		System.out.print(map);
	}
}
