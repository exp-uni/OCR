package OCR;

public class CharFactory {

	private Character curChar;
	private int[][] curGlyph;
	private SegmentData curSegment;
	
	
	
	//SEND GLPYHS TO THIS METHOD, RECIEVE UNKNOWN CHARACTER
	public Character scan(int[][] glyph){
		curChar = new Character();
		int x,y;
		for(x=0;x<glyph.length;x++){
			for(y=0;y<glyph[0].length;y++){
				if(glyph[x][y]==0 && checkNext(x,y)[0] != -1){//ugly, but basically ensures a segment was found rather than a single dot
					foundSegment(x,y);
				}
			}
			
		}
		
		
		
		return curChar;
		
	}
	
	public void foundSegment(int x, int y){
		curSegment = new SegmentData();
		curSegment.START_X = x;
		curSegment.START_Y = y;
		int[] next = checkNext(x,y);
		while(next[0] != -1){		
			next = checkNext(next[0],next[1]);
			proccessNext(next);
		}
	}
	
	private void proccessNext(int[] next) {
		//basically just do the algorithm stuff here.
		
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
