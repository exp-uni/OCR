import java.lang.reflect.Array;

public class OCR{
    RightProcessor rightscan;
    SegmentScan segmentScan;
    
    
    /*
     For now this class will just hold the different processed stuff (pass it in through the main method maybe?)
     Eventually it will load up a premade dictionary of segment pieces.
     
     */
    OCR(){
        rightscan = new RightProcessor();
        segmentScan = new SegmentScan();
    }
    
    public char getCharacter(int[][] glyph){
        int he = Array.getLength(glyph); //height of image
        int wi = Array.getLength(glyph[0]); // width of image
        
        return('a');
    }
    
    
    // helper method for getTNRChar()
    public static List<String> readFileInTNR(String chara) throws Exception {
        String line = null;
        List<String> records = new ArrayList<String>();
        
        // need to change the directory for your machine.  This could probably be changed to be universal.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/nicholasgerassimakis/Desktop/OCR/OCR/tnr/" + chara + ".txt"));
        
        while((line = bufferedReader.readLine()) != null) {
            records.add(line);
        }
        
        bufferedReader.close();
        return records;
    }
    
    // takes a character, reads the Times New Roman .txt representation of that character,
    // and returns a corresponding 2D array of 0's and 1's
    public static int [][] getTNRChar(char chara) throws Exception {
        List<String> records = readFileInTNR(chara);
        
        int [][] returnGlyph = new int [records.size()][Array.getLength(records.get(0).toCharArray())];
        
        char[] tempCharArray;
        for(int i = 0; i < records.size(); i++) {
            tempCharArray = records.get(i).toCharArray();
            for(int j = 0; j < Array.getLength(tempCharArray); j++) {
                if(tempCharArray[j] == '.') returnGlyph[i][j] = 1;
                else returnGlyph[i][j] = 0;
            }
        }
        
        return returnGlyph;
    }
    
    
}