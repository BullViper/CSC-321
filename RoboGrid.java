import java.util.ArrayList;

/**
 * Class that models a grid (with obstacles) for robot navigation.
 *   @author Dave Reed
 *   @version 8/17/17
 */
public class RoboGrid {
    private int numRows;
    private int numCols;
    private ArrayList<Obstacle> obstacles;
    
    /**
     * Constructs a grid with the specified number of rows and columns.
     *   @param numRows the number of rows in the grid
     *   @param numCols the number of columns in the grid
     */
    public RoboGrid(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.obstacles = new ArrayList<Obstacle>();
    }
    
    /**
     * Accessor method for the number of rows in the grid.
     *   @return the number of rows
     */
    public int getNumRows() {
        return this.numRows;
    }
    
    /**
     * Accessor method for the number of columns in the grid.
     *   @return the number of columns
     */
    public int getNumCols() {
        return this.numCols;
    }    
    
    /**
     * Adds an obstacle to the grid given its corner row/col pairs.
     *   @param r1 row of top left corner
     *   @param c1 column of top left corner
     *   @param r2 row of bottom right corner
     *   @param c2 column of bottom right corner
     */
    public void addObstacle(int r1, int c1, int r2, int c2) {
        this.obstacles.add(new Obstacle(r1, c1, r2, c2));
    }
    
    /**
     * Determines whether a specific position in the grid is within an obstacle.
     *   @param r the row number
     *   @param c the column number
     *   @return true if (r,c) is within an obstacle; else, false
     */
    public boolean isInObstacle(int r, int c) {
        for (Obstacle ob : this.obstacles) {
            if (ob.contains(r, c)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Converts the grid into its String representation.
     *   @return a String displaying the contents of the grid
     */
    public String toString() {
        String horiz = "+";
        for (int c = 1; c <= this.numCols; c++) {
            horiz += "-";
        }
        horiz += "+\n";
        
        String outstr = horiz;
        for (int r = 1; r <= this.numRows; r++) {
            outstr += "|";
            for (int c = 1; c <= this.numCols; c++) {
                if (this.isInObstacle(r, c)) {
                    outstr += "*";
                }
                else {
                    outstr += " ";
                }
            }
            outstr += "|\n";
        }
        outstr += horiz;
        return outstr;
    }
}