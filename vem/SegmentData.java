

public class SegmentData {
	private boolean top;
	private boolean left;
	private boolean little;
	private boolean straight;
	private boolean line;
	private boolean rightSidedLine;
	private boolean rightSidedCurve;
	
	private int START_X, START_Y, LEFTMOST,RIGHTMOST,STRAIGHT_PART_PREVIOUS,STRAIGHT_PART, END_X,END_Y;
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
	
	
	
	//Return the number at the requested location. If outOfBounds, assume white(1);
	/*private int setLetter(int i, int j){
		if(i>=0 && i<character.length)
			if(j>=0 && j<character[0].length)
				return character[i][j];
			else return 1;
		else return 1;
	}*/
	
	public boolean[] getSegmentData(){
		boolean[] toReturn = 
			{top,
			left,
			little,
			straight,
			line,
			rightSidedLine,
			rightSidedCurve};    	
		return toReturn;
	}
}
