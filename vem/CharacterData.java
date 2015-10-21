import java.util.ArrayList;

public class CharacterData {

	private ArrayList<SegmentData> segmentDatas;
	private int[][] character;
	private int START_X, START_Y, LEFTMOST,RIGHTMOST,STRAIGHT_PART_PREVIOUS,STRAIGHT_PART, END_X,END_Y;

	//Creating a Character Data automatically
	//scans and fills segmentDatas with data
	public CharacterData(int[][] character){
		segmentDatas = new ArrayList<SegmentData>();
		this.character = character;
		resetData();
		scanCharacter();
	}

	public ArrayList<SegmentData> getCharacterData(){
		return segmentDatas;
	}

	public void addSegmentData(SegmentData s){
		segmentDatas.add(s);
	}

	public void scanCharacter(){
		int a,b,c;//Pixels above current pixel
		int d,e,f;//Pixels below current pixel
		for(int i=0;i<character.length;i++){//length of the 2d array
			for(int j=0;j<character[i].length;j++){//height of the 2d array
				if(character[i][j]==0){//find a black pixel
					START_X = i;
					START_Y = j;
					LEFTMOST=i;
					RIGHTMOST=i;
					scanFrom(i,j);
					SegmentData thisSeg = new SegmentData(START_X, START_Y, LEFTMOST,RIGHTMOST,STRAIGHT_PART_PREVIOUS,STRAIGHT_PART, END_X,END_Y);
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
		if(character[i-1][j+1] == 0){//left 1, down 1
			STRAIGHT_PART = 0;
			LEFTMOST = i;
			scanFrom(i-1,j+1);
		}
		else if(character[i][j+1]==0){//down 1{
			STRAIGHT_PART++;
			if(STRAIGHT_PART>STRAIGHT_PART_PREVIOUS){
				STRAIGHT_PART_PREVIOUS= STRAIGHT_PART;
			}
			scanFrom(i,j+1);
		}
		else if(character[i+1][j+1]== 0){//right 1, down 1
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
			character[i][j]=1;
		else
			character[i][j]=2;
	}
	
	//Return the number at the requested location. If outOfBounds, assume white(1);
	private int setLetter(int i, int j){
		if(i>=0 && i<character.length)
			if(j>=0 && j<character[0].length)
				return character[i][j];
			else return 1;
		else return 1;
	}

	/*a=setLetter(i-1,j-1);
	b=setLetter(i,j-1);
	c=setLetter(i+1,j-1);
	d=setLetter(i-1,j+1);
	e=setLetter(i,j+1);
	f=setLetter(i+1,j+1);*/
}