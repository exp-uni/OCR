#Important Classes

OCR: Main class

RightProcessor: Processes the original black and white image

CharFactory: Processes the right-edge version of the image

TestMain: Used for testing OCR package

#Other Files

arialcaps: The set of matrices obtained by running OCRX on a capitalized 'Arial' alphabet 

couriernewcaps: The set of matrices obtained by running OCRX on a capitalized 'Courier New' alphabet 

tnrcaps: The set of matrices obtained by running OCRX on a capitalized 'Times New Roman' alphabet 

#Usage

// read in a 2D glyph from one of the .txt files in tnrcaps 
// (can be easily modified to read from the other font directories)
int [][] glyph = getTNRChar('a');

// right-edge process a 2D matrix corresponding to a 'character mapping'
glyph = RightProcessor.process(glyph);

// examine a right-edge glyph and extract its segment data
Character glyphChar = CharFactory.scan(glyph);

// print out segment data
glyphChar.output();

#To Do

Create a database of Character entries corresponding to each letter in the alphabet.
Devise a method to map a list of segment objects in a given Character to a Character in the database.

The simplest implementation would be bruteforcing your way through the database, saving a 'score'
for each Character based on how many segment objects match your given Characters segment objects.
The highest scored Character in the database would be the closest matching character to your given
Character object.

A more complex implementation may involve a HashTable, with a hash function using the segment
data in its computation.

#Issues with OCRX

The given OCRX algorithm doesn't correctly identify certain characters.  The ones we couldn't get it to
identify were 'S' in Times New Roman, 'J', 'M', 'S' in Arial, and 'J', 'S' in Courier New.  There is also
the issue of 'j' and 'i' being ID'd incorrectly, as OCRX sees the dots as seperate blobs to the main part
of the character image.  This is why we worked with capital letters in our implementation of the OCR algorithm,
but it needs to be addressed in the future.