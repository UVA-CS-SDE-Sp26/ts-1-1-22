import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {
    private FileHandler fileHandler;
    @BeforeEach
    void setUp() throws IOException {
        fileHandler = new FileHandler();
    }

    @Test
    void getFileNames() {
        String firstName = fileHandler.getFileNames(0);
        assertEquals("Data/test.txt", firstName);
    }

    @Test
    void getFileContent() {
        String expected ="Reading is one of the most valuable skills a person can develop. It opens the door to knowledge, imagination, and personal growth. Unlike other forms of entertainment, reading engages the mind, encourages critical thinking, and allows people to explore ideas beyond their own experiences. Whether through books, articles, or online resources, reading is a key tool for lifelong learning.\n";
        String actual = fileHandler.getFileContent(0);
        assertEquals(expected, actual);
    }

    @Test
    void getContentsSize() {
        int expected = 1;
        int actual = fileHandler.getContentsSize();
        assertEquals(expected, actual);
    }
}