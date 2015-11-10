package OCR;

import java.util.ArrayList;

import OCR.Segment;

/**
 * Holds boolean values identifying each segment
 *
 */
public class Character {
	ArrayList<Segment> segments;
    
	public Character(){
		segments = new ArrayList<Segment>();
	}
	
	public void addSegment(Segment seg){
		segments.add(seg);
	}
}
