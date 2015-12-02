package OCR;
/*
new segment class
*/

public class Segment{
  public boolean seg_top;
  public boolean seg_left;
  public boolean seg_short;
  public boolean seg_straight;
  public boolean seg_line;
  public boolean seg_leftSidedLine;
  public boolean seg_leftSidedCurve;
  
  public Segment(boolean s_top, boolean s_left, boolean s_short, boolean s_straight, boolean s_line, boolean s_leftSideLine, boolean s_leftSideCurve){
	  this.seg_top = s_top;
	  this.seg_left = s_left;
	  this.seg_short = s_short;
	  this.seg_straight = s_straight;
	  this.seg_line = s_line;
	  this.seg_leftSidedLine = s_leftSideLine;
	  this.seg_leftSidedCurve = s_leftSideCurve;
  }
  
  public Segment(){
	  this.seg_top = true;
	  this.seg_left = true;
	  this.seg_short = true;
	  this.seg_straight = true;
	  this.seg_line = true;
	  this.seg_leftSidedLine = true;
	  this.seg_leftSidedCurve = true;
  }
  
  public void exportSegment(){
    
  }
  
  @Override
  public String toString(){
  	String seg = "";
	seg = seg + "seg_top: " + seg_top + "\n";
        seg = seg + "seg_left: " + seg_left + "\n";
        seg = seg + "seg_short: " + seg_short + "\n";
        seg = seg + "seg_straight: " + seg_straight + "\n";
        seg = seg + "seg_line: " + seg_line + "\n";
        seg = seg + "seg_leftSidedLine: " + seg_leftSidedLine + "\n";
        seg = seg + "seg_leftSidedCurve: " + seg_leftSidedCurve + "\n";
        return seg;

	
  }
}
