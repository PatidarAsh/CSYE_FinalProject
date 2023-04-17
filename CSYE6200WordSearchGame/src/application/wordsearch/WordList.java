package application.wordsearch;
import java.util.ArrayList;

/**
 * This manages the wordList Array List for the Word Search game. The Array List
 * is used to track how many words the user still has to find.
 * 
 * The following files are also required to run:
 * 
 * WordSearch.java Base.java WordSelect.java
 * 
 * @version 2.0
 * @author Seth Hilder (478393)
 * @version 14 May 2018
 */

public class WordList {

    private ArrayList<String> wordList = new ArrayList<String>(); // Stores the list of words to find

    /**
     * Adds a word to wordList
     * 
     * @param word The word to add
     */
    public void addWord(String word) {
        wordList.add(word);
    }

    /**
     * Returns the size of wordList
     */
    public int getSize() {
        return wordList.size();
    }

    /**
     * Returns the value of wordList at a given position.
     * 
     * @param pos The index of the value to return
     */
    public String getValue(int pos) {
        return wordList.get(pos);
    }

    /**
     * Removes all values in wordList.
     */
    public void clearArrayList() {
        wordList.clear();
    }

    /**
     * Returns true if wordList contains a given word
     * 
     * @param word Word to check if wordList contains
     */
    public boolean checkContains(String word) {
        return wordList.contains(word);
    }

    /**
     * Removes a given position from wordList
     * 
     * @param pos Position of word to remove
     */
    public void removeWordListValue(int pos) {
        wordList.remove(pos);
    }
}