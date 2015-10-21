import java.lang.reflect.Array;

public class OCR{
  RightProcessor rightscan;
  SegmentScan segmentScan;
  
  
  /*
  For now this class will just hold the different processed stuff (pass it in through the main method maybe?)
  Eventually it will load up a premade dictionary of segment pieces. 
  
  */
  OCR(){
    rightscan = new RightProcessor();
    segmentScan = new SegmentScan();  
  }
  
  public char getCharacter(int[][] glyph){
    int he = Array.getLength(glyph); //height of image
    int wi = Array.getLength(glyph[0]); // width of image
    
    
    return('a');
  }
  
  
}