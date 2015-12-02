package OCR;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class OCR {
    /*RightProcessor rightscan;
    SegmentScan segmentScan;*/

    /*
     For now this class will just hold the different processed stuff (pass it in through the main method maybe?)
     Eventually it will load up a premade dictionary of segment pieces. 
     */
     
    /*OCR(){
        rightscan = new RightProcessor();
        segmentScan = new SegmentScan();
    }
    
    public char getCharacter(int[][] glyph){
        int he = Array.getLength(glyph); //height of image
        int wi = Array.getLength(glyph[0]); // width of image
        
        return('a');
    }
    */

    //helper method for getTNRChar()
    public static ArrayList<String> readFileInTNR(char chara) throws Exception {
        try {

            String line = null;
            ArrayList<String> records = new ArrayList<String>();
        
            BufferedReader bufferedReader = new BufferedReader(new FileReader("tnr/" + chara + ".txt"));
        
            while((line = bufferedReader.readLine()) != null) {
                records.add(line);
            }
        
            bufferedReader.close();
            return records;
        }

        catch(Exception e) {
            throw(e);
        }
    }

    //takes a character, reads the Times New Roman .txt representation of that character,
    //and returns a corresponding 2D array of 0's and 1's
    public static int [][] getTNRChar(char chara) throws Exception {
        try {
            ArrayList<String> records = readFileInTNR(chara);
        
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

        catch(Exception e) {
            throw(e);
        }
    }

    // accepts a character from user input and creates a matrix from that character's
    // text file in /tnr.  Prints out the matrix.  Can be used for 'training' our algorithm.
    public static void main(String[] args) throws Exception {

        while(true) {
            int [][] g1;

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a character: ");

            char c = scanner.next().charAt(0);            

            try { 
                g1 = getTNRChar(c);
                for(int i = 0; i < Array.getLength(g1); i++){
                    for(int j = 0; j < Array.getLength(g1[i]); j++) {
                        System.out.print(g1[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();

                g1 = RightProcessor.process(g1);
                for(int i = 0; i < Array.getLength(g1); i++){
                    for(int j = 0; j < Array.getLength(g1[i]); j++) {
                        System.out.print(g1[i][j]);
                    }
                    System.out.println();
                }
                System.out.println();

            }

            catch(Exception e) {
                System.out.println("Input is not a character.");
                throw(e);
            }
        }
    }
    
}