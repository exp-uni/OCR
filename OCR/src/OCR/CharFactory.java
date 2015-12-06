package OCR;

public class CharFactory {

	private Character curChar;
	private int[][] curGlyph;
	private SegmentFactory segFact = new SegmentFactory();
	private SegmentData curSegment;
	int X = 0;
	int Y = 1;
	
	
	//SEND GLPYHS TO THIS METHOD, RECIEVE UNKNOWN CHARACTER
	public Character scan(int[][] glyph){
		curChar = new Character();
		int height = glyph.length;
		int width = glyph[0].length;
		segFact.SetHeight(height);
		segFact.SetWidth(width);
		int x,y;
		for(x=0; x < height; x++){
			for(y=0;y < width;y++){
				if(glyph[x][y]==0 && checkNext(x,y)[0] != -1){//ugly, but basically ensures a segment was found rather than a single dot
					foundSegment(x,y);
				}
			}
			
		}
		
		
		
		return curChar;
		
	}
	
	public void foundSegment(int x, int y){
		int[] next = {1};
		int[] prev = {x,y};
		
		
		curSegment = new SegmentData(x,y);
		
		while(next[X] != -1){		
			next = checkNext(next[X],next[Y]);
			proccessNext(next, prev[Y]);
			prev=next;
		}
		curSegment.end(prev[X],prev[Y]);
		
		curChar.addSegment(segFact.buildSegment(curSegment));
		
	}

	
	private void proccessNext(int[] next, int prevY) {
		//basically just do the algorithm stuff here.
		
		/*
		 * woohoo switches
		 * We use a switch here because the difference between the Y and its 
		 * previous decides whether or not we have to do certain checks i.e. its pointless
		 * to just check all of the rightmost leftmost every time and I don't like elifs
		 */
		switch(next[Y] - prevY){
			case -1:
				//prevY>next[y]
				if(next[Y]>curSegment.RIGHTMOST){
					curSegment.RIGHTMOST=next[Y];;
				}
				break;
			case 0:
				//prevY==next[y]
				curSegment.STRAIGHT_PART++;
				if(curSegment.STRAIGHT_PART>curSegment.STRAIGHT_PART_PREVIOUS){
					curSegment.STRAIGHT_PART_PREVIOUS = curSegment.STRAIGHT_PART;
					
				}
				break;
			case 1:
				//prevY<next[y]
				if(next[Y]<curSegment.LEFTMOST){
					curSegment.LEFTMOST=next[Y];
				}
				break;
		}

	}

	public int[] checkNext(int x, int y){
		
		//x+1
		
		//y-1
		//y-0
		//y+1
		int i, j;
		i = x+1;
		for(j = y-1;j<=y+1;j++){
			if(curGlyph[i][j]==0){
				return(new int[]{i,j});
			}
		}
		return(new int[]{-1});
	}
	
	
	
}
