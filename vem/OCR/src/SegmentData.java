

public class SegmentData {
	private boolean top_seg;
	private boolean left_seg;
	private boolean short_seg;
	private boolean straight_seg;
	private boolean line_seg;
	private boolean rightSidedLine_seg;
	private boolean rightSidedCurve_seg;
	
	public SegmentData(){
	
	}
	
	public boolean[] getSegmentData(){
	return new boolean[
	top_seg,
	left_seg,
	little_seg,
	straight_seg,
	line_seg,
	rightSidedLine_seg,
	rightSidedCurve_seg
	]();
	}

	
}
