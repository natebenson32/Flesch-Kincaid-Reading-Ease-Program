/*****************************************************
* Nate Benson - Due 1/23/2018
* Assignment1: runProgram.java
*****************************************************/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class runProgram {
  /*****************************************************
  * Main function to run the program
  *****************************************************/
  public static void main(String[] args) throws IOException {
    // Create new program object
    Assignment1 as1 = new Assignment1();
    // Print the number of words
    as1.getWordCount();
    // Print the number of sentences
    as1.getSentenceCount();
    // Print the number of syllables
    as1.getSyllableCount();
    // Print the reading level
    as1.getReadingLevel();
  }
}
