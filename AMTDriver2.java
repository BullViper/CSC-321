/*
 * Reads in grid information from a text file
 * Displays and accesses that grid
 * @author Austin Philippi, Stephen Yang
 * @version 8/31/2017
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AMTDriver2 {
    
    private static ArrayList<Integer> values = new ArrayList<>();
    private static int topX=-1;
    private static int topY=-1;
    private static int botX=-1;
    private static int botY=-1;
    
    public static void main(String[] args) {
        int paramX =0;
        int paramY =0;
	//ArrayList<Integer> values = new ArrayList<Integer>();
        // or store in variables without ArrayList?
        // or create 2D array based on first 2 integers without variables?
	String filename ="robo1.txt";
	try {
		Scanner infile = new Scanner(new File(filename));
		while (infile.hasNext()) {
			int nextInt = infile.nextInt();
                        //check
			System.out.print(nextInt);
			values.add(nextInt);
		}
	}
        catch(java.io.FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
	}
        //int[][] mapValues = new int[paramX][paramY]; 
	//infile.close();
	System.out.println(values);
        // store dimensions in variables and remove from list
        // with helper method
	paramX = values.get(0)+2;
	paramY = values.get(1)+2;
	values.remove(1);
	values.remove(0);
        // check
	System.out.println(values);
	System.out.println(paramX);
	System.out.println(paramY);
        //  2D array
        String[][] grid = new String[paramX][paramY];
        for (int col = 0; col < paramX; col++) {
            for (int row = 0; row < paramY; row++) {
                // if vertical border
                if (row == 0 || row == paramY-1) {
                    // if corner, +
                    if (col == 0 || col == paramX-1) {
                        grid[col][row] = "+";
                    }
                    // else, |
                    else {
                        grid[col][row] = "|";
                    }
                }
                // else if side, - 
                else if (col == 0 || col == paramX-1) {
                    grid[col][row] = "-";
                }
                // else space
                else {
                    grid[col][row] = " ";
                }
                // check
                System.out.print(grid[col][row]);
            }
            // start new line
            System.out.println("");
        }
        // store obstacle values in variables and remove from list
        while (!values.isEmpty()) {
            setNewObstacle();
            for (int col = 0; col < paramX; col++) {
                for (int row = 0; row < paramY; row++) {
                    // if obstacle, *
                    if ((col >= topX && col <= botX) && (row >= topY && row <= botY)) {
                        grid[col][row] = "*";
                    }
                    // check
                    System.out.print((grid[col][row]));
                }
                // start new row
                System.out.println("");
            }
        }
        // display full grid
        for (int col = 0; col < paramX; col++) {
            for (int row = 0; row < paramY; row++) {
                System.out.print((grid[col][row]));
            }
            System.out.println("");
        }
    }
    /*
    * private helper class
    * stores first 4 values into respective variables
    * removes them from ArrayList index
    * sets * at corresponding 2D array index
    */
    private static void setNewObstacle() {
        if (!values.isEmpty())
        {
            // check
            System.out.println(values);
            
            topX = values.get(0);
            topY = values.get(1);
            botX = values.get(2);
            botY = values.get(3);
            values.remove(0);
            values.remove(0);
            values.remove(0);
            values.remove(0);
            
            // check
            //System.out.print(topX);
            //System.out.print(topY);
            //System.out.print(botX);
            //System.out.print(botY);
            System.out.println(values);
        }
    }
}

