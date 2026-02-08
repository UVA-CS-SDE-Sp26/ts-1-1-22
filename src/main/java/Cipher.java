import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Cipher{

private char[] originalChars;
private char[] cipherChars;

public Cipher() throws FileNotFoundException {
    File cipherFile = new File("ciphers/key.txt");
    Scanner sc = new Scanner(cipherFile);

    String originalString = sc.nextLine();
    String cipherString = sc.nextLine();

    sc.close();

    originalChars = originalString.toCharArray();
    cipherChars =  cipherString.toCharArray();

}

public String decipher(String input){
    String decipheredString = "";

    for(int i=0; i< input.length(); i++){

        char currentChar = input.charAt(i);
        char decipheredChar = currentChar;


        for(int z=0; z < cipherChars.length; z++){
            if(cipherChars[z] == currentChar){
                decipheredChar = originalChars[z];
                break;
            }
        }
        decipheredString += decipheredChar;
    }


    return decipheredString;
}

    public static void main(String[] args) {
        try {
            Cipher cipher = new Cipher();  // ← instance created
            System.out.println(cipher.decipher("dog"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
