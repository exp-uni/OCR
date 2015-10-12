

public class SegmentData {
	private boolean top;
	private boolean left;
	private boolean little;
	private boolean straight;
	private boolean line;
	private boolean rightSidedLine;
	private boolean rightSidedCurve;
	
	public SegmentData(){
	
	}
	
	public boolean[] getSegmentData(){
	return new boolean[
	top,
	left,
	little,
	straight,
	line,
	rightSidedLine,
	rightSidedCurve
	]();
	}

	
}
