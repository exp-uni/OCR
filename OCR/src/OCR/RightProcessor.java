package OCR;
import java.lang.reflect.Array;

public class RightProcessor{

  int[][] process(int [][] glyph){
      
      int hi = Array.getLength(glyph);
      int wi = Array.getLength(glyph[0]);
      int [][] returnGlyph = new int[hi][wi];
      int i;
      int j;
      // initialize return matrix
      for(i = 0; i < hi; i++) {
        for(j = 0; j < wi; j++) {
            returnGlyph[i][j] = 1;
        }
      }
      //output(returnGlyph);

      // change right edges to black pixels
      
      
      for(i = 0; i < hi; i++) {
        for(j = 0; j < wi; j++) {
            // found a black pixel
            if(glyph[i][j] == 0) {
                // j+1 within bounds

                if(j+1 < wi) {
                    // pixel immediately right of black pixel is white,
                    // so make returnGlyph[i][j] a right edge
                    if(glyph[i][j+1] == 1){
                    	returnGlyph[i][j] = 0;
                    }
                }
                else{
                	returnGlyph[i][j] = 0;
                }
               
            }
            // if j+1 is off the screen, make returnGlyph[i][j] a right edge
            
        }
        
      }
      output(returnGlyph);
      	//System.out.println();
      return returnGlyph;
  }
  
  private void output(int[][] glyph){
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
