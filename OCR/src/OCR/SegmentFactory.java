package OCR;
import java.lang.Math;
import OCR.Segment;

/**
 * Converts int values of a SegmentData into boolean values of a Segment
 * @author Denny
 *
 */

public class SegmentFactory{
  private int GlyphHeight;
  private int GlyphWidth;
  
  
  public SegmentFactory(){
    
    
  }
  public Segment buildSegment(SegmentData seg){
    return(buildSegment(GlyphHeight,GlyphWidth,seg));
  }
  public Segment buildSegment(int GlyphWidth, int GlyphHeight, SegmentData seg){
    Segment finalSeg = new Segment();
    int height = Math.abs(seg.START_X - seg.END_X);
    int width = Math.abs(seg.LEFTMOST - seg.RIGHTMOST); //so apparently this is in the algorithm despite not being used in calculation
    int gap = Math.abs(seg.START_Y - seg.END_Y);
    int leftdist = Math.abs(seg.LEFTMOST - seg.START_Y);
    int rightdist = Math.abs(seg.RIGHTMOST - seg.START_Y);
    
    //Determines if segment is in top/bottom of character
    if(seg.START_X < GlyphHeight/2){
      finalSeg.seg_top = true;
    }
    else{
      finalSeg.seg_top = false;
    }
      
    //Determines if segment is right/left of character
    
    if(seg.START_Y < GlyphWidth/2){
      finalSeg.seg_left = true;
    }
    else{
      finalSeg.seg_left = false;
    }

    if(height > ((GlyphHeight*3)/4)){
      finalSeg.seg_short = true;
    }
    else{
      finalSeg.seg_short = false;
    }
    if(gap > (GlyphHeight/4)){
      finalSeg.seg_straight = true;
    }
    else{
      finalSeg.seg_straight = false;
    }
    if(seg.STRAIGHT_PART_PREVIOUS > ((height*3)/4)){
      finalSeg.seg_line = true;
      finalSeg.seg_leftSidedCurve = false;
      if(seg.START_Y > seg.END_Y){
        finalSeg.seg_leftSidedLine = true;
      }
      else{
        finalSeg.seg_leftSidedLine = false;
      }
    }
    else{
      finalSeg.seg_line = false;
      finalSeg.seg_leftSidedLine = false;
      if(leftdist > rightdist){
        finalSeg.seg_leftSidedCurve = true;
      }
      else{
        finalSeg.seg_leftSidedCurve = false;
      }
    }
    
    return(finalSeg);
  }

  
  public void SetHeight(int GlyphHeight){
    this.GlyphHeight = GlyphHeight;
  }
  public void SetWidth(int GlyphWidth){
    this.GlyphWidth = GlyphWidth;
  }
  public int getHeight(){
	  return(this.GlyphHeight);
  }
  public int getWidth(){
	  return(this.GlyphWidth);
  }

  
}