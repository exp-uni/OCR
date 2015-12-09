package OCR;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import OCR.*;


/*
This class will test the other files in the OCR package, and may also be used to insert
new letters into the database. It should be able to send 2d matrices to the different
parts of the package

*/
public class TestMain{
  public static void main(String[] args){
	ArrayList<int[]> character = new ArrayList<int[]>();
	try {
		BufferedReader br = new BufferedReader(new FileReader("/Users/nicholasgerassimakis/git/OCR/tnrcaps/a.txt"));
		String line;
		int row = 0;
		while ((line = br.readLine()) != null){
			//System.out.print(line + '\n');
			character.add(new int[line.length()]);
			for (int i = 0; i < line.length(); i++){
				if (line.charAt(i) == '.'){
					character.get(row)[i] = 1;
				}
				else{
					character.get(row)[i] = 0;
				}
			}
			row++;
		}
	} 
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	  
	  int[][] tester1 = {{0,1,1,1,1,0,0,0},
			  {0,1,1,0,1,1,1,0},
			  {1,0,1,0,1,1,1,0},
			  {1,1,1,0,1,0,0,0},
			  {1,1,1,0,1,0,0,0},
			  {1,1,0,1,1,1,0,0},
			  {1,0,1,1,1,0,1,0},
			  {1,1,1,1,1,0,0,0},
			  {1,1,1,1,1,0,0,0},
			  {1,1,1,1,1,0,0,0}};
	  int[][] testglyph = RightProcessor.process(tester1);
	  

	  	
	  
	  Character testchar = CharFactory.scan(testglyph);
	  testchar.output();
	 /* 
	  Segment segTest0 = new Segment();
	  System.out.println(segTest0.toString());
	  
	  Segment segTest1 = new Segment(true, false, true, false, true, false, true);
	  System.out.println(segTest1.toString());
	  */
  }

}
