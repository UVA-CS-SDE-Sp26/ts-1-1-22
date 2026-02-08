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

    public static void runProgram(int arg1, String arg2) {
        if (arg1 > fh.getFileNamesSize()) throw new RuntimeException("Index out of bounds!");
        else if (arg1 < 0) throw new RuntimeException("Invalid index");
        String fileContent = fh.getFileContent(arg1); // TODO: validate
        if (arg2 == null) {
            try {
                Cipher c = new Cipher(null);
                c.decipher(fileContent);
            } catch (FileNotFoundException e) {
                System.out.println("Unexpected file");
                System.exit(1);
            }


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



