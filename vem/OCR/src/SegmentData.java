package OCR;
import OCR.SegmentFactory;

public class SegmentData {
	
 	public int START_X, START_Y, LEFTMOST, RIGHTMOST, STRAIGHT_PART_PREVIOUS, STRAIGHT_PART, END_X,END_Y;
	
 	public SegmentData(int START_X, int START_Y,
			int LEFTMOST, int RIGHTMOST,
			int STRAIGHT_PART_PREVIOUS,
			int STRAIGHT_PART,
			int END_X, int END_Y){
		
		this.START_X = START_X;
		this.START_Y = START_Y;
		this.LEFTMOST = LEFTMOST;
		this.RIGHTMOST = RIGHTMOST;
		this.STRAIGHT_PART_PREVIOUS = STRAIGHT_PART_PREVIOUS;
		this.STRAIGHT_PART = STRAIGHT_PART;
		this.END_X = END_X;
		this.END_Y = END_Y;
	}
 	/**
 	 * Uses segmentFactory to build a Segment
 	 * This converts int values of the SegmentData to boolean values in Segment
 	 * @param glyphWidth
 	 * @param glyphHeight
 	 * @return
 	 */
	public Segment getSegmentData(int glyphWidth, int glyphHeight){    	
		return SegmentFactory.buildSegment(glyphWidth, glyphHeight, this);
	}
}
