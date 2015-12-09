package OCR;

public class CharFactory {

	private static Character curChar;
	private static int[][] curGlyph;
	private static SegmentFactory segFact = new SegmentFactory();
	private static SegmentData curSegment;
	static int X = 0;
	static int Y = 1;
	
	
	//SEND GLPYHS TO THIS METHOD, RECIEVE UNKNOWN CHARACTER
	public static Character scan(int[][] glyph){
		curChar = new Character();
		curGlyph = glyph;
		int height = curGlyph.length;
		int width = curGlyph[0].length;
		segFact.SetHeight(height);
		segFact.SetWidth(width);
		int x,y;
		for(x=0; x <= height-2; x++){
			for(y=0;y <= width-1;y++){
				//System.out.println(y);
				if(curGlyph[x][y]==0 && checkNext(x,y)[0] != -1){//ugly, but basically ensures a segment was found rather than a single dot
					
					foundSegment(x,y);
				}
			}
			
		}
		
		
		
		return curChar;
		
	}
	
	private static void foundSegment(int x, int y){
		int[] next = {x,y};
		int[] prev = next;
		
		
		curSegment = new SegmentData(x,y);
		
		while(next[X] != -1){		
			if(prev[0]==curGlyph.length-1){
				next[X]=-1;
			}
			else{
				next = checkNext(next[X],next[Y]);
				if(next[0] !=-1){
					proccessNext(next, prev[Y]);
					prev=next;
					flip(prev[0],prev[1]);
				}
					
			}
			
		}
		curSegment.end(prev[X],prev[Y]);
		curChar.addSegment(segFact.buildSegment(curSegment));
		
	}
	
	private static void flip(int x, int y){
		curGlyph[x][y]=2;
	}

	
	private static void proccessNext(int[] next, int prevY) {
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

	private static int[] checkNext(int x, int y){
		
		//x+1
		
		//y-1
		//y-0
		//y+1
		
		int limit = y+1;
		int start = y-1;
		
		if(y==segFact.getWidth()-1){
			limit = y; 
		}
		if(y==0){
			start = y;
		}
		
		int i, j;
		i = x+1;
		for(j = start;j<=limit;j++){
			//System.out.println("x: "+ i +"y: "+j);
			if(curGlyph[i][j] == 0){
				return(new int[]{i,j});
			}
		}
		return(new int[]{-1});
	}
	
	  private static void output(int[][] glyph){
		  String nums;
	      for(int[] row : glyph){
	    	  nums = "";
	    	  for(int num : row){
	    		 nums = nums + num;
	    	  }
	    	  System.out.println(nums);
	      }
	  }
	
	
	
}
