package OCR;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestRightProcessor{

	@Test
	public void RightProcessorTests(){
		RightProcessor test = new RightProcessor();
		
		int[][] tester1 = {{1, 1, 1, 0, 0, 0},
                		{1, 1, 1, 1, 1, 0},
                		{1, 1, 1, 1, 1, 0},
                		{1, 1, 1, 0, 0, 0}};

		int[][] solution1 = {{1, 1, 1, 1, 1, 0},
                  		{1, 1, 1, 1, 1, 0},
                  		{1, 1, 1, 1, 1, 0},
                  		{1, 1, 1, 1, 1, 0}};
		
		try{
			
			assertEquals(test.process(tester1), solution1);
		}
		catch(Exception e){
			fail();
			System.out.println(e.getLocalizedMessage());
		}
	}

}
