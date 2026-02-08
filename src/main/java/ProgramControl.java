import java.io.FileNotFoundException;
import java.io.IOException;

// Connects all the functions together
public class ProgramControl {
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("SDE!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ProgramControl() {
    }

    public static void runProgram(int arg1, String arg2) throws FileNotFoundException {
        if (arg1 > fh.getFileNamesSize()) throw new RuntimeException("Index out of bounds!");
        String fileContent = fh.getFileContent(arg1); // TODO: validate
        if (arg2 == null) {
            Cipher c = new Cipher(null);
            c.decipher(fileContent);
        }
        else {
            // call cipher with arg2 key
        }
    }

    public static void printFileList() {
        for (int i = 0; i < fh.getFileNamesSize(); i++) {
            System.out.println((i + 1) + ": " + fh.getFileNames(i));
        }
    }
}



