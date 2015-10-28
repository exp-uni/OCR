package OCR;
import java.lang.Math;
import OCR.Segment;

/*
This class builds segments


*/

public class SegmentFactory{
  static int GlyphHeight;
  static int GlyphWidth;
  
  
  public SegmentFactory(){
    
    
  }
  public static Segment buildSegment(SegmentData seg){
    return(buildSegment(GlyphHeight,GlyphWidth,seg));
  }
  public static Segment buildSegment(int GlyphHeight, int GlyphWidth, SegmentData seg){
    Segment finalSeg = new Segment();
    int height = Math.abs(seg.START_Y - seg.END_Y);
    int width = Math.abs(seg.LEFTMOST - seg.RIGHTMOST);
    int gap = Math.abs(seg.START_X - seg.END_X);
    int leftdist = Math.abs(seg.LEFTMOST - seg.START_X);
    int rightdist = Math.abs(seg.RIGHTMOST - seg.START_X);
    
    if(seg.START_Y < GlyphHeight/2){
      finalSeg.seg_top = true;
    }
    else{
      finalSeg.seg_top = false;
    }
    if(seg.START_X < GlyphWidth/2){
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
      if(seg.START_X > seg.END_X){
        finalSeg.seg_leftSidedLine = true;
      }
      else{
        finalSeg.seg_leftSidedLine = false;
      }
    }
    else{
      finalSeg.seg_line = false;
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
  

  
}