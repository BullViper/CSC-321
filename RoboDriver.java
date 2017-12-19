import java.io.File;
import java.util.Scanner;

/**
 * Driver class for navigating a robot grid.
 *   @author Austin Fillipi
 *   @version 8/17/17
 */
public class RoboDriver {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the grid file name: ");
        String filename = input.next();

        try {
            Scanner infile = new Scanner(new File(filename));

            RoboGrid grid = new RoboGrid(infile.nextInt(), infile.nextInt());
            while (infile.hasNextInt()) {
                grid.addObstacle(infile.nextInt(), infile.nextInt(),
                                 infile.nextInt(), infile.nextInt());
            }

            System.out.println("\n" + grid);

            System.out.print("Enter a row and column as a start point and moves: ");
            int row = input.nextInt();
            int col = input.nextInt();
            String moves = input.next();
            String nextmove = "";
            //System.out.println(moves);
            while (row != 0 || col != 0) {
            	for(int i = 0; moves.length()>i; i++) {
            		nextmove = Character.toString(moves.charAt(i));
            		//System.out.println(nextmove);
            		if(nextmove.equals("v") || nextmove.equals("V")) {
            			col++;
            			if(helper(row,col,grid) == 1 || helper(row,col,grid) == 2) {
            				break;
            			}            			
            		}
            		if(nextmove.equals("^")) {
            			col--;
            			if(helper(row,col,grid) == 1 || helper(row,col,grid) == 2) {
            				break;
            			}
            		}
            		if(nextmove.equals("<")) {
            			row--;
            			if(helper(row,col,grid) == 1 || helper(row,col,grid) == 2) {
            				break;
            			}
            		}
            		if(nextmove.equals(">")) {
            			row++;
            			if(helper(row,col,grid) == 1 || helper(row,col,grid) == 2) {
            				break;
            			}
            		}	                
            	}   
            	System.out.print("Enter a row and col as a start point (zeros to end) and moves: ");
                row = input.nextInt();
                col = input.nextInt();
                moves = input.next();
            }
            System.out.println("    DONE");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    private static int helper(int row, int col, RoboGrid grid) {
    	if (row <= 0 || row > grid.getNumRows() || col <= 0 || col > grid.getNumCols()) {
    		System.out.println("    (" + row + "," + col +") IS OUTSIDE THE GRID.");
    		return 1;
            }
        else if (grid.isInObstacle(row, col)) {
        	System.out.println("    (" + row + "," + col +") IS WITHIN AN OBSTACLE.");
        	return 2;
            }
        else {
        	System.out.println("    (" + row + "," + col +") IS VACANT IN THE GRID.");
        	return 3;
        	}
    }
}