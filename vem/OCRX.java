import java.io.*;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.lang.*;
import java.awt.image.*;
import javax.imageio.*;
import java.net.*;
import java.util.*;
import java.lang.reflect.*;
//import OCR.*;

/**
 * The main program for the chart reading project.
 * Modified for experimenting with OCR algortithms.
 * It calls methods of the <code>BWImageG</code> class.
 * 
 */

public class OCRX {


	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex+1);
	}
	
	// helper method for getTNRChar()
	public static List<String> readFileInTNR(String chara) throws Exception {
		String line = null;
		List<String> records = new ArrayList<String>();
		
		// need to change the directory for your machine.  This could probably be changed to be universal.
		BufferedReader bufferedReader = new BufferedReader(new FileReader("/E:/GitHub/OCR/tnr/" + chara + ".txt"));
		
		while((line = bufferedReader.readLine()) != null) {
			records.add(line);
		}
		
		bufferedReader.close();
		return records;
	}
	
	// takes a character, reads the Times New Roman .txt representation of that character, 
	// and returns a corresponding 2D array of 0's and 1's
	public static int [][] getTNRChar(String chara) throws Exception {
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
	
	public static void main(String args[]) throws Exception { 
		OCRX app = new OCRX();
        BWImageG image;
		//OCR ocr = new OCR();
        URL u = new URL(args[0]);
        BufferedImage jImage = ImageIO.read(u);
		image = new BWImageG();
        image.loadJavaImage(jImage);
		image.filterImage();
		int numImageRows = image.getImageHeight();
		int numImageColumns = image.getImageWidth();
        image.labelImage();
        //System.out.println("Labelled.\n\n");
        image.findBorders();
        //System.out.println("Bordered.\n\n");
        image.findCharacters();
		// OCR stuff goes here.
        Scanner in = new Scanner(System.in);
				
		PrintWriter writer = new PrintWriter("blob_reps.txt", "UTF-8");
				
		boolean keepRunning = true;
        while(keepRunning) {
            System.out.println("which blob number?");
            int i = in.nextInt();
			if (i == 0) keepRunning = false;
            if (i < 1 || i >= image.getBlobCount()) continue;
            int [][] blob = image.getBlobImage(i);
            int hi = Array.getLength(blob);
            int wi = Array.getLength(blob[0]);
			//char character = ocr.getChar(blob);
            image.save("blob.pgm",blob,hi,wi);
            for (int r = 0;r < hi;r++) {
                for (int c = 0; c < wi; c++) {
					if (blob[r][c] == 0) {
						System.out.print("X");
						writer.print("X");
					}
                    else {
						System.out.print(".");
						writer.print(".");
					}
                }
            System.out.println();
			writer.println();
            }   
			writer.println();
        }
		
		// demonstrates reading a .txt file into a int[][] 
		int [][] glyph = getTNRChar("a");
		for(int i = 0; i < Array.getLength(glyph); i++) {
			for(int j = 0; j < Array.getLength(glyph[i]); j++) {
				System.out.print(glyph[i][j]);
			}
			System.out.println();
		}

        //System.out.println("Found characters.\n\n");
        //image.thinThickLines();
        //System.out.println("Thinned.\n\n");
        //image.segmentBorders();
        //System.out.println("Found chains.\n\n");
        //image.fitLines();
        //System.out.println("Fit lines.\n\n");
        //image.findRectangles(image);
        //System.out.println("Found rectangles.\n\n");
        //image.findBars();
        //System.out.println("Found bars");
        //simpleOCR.loadFonts();
        //image.findWords();
        //image.findCoordinateAxes(image);
        //System.out.println("Found axes.\n\n");
        //image.findWedges();
        //System.out.println("Found wedges.\n\n");
        //image.findConnectedLines();
        //System.out.println("Found connected line.\n\n");
        //int i = args[0].lastIndexOf('/');
        //String filename = args[0].substring(i);
        //i = filename.lastIndexOf('.');
        //filename = filename.substring(1,i) + "-vision.xml";
        //System.out.println(filename);
        //image.displaySummary(filename);
        //System.out.println("Displayed summary.\n\n");
		//System.exit(0);
		writer.close();
	}	
}

