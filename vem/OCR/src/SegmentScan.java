public class Coord{
	public int x;
	public int y;

	// constructor
	Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SegmentScan{
  
  SegmentScan(int [][] rightGlyph){
  
  // a double array of coords used to store segment data
  Coord [][] segments; 

  // number of segments found
  int numSeg = Array.getLength(segments);
  // number of coords in current segment
  int numCoords = Array.getLength(segments[0]);

  int hi = Array.getLength(glyph);
  int wi = Array.getLength(glyph[0]);

  Coord tempCoord = new Coord(0,0);

 	// iterate through rightGlyph looking for segment data
    for(int i = 0; i < hi; i++) {
    	for(int j = 0; j < wi; j++) {
    		// found a black pixel
    		if(rightGlyph[i,j] == 0) {
    			// make a new coord
    			Coord tempCoord = new Coord(i, j);
    			// update numSeg and numCoords
    			numSeg = Array.getLength(segments);
    			numCoords = Array.getLength(segments[0]);
    			// add tempCoord to 2d segments array
    			segments[numSeg][numCoords] = tempCoord;

    			// set rightGlyph[i][j] to a white pixel, so we don't process it twice
    			rightGlyph[i][j] = 1;

    			// Next, we need to check the pixels around [i][j] for black
    			// If we don't find any black pixels, advance numSeg by 1
    		}
    	}
    }
  }
}
