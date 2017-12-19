import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DulcimerString{
	String stringNote = "C";
	int OffsetFromMiddleC;
	Queue<Double> displacement = new LinkedList<>();
	long n = 200;
	
	public DulcimerString(String note) {
		stringNote = note;
		int OffsetFromMiddleC= getOffsetFromMiddleC();
		double q = 2*((22-getOffsetFromMiddleC())/12);
		n = Math.round(StdAudio.SAMPLE_RATE *q/440);
		for(int i = 0; i<n; i++) {
			displacement.add(0.0);
			System.out.println(displacement);
		}
	}
	public String getNote() {
		return stringNote;
	}
	public int getOffsetFromMiddleC() {
		ArrayList<String> scale = new ArrayList<String>();
		scale.add("A");
		scale.add("A#");
		scale.add("B");
		scale.add("C");
		scale.add("C#");
		scale.add("D");
		scale.add("D#");
		scale.add("E");
		scale.add("F");
		scale.add("F#");
		scale.add("G");
		scale.add("G#");
		
		int octave = 0;
		while(stringNote.contains("+") || stringNote.contains("-")) {
			if(stringNote.contains("+")) {
				stringNote= stringNote.replace("+", "");
				octave+=12;
			}
			if(stringNote.contains("-")) {
				stringNote= stringNote.replace("-", "");
				octave-=12;
			}	
		}
		return scale.indexOf(stringNote)+octave;
	}
	public void strike() {
		for(int i = 0; i<n; i++) {
			displacement.remove();
			Random rn = new Random();
			double randomDisp = -.5 + (.5 - -.5) * rn.nextDouble();
			displacement.add(randomDisp);
		}
	}
	public double sample() {
		double temp1 = displacement.peek();
		displacement.remove();
		double temp2 = displacement.peek();
		double decay = ((temp1+temp2)/2)*.996;
		displacement.add(decay);
		return temp1;
	}
}
