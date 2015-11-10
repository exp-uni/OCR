package OCR;
import OCR.SegmentFactory;
import ../OCRX;


public class TestSegmentFactory{

    public static void main(String[] args){
        SegmentFactory tester = new SegmentFactory();
        // Don't see where SegmentData objects are made
        
        
        
        
        int[][] a = getTNRChar('a');
        for(int i : a){
            System.out.print(i);
        }
        
        //SegmentData test1 = new SegmentData();
    }

}