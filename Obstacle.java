/**
 * Simple class that represents a rectangular obstacle in a grid.
 *   @author Dave Reed
 *   @version 8/17/17
 */
public class Obstacle {
    private int topRow;
    private int leftCol;
    private int bottomRow;
    private int rightCol;
    
    /**
     * Constructs an obstacle given its upper-left and lower-right corners.
     *   @param r1 row of upper-left corner
     *   @param c1 column of upper-left corner
     *   @param r2 row of lower-right corner
     *   @param c2 column of lower-right corner
     */
    public Obstacle(int r1, int c1, int r2, int c2) {
        this.topRow = r1;
        this.leftCol = c1;
        this.bottomRow = r2;
        this.rightCol = c2;
    }
    
    /**
     * Determines if a particular (row,column) falls within the obstacle.
     *   @param r row number
     *   @param c columns number
     *   @return true if (r,c) is within the obstacle; else, false
     */
    public boolean contains(int r, int c) {
        return (r >= topRow && r <= bottomRow && c >= leftCol && c <= rightCol);
    }
}