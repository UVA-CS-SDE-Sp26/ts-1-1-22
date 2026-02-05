import java.utils.Arraylist;
import java.utils.StringBuilder;
import java.utils.HashMap;
/*
these will be marked by numbers
and the related indexing will be
corresponidng to the file inputted in order
 */
class Parser {
    private String fileName;
    private String contents;
    private ArrayList<String fileName> fileNames;
    private ArrayList<String content> contents;

    public Parser() {
        putFilesInArray(String dataName);
        readAndParseFiles();
    }

    public getFileContent(int indexNum) {
        return contents[indexNum];
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

    private void putFilesInArray(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                fileNames.add(listFilesForFolder(fileEntry));
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }
}