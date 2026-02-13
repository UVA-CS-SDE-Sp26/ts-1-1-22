import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cipher {

    private char[] originalChars;
    private char[] cipherChars;

    public Cipher() throws FileNotFoundException {
        this(null);
    }

    public Cipher(String file) throws FileNotFoundException {

        File cipherFile;

        if (file == null || file.isEmpty()) {
            cipherFile = new File("ciphers/key.txt");
        } else {
            cipherFile = new File(file);
            if (!cipherFile.exists()) {
                throw new FileNotFoundException("Cipher file not found.");
            }
        }

        Scanner sc = new Scanner(cipherFile);

        if (!sc.hasNextLine()) {
            sc.close();
            throw new IllegalArgumentException("Cipher file missing first line.");
        }

        String originalString = sc.nextLine();

        if (!sc.hasNextLine()) {
            sc.close();
            throw new IllegalArgumentException("Cipher file missing second line.");
        }

        String cipherString = sc.nextLine();

        if (sc.hasNextLine()) {
            sc.close();
            throw new IllegalArgumentException("Cipher file must contain exactly two lines.");
        }

        sc.close();

        originalChars = originalString.toCharArray();
        cipherChars = cipherString.toCharArray();

        if (originalChars.length != cipherChars.length) {
            throw new IllegalArgumentException("Cipher file is invalid.");
        }

        for (int i = 0; i < originalChars.length; i++) {
            for (int h = i + 1; h < originalChars.length; h++) {
                if (originalChars[i] == originalChars[h]) {
                    throw new IllegalArgumentException("Cipher file is invalid.");
                }
            }
        }

        for (int i = 0; i < cipherChars.length; i++) {
            for (int h = i + 1; h < cipherChars.length; h++) {
                if (cipherChars[i] == cipherChars[h]) {
                    throw new IllegalArgumentException("Cipher file is invalid.");
                }
            }
        }
    }

    public String decipher(String input) {

        String decipheredString = "";

        for (int i = 0; i < input.length(); i++) {

            char currentChar = input.charAt(i);
            char decipheredChar = currentChar;

            for (int z = 0; z < cipherChars.length; z++) {
                if (cipherChars[z] == currentChar) {
                    decipheredChar = originalChars[z];
                    break;
                }
            }

            decipheredString += decipheredChar;
        }

        return decipheredString;
    }
}