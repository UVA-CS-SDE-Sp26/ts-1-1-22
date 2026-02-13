import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopSecretTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() { System.setOut(originalOut); }

    private String runMain(String... args) {
        TopSecret.main(args);
        return outContent.toString().trim();
    }

    @Test
    void whenNoArguments_thenPrintNoFileMessageAndListFiles() {
        String output = runMain();
        assertTrue(output.startsWith("No file selected."), "Should start with the 'No file selected.' message");
        assertTrue(output.contains("\n"), "There should be a second line printed by ProgramControl.printFileList()");
    }

    @Test
    void whenArgumentIsNotANumber_thenShowParseError() {
        String output = runMain("abc");
        assertEquals("Error parsing file number.", output);
    }

    @Test
    void whenTooManyArguments_thenShowErrorMessage() {
        String output = runMain("1", "key", "extra");
        assertEquals("Error: Too many arguments.", output);
    }
}