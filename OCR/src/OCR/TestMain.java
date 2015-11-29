package OCR;
import OCR.*;


/*
This class will test the other files in the OCR package, and may also be used to insert
new letters into the database. It should be able to send 2d matrices to the different
parts of the package

*/
public class TestMain{
  public static void main(String[] args){
	  
	  RightProcessor test = new RightProcessor();
		
		int[][] tester1 =  {{1, 1, 1, 0, 0, 0},
    			{1, 0, 1, 1, 1, 0},
    			{1, 0, 1, 1, 1, 0},
    			{1, 0, 1, 0, 0, 0}};
		test.process(tester1);

  }
}