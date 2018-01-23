/*****************************************************
* Nate Benson - Due 1/23/2018
* Assignment1: Assignment1.java
*****************************************************/
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Assignment1 {
  /*****************************************************
  * Public variables accessible by runProgram.java
  *****************************************************/
  // The String the file is read into
  public String text = "";
  // The counts of the words, sentences, and syllables
  public int totalWords, totalSentences, totalSyllables;
  // The resulting reading level
  public String readingLevel = "";
  // An array of all words in the text file
  String[] numWords;

  /*****************************************************
  * Constructor - CHANGE "TEXTFILE.txt" to name of text
  *****************************************************/
  public Assignment1() throws IOException {
    // Reads file into String text
    text = new String(Files.readAllBytes(Paths.get("TEXTFILE.txt")));

    // Counts the number of words in text and stores in global variable
    totalWords = setWordCount(text);
    // Counts the number of sentences in text and stores in global variable
    totalSentences = setSentenceCount(text);
    // Counts the number of syllables in text and stores in global variable
    totalSyllables = setSyllableCount(text);
    // Does the algorithm calculation and stores in global variable
    readingLevel = DoCalculation(totalWords, totalSentences, totalSyllables);
  }

  /*****************************************************
  * Counts the number of words in String t
  *****************************************************/
  public int setWordCount(String t) {
    // Splits the String by spaces
    numWords = t.split("\\s+");

    // Returns the length of the array numWords
    return numWords.length;
  }

  /*****************************************************
  * Counts the number of sentences in String t
  *****************************************************/
  public int setSentenceCount(String t) {
    // Temperary variables for determining if punctuation
    int count = 0;
    char c;
    // If punctuation is found in the String, increase the count
    for(int i = 0; i < t.length(); i++) {
      c = t.charAt(i);
      // Look for '.', '!', or '?'
      if(c == '.' || c == '!' || c == '?') {
        count++;
      }
    }
    // Return the count
    return count;
  }

  /*****************************************************
  * Counts the number of syllables in String t
  *****************************************************/
  public int setSyllableCount(String t) {
    int sylCount = 0;
    // For every word in word array
    for(int i = 0; i < numWords.length; i++) {
      // Length of the current word
      int length = numWords[i].length();
      // Last character of the current word
      char lastChar = numWords[i].charAt(length - 1);
      // For every character in current word except last letter
      for(int j = 0; j < length - 1; j++) {
        // If a vowel is found, up the count
        if(isVowel(numWords[i].charAt(j))) {
          sylCount++;
        }
      }
      // If the last letter is a vowel and not an 'e', up the count
      if(lastChar == 'e') {
        sylCount = sylCount;
      } else if(isVowel(lastChar)) {
        sylCount++;
      }
    }
    // Return the count
    return sylCount;
  }

  /*****************************************************
  * Checks if the character is a vowel, returns boolean
  *****************************************************/
  public boolean isVowel(char c) {
    // Sets all characters to lowercase
    c = Character.toLowerCase(c);
    // If the character is an a,e,i,o,u, or y, return true
    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y') {
      return true;
    }
    return false;
  }
  // Prints the word count
  public void getWordCount() {
    System.out.println(totalWords + " Word(s),");
  }
  // Prints the sentence count
  public void getSentenceCount() {
    System.out.println(totalSentences + " Sentence(s),");
  }
  // Prints the syllable count
  public void getSyllableCount() {
    System.out.println(totalSyllables + " Syllable(s)");
  }
  // Prints the reading level result
  public void getReadingLevel() {
    System.out.println(readingLevel);
  }

  /*****************************************************
  * Uses the Flesch-Kincaid Reading Ease Formula to
  * calculate the reading level of the text
  *****************************************************/
  public String DoCalculation(int words, int sentences, int syllables) {
    double total = 0.0;
    String answer = "";
    // Flesch-Kincaid Reading Ease Formula
    total = 206.835 - (1.015*((double)words/(double)sentences)) -
    (84.6*((double)syllables/(double)words));

    // Categorizes which reading level the text fits
    if(total >= 0 && total < 30.0)
      answer = "College graduate";
    else if(total > 30.0 && total < 50.0)
      answer = "College";
    else if(total > 50.0 && total < 60.0)
      answer = "10th-12th grade";
    else if(total > 60.0 && total < 70.0)
      answer = "8th & 9th grade";
    else if(total > 70.0 && total < 80.0)
      answer = "7th grade";
    else if(total > 80.0 && total < 90.0)
      answer = "6th grade";
    else if(total > 90.0 && total <= 100.0)
      answer = "5th grade";
    else {
      answer = "ERROR";
    }
    return answer + " reading level!";
  }
}
