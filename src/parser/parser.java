import java.utils.Arraylist;
import java.utils.StringBuilder;
import java.utils.HashMap;
/*
these will be marked by numbers
and the related indexing will be
corresponidng to the file inputted in order
 */
class Parser {
    private ArrayList<String fileName> fileNames;
    private ArrayList<String content> contents;

    public Parser() {
        putFilesInArray(String dataName); //put data directory here
        readAndParseFiles();
    }

    public getFileContent(int indexNum) {
        return contents.get(indexNum);
    }

    //privates
    private void readAndParseFiles() {
        for(String fileName : filesNames) {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                    line = br.readLine();
                }
                String everything = sb.toString();
                this.contents = everything;
            } finally {
                br.close();
            }
        }
    }

    private void putFilesInArray(String directory) {
        for (final File fileEntry : directory.listFiles()) {
            if (fileEntry.isDirectory()) {
                fileNames.add(listFilesForFolder(fileEntry));
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}