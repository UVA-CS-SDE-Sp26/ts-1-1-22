import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;



public class ProgramControlTest {

    private ProgramControl pc;
    @Test
    void noArgs() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> ProgramControl.runProgram(-1, null));
        assertEquals("Invalid file number.", e.getMessage());
    }
    @Test
    void oneArg() {
        // Will be false if an exception is thrown, and exceptions are thrown if there are problems
        assertFalse(ProgramControl.runProgram(1, null).isEmpty());
    }

    @Test
    void twoArg() {
        // I'm using the absolute path to the default key, since it will always be there.
        // Still tests whether the second argument works.
        assertFalse(ProgramControl.runProgram(1, "ciphers/key.txt").isEmpty());
    }

    @Test
    void listFiles() {
        assertTrue(ProgramControl.printFileList().contains("\n"));
    }

}
