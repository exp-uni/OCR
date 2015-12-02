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
  
  
  public void exportSegment(){
    
  }
  @Override
  public String toString(){
  	seg = "";
	seg = seg + "seg_top" + seg_top.toString() + "\n";
        seg = seg + "seg_left" + seg_left.toString() + "\n";
        seg = seg + "seg_short" + seg_short.toString() + "\n";
        seg = seg + "seg_straight" + seg_straight.toString() + "\n";
        seg = seg + "seg_line" + seg_line.toString() + "\n";
        seg = seg + "seg_leftSidedLine" + seg_leftSidedLine.toString() + "\n";
        seg = seg + "seg_leftSidedCurve" + seg_leftSidedCurve.toString() + "\n";

	
  }
}
