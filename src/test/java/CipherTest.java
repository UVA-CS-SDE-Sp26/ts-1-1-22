import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class CipherTest {

    // Helper method to create temporary cipher files
    private void createFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    // ===============================
    // CONSTRUCTOR TESTS
    // ===============================

    @Test
    public void testValidCipherFile() throws Exception {
        createFile("valid.txt",
                "abc\n" +
                        "def");

        Cipher cipher = new Cipher("valid.txt");
        assertNotNull(cipher);
    }

    @Test
    public void testFileNotFound() {
        assertThrows(FileNotFoundException.class, () -> {
            new Cipher("doesnotexist.txt");
        });
    }

    @Test
    public void testMissingSecondLine() throws Exception {
        createFile("missingSecond.txt",
                "abc");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("missingSecond.txt");
        });
    }

    @Test
    public void testExtraLines() throws Exception {
        createFile("extraLines.txt",
                "abc\n" +
                        "def\n" +
                        "ghi");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("extraLines.txt");
        });
    }

    @Test
    public void testDifferentLengthLines() throws Exception {
        createFile("differentLength.txt",
                "abcd\n" +
                        "xyz");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("differentLength.txt");
        });
    }

    @Test
    public void testDuplicateInOriginal() throws Exception {
        createFile("duplicateOriginal.txt",
                "aabc\n" +
                        "wxyz");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("duplicateOriginal.txt");
        });
    }

    @Test
    public void testDuplicateInCipher() throws Exception {
        createFile("duplicateCipher.txt",
                "abcd\n" +
                        "wwxy");

        assertThrows(IllegalArgumentException.class, () -> {
            new Cipher("duplicateCipher.txt");
        });
    }

    // ===============================
    // DECIPHER TESTS
    // ===============================

    @Test
    public void testDecipherBasic() throws Exception {
        createFile("basic.txt",
                "abc\n" +
                        "xyz");

        Cipher cipher = new Cipher("basic.txt");

        String result = cipher.decipher("xyz");
        assertEquals("abc", result);
    }

    @Test
    public void testDecipherWithUnmappedCharacters() throws Exception {
        createFile("partial.txt",
                "abc\n" +
                        "xyz");

        Cipher cipher = new Cipher("partial.txt");

        String result = cipher.decipher("xyz!");
        assertEquals("abc!", result);
    }

    @Test
    public void testDecipherEmptyString() throws Exception {
        createFile("empty.txt",
                "abc\n" +
                        "xyz");

        Cipher cipher = new Cipher("empty.txt");

        String result = cipher.decipher("");
        assertEquals("", result);
    }
}