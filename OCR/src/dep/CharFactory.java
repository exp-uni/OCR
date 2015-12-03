package dep;

import java.util.ArrayList;

import OCR.Segment;

/**
 * @author Dennis and Chris
 * input - right side scanned glyph
 * output - a Character
 * 
 * How to Use - Create a new CharFactory using right scanned glyph
 * Call makeCharacter() to return the Character
 */


public class CharFactory {

	private ArrayList<SegmentData> segmentDatas;
	private int[][] glyph;
	private int START_X, START_Y, LEFTMOST, RIGHTMOST, STRAIGHT_PART_PREVIOUS, STRAIGHT_PART, END_X, END_Y;

	/**
	 * Takes in a right sided glyph
	 * @param glyph
	 */
	public CharFactory(int[][] glyph){
		segmentDatas = new ArrayList<SegmentData>();
		
		this.glyph = glyph;
		
	}
	/**
	 * Scans the glyph for segments and adds them to an array (segmentDatas)
	 * Uses segmentDatas to create an array of segments (segments)
	 * Stores the segments in a new Character
	 * @return a new Character with appropriate boolean values
	 */
	public Character makeCharacter(){
		Character toReturn = new Character();
		ArrayList<Segment> segments = new ArrayList<Segment>();
		scanCharacter();
		for(int i=0;i<segmentDatas.size();i++){
			segments.add(segmentDatas.get(i).getSegmentData(glyph.length, glyph[0].length));
		}
		for(int i=0; i<segments.size();i++){
			toReturn.addSegment(segments.get(i));
		}
		return toReturn;
	}
	
	/**
	 * Scans from top to bottom going left to right looking for a black pixel
	 * Each black pixel is a start of a segment.
	 * Call scanFrom() at this black pixel and find the entirety of the segment
	 * repeat, adding each segment to segmentDatas
	 */
	public void scanCharacter(){
		
		for(int i=0;i<glyph.length;i++){//length of the 2d array
			for(int j=0;j<glyph[i].length;j++){//height of the 2d array
				if(glyph[i][j]==0){//find a black pixel
					START_X = i;
					START_Y = j;
					LEFTMOST=i;
					RIGHTMOST=i;
					scanFrom(i,j);
					SegmentData thisSeg = new SegmentData(START_X, START_Y, LEFTMOST, RIGHTMOST, STRAIGHT_PART_PREVIOUS, STRAIGHT_PART, END_X, END_Y);
					if(END_X == START_X && END_Y == START_Y)
						resetData();
					else{
						segmentDatas.add(thisSeg);
						resetData();
						}
					}
				
			}
		}
	}
	private void resetData(){
		this.START_X = 0;
		this.START_Y = 0;
		this.LEFTMOST = 0;
		this.RIGHTMOST =0;
		this.STRAIGHT_PART_PREVIOUS = 0;
		this.STRAIGHT_PART = 0;
		this.END_X = 0;
		this.END_Y = 0;
	}
	//Takes the start pixel and finds the continuous segment
	private void scanFrom(int i, int j){
		if(glyph[i-1][j+1] == 0){//left 1, down 1
			STRAIGHT_PART = 0;
			LEFTMOST = i;
			scanFrom(i-1,j+1);
		}
		else if(glyph[i][j+1]==0){//down 1{
			STRAIGHT_PART++;
			if(STRAIGHT_PART>STRAIGHT_PART_PREVIOUS){
				STRAIGHT_PART_PREVIOUS= STRAIGHT_PART;
			}
			scanFrom(i,j+1);
		}
		else if(glyph[i+1][j+1]== 0){//right 1, down 1
			STRAIGHT_PART = 0;
			RIGHTMOST = i;
			scanFrom(i+1, j+1);
		}
		else{//NO PIXELS BELOW
			END_X=i;
			END_Y=j;
		}
		//set processed pixel to 2 MEANING ALREADY READ
		//unless it was a noise pixel
		if(END_X == START_X && END_Y == START_Y)
			glyph[i][j]=1;
		else
			glyph[i][j]=2;
	}
	
}
