import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
these will be marked by numbers
and the related indexing will be
corresponidng to the file inputted in order
 */
class FileHandler {
    private ArrayList<String> fileNames;
    private ArrayList<String> contents;

    public FileHandler() throws IOException {
        fileNames = new ArrayList<>();
        contents = new ArrayList<>();
        putFilesInArray(new File("data"));
        readAndParseFiles();
    }

    public String getFileContent(int indexNum) {
        if(indexNum >= 0 && indexNum < contents.size()) {
            return contents.get(indexNum);
        }
        return null;
    }

    //privates
    private void readAndParseFiles() throws IOException {
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

    private void putFilesInArray(File directory) {
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