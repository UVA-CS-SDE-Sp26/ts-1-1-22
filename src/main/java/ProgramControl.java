import java.io.FileNotFoundException;
import java.io.IOException;

// Connects all the functions together
public class ProgramControl {
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ProgramControl() {
    }

    public static String runProgram(int arg1, String arg2) {
        if (arg1 > fh.getFileNamesSize() || arg1 < 0) {
            System.out.println("Invalid file number.");
            System.exit(1);
        }

        String fileContent = fh.getFileContent(arg1);
        if (fileContent == null) {
            throw new RuntimeException("File is null.");
        }
        if (arg2 == null) {
            // Default key for the cipher
            try {
                Cipher c = new Cipher(null);
                return c.decipher(fileContent);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Unexpected file.");
            }


        }
        else {
            try {
                // call cipher with arg2 key
                Cipher c = new Cipher(arg2);
                return c.decipher(fileContent);
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Unexpected file.");
            }
        }
    }

    public static void printFileList() {
        for (int i = 0; i < fh.getFileNamesSize(); i++) {
            System.out.println((i + 1) + ": " + fh.getFileNames(i));
        }
    }
}



