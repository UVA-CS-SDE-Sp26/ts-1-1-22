# File Handler

This module will contain the File Handler object which works when this object is called and taking a argument "data directory". By default it will take the parameter and call its private function, putFileInArray, which takes the directory name and create a file object in order to store those names. Then proceeding the file type array it will put each element inside the parser.contents array list storing the string value. Immediately after it will call readAndParseFiles which will for the size of the ArrayList and it will call a local string builder and continuously add lines of each .txt file and concatenate it in the StringBuilder object. Once it reaches the end of a .txt file it will add it to the contents. Contents will be sorted in order in which ever order it is in the Data folder.


## UML

Parser