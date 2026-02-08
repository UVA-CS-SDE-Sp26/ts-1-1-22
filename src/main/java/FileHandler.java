import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
This module will contain the File Handler object which works when this object is
called and taking a argument "data directory". By default it will take the parameter
and call its private function, putFileInArray, which takes the directory name and
create a file object in order to store those names. Then proceeding the file type array
it will put each element inside the parser.contents array list storing the string value.
Immediately after it will call readAndParseFiles which will for the size of the ArrayList
and it will call a local string builder and continuously add lines of each .txt file
and concatenate it in the StringBuilder object. Once it reaches the end of a .txt file
it will add it to the contents. Contents will be sorted in order in which ever order
 it is in the Data folder.
 */
class FileHandler {
    private ArrayList<String> fileNames;
    private ArrayList<String> contents;

    public FileHandler(String data) throws IOException {
        fileNames = new ArrayList<>();
        contents = new ArrayList<>();
        putFilesInArray(new File("Data"));
        readAndParseFiles();
    }

    public int getContentsSize() {
        return contents.size();
    }

    public int getFileNamesSize() {
        return fileNames.size();
    }

    public String getFileNames(int indexNum) {
        if(indexNum >= 0 && indexNum < fileNames.size()) {
            return fileNames.get(indexNum);
        }
        return null;
    }

    public String getFileContent(int indexNum) {
        if(indexNum >= 0 && indexNum < contents.size()) {
            return contents.get(indexNum);
        }
        return null;
    }

    //package privates
    void readAndParseFiles() throws IOException {
        for(int i = 0; i < fileNames.size(); i++) {
            BufferedReader br = new BufferedReader(new FileReader(fileNames.get(i))); // Fixed: get(i)
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                this.contents.add(sb.toString());
            } finally {
                br.close();
            }
        }
    }

    void putFilesInArray(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (final File fileEntry : files) {
                    if (fileEntry.isDirectory()) {
                        putFilesInArray(fileEntry);
                    } else {
                        fileNames.add(fileEntry.getAbsolutePath());
                        System.out.println("Found file: " + fileEntry.getName());
                    }
                }
            }
        }
    }
}