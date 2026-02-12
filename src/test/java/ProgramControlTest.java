import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramControlTest {
    private ProgramControl pc;
    @Test
    void noArgs() {
        assertEquals("", ProgramControl.runProgram(-1, null));
    }
    @Test
    void oneArg() {
        assertEquals("", ProgramControl.runProgram(1, null));
    }

    @Test
    void twoArg() {
        assertEquals("", ProgramControl.runProgram(1, ""));
    }
}
