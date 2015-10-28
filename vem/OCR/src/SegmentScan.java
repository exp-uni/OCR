import java.lang.reflect.Array;

class Coord{
	public int x;
	public int y;

	// constructor
	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SegmentScan{
	
  public SegmentScan(){
		
	}
	
	
  public void scan(int [][] rightGlyph){
  
	  // a double array of coords used to store segment data
  	  // I just set it to 100x100 2d array, will make it dynamic later - Joe
	  Coord [][] segments = new Coord [100][100];

	  // number of segments found
	  int numSegs = 0;
	  // number of coords in current segment
	  int numCoords = 0;

	  int hi = Array.getLength(rightGlyph);
	  int wi = Array.getLength(rightGlyph[0]);

 		// iterate through rightGlyph looking for segment data
    for(int i = 0; i < hi; i++) {
    	for(int j = 0; j < wi; j++) {
    		// found a black pixel
    		if(rightGlyph[i][j] == 0) {
    			// make a new coord
    			Coord tempCoord = new Coord(i, j);
    			// update numSeg and numCoords
    			numSegs = Array.getLength(segments);
    			numCoords = Array.getLength(segments[numCoords]);
    			// add tempCoord to 2d segments array
    			segments[numSegs][numCoords] = tempCoord;

    			// set rightGlyph[i][j] to a white pixel, so we don't process it twice
    			rightGlyph[i][j] = 1;

    			// Next, we need to check the pixels around [i][j] for black
    			// If we don't find any black pixels, advance numSeg by 1
    		}
    	}
    }
  }
}
