package OCR;




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.matchers.JUnitMatchers.both;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.junit.matchers.JUnitMatchers.everyItem;
import static org.junit.matchers.JUnitMatchers.hasItems;

import java.util.Arrays;






import org.junit.Test;


public class TestRightProcessor{

	@SuppressWarnings("deprecation")
	@Test
	public void RightProcessorTests(){
		
		RightProcessor test = new RightProcessor();
		
		int[][] tester1 = {{1, 1, 1, 0, 0, 0},
                			{1, 0, 1, 1, 1, 0},
                			{1, 0, 1, 1, 1, 0},
                			{1, 0, 1, 0, 0, 0}};

		int[][] solution1 = {{1, 1, 1, 1, 1, 0},
                  			{1, 0, 1, 1, 1, 0},
                  			{1, 0, 1, 1, 1, 0},
                  			{1, 0, 1, 1, 1, 0}};
		
		try{
			
			assertEquals(test.process(tester1), solution1);
		}
		catch(Exception e){
			//fail();
			System.out.println(e.getLocalizedMessage());
		}
		
		
		int[][] tester2 = {{1, 1, 1, 0, 0, 1},
        		{1, 1, 1, 1, 0, 1},
        		{1, 1, 1, 1, 0, 1},
        		{1, 1, 1, 0, 0, 1}};

		int[][] solution2 = {{1, 1, 1, 1, 0, 1},
		          			{1, 1, 1, 1, 0, 1},
		          			{1, 1, 1, 1, 0, 1},
		          			{1, 1, 1, 1, 0, 1}};
		
		try{
			
			assertEquals(test.process(tester2), solution2);
			
		}
		catch(Exception e){
			//fail();
			System.out.println(e.getLocalizedMessage());
		}
				
	}

}
