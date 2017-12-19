import java.awt.Font;

/**
 * Driver class for the keyboard-based virtual dulcimer.
 *   @author Dave Reed
 *   @version 9/13/17
 */
public class DulcimerDriver {
   public static void main(String[] args) {
	    String bassKeys = "a   s   d   f   g   h   j   k   l   ;   '";       
        String dashes = "--- --- --- --- --- --- --- --- --- --- --- ---";
        String bassNotes = "G-  A   B   C   D   E   F   G   A+ A#+  C+";
        
	    String treble2Keys = "1   2   3   4   5   6   7   8   9   0   -   =";       
        String treble2Notes = "C#  D   E   F#  G   A+  B+  C+  D+  E+ F#+  G+";
        
	    String treble1Keys = "q   w   e   r   t   y   u   i   o   p   [   ]";       
        String treble1Notes = "G#  A+  B+ C#+  D+  E+ F#+  G+ A++ B++ C++ D++";
        
        StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
        StdDraw.textLeft(0.00, 1.00, "DULCIMER KEY MAPPINGS");
        StdDraw.textLeft(0.00, 0.90, "        keys:  " + bassKeys);
        StdDraw.textLeft(0.00, 0.87, "BASS          " + dashes);
        StdDraw.textLeft(0.00, 0.84, "       notes:  " + bassNotes);
        
        StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
        StdDraw.textLeft(0.00, 0.81, "        keys:  " + treble2Keys);
        StdDraw.textLeft(0.00, 0.78, "TREBLE2       " + dashes);
        StdDraw.textLeft(0.00, 0.75, "       notes:  " + treble2Notes);
        
        StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
        StdDraw.textLeft(0.00, 0.72, "        keys:  " + treble1Keys);
        StdDraw.textLeft(0.00, 0.69, "TREBLE1       " + dashes);
        StdDraw.textLeft(0.00, 0.66, "       notes:  " + treble1Notes);
        
        String keys = bassKeys.replace(" ","");  
        
        Dulcimer dulc = new Dulcimer(bassNotes,treble2Notes,treble1Notes);
        while (true) { 
            if (StdDraw.hasNextKeyTyped()) {
                int typed = keys.indexOf(StdDraw.nextKeyTyped());
                dulc.hammer(typed);
            }
            dulc.play();
        }
    }    
}