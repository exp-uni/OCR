package OCR;
import OCR.*;


/*
This class will test the other files in the OCR package, and may also be used to insert
new letters into the database. It should be able to send 2d matrices to the different
parts of the package

*/
public class TestMain{
  public static void main(String[] args){

	  
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
