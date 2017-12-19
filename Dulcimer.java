import java.util.ArrayList;

/**
 * Class that models a dulcimer. Currently, only the bass strings are represented.
 *   @author Dave Reed
 *   @version 9/13/17
 */
public class Dulcimer {
    public ArrayList<DulcimerString> baseStrings;
    public ArrayList<DulcimerString> treble2Strings;
    public ArrayList<DulcimerString> treble1Strings;
    /**
     * Constructs a Dulcimer with the specified bass strings.
     *   @param bassNotes a String specifying the bass notes, from bottom to top
     */
    public Dulcimer(String bassNotes,String treble2Notes,String treble1Notes) {
        this.baseStrings = new ArrayList<DulcimerString>();
        this.treble2Strings = new ArrayList<DulcimerString>();
        this.treble1Strings = new ArrayList<DulcimerString>();
        for (String str : bassNotes.split("\\s+")) {
            this.baseStrings.add(new DulcimerString(str));
        }
        for (String str : treble2Notes.split("\\s+")) {
            this.treble2Strings.add(new DulcimerString(str));
        }
        for (String str : treble1Notes.split("\\s+")) {
            this.treble1Strings.add(new DulcimerString(str));
        }
    }
    
    /**
     * Strikes the specified string and sets it to vibrating.
     *   @param stringNum the string number (starting at the bottom with 0)
     */
    public void hammer(int stringNum) {
        if (stringNum >= 0 && stringNum < this.baseStrings.size()) {
            this.baseStrings.get(stringNum).strike();
        }
        if (stringNum >= 0 && stringNum < this.treble2Strings.size()) {
            this.treble2Strings.get(stringNum).strike();
        }
        if (stringNum >= 0 && stringNum < this.treble1Strings.size()) {
            this.treble1Strings.get(stringNum).strike();
        }
    }

    /**
     * Plays the sounds corresponding to all of the struck strings.
     */
    public void play() {
        double combinedFrequencies = 0.0;
        for (int i = 0; i < this.baseStrings.size(); i++) {
            combinedFrequencies += this.baseStrings.get(i).sample();
        }
        StdAudio.play(combinedFrequencies);
    }
}